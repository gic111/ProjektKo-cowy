<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 06.06.2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Lend</title>
    <a href="<c:url value="/books/all"/>">Books</a>
    <a href="<c:url value="/users/all"/>">Users</a>
    <a href="<c:url value="/categories/all"/>">Categories</a>
    <a href="<c:url value="/lend/all"/>">Lendings</a>
</head>
<body>
<form:form modelAttribute="lendings" action="/lend/edit">
    <form:hidden path="id"/>
    Extend: <form:input path="extensionOfTheDeadline"/>
    Rent Date: <form:input path="rent"/>
    Return Date: <form:input path="returning"/><br>
    Book Edit:
    <form:select itemValue="id" itemLabel="title" path="book.id"
                 items="${books}" />
    User Edit:
    <form:select itemValue="id" itemLabel="email" path="user.id"
                 items="${users}" />



    <input type="submit" value="Save">
</form:form>


</body>
</html>
