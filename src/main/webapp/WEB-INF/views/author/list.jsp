<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>

<h2>Authors</h2>
<a href="${pageContext.request.contextPath}/author/form">Add author</a>
<c:forEach items="${authors}" var="author">
    <li>
            ${author.fullName}
        <a href="${pageContext.request.contextPath}/author/edit/${author.id}">Edit</a>
        <a href="${pageContext.request.contextPath}/author/delete/${author.id}">Delete</a>

    </li>
</c:forEach>


</body>
</html>
