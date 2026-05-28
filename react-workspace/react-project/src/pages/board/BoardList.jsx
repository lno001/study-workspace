import axios from "axios";
import { useEffect, useState } from "react";
import {
  InnerWrap,
  StyleWrap,
  StyledCard,
  StyledNo,
  StyledNoticeTitle,
  StyledTitle,
  StyledWriter,
} from "../Notice/NoticeList/NoticeList.style";
import { StyledBludP } from "../Styles";
import { useNavigate } from "react-router-dom";

const BoardList = () => {
  const [notices, setNotices] = useState([]);
  const navi = useNavigate();

  useEffect(() => {
    /*
    fetch('http://localhost/api/notices')
        .then((response) => response.json())
        .then((data) => console.log(data));
    */
    axios.get("http://localhost/api/board").then((data) => {
      // console.log(data);
      setNotices(data.data);
    });
  }, []);

  return (
    <>
      <StyleWrap>
        <StyledTitle>게시판목록</StyledTitle>
        <InnerWrap>
          {notices.legnth === 0 ? (
            <div>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
            </div>
          ) : (
            notices.map((e) => {
              return (
                <StyledBludP onClick={() => navi(`/board/${e.boardNo}`)}>
                  <StyledNo>{e.boardNo}</StyledNo>
                  <StyledNoticeTitle>{e.boardTitle}</StyledNoticeTitle>
                  <StyledNoticeTitle>{e.boardContent}</StyledNoticeTitle>
                  <StyledNoticeTitle>{e.count}</StyledNoticeTitle>
                  <StyledNoticeTitle>{e.createDate}</StyledNoticeTitle>
                  <StyledWriter>{e.boardWriter}</StyledWriter>
                </StyledBludP>
              );
            })
          )}
        </InnerWrap>
      </StyleWrap>
    </>
  );
};

export default BoardList;
