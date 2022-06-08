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
    <title>Categories list</title>
</head>
<body>
<a href="<c:url value="/lend/add"/>">Lend Book</a>
<table>
    <thead>
    <th>Renting id</th>
    <th>Rent Date</th>
    <th>Return Date</th>
    <th>Extension Number</th>

    </thead>
    <tbody>
    <c:forEach items="${lendings}" var="lending">
        <tr>
            <td><c:out value="${lending.id}"/></td>
            <td><c:out value="${lending.rent}"/></td>
            <td><c:out value="${lending.returning}"/></td>
            <td><c:out value="${lending.extensionOfTheDeadline}"/></td>

            <td>
                <a href="<c:url value="/ledings/delete/${lending.id}"/>">Delete</a>
                <a href="<c:url value="/lendings/edit/${lending.id}"/>">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
