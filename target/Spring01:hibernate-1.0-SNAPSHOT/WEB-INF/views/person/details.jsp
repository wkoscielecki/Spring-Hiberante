<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/person/list">Show all</a>
<a href="${pageContext.request.contextPath}/person/form">Add new</a>


<h2>Person details</h2>
<ul>
    <li>Login: ${person.login}</li>
    <li>Email: ${person.email}</li>
    <li><a href="${pageContext.request.contextPath}/person/edit/${person.id}">Edit</a></li>

</ul>

</body>
</html>
