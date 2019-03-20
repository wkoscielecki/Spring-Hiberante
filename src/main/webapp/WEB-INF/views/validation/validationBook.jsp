<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 20.03.19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
<c:forEach items="${violations}" var="err">
    <li>
        Nazwa pola: ${err.propertyPath}  Błąd- ${err.message}
    </li>
</c:forEach>
</ul>
</body>
</html>
