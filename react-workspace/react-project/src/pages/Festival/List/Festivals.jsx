import {
  FestivalList,
  FestivalWrap,
  FestivalTitle,
  FestivalCard,
  FestivalImg,
  FestivalName,
  FestivalInfo,
  FestivalTag,
  FestivalMoreButton,
} from "../Styles/Festival.styles";
import axios from "axios";
import { useState, useEffect } from "react";

const Festivals = () => {
  const [page, setPage] = useState(1);
  const [festivals, setFestivals] = useState([]);

  const cleanTitle = (title) => {
  if (!title) return "";
  // (한), (영), (한,영,중간,중번,일) 등 모든 괄호 내용 제거
  return title.replace(/\s*\([^)]+\)\s*$/, "").trim();
};

  useEffect(() => {
    axios.get(`http://localhost/api/festivals?page=${page}`).then((result) => {
      console.log(result.data.getFestivalKr.item);
      const res = result.data.getFestivalKr.item;
      setFestivals([...festivals, ...res]);
    });
  }, [page]);



  return (
    <>
      <FestivalWrap>
        <FestivalTitle>축제 목록</FestivalTitle>
        <FestivalList>
          {festivals.length === 0 ? (
            <FestivalCard>로딩 중~</FestivalCard>
          ) : (
            festivals.map((e) => (
              <FestivalCard key={e.UC_SEQ}>
                <FestivalImg src={e.MAIN_IMG_NORMAL}></FestivalImg>
                <FestivalName>{cleanTitle(e.MAIN_TITLE)}</FestivalName>
              </FestivalCard>
            ))
          )}
        </FestivalList>
      </FestivalWrap>
    </>
  );
};

export default Festivals;
