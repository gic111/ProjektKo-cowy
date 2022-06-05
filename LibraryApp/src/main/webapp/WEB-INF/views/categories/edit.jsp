<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 05.06.2022
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update category</title>
</head>
<body>
<form:form modelAttribute="categories" action="/categories/edit">
  <form:hidden path="id"/>
  Name: <form:input path="name"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
