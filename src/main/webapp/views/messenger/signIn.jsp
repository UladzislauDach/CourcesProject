<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<p style="color: red"><%=(String) request.getAttribute("info")%></p>
<form action="signIn" method="post">
    <p><b>Вход в аккаунт</b></p>
    <p>
        <label for="login">Логин: </label>
        <input id="login" type="text" name="login">
    </p>
    <p>
        <label for="password">Пароль: </label>
        <input id="password" type="password" name="password">
    </p>
    <p><input type="submit" value="Войти"></p>
</form>
<form action="/app/messenger">
    <button>Главная страница</button>
</form>
<form action="signUp">
    <button>Зарегистрироваться</button>
</form>
</body>
</html>
