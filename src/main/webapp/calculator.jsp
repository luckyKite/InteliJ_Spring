<%--
  Created by IntelliJ IDEA.
  User: egg
  Date: 2023-03-02
  Time: 오전 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산</title>
</head>
<body>
<%
  int num1 = Integer.parseInt(request.getParameter("num1"));
  int num2 = Integer.parseInt(request.getParameter("num2"));
  int res = 0;

  String op = request.getParameter("op");
  if (op.equals("+")) {
    res = num1 + num2;
  } else if (op.equals("-")) {
    res = num1 - num2;
  }

  String result = num1 + "" + op + "" + num2 + " = " + res;
%>
<h2>Hello Calculator!</h2>
<div>
  <p><%=result%></p>
</div>
</body>
</html>
