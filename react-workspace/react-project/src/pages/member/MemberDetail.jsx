import { useParams } from "react-router-dom";
import {
  InnerWrap,
  StyledTitle,
  StyledWriter,
  StyleWrap,
} from "../Notice/NoticeList/NoticeList.style";
import { useEffect, useState } from "react";
import axios from "axios";

const MemberDetail = () => {
  const { id } = useParams();
  // alert(id);
  const [member, setMember] = useState({
    userId: "",
    userName: "",
    email: "",
    enrollDate: "",
  });
  const [load, isload] = useState(false);

  useEffect(() => {
    axios.get(`http://localhost/api/member/${id}`).then((res) => {
      console.log(res.data);
      const obj = res.data;
      setMember({
        userId: obj.userId,
        userName: obj.userName,
        email: obj.email,
        enrollDate: obj.enrollDate,
      });
      isload(true);
    });
  }, [id]);

  if (!load) {
    return (
      <StyleWrap>
        <StyledTitle>회원 정보를 조회중입니다...</StyledTitle>
      </StyleWrap>
    );
  }

  return (
    <>
      <StyleWrap>
        <InnerWrap>
          <StyledTitle>{member.userId}님의 정보</StyledTitle>
          <StyledWriter>아이디 : {member.userName}</StyledWriter>
          <StyledWriter>이메일 : {member.email}</StyledWriter>
          <StyledWriter>가입일 : {member.enrollDate}</StyledWriter>
        </InnerWrap>
      </StyleWrap>
    </>
  );
};

export default MemberDetail;
