<%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-01
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>구구단</title>
</head>
<body>
<%
  int dan = (int)request.getAttribute("dan");
  int limit = (int)request.getAttribute("limit");
%>

<h2>구구단 <%=dan %>단을 <%=limit %>까지 출력합니다. </h2>

<%
  for (int i = 1; i <= limit; i++) {%>
<p><%=dan %> * <%=i %> = <%=i*dan %> </p>

<% } %>
</body>
</html>
