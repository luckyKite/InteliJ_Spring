<%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-01
  Time: 오후 5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MemberJoin.jsp</title>
</head>
<body>
<%
  String message = (String) request.getParameter("errorMessage");
%>

<h2>Member 내용출력 - memberJoin.jsp</h2>

<h2>회원가입</h2>
<form method="post" action="/member">
  <p>아이디 <input type="text" name="id"> </p>
  <p>이름 <input type="text" name="name"> </p>
  <p>암호1 <input type="password" name="password1"> </p>
  <p>암호2 <input type="password" name="password2"> </p>
  <p> <input type="submit"> </p>
</form>
<p><%=message %></p>
</body>
</html>
