<%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-02
  Time: 오전 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*"
%>
<html>
<head>
    <title>배열출력하기</title>
</head>
<body>
<%
    String [] array = (String []) request.getAttribute("array");
%>

<h3>배열 출력하기</h3>

<%
    for(String name : array) { %>
    <p><%= name %></p>
<%} %>
</body>
</html>
