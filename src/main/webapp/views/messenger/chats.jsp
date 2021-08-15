<%@ page import="lesson8.homework.view.Storage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="lesson8.homework.model.Message" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сообщения</title>
</head>
<body>
<h4>Ваши сообщения:</h4>
<table border="1">
    <tr>
        <td>От кого</td>
        <td>Время отправки</td>
        <td>Текст сообщения</td>
    </tr>
    <c:forEach var="message" items="${listMessage}">
        <tr>
            <td>${message.getFrom()}</td>
            <td>${message.getSendAt()}</td>
            <td>${message.getText()}</td>
        </tr>
    </c:forEach>
</table>
</br>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
</body>
</html>
