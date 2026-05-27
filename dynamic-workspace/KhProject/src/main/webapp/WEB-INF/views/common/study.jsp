<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h1{
		color : red;
		font-size : 64px;
		text-align : center;
		height : 600px;
		line-height : 600px;
	}
</style>
</head>
<body>

	<jsp:include page="../include/header.jsp"></jsp:include>
	
	<h1>아주 중요</h1>
	
	<h2>AJAX!</h2>
	
	<h4>jQuery를 이용한 AJAX활용</h4>
	
	<h5>요청을 보내고 응답 받아오기</h5>
	
	<div class="form-group">
		<div class="form-control">
			<button class="btn btn-sm btn-sunday" onclick="fn1();">요청 보내기!</button>
		</div>
	</div>
	
	응답 : <label id="output1">아직 응답 없음</label>
	
	<script>
		function fn1() {
			// 동기식 요청
			// location.href = 'http://localhost:8088/kh/ajax.do'
			
			// 비동기식 요청
			$.ajax({
				url : 'http://localhost:8088/kh/ajax1.do',
				type : 'get',
				success : result => {
					console.log(result);
					document.querySelector('#output1').innerHTML = result;
				},
				error : result => {
					console.log('ajax요청 실패!');
					document.querySelector('#output1').innerHTML = '통신에 실패했습니다';
				},
				complete : () => {
					console.log('성공이든 실패든 무조건');
				}
			});
			
		}
	</script>
	
	<hr>
	
	<h3>게시글 번호를 보내서 게시글 정보 받아오기</h3>
	
	게시글 번호 : <input type="number" id="boardNo"/> <br>
	
	<button onclick="infoBoard();">게시글 주세요~</button>
	
	<hr>
	
	게시글 제목 : <label id="title">현재 응답 없음</label> <br>
	게시글 내용 : <label id="content">현재 응답 없음</label> <br>
	
	<script>
		function infoBoard() {
			$.ajax({
				url : 'http://localhost:8088/kh/ajax2.do',
				type : 'get',
				data : {
					boardNo : document.querySelector('#boardNo').value
				},
				success : result => {
					console.log(result);
					document.querySelector("#title").innerHTML = result.boardTitle;
					document.querySelector("#content").innerHTML = result.boardContent;
				},
				error : e => {
					console.log(e);
				}
			});
		}
	</script>
	
	<hr>
	
	<h3>사진게시글 목록조회</h3>
	
	<button class="btn btn-lg btn-danger" onclick="img();">사진게시글 조회하기</button>
	
	<div id="result" style="width: 80%; height : 1000px; margin : auto;">
	
	
	</div>
	
	
	<script>
		function img() {
			$.ajax({
				url : 'http://localhost:8088/kh/ajax3.do',
				type : 'get',
				success : result => {
					console.log(result);
					
					const el = result.map(e =>
						`
							<div>
								<label>글 번호 : \${e.boardNo}</label>
								<div><img src="\${e.src}" width="120" height="70" /></div>
								<p>제목 : \${e.boardTitle}</p>	
							</div>
						`
					).join('');
					
					document.querySelector('#result').innerHTML = el;
				}
			});
		}
	</script>




	
	<jsp:include page="../include/footer.jsp"></jsp:include>
	
</body>
</html>