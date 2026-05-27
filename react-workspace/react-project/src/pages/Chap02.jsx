import "./Chap02.css";
import {StyledP, StyledBludP} from "./Styles";

const Chap02 = () => {
  return (
    <>
      <p style={{ color: "red", background: "black" }}>
        이 요소에 스타일을 입히고 싶은데?
      </p>
      <p className="chap02">애는 CSS파일을 이용해서 스타일 입히기</p>
      <p className="font-bold bg-blue-600 text-white rounded hover:bg-red-700">
        하이 나는 테일윈드야
      </p>
      <StyledP>나는 스타일 P태그야</StyledP>
      <StyledBludP>나는 스타일 파랑이 P태그야</StyledBludP>
    
    
    </>
  );
};

export default Chap02;
