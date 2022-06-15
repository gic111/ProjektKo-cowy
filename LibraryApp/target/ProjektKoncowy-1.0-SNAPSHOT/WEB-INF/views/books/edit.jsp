<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 04.06.2022
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Update book</title>
  <a href="<c:url value="/books/all"/>">Books</a>
  <a href="<c:url value="/users/all"/>">Users</a>
  <a href="<c:url value="/categories/all"/>">Categories</a>
  <a href="<c:url value="/lend/all"/>">Lendings</a>
</head>
<body>
<form:form modelAttribute="book" action="/books/edit">
  <form:hidden path="id"/>
  ISBN: <form:input path="isbn"/>
  Title: <form:input path="title"/>
  Author: <form:input path="author"/>
  Publisher: <form:input path="publisher"/>
  Description: <form:input path="description"/>
  Quantity:<form:input path="quantity"/>
  Category:
  <form:select itemValue="id" itemLabel="name" path="category.id"
               items="${categories}"/>
  <input type="submit" value="Save">
</form:form>
</body>
</html>
