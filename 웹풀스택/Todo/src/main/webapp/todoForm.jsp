<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>TODO FORM</title>
<link rel="stylesheet" href="todoForm.css">
</head>
<body>


<div class="form_Title">할일 등록</div>
<div id="div_body">
	<div style="width: 35%; "></div>
	<div style="width: 30%; ">
		<form action="TodoAddServlet" class="form_Input" method="post">
			<p>어떤일인가요?</p>
			<input type="text" id="title" name="title" maxlength="24" placeholder="swift공부하기(24자까지)" required="required">
			<p>누가 할일인가요?</p>
			<input type="text" id="name" name="name" placeholder="홍길동" required="required">
			<p>우선순위를 선택하세요</p>
			<input type="radio" name="sequence" value="1" required="required">1순위
			<input type="radio" name="sequence" value="2" required="required">2순위
			<input type="radio" name="sequence" value="3" required="required">3순위
			<br>
			<div class="btn_div">
				<button class="prev" onclick="location.href = 'http://localhost:8080/Todo/MainServlet'"> < 이전 </button>
				<button type="submit" class="submit">제출</button>
				<button type="reset" class="reset">내용지우기</button>
			</div>
		</form>
	</div>
	<div style="width:35%"></div>
</div>
</body>
</html>