import "./App.css";
import Footer from "./compornents/layout/Footer/Footer";
import Header from "./compornents/layout/Header/Header";
import { Routes, Route } from "react-router-dom";
import SignUp from "./features/member/SignUp";
import Login from "./features/member/Login";

function App() {
  return (
    <>
      <Header />

      <Routes>
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
      </Routes>

      <Footer />
    </>
  );
}

export default App;
