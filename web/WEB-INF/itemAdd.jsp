<%--
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
<form action="/item/add" method="post" enctype="multipart/form-data">
  <input type="text" name="title" placeholder="title"><br><br>
  <input type="number" name="price" placeholder="price"><br><br>
  <select name="categoryName">
    <option value="1">Cars</option>
    <option value="2">House</option>
    <option value="3">Commercial</option>
    <option value="4">Furniture</option>
  </select><br><br>
  <input type="file" name="pic"><br><br>
  <input type="submit" value="ADD">


</form>

</body>
</html>
