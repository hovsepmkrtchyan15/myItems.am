<%@ page import="model.Item" %>
<%@ page import="manager.ItemManager" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 13.09.2022
  Time: 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Item Page</title>
</head>
<body>


<%Item item = (Item)request.getAttribute("item");%>

<form action="/edit" , method="post">
    <input type="hidden" name="id" value="<%=item.getId()%>">
    <input type="text" name="title" value="<%=item.getTitle()%>"/><br>
    <input type="number" name="price" value="<%=item.getPrice()%>"/><br>

    <input type="submit" value="Update">
</form>

</body>
</html>
