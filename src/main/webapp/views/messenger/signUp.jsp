<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<p style="color: red"><%=(String) request.getAttribute("info")%></p>
<form action="signUp" method="post">
    <p><b>Заполните данные для регистрации</b></p>
    <p>
        <label for="login">login: </label>
        <input id="login"  type="text" name="login">
    </p>
    <p>
        <label for="password">password: </label>
        <input id="password" type="text" name="password">
    </p>
    <p>
        <label for="name">name: </label>
        <input id="name" type="text" name="name">
    </p>
    <p>
        <label for="birth">birth: </label>
        <input id="birth" type="text" name="birth">
    </p>
    <p><input type="reset" value="Очистить"><input type="submit" value="Зарегистрироваться"></p>
</form>
</body>
</html>
