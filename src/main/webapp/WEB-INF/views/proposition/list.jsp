<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 20.03.19
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>

<h2>Proposition books</h2>
<a href="${pageContext.request.contextPath}/proposition/form">Add new proposition</a>
<a href="${pageContext.request.contextPath}/book/list">Book list</a>

<c:forEach items="${books}" var="book">
    <li>
            ${book.title} ${book.description}
        <a href="${pageContext.request.contextPath}/proposition/edit/${book.id}">Edit</a>
        <a href="${pageContext.request.contextPath}/proposition/delete/${book.id}">Delete</a>
        <a href="${pageContext.request.contextPath}/book/edit/${book.id}">Upgrade to book</a>
    </li>
</c:forEach>

</body>
</html>
