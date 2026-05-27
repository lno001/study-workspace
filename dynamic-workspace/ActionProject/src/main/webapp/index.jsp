<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호오오잉</title>
</head>
<body>

	<h1>웰컴파일입니다.</h1>
	
	<h2>* EL (Expression Language)</h2>

	<h3>EL구문 학습</h3>
	
	<a href="http://localhost:8088/action/el.do">서블릿으로 요청~~</a>

	<hr>
	
	sessionScope : ${ academy } <br>
	requestScope : ${ classRoom } <br>
	
	<hr>

	<h2>* JSP Action Tag</h2>

	<h3>1. 표준 액션 태그</h3>

	<a href="http://localhost:8088/action/include.do">아리끼리아리끼리</a>

	<hr>
	
	<a href="http://localhost:8088/action/forward.do">더좋은 액션태그</a>

	<hr>
	
	<h3>2. 커스텀 액션 태그</h3>

	<a href="/action/jstl.do">JSTL</a>
	



</body>
</html>