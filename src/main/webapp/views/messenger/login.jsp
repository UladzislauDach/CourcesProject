<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<p style="color: red"><%=(String) request.getAttribute("info")%></p>
<form action="login" method="post">
    <p><b>Вход в аккаунт</b></p>
    <p>
        <label for="login">Логин: </label>
        <input id="login" type="text" name="login">
    </p>
    <p>
        <label for="password">Пароль: </label>
        <input id="password" type="text" name="password">
    </p>
    <p><input type="reset" value="Очистить"><input type="submit" value="Войти"></p>
</form>
</body>
</html>
