package com.kh.spring.member.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.kh.spring.exception.AuthorizationException;
import com.kh.spring.exception.InvalidParameterException;
import com.kh.spring.exception.TooLargeValueException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDto;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl {

//  @Slf4j가 밑에 있는걸 대체 log 객체를 호출
//	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
//	private final MemberDao memberDao;
//	private final SqlSessionTemplate sqlSession;
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;
	
//	@Autowired
//	public MemberServiceImpl(MemberDao memberDao, SqlSessionTemplate sqlSession) {
//		this.memberDao = memberDao;
//		this.sqlSession = sqlSession;
//	}
	
	public MemberDto login(MemberDto member) {
//		log.info("인포 메소드로 출력 {}", member.getUserId());
		// return memberDao.login(sqlSession, member);

		// return memberMapper.login(member);
		MemberDto userInfo = memberMapper.login(member);
		
		/*
		if(userInfo == null) {
			throw new InvalidParameterException("아이디 또는 비밀번호가 틀림"); // 원래는 따로 예외 클래스를 만들어야함
		}
		
		// 1절
		// log.info("사용자가 입력한 비밀번호 평문 : {}", member.getUserPwd());
		// log.info("DB에 저장된 암호화된 비밀번호 : {}", userInfo.getUserPwd());
		
		if(passwordEncoder.matches(member.getUserPwd(), userInfo.getUserPwd())) {
			return userInfo;
		}
		*/
		
		return validateLoginMember(userInfo, member.getUserPwd());
	}

	public void signup(MemberDto member) {
		
//		if(member.getUserId().length() >30) {
//			throw new TooLargeValueException("아이디 값이 너무 깁니다.");
//		}
		
//		if(member.getUserId() == null || member.getUserId().trim().isEmpty() ||
//		   member.getUserPwd() == null || member.getUserPwd().trim().isEmpty() ||
//		   member.getUserName() == null || member.getUserName().trim().isEmpty()) {
//			throw new InvalidParameterException("유효하지 않은 값입니다");
//		}
		
		vaildateMember(member);
		// 정보에 따른 암호화 분류체계
		
		// 비밀번호 => 반드시 암호화
		// 주민등록번호, 계좌번호, 카드번호 => 반드시 암호화
		// 이름, 이메일, 전화번호 => 그때그때 달라요
		
		String plainPwd = member.getUserPwd();
		String encPwd = passwordEncoder.encode(plainPwd);
		
//		Member encMember = new Member(member.getUserId(), encPwd, encPwd, encPwd, null, null, encPwd);
		Member encMember = Member.builder()
								 .userId(member.getUserId())
								 .userPwd(encPwd)
								 .userName(member.getUserName())
								 .email(member.getEmail())
								 .build();
//		log.info("{}의 암호문 : {}", plainPwd, encPwd);
//		memberMapper.signup(member);
		memberMapper.signup(encMember);
	
	}

	public void update(MemberDto member, HttpSession session) {
		
		MemberDto sessionMember = ((MemberDto)session.getAttribute("userInfo"));
		
		// 앞단에서 넘어온 ID값과 현재 로그인된 사용자의 ID값이 일치하는지?
		// USERNAME컬럼에 넣을 값이 USERNAME컬럼크기보다 크지 않은가?
		// EMAIL컬럼에 넣을 값이 EMAIL컬럼 크기보다 크지 않은가?
		// USERNAME컬럼에 전달된 값이 빈문자열이 아닌가?
		// 실제 DB에 ID값이 존재하는 회원인가?
		validateUpdateMember(member, sessionMember);

		// DB가서 UPDATE
		int result = memberMapper.update(member);
		
		// 업데이트가 성공적으로 수행되었는가?
		if(result != 1) {
			throw new AuthorizationException("문제가 발생했습니다. 관리자에게 문의하세요.");
		}
		
		// 수정된 정보를 DB에서 SELECT => sessionScope에 존재하는 userInfo키값의 MemberDTO객체 필드값을 갱신해주기
		sessionMember.setUserName(member.getUserName());
		sessionMember.setEmail(member.getEmail());
	}

	public void delete(String userId, String userPwd, HttpSession session) {
		
		MemberDto sessionMember = ((MemberDto)session.getAttribute("userInfo"));
		
		checkNull(sessionMember);

		if(!userId.equals(sessionMember.getUserId())) {
			throw new AuthorizationException("잘못된 요청입니다~~");
		}
		
		String encPassword = memberMapper.login(sessionMember).getUserPwd();
		
		if(!passwordEncoder.matches(userPwd, encPassword)) {
			throw new AuthorizationException("비밀번호가 일치하지 않습니다.");
		}
		
		int result = memberMapper.delete(userId);
		
		if(result != 1) {
			throw new AuthorizationException("관리자에게 문의하세요.");
		}
		
		session.removeAttribute("userInfo");
	}
	
	public String checkId(String id) {
		return memberMapper.checkId(id);
	}
	
	
	
	// 유효성 검사
	private void vaildateMember(MemberDto member) {
		checkLength(member);
		checkBlank(member);
	}
	
	private void checkLength(MemberDto member) {
		if(member.getUserId().length() >30) {
			throw new TooLargeValueException("아이디 값이 너무 깁니다.");
		}
	}
	
	private void checkBlank(MemberDto member) {
		checkUserId(member);
		checkUserPwd(member);
		checkUserName(member);
	}
	
	private void checkUserId(MemberDto member) {
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
				throw new InvalidParameterException("유효하지 않은 아이디입니다");
				}
	}
	private void checkUserPwd(MemberDto member) {
		if(member.getUserPwd() == null || member.getUserPwd().trim().isEmpty()) {
				throw new InvalidParameterException("유효하지 않은 비밀번호입니다");
				}
	}
	private void checkUserName(MemberDto member) {
		if(member.getUserName() == null || member.getUserName().trim().isEmpty()) {
				throw new InvalidParameterException("유효하지 않은 이름입니다");
				}
	}

	private void checkNull(MemberDto member) {
		if(member == null) {
			throw new NullPointerException("잘못된 접근입니다.");
		}
	}
	
	private void validateUpdateMember(MemberDto member, MemberDto sessionMember) {
		
		checkNull(member);
		checkNull(sessionMember);
		checkUserName(member);
		checkUserId(member);
		
		if(!member.getUserId().equals(sessionMember.getUserId())) {
			throw new AuthorizationException("잘못된 접근 방식입니다.");
		}
		
		checkNull(memberMapper.login(member));
	}
	

	private MemberDto validateLoginMember(MemberDto userInfo, String userPwd) {
		if(userInfo == null) {
			throw new InvalidParameterException("아이디 또는 비밀번호가 틀림"); // 원래는 따로 예외 클래스를 만들어야함
		}
		
		if(passwordEncoder.matches(userPwd, userInfo.getUserPwd())) {
			return userInfo;
		}
		return null;
	}


}
