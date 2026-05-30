import axios from "axios";
import { useState, useEffect } from "react";
import ReviewUpdate from "./ReviewUpdate";
import ReviewDelete from "./ReviewDelete";

const Review = ({id, success, onSuccess }) => {
  // console.log(props.id);
  const [review, setReview] = useState([]);

  useEffect(() => {
    axios
      .get(`http://localhost/api/busans/${id}/reviews`)
      .then((result) => {
        console.log(result);
        setReview([...result.data]);
      });
  }, [success]);

  return (
    <>
      {review.length != 0 ? (
        review.map((e, i) => (
          <div
            style={{
              width: "80%",
              margin: "12px auto",
              border: "1px solid #ddd",
              borderRadius: "10px",
              padding: "16px 20px",
              display: "flex",
              justifyContent: "space-between",
              alignItems: "flex-start",
              backgroundColor: "#fff",
              boxShadow: "0 2px 4px rgba(0,0,0,0.05)",
            }}
            key={i}
          >
            <div style={{ flex: 1, paddingRight: "20px" }}>
              <h4 style={{ margin: "0 0 10px 0", fontSize: "17px" }}>
                {e.content}
              </h4>
              <h5 style={{ color: "#666", margin: "4px 0", fontSize: "14px" }}>
                {e.createDate}
              </h5>
              <h5 style={{ margin: "4px 0", fontSize: "15px" }}>
                별점 : {e.rating}
              </h5>
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "8px" }}
            >
              <ReviewUpdate id={id} review={e} onSuccess={onSuccess} />
              <ReviewDelete id={id} review={e} />
            </div>
          </div>
        ))
      ) : (
        <h2>아직 리뷰가 존재하지 않습니다.</h2>
      )}
    </>
  );
};

export default Review;
