<%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 12.09.2022
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN PAGE</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
%>
<%if (msg != null) {%>
<p style="color: red"><%=msg%>
</p>
<%}%>

<form action="/login" method="post">
    Email: <input type="email" name="email"> <br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
