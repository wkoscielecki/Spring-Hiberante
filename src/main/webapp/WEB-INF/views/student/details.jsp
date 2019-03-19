<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Student details:</h2>
<ul>
    <li>Name: ${student.firstName}</li>
    <li>Surname: ${student.lastName}</li>
    <li>Gender: ${student.gender}</li>
    <li>Country: ${student.country}</li>
    <li>Notes: ${student.notes}</li>
    <li>Mailing: ${student.mailingList}</li>
    <li>Hobbies: ${student.hobbies}</li>
    <li>Skills: ${student.programmingSkills}</li>
</ul>
</body>
</html>
