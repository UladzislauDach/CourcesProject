<%--
  Created by IntelliJ IDEA.
  User: uladz
  Date: 14.08.2021
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<%@ page import="lesson8.homework.view.Storage" %>
<%@ page import="lesson8.homework.model.User" %>
<h4>
    <%
        User user = Storage.getInstance().getUser((String) session.getAttribute("login"),
                (String) session.getAttribute("password"));
    %>
    Привет, <%=user.getName() + user.getPassword()%>
</h4>
</br>
<form action="messenger/registration">
    <button>Мои сообщения</button>
</form>
</br>
<form action="messenger/login">
    <button>Отправить сообщение</button>
</form>
</br>
<form action="messenger/logout" method="post">
    <button>Выйти из аккаунта</button>
</form>
</body>
</html>
