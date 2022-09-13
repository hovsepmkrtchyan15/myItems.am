<%@ page import="manager.CategoryManager" %>
<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hoso
  Date: 12.09.2022
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item Page</title>
</head>
<body>

<%CategoryManager categoryManager = new CategoryManager();%>
<%List<Category> categoryList = categoryManager.getAll();%>
<form action="/item/add" method="post" enctype="multipart/form-data">
  <input type="text" name="title" placeholder="title"><br><br>
  <input type="number" name="price" placeholder="price"><br><br>
  <select name="categoryName">

    <%for (Category category : categoryList) {%>

    <option value=<%=category.getId()%>>><%=category.getCategoryName()%></option>

    <%}%>
  </select><br><br>
  <input type="file" name="pic"><br><br>
  <input type="submit" value="ADD">


</form>

</body>
</html>
