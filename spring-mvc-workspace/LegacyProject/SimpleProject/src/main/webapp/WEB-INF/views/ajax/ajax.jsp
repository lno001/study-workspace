<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에이젝스!</title>
</head>
<body>
	<h1>AJAX</h1>

	<jsp:include page="../include/header.jsp"/>

	<h3>버튼을 클릭해서 GET방식으로 요청을 보낸 뒤 데이터를 응답받아서 화면에 출력</h3>
	
	<div class="form-group">
		<div class="form-control">
			<button class="btn btn-sm btn-success" onclick="test1();">요청 보내기</button>
		</div>
		<div class="form-control">
			<button class="btn btn-sm btn-danger" onclick="test2();">요청 보내기</button>
		</div>
	</div>
	
	<hr>
	동기 방식 요청 : <label id="result1">
					<c:choose>
						<c:when test="${ empty count }">
							게시글 총 개수
						</c:when>	
						<c:otherwise>
							${ count } 개
						</c:otherwise>				
					</c:choose>
				 </label>
	<hr>
	비동기 방식 요청 : <label id="result2">게시글 총 개수</label>
	
	<script>
		function test1() {
			location.href = "/spring/sync";
		}
		
		function test2() {
			fetch('/spring/async')
				.then(response => response.json())
				.then(data => {
					console.log(data);
					document.querySelector('#result2').innerHTML = data.result + " 개";
				});
		}
		
		
	</script>
	
	
	
	
	
	
	
	
	<jsp:include page="../include/footer.jsp"/>

</body>
</html>