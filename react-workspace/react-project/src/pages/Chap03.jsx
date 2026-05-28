import { styled } from "styled-components";

const StyledDiv = styled.div`
  width: 100%;
  height: 120px;
  border: 1px solid lightgray;
  margin: 40px;
  color: white;
  background-color: ${(props) => (props.color ? props.color : "black")};
`;

const PropPrint = (props) => {
    // props.num = 2;
    // props는 읽기 전용이기 떄문에 자식 컴포넌트에서 값을 변경하려고 해서는 안됨!
    console.log(props);
}

const notices = [
  {
    noticeNo: "1",
    noticeTitle: "공지사항",
    noticeWriter: "admin",
    color: "yellow",
  },
  {
    noticeNo: "2",
    noticeTitle: "공지사항2",
    noticeWriter: "admin",
    color: "green",
  },
  {
    noticeNo: "3",
    noticeTitle: "공지사항 세 번째",
    noticeWriter: "관리자",
  },
];

{
  /*
const NoticeInfo = (props) => {
  console.log(props);
  return (
    <StyledDiv>
      <h3>공지사항 제목 : {props.noticeTitle}</h3>
      <strong> {props.noticeNo} 번</strong> |<label> {props.noticeWriter}</label>
    </StyledDiv>
  );
};
*/
}

const NoticeInfo = (props) => {
  console.log(props);
  const { noticeTitle, noticeNo, noticeWriter, color } = props.notice;
  return (
    <StyledDiv color={color}>
      <h3>공지사항 제목 : {noticeTitle}</h3>
      <strong> {noticeNo} 번</strong> |<label> {noticeWriter}</label>
    </StyledDiv>
  );
};

const Chap03 = () => {
  if (notices.length == 0) {
    return <h1>조회 경과가 존재하지 않습니다.</h1>;
  }

  return (
    <>
    <PropPrint num="1"/>
      {/*
            
            <StyledDiv>
        <h3>공지사항 제목 : {notices[0].noticeTitle} </h3>
        <strong>{notices[0].noticeNo}번</strong> |
        <label> {notices[0].noticeWriter}</label>
      </StyledDiv>
      <hr />
      <StyledDiv>
        <h3>공지사항 제목 : {notices[1].noticeTitle}</h3>
        <strong>{notices[1].noticeNo}번</strong> |
        <label> {notices[1].noticeWriter}</label>
      </StyledDiv>
      <hr />
      <StyledDiv>
        <h3>공지사항 제목 : {notices[2].noticeTitle}</h3>
        <strong>{notices[2].noticeNo}번</strong> |
        <label> {notices[2].noticeWriter}</label>
      </StyledDiv>
        */}
      {/*
      <NoticeInfo {...notices[0]} />
      <NoticeInfo {...notices[1]} />
      <NoticeInfo {...notices[2]} />
    */}
      {notices ? (
        notices.map((e) => <NoticeInfo notice={e} key={e.noticeNo} />)
      ) : (
        <h1>조회결과가 존재하지 않습니다.</h1>
      )}
    </>
  );
};





export default Chap03;
