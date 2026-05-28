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
} from "./NoticeList.style";

const ReplyList = () => {
  const [notices, setNotices] = useState([]);

  useEffect(() => {
    /*
    fetch('http://localhost/api/notices')
        .then((response) => response.json())
        .then((data) => console.log(data));
    */
    axios.get("http://localhost/api/replies").then((data) => {
      // console.log(data);
      setNotices(data.data);
    });
  }, []);

  return (
    <>
      <StyleWrap>
        <StyledTitle>댓글목록</StyledTitle>
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
                <StyledCard>
                  <StyledNo>{e.replyNo}번 공지</StyledNo>
                  <StyledNoticeTitle>{e.replyContent}</StyledNoticeTitle>
                  <StyledWriter>{e.replyWriter}</StyledWriter>
                </StyledCard>
              );
            })
          )}
        </InnerWrap>
      </StyleWrap>
    </>
  );
};

export default ReplyList;
