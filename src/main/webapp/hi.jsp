<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*"
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>인사말 출력하기</title>
</head>

<body>
<%
  String name = request.getParameter("name");
%>
<h2>Hi! <%= name%></h2>
</body>
</html>