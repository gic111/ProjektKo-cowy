<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 04.06.2022
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update book</title>
</head>
<body>
<c:url var="edit_url" value="/books/edit"/>
<form:form modelAttribute="book" action="${edit_url}">
  <form:hidden path="id"/>
  ISBN: <form:input path="isbn"/>
  Title: <form:input path="title"/>
  Author: <form:input path="author"/>
  Publisher: <form:input path="publisher"/>
  Description: <form:input path="description"/>
  Quantity:<form:input path="quantity"/>
  <input type="submit" value="Save">
</form:form>
</body>
</html>
