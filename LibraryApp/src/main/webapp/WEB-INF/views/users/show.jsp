<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 05.06.2022
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User details</title>
</head>
<body>
<table>
    <thead>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Pesel</th>
    <th>Email</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${user.fistName}"/></td>
        <td><c:out value="${user.lasrName}"/></td>
        <td><c:out value="${user.pesel}"/></td>
        <td><c:out value="${user.email}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>