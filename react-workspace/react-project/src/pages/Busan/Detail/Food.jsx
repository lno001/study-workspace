import { useEffect, useState } from "react";
import {
  RestaurantDetailMap,
  RestaurantDetailOther,
  RestaurantDetailDescription,
  RestaurantDetailImg,
  RestaurantMoreButton,
  RestaurantWrap,
  RestaurantTitle,
} from "../Styles/Foods.styles";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

const Food = () => {
  const { id } = useParams();
  const navi = useNavigate();
  const [load, isLoad] = useState(false);
  const [food, setFood] = useState({
    title: "",
    img: "",
    description: "",
    address: "",
    usageTime: "",
    lat: "",
    lng: "",
  });

  useEffect(() => {
    axios.get(`http://localhost/api/busans/${id}`).then((result) => {
      //console.log(result);
      const food = result.data.getFoodKr.item[0];
      console.log(food);
      setFood({
        title: food.MAIN_TITLE,
        img: food.MAIN_IMG_NORMAL,
        description: food.ITEMCNTNTS,
        address: food.ADDR1,
        usageTime: food.USAGE_DAY_WEEK_AND_TIME,
        lat: food.LAT,
        lng: food.LNG,
      });
      isLoad(true);
    });
  }, []);
  useEffect(() => {
    if (food.lat === "") return;
    var container = document.getElementById("map");
    var options = {
      center: new kakao.maps.LatLng(food.lat, food.lng),
      level: 3,
    };

    var map = new kakao.maps.Map(container, options);
  }, [food.lat]);

  if (!load) return <RestaurantTitle>로 딩 중 ...</RestaurantTitle>;

  return (
    <>
      <RestaurantWrap>
        <RestaurantTitle>{food.title}</RestaurantTitle>
        <RestaurantDetailImg src={food.img} />
        <RestaurantDetailDescription>
          {food.description}
        </RestaurantDetailDescription>
        <RestaurantDetailOther>{food.address}</RestaurantDetailOther>
        <RestaurantDetailOther>{food.usageTime}</RestaurantDetailOther>
        <RestaurantDetailMap id="map"></RestaurantDetailMap>
        <RestaurantMoreButton onClick={() => navi(-1)}>
          뒤로가기
        </RestaurantMoreButton>
      </RestaurantWrap>
      <div style={{ width: "50%", margin: "auto", height: "120px", border: "1px solid black", borderRadius: "20px" }}>
        <form action="">
            후기 작성 :{" "}
          <input
            type="text"
            placeholder="음식은 어떠셨나요??"
          />
          <hr />
          별점 선택 :{" "}
          <input
            type="number"
            max="5"
            min="1"
            placeholder="별점을 남겨주세요"
          />
          <hr />
          <button style={{border: "1px solid black"}}>후기 작성 완료</button>
        </form>
      </div>
    </>
  );
};

export default Food;
