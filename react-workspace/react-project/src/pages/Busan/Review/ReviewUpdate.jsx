import axios from "axios";
import { useState } from "react";

const ReviewUpdate = ({ id, review, onSuccess }) => {
  const [showModel, setShowModel] = useState(false);
  const [updateContent, setUpdateContent] = useState("");

  const openModel = () => {
    setShowModel(true);
  };

  const closeModel = () => {
    setShowModel(false);
  };

  const updateContentHandler = (e) => {
    setUpdateContent(e.target.value);
  };

  const submitHandler = (e) => {
    e.preventDefault();

    if (updateContent.trim() === "") {
      alert("내용을 입력해주세요.");
      return;
    }

    axios
      .patch(`http://localhost/api/busans/${id}/reviews`, {
        content: review.content,
        updateContent: updateContent,
      })
      .then((result) => {
        console.log(result);
        if(onSuccess) {
            onSuccess();
        }
        setShowModel(false);
      });
  };

  return (
    <>
      <button
        onClick={openModel}
        style={{
          padding: "7px 14px",
          cursor: "pointer",
          backgroundColor: "#4a90e2",
          color: "white",
          border: "none",
          borderRadius: "6px",
          fontSize: "14px",
        }}
      >
        수정
      </button>

      {/* 팝업창 */}
      {showModel && (
        <div
          style={{
            position: "fixed",
            top: 0,
            left: 0,
            width: "100%",
            height: "100%",
            backgroundColor: "rgba(0,0,0,0.5)",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            zIndex: 1000,
          }}
        >
          <div
            style={{
              backgroundColor: "white",
              padding: "30px",
              borderRadius: "12px",
              width: "400px",
              textAlign: "center",
            }}
          >
            <h3>리뷰 수정</h3>
            <hr />

            <form onSubmit={submitHandler}>
              리뷰 내용 :
              <input
                type="text"
                onChange={updateContentHandler}
                placeholder={review.content}
                value={updateContent}
              />
              <hr />
              <button
                style={{
                  padding: "10px 20px",
                  backgroundColor: "#ccc",
                  border: "none",
                  borderRadius: "6px",
                  cursor: "pointer",
                }}
              >
                수정하기
              </button>
            </form>
            <br />
            <button
              onClick={closeModel}
              style={{
                padding: "10px 20px",
                backgroundColor: "#ccc",
                border: "none",
                borderRadius: "6px",
                cursor: "pointer",
              }}
            >
              닫기
            </button>
          </div>
        </div>
      )}
    </>
  );
};

export default ReviewUpdate;
