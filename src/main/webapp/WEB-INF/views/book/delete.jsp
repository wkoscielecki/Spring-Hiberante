<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>

<h4>Czy na pewno chcesz usunąć książkę ${book.title}?</h4>
<a href="/book/delete/true/${book.id}">TAK</a>
<a href="/book/list">NIE</a>

</body>
</html>
