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
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [memberId, setMemberId] = useState("");
  const [memberPwd, setMemberPwd] = useState("");
  const [status, setStatus] = useState("");
  const [loading, isLoading] = useState(false);
  const navi = useNavigate();

  const onChangeId = (e) => {
    setMemberId(e.target.value);
  };
  const onChangePwd = (e) => {
    setMemberPwd(e.target.value);
  };

  const onSubmit = () => {
    if (!memberId || !memberPwd) {
      setStatus("아이디랑 비밀번호를 꼭꼭 입력하세요");
      return;
    }

    isLoading(true);
    setStatus("");

    axios
      .post("http://localhost/api/auth/login", {
        memberId,
        memberPwd,
      })
      .then((result) => {
        console.log(result);
      })
      .catch((err) => {
        // console.log(err.response);
        if (err.response?.data.code === 400) {
          setStatus(err.response.data.message);
        } else {
          setStatus("로그인에 실패했습니다.");
        }
        isLoading(false);
      });
  };

  return (
    <Page>
      <Card>
        <Title>로그인</Title>
        <Sub>어디 한 번 로그인 해보시지</Sub>

        <Field>
          <Label>아이디</Label>
          <Input placeholder="아이디를 입력하세요." onChange={onChangeId} />
        </Field>
        <Field>
          <Label>비밀번호</Label>
          <Input
            placeholder="비밀번호를 입력하세요."
            type="password"
            onChange={onChangePwd}
          />
        </Field>
        <Button onClick={onSubmit} disabled={loading}>
          {loading ? "로그인 하는 중..." : "로그인"}
        </Button>
        {status?.length > 0 && <Message>{status}</Message>}
      </Card>
    </Page>
  );
};

export default Login;
