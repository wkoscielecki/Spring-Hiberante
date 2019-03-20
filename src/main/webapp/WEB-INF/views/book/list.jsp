<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>

<h2>Books</h2>
<a href="${pageContext.request.contextPath}/book/form">Add book</a>
<a href="${pageContext.request.contextPath}/proposition/form">Add new proposition</a>
<a href="${pageContext.request.contextPath}/proposition/list">Book proposition</a>

<c:forEach items="${books}" var="book">
    <li>
        ${book.title}
        <a href="${pageContext.request.contextPath}/book/edit/${book.id}">Edit</a>
        <a href="${pageContext.request.contextPath}/book/delete/${book.id}">Delete</a>
    </li>
</c:forEach>
</body>
</html>
