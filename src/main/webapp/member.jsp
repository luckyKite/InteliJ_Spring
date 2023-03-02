<%@ page import="data.Member" %><%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-01
  Time: 오후 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member 내용 출력</title>
</head>
<body>
<%
  Member member = (Member) request.getAttribute("member");
%>

<h3>Member 내용 출력</h3>
<p><%= member.getId()%></p>
<p><%= member.getName()%></p>
</body>
</html>
