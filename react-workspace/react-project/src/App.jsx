import { useState } from "react";
import "./App.css";
import ObservatoryHeader from "./pages/star/StarHeader";
import ObservatoryFooter from "./pages/star/StarFooter";
import MainHero from "./pages/star/StarMain";
import { Route, Routes } from "react-router-dom";
import Chap01 from "./pages/Chap01";
import Chap02 from "./pages/Chap02";
import Chap03 from "./pages/Chap03";


function App() {
  return (
    <>
    
     {/* <ObservatoryHeader /> */}
      
      <Routes>
        <Route path="/" element={<h1>요기는 메인이에요</h1>} />
        <Route path="/chap01" element={<Chap01/>}/>
        <Route path="/chap02" element={<Chap02/>}/>
        <Route path="/chap03" element={<Chap03/>}/>
        <Route path="*" element={<h1>존재하지 않는 페이지 입니다.</h1>}/>
      </Routes>
      <ObservatoryFooter />
    </>
  );
}

export default App;
