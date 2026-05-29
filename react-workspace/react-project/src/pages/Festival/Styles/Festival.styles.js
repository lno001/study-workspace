import styled from "styled-components";

export const FestivalWrap = styled.div`
  width: 100%;
  max-width: 1200px;
  min-height: 1200px;
  margin: 30px auto;
  padding: 24px;
  border-radius: 24px;
  background-color: #18181b;
  box-shadow: 0 8px 30px rgba(0, 0, 0, 0.4);
`;

export const FestivalTitle = styled.h1`
  font-size: 48px;
  font-weight: 800;
  color: #c084fc;           /* 보라색 */
  text-align: center;
  letter-spacing: -1px;
  margin: 48px 0;
`;

export const FestivalList = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 24px;
  margin: auto;
  padding: 12px;
`;

export const FestivalCard = styled.div`
  padding: 12px;
  border-radius: 20px;
  background-color: #27272a;
  border: 1px solid rgba(255, 255, 255, 0.08);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  overflow: hidden;

  &:hover {
    cursor: pointer;
    transform: translateY(-8px);
    box-shadow: 0 20px 40px rgba(168, 85, 247, 0.15);
  }
`;

export const FestivalImg = styled.img`
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 16px;
  transition: transform 0.4s ease;

  ${FestivalCard}:hover & {
    transform: scale(1.08);
  }
`;

export const FestivalName = styled.h3`
  font-weight: 700;
  text-align: center;
  font-size: 20px;
  color: #e4e4e7;
  margin: 16px 0 8px;
`;

export const FestivalInfo = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  color: #a1a1aa;
  font-size: 14px;
  margin-bottom: 12px;
`;

export const FestivalTag = styled.span`
  display: inline-block;
  padding: 4px 12px;
  background-color: #4c1d95;
  color: #c084fc;
  font-size: 12px;
  font-weight: 600;
  border-radius: 9999px;
  margin: 0 4px;
`;

export const FestivalMoreButton = styled.div`
  width: 180px;
  height: 50px;
  line-height: 50px;
  text-align: center;
  margin: 50px auto 0;
  border-radius: 9999px;
  background: linear-gradient(90deg, #a855f7, #ec4899);
  color: white;
  font-weight: 700;
  font-size: 17px;
  transition: all 0.3s ease;
  box-shadow: 0 10px 20px rgba(168, 85, 247, 0.3);

  &:hover {
    cursor: pointer;
    transform: translateY(-2px);
    box-shadow: 0 15px 30px rgba(168, 85, 247, 0.4);
  }
`;

/* ==================== 상세 페이지 스타일 ==================== */

export const FestivalDetailImg = styled.img`
  width: 100%;
  height: 520px;
  object-fit: cover;
  border-radius: 20px;
  margin-bottom: 30px;
`;

export const FestivalDetailDescription = styled.div`
  font-size: 19px;
  font-weight: 600;
  line-height: 1.8;
  color: #e4e4e7;
  margin: 30px 0;
  padding: 36px;
  background-color: #27272a;
  border-radius: 20px;
  border: 1px solid rgba(255, 255, 255, 0.06);
`;

export const FestivalDetailInfo = styled.div`
  font-size: 17px;
  text-align: center;
  color: #a1a1aa;
  margin: 20px 0;
  display: flex;
  justify-content: center;
  gap: 30px;
`;

export const FestivalDetailMap = styled.div`
  width: 55%;
  height: 620px;
  margin: 40px auto;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
`;