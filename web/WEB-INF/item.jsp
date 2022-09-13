<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 12.09.2022
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items Page</title>
</head>

<%User user = (User) session.getAttribute("user");%>
<%List<Item> itemList = (List<Item>) request.getAttribute("items");%>
<body>
<div>
    <form action="/item/show" method="post">

        <% if (itemList == null) {%>
        <div>
            <h1>WELCOME <%=user.getName()%>
            </h1>
            <a href="/item/add">| Add item</a>
            <a href="/item/user">| My items</a>
            <a href="/logout">| Logout</a>
            <%} else {%>
            <h1>WELCOME <%=user.getName()%>
            </h1>
            <a href="/item/add">| Add item</a>
            <a href="/item/user">| My items</a>
            <a href="/logout">| Logout</a>
        </div>
        <div>
            <%
                for (Item item : itemList) {
                    if (item.getPicUrl() == null || item.getPicUrl().length() == 0) {
            %>
            <img src="/image/defaultImageCar.png" width="200">
            <% } else {%>
            <img src="/getImage?pic=<%=item.getPicUrl()%>" width="200">

            <%}%>
            <h3><%=item.getTitle()%></h3> <h3><%=item.getPrice()%></h3>

            <a href="/edit?itemId=<%=item.getId()%>">EDIT  |</a>
            <a href="/remove?itemId=<%=item.getId()%>">REMOVE</a>
            <%}%>
            <%}%>
        </div>
    </form>
</div>
</body>
</html>
