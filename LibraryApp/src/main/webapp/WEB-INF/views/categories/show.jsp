<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 05.06.2022
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categorie's details</title>
</head>
<body>
<table>
    <thead>
    <th>Category</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${category.name}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
