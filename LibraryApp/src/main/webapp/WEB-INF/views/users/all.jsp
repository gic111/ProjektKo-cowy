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
    <title>Users list</title>
    <a href="<c:url value="/books/all"/>">Books</a>
    <a href="<c:url value="/users/all"/>">Users</a>
    <a href="<c:url value="/categories/all"/>">Categories</a>
    <a href="<c:url value="/lend/all"/>">Lendings</a><br>
</head>
<body>
<a href="<c:url value="/users/add"/>">Add User</a>
<table>
    <thead>
    <th>Fisrt Name</th>
    <th>Last Name</th>
    <th>Pesel</th>
    <th>Email</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.pesel}"/></td>
            <td><c:out value="${user.email}"/></td>

            <td>
                <a href="<c:url value="/users/delete/${user.id}"/>">Delete</a>
                <a href="<c:url value="/users/edit/${user.id}"/>">Update</a>
                <a href="<c:url value="/users/show/${user.id}"/>">Detalis</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>