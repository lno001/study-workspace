package com.kh.semi.board.model.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.board.model.dao.BoardMapper;
import com.kh.semi.board.model.dto.BoardDto;
import com.kh.semi.board.model.vo.Board;
import com.kh.semi.exception.CustomAuthenticationException;
import com.kh.semi.file.service.FileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;
	private final FileService fileService;

	public void save(BoardDto board, MultipartFile file, CustomUserDetails user) {

		Board b = Board.builder().boardTitle(board.getBoardTitle()).boardContent(board.getBoardContent())
				.boardWriter(user.getUsername()).fileUrl(storeIfPresent(file)).build();
		boardMapper.save(b);

	}

	private String storeIfPresent(MultipartFile file) {
		return (file != null && !file.isEmpty()) ? fileService.store(file) : null;
	}

	public List<BoardDto> findAll(int page) {

		RowBounds rb = new RowBounds(page * 3, 3); // RowBounds는 전체를 다 조회해오고 page*3만큼 점프 뛰어서 결과를 반환해주니까 만약 게시글수가 많아질수록
													// 성능이 감소됨 따라서 offset이나 인라인Rownum으로 처리해주는것이 권장사항임
		return boardMapper.findAll(rb);
	}

	public BoardDto findByBoard(Long boardNo) {
		return getBoardOrThrow(boardNo);
		/*
		 * BoardDto board = boardMapper.findByBoardNo(boardNo); if(board == null) {
		 * throw new InvalidParameterException("유효하지 않은 보드접근입니다."); }
		 * 
		 * return board;
		 */
	}

	// 둘다 게시글이 있는건가
	// 요청 보낸 사람이 보드 작성자랑 동일 한가

	public void update(@Valid BoardDto board, MultipartFile file, CustomUserDetails user, Long boardNo) {
		validateUser(boardNo, user.getUsername());

		if (file != null && !file.isEmpty()) {
			String filePath = fileService.store(file);
			board.setFileUrl(filePath);
		}

		board.setBoardNo(boardNo);
		boardMapper.update(board);

	}

	public void dlelteByBoardNo(CustomUserDetails user, Long boardNo) {
		validateUser(boardNo, user.getUsername());
		boardMapper.deleteByBoardNo(boardNo);
	}

	private BoardDto getBoardOrThrow(Long boardNo) {
		BoardDto board = boardMapper.findByBoardNo(boardNo);
		if (board == null) {
			throw new InvalidParameterException("유효하지 않은 보드접근입니다.");
		}

		return board;
	}

	private void validateUser(Long boardNo, String username) {
		BoardDto board = getBoardOrThrow(boardNo);
		if (!board.getBoardWriter().equals(username)) {
			throw new CustomAuthenticationException("작성자가 일치하지 않습니다.");
		}
	}

}
