<%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-02
  Time: 오전 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>최종예제</title>
</head>
<body>
<%!
  String [] members = {"A","B","C","D","E","F","G","H","I","J"};
  int num2 = 10;
  int calc(int num1) {
    return num1 + num2;
  };
%>

<h2>Last~~~!!</h2>
<h3><%= calc(10)%></h3>
<%@ include file="index.jsp" %>

<% for (String member : members) { %>
<li><%= member%></li>

<% } %>
</body>
</html>
