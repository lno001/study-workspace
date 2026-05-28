import { useState, useEffect } from "react";

const UseHook = () => {
  const [num, setNum] = useState(100);

  const minus = () => {
    // setNum(num - 1);
    setNum((num) => num - 1);
  };

  useEffect(() => {
    alert("하이하이~");
  }, [num]);

  return (
    <>
      <h1>{num}</h1>
      <p>
        <button
          onClick={minus}
          className="bg-white text-black px-4 py-2 text-sm font-semibold hover:bg-gray-200"
        >
          감소감소버튼
        </button>
      </p>
    </>
  );
};

export default UseHook;
