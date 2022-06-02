<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 30.05.2022
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form:form action="/form/user" method="post" modelAttribute="user">
First Name : <form:input path="firstName"/>
Last Name:<form:input path="lastName"/>
Email:<form:input path="email"/>
Pesel:<form:input path="pesel"/>

<input type="submit" value="save">
</form:form>

</body>
</html>
