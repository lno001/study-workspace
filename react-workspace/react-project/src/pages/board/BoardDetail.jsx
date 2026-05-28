import { useParams } from "react-router-dom";
import {
  InnerWrap,
  StyledNo,
  StyledNoticeTitle,
  StyledTitle,
  StyledWriter,
  StyleWrap,
} from "../Notice/NoticeList/NoticeList.style";
import { useEffect, useState } from "react";
import axios from "axios";

const BoardDetail = () => {
  const { boardNo } = useParams();
  console.log(boardNo);

  const [board, setBoard] = useState({
    boardContent: "",
    boardNo: 0,
    boardTitle: "",
    boardWriter: "",
    count: 0,
    createDate: "",
  });
  const [load, isload] = useState(false);

  useEffect(() => {
    axios.get(`http://localhost/api/board/${boardNo}`).then((res) => {
      console.log(res.data);
      const obj = res.data;
      setBoard({
        boardContent: obj.boardContent,
        boardNo: obj.boardNo,
        boardTitle: obj.boardTitle,
        boardWriter: obj.boardWriter,
        count: obj.count,
        createDate: obj.createDate,
      });
      isload(true);
    });
  }, [boardNo]);

  if (!load) {
    return (
      <StyleWrap>
        <StyledTitle>게시글 정보를 조회중입니다...</StyledTitle>
      </StyleWrap>
    );
  }

  return (
    <>
      <StyleWrap>
        <InnerWrap>
          <StyledNo>게시글번호 : {board.boardNo} </StyledNo>
          <StyledWriter>게시글제목 : {board.boardTitle}</StyledWriter>
          <StyledWriter>게시글 내용</StyledWriter>
          <StyledNoticeTitle>{board.boardContent}</StyledNoticeTitle>
          <StyledNoticeTitle>조회수</StyledNoticeTitle>
          <StyledNoticeTitle>작성일</StyledNoticeTitle>
          <StyledWriter>작성자</StyledWriter>
        </InnerWrap>
      </StyleWrap>
    </>
  );
};

export default BoardDetail;
