const ReviewDelete = ({ review }) => {
  return (
    <>
      <button
        style={{
          padding: "7px 14px",
          cursor: "pointer",
          backgroundColor: "#e74c3c",
          color: "white",
          border: "none",
          borderRadius: "6px",
          fontSize: "14px",
        }}
      >
        삭제
      </button>
    </>
  );
};

export default ReviewDelete;
