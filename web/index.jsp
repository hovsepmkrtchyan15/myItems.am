<%@ page import="model.User" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.CategoryManager" %>
<%@ page import="model.Category" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 12.09.2022
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME PAGE</title>
</head>

<%List<Item> itemList = (List<Item>) request.getAttribute("catList");%>


<body>

<%CategoryManager categoryManager = new CategoryManager();%>
<div style="margin: 0 auto; width: 1400px">

    <div style="text-align: right">
        <a href="/login">LOGIN |</a>
        <a href="/register">REGISTER</a>
    </div>
    <div style="text-align: center; margin-top: 30px">

<%List<Category> categoryList = categoryManager.getAll();%>

        <a href="/items?categoryId=0">HOME |</a>

        <%for (Category category : categoryList) {%>

        <a href="/items?categoryId=<%=category.getId()%>"><%=category.getCategoryName()%> |</a>

<%}%>
        <%if (itemList != null) {%>
        <%
            for (Item item : itemList) {
                if (item.getPicUrl() == null || item.getPicUrl().length() == 0) {
        %>

        <img src="/image/defaultImageCar.png" width="200">
        <% } else {%>
        <img src="/getImage?pic=<%=item.getPicUrl()%>" width="200">

        <%}%>
        <h3><%=item.getTitle()%>
        </h3>
        <h3><%=item.getPrice()%>
        </h3>

        <%}%>
        <%}%>

    </div>


</div>


</body>
</html>
