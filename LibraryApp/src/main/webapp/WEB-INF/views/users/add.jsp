<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 05.06.2022
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>

<form:form action="/users/add" method="post" modelAttribute="user">
    First Name: <form:input path="firstName"/>
    Last Name:<form:input path="lastName"/>
    Pesel:<form:input path="pesel"/>
    Email:<form:input path="email"/>

    <input type="submit" value="save">
</form:form>
</body>
</html>