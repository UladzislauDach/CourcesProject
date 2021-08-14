<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<form action="registration" method="post">
    <p><b>Заполните данные для регистрации</b></p>
    <p>
        <label for="login">login: </label>
        <input value="test" id="login"  type="text" name="login">
    </p>
    <p>
        <label for="password">password: </label>
        <input value="test" id="password" type="text" name="password">
    </p>
    <p>
        <label for="name">name: </label>
        <input value="test" id="name" type="text" name="name">
    </p>
    <p>
        <label for="birth">birth: </label>
        <input value="test" id="birth" type="text" name="birth">
    </p>
    <p><input type="reset" value="Очистить"><input type="submit" value="Зарегистрироваться"></p>
</form>
</body>
</html>
