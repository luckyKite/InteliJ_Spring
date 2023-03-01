<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<body>
<% Object value= request.getAttribute("key"); %>
<h2>Hello World! -- index.jsp</h2>
<p><%=value %></p>
</body>
</html>
