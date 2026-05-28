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

const NoticeList = () => {
  const [notices, setNotices] = useState([]);

  useEffect(() => {
    /*
    fetch('http://localhost/api/notices')
        .then((response) => response.json())
        .then((data) => console.log(data));
    */
    axios.get("http://localhost/api/notices").then((data) => {
      // console.log(data);
      setNotices(data.data);
    });
  }, []);

  return (
    <>
      <StyleWrap>
        <StyledTitle>공지사항</StyledTitle>
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
                  <StyledNo>{e.noticeNo}번 공지</StyledNo>
                  <StyledNoticeTitle>{e.noticeTitle}</StyledNoticeTitle>
                  <StyledWriter>{e.noticeWriter}</StyledWriter>
                </StyledCard>
              );
            })
          )}
        </InnerWrap>
      </StyleWrap>
    </>
  );
};

export default NoticeList;
