-- 일반 사용자 계정(수업시간에 사용할 각자 계정)
CREATE USER C##IL IDENTIFIED BY il;

-- 접속 권한 부여, 데이터를 다룰 수 있는 권한 부여
GRANT CONNECT, RESOURCE TO C##IL;

-- 테이블 스페이스 사용 권한
GRANT UNLIMITED TABLESPACE TO C##IL;