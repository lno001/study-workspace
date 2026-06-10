import { useState } from "react";
import {
  Button,
  Card,
  DangerButton,
  Field,
  Hint,
  Input,
  Label,
  Message,
  Page,
  Sub,
  Title,
} from "../styles/AuthForm.styles";
import api from "../../api/axios";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

const DeleteAccount = () => {
  const navi = useNavigate();
  const { logout } = useAuth();
  const [password, setPassword] = useState("");
  const [agree, setAgree] = useState(false);
  const [status, setStatus] = useState(false);
  const [loading, isLoading] = useState(false);

  const onSubmit = async () => {
    if (!password) {
      setStatus("비밀번호를 입력해주세요");
      return;
    }
    if (!agree) {
      setStatus("유의사항에 동의해주세요");
      return;
    }

    isLoading(true);
    setStatus("");
    try {
      // 컨트롤러에서 Map<String, String>
      // 데이터 보낼 때는 바디에 { data : {password}}
      await api.delete("/members", { data: { password } });

      logout();
      navi("/");
    } catch (err) {
      setStatus(err.response?.data.message || "회원탈퇴 실패");
    } finally {
      isLoading(false);
    }
  };

  return (
    <Page>
      <Card>
        <Title>회원 탈퇴하기</Title>
        <Sub>탈퇴해도 메일 보내면 다시 살려드립니다.</Sub>

        <ul style={{ padding: "0px", fontSize: "12px", color: "lightgray" }}>
          <li>탈퇴 후 동일한 아이디로 재 가입 할 수 없습니다.</li>
          <li>작성하신 데이터는 정책에 따라 일정 시간 보관된 후 삭제됩니다.</li>
        </ul>

        <Field>
          <Label>비밀번호를 입력하세요.</Label>
          <Input
            type="password"
            placeholder="비밀번호를 입력 해주세요."
            onChange={(e) => setPassword(e.target.value)}
            value={password}
          />
        </Field>

        <label
          style={{
            fontSize: "13px",
            display: "flex",
            alignItems: "center",
            margin: "4px 0 20px",
            color: "crimson",
          }}
        >
          <input
            type="checkbox"
            style={{ width: "15px", height: "15px" }}
            checked={agree}
            onChange={(e) => setAgree(e.target.checked)}
          />
          <span>유의사항을 모두 확인했으며 탈퇴에 동의하겠습니다.</span>
        </label>
        <DangerButton onClick={onSubmit} disabled={loading}>
          {loading ? "탈퇴하는 중..." : "탈퇴하기"}
        </DangerButton>
        {status && <Message>{status}</Message>}
      </Card>
    </Page>
  );
};

export default DeleteAccount;
