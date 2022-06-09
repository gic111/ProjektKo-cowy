<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 06.06.2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>LendBook</title>
</head>
<body>

<form:form action="/lend/add" method="post" modelAttribute="lendings">
    Books:
    <form:select itemValue="id" itemLabel="title" path="books"
                 items="${books}" />
    Users:
    <form:select itemValue="id" itemLabel="firstName" path="users"
                 items="${users}" />

    <input type="submit" value="save">
</form:form>
</body>
</html>