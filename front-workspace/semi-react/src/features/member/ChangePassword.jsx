import { useState } from "react";
import {
  Button,
  Card,
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

const ChangePassword = () => {
  const [currentPwd, setCurrentPwd] = useState("");
  const [newPwd, setNewPwd] = useState("");
  const [newPwdConfirm, setNewPwdConfirm] = useState("");
  const [status, setStatus] = useState("");
  const [loading, isLoading] = useState(false);

  const mismatch = newPwdConfirm.length > 0 && newPwd !== newPwdConfirm;

  const onSubmit = async () => {
    if (!currentPwd || !newPwd) {
      setStatus("모든 항목을 입력해주세요");
      return;
    }
    if (mismatch) {
      setStatus("새 비밀번호가 일치하지 않습니다.");
      return;
    }

    try {
      await api.patch("/members", {
        memberPwd: currentPwd,
        updatePwd: newPwd,
      });
      setStatus("비밀번호가 변경되었습니다.");
      setCurrentPwd("");
      setNewPwd("");
      setNewPwdConfirm("");
    } catch (err) {
      setStatus(err.response.message);
    } finally {
      isLoading(false);
    }

    // axios
    //   .patch(
    //     "http://localhost/api/members",
    //     {
    //       memberPwd: currentPwd,
    //       updatePwd: newPwd,
    //     },
    //     {
    //       headers: {
    //         Authorization: `Bearer ${localStorage.getItem("token")}`,
    //       },
    //     },
    //   )
    //   .then((result) => {
    //     console.log(result);
    //     if (result.status == 200) {
    //     }
    //   })
    //   .catch((err) => {
    //     setStatus(err.response.message);
    //   });
  };

  return (
    <Page>
      <Card>
        <Title>비밀번호 바꾸기</Title>
        <Sub>안전한 사용을 위해 3개월 마다 바꿔주세요.</Sub>

        <Field>
          <Label>현재 비밀번호</Label>
          <Input
            type="password"
            placeholder="현재 비밀번호"
            onChange={(e) => setCurrentPwd(e.target.value)}
          />
        </Field>
        <Field>
          <Label>새 비밀번호</Label>
          <Input
            type="password"
            placeholder="새 비밀번호"
            onChange={(e) => setNewPwd(e.target.value)}
          />
          {mismatch && <Hint $error>비밀번호가 일치하지 않습니다.</Hint>}
        </Field>
        <Field>
          <Label>새 비밀번호 확인</Label>
          <Input
            type="password"
            placeholder="새 비밀번호 확인"
            onChange={(e) => setNewPwdConfirm(e.target.value)}
          />
        </Field>

        <Button disabled={loading} onClick={onSubmit}>
          {loading ? "바꾸는 중" : "바꿔버리기"}
        </Button>
        {status && <Message>{status}</Message>}
      </Card>
    </Page>
  );
};

export default ChangePassword;
