<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.dto.TodoDto"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.connect.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Main화면</title>
<link rel="stylesheet" href="main.css?after">

<script type="text/javascript" src="./main.js?v=<%=System.currentTimeMillis()%>"></script>

</head>
<body>

<header>
	<div class="mainTitle">나의 해야할 일들</div>
	<a class="addTodo" href="todoForm.jsp">새로운 TODO등록</a>
</header>


<section id="sec_body">
	<ul id="TODO">
		<li class="list_title">TODO</li>
		<%
			List<TodoDto> todo = (ArrayList<TodoDto>) request.getAttribute("todo");
		
			for(TodoDto dto : todo){
		%>
		<li class="list_content">
			<h3><%=dto.getTitle() %></h3>
			<%
			String y = dto.getRegdate().substring(0,4);
			String m = dto.getRegdate().substring(5,7);
			String d = dto.getRegdate().substring(8,10);
			
			String date = y + "." + m + "." + d;
			%>
			<p>
				등록날짜:<%=date %>, <%=dto.getName() %>, 우선순위<%=dto.getSequence() %>
				<button id="<%=dto.getId()%>#<%=dto.getType()%>" class="next_btn" onclick="next(id)">-></button>
			</p>
		</li>
		<%} %>
	</ul>
	
	<ul id="DOING">
		<li class="list_title">DOING</li>
		<%
			List<TodoDto> doing = (ArrayList<TodoDto>) request.getAttribute("doing");
		
			for(TodoDto dto : doing){
		%>
		<li class="list_content">
			<h3><%=dto.getTitle() %></h3>
			<%
			String y = dto.getRegdate().substring(0,4);
			String m = dto.getRegdate().substring(5,7);
			String d = dto.getRegdate().substring(8,10);
			
			String date = y + "." + m + "." + d;
			%>
			<p>
				등록날짜:<%=date %>, <%=dto.getName() %>, 우선순위<%=dto.getSequence() %>
				<button id="<%=dto.getId()%>#<%=dto.getType()%>" class="next_btn" onclick="next(id)">-></button>
			</p>
		</li>
		<%} %>
	</ul>
	
	<ul id="DONE">
		<li class="list_title">DONE</li>
		<%
			List<TodoDto> done = (ArrayList<TodoDto>) request.getAttribute("done");
		
			for(TodoDto dto : done){
		%>
			<li class="list_content">
			<h3><%=dto.getTitle() %></h3>
			<%
			String y = dto.getRegdate().substring(0,4);
			String m = dto.getRegdate().substring(5,7);
			String d = dto.getRegdate().substring(8,10);
			
			String date = y + "." + m + "." + d;
			%>
			<p>
				등록날짜:<%=date %>, <%=dto.getName() %>, 우선순위<%=dto.getSequence() %>
			</p>
		</li>
		<%} %>
	</ul>
</section>


</body>
</html>