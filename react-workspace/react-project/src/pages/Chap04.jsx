import { useState } from "react";
import UseHook from "../components/Chap04/UseHook";

const Chap04 = () => {
  //let num = 0;
  /*
    const arr = useState(0);
    const num = arr[0];
    const fn = arr[1];
    */

  const [num, setNum] = useState(0);

  const plus = () => {
    setNum(num + 1);
  };

  return (
    <>
      <h1>누르면 늘어나는 버튼!</h1>
      <br />
      <h3>{num}</h3>
      <button
        onClick={plus}
        className="bg-white text-black px-4 py-2 text-sm font-semibold hover:bg-gray-200"
      >
        누르면 늘어남~~
      </button>
      <hr />
      <UseHook />
    </>
  );
};

export default Chap04;
