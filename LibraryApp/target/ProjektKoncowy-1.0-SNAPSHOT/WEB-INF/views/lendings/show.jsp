<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 06.06.2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Lends</title>
    <a href="<c:url value="/books/all"/>">Books</a>
    <a href="<c:url value="/users/all"/>">Users</a>
    <a href="<c:url value="/categories/all"/>">Categories</a>
    <a href="<c:url value="/lend/all"/>">Lendings</a>
</head>
<body>
<table>
    <thead>
    <th>Id</th>
    <th>Rent Date</th>
    <th>Return Date</th>
    <th>Book Name</th>
    <th>User Name</th>
    <th>Extension </th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${lendings.id}"/></td>
        <td><c:out value="${lendings.rent}"/></td>
        <td><c:out value="${lendings.returning}"/></td>
        <td><c:out value="${lendings.book.title}"/></td>
        <td><c:out value="${lendings.user.toString()}"/></td>
        <td><c:out value="${lendings.extensionOfTheDeadline}"/></td>

    </tr>
    </tbody>
</table>

</body>
</html>
