import { useState } from "react";
import "./App.css";
import ObservatoryHeader from "./pages/star/StarHeader";
import ObservatoryFooter from "./pages/star/StarFooter";
import MainHero from "./pages/star/StarMain";
import { Route, Routes, UNSAFE_useFogOFWarDiscovery } from "react-router-dom";
import Chap01 from "./pages/Chap01";
import Chap02 from "./pages/Chap02";
import Chap03 from "./pages/Chap03";
import Chap04 from "./pages/Chap04";
import Chap05 from "./pages/Chap05";
import Header from "./pages/common/Header/Header";
import NoticeList from "./pages/Notice/NoticeList/NoticeList";
import ReplyList from "./pages/Notice/NoticeList/ReplyList";
import MemberList from "./pages/member/MemberList";
import BoardList from "./pages/board/BoardList";
import MemberDetail from "./pages/member/MemberDetail";
import BoardDetail from "./pages/board/BoardDetail";
import Foods from "./pages/Busan/List/Foods";
import Food from "./pages/Busan/Detail/Food";


function App() {
  return (
    <>
    
     {/* <ObservatoryHeader /> */}
      <Header/>
      <Routes>
        <Route path="/" element={<h1>요기는 메인이에요</h1>} />
        <Route path="/notices" element={<NoticeList/>}/>
        <Route path="/rep" element={<ReplyList/>}/>
        <Route path="/member" element={<MemberList/>}/>
        <Route path="/member/:id" element={<MemberDetail/>}/>
        <Route path="/board" element={<BoardList/>}/>
        <Route path="/board/:boardNo" element={<BoardDetail/>}/>
        <Route path="/busans" element={<Foods/>}/>
        <Route path="/busans/:id" element={<Food/>}/>
        <Route path="/chap01" element={<Chap01/>}/>
        <Route path="/chap02" element={<Chap02/>}/>
        <Route path="/chap03" element={<Chap03/>}/>
        <Route path="/chap04" element={<Chap04/>}/>
        <Route path="/chap05" element={<Chap05/>}/>
        <Route path="*" element={<h1>존재하지 않는 페이지 입니다.</h1>}/>
      </Routes>
      <ObservatoryFooter />
    </>
  );
}

export default App;
