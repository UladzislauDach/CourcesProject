<%--
  Created by IntelliJ IDEA.
  User: uladz
  Date: 31.07.2021
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote</title>
</head>
<body>
<form action="/app/vote" method="post">
    <p><b>Кто по вашему лучший исполнитель?</b></p>
    <p><input type="radio" name="answer1" value="a1" checked>Селена Гомес</p>
    <p><input type="radio" name="answer1" value="a2">Кэти Перри</p>
    <p><input type="radio" name="answer1" value="a3">Эминем</p>
    <p><input type="radio" name="answer1" value="a4">Дэцл</p>
    <br>
    <p><input type="checkbox" name="answer2" value="b1">Фолк-музыка</p>
    <p><input type="checkbox" name="answer2" value="b2">Кантри</p>
    <p><input type="checkbox" name="answer2" value="b3">Латиноамериканская музыка</p>
    <p><input type="checkbox" name="answer2" value="b4">Блюз</p>
    <p><input type="checkbox" name="answer2" value="b5">Ритм-н-блюз</p>
    <p><input type="checkbox" name="answer2" value="b6">Джаз</p>
    <p><input type="checkbox" name="answer2" value="b7">Электронная музыка</p>
    <p><input type="checkbox" name="answer2" value="b8">Рок</p>
    <p><input type="checkbox" name="answer2" value="b9">Хип-хоп</p>
    <p><input type="checkbox" name="answer2" value="b10">Тиктоник</p>
    <textarea name="comment" cols="40" rows="3"></textarea>
    <p><input type="reset" value="Очистить"><input type="submit" value="Отдать голос"></p>
</form>
</body>
</html>
