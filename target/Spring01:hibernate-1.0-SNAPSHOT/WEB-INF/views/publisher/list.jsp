<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>


<h2>Publishers</h2>
<a href="${pageContext.request.contextPath}/publisher/form">Add new</a>

<ul>
    <c:forEach items="${publishers}" var="publisher">
        <li>
            ${publisher.name}
            <a href="${pageContext.request.contextPath}/publisher/edit/${publisher.id}">Edit</a>
            <a href="${pageContext.request.contextPath}/publisher/delete/${publisher.id}">Delete</a>

        </li>

    </c:forEach>
</ul>

</body>
</html>
