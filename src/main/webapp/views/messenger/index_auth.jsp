<%--
  Created by IntelliJ IDEA.
  User: uladz
  Date: 14.08.2021
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lesson8.homework.view.Storage" %>
<%@ page import="lesson8.homework.model.User" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
    <h4> Привет, ${login} </h4>
</br>
<form action="messenger/chats">
    <button>Мои сообщения</button>
</form>
</br>
<form action="messenger/message">
    <button>Отправить сообщение</button>
</form>
</br>
<form action="messenger/signOut" method="post">
    <button>Выйти из аккаунта</button>
</form>
</body>
</html>
