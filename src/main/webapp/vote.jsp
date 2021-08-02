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
    <table border="0">
        <tr>
            <td>
                <p><b>Who is the best artist?</b></p>
                <p><input type="radio" name="answer1" value="Selena Gomes" checked>Селена Гомес</p>
                <p><input type="radio" name="answer1" value="Katty Parry">Кэти Перри</p>
                <p><input type="radio" name="answer1" value="Eminem">Эминем</p>
                <p><input type="radio" name="answer1" value="Decl">Дэцл</p>
            </td>
            <td>
                <p><b>What is your favorite genre of music?</b></p>
                <p><input type="checkbox" name="answer2" value="Flock-music">Фолк-музыка</p>
                <p><input type="checkbox" name="answer2" value="Country">Кантри</p>
                <p><input type="checkbox" name="answer2" value="American music">Латиноамериканская музыка</p>
                <p><input type="checkbox" name="answer2" value="Blues">Блюз</p>
                <p><input type="checkbox" name="answer2" value="Rhythm and Blues">Ритм-н-блюз</p>
                <p><input type="checkbox" name="answer2" value="Jazz">Джаз</p>
                <p><input type="checkbox" name="answer2" value="Electric music">Электронная музыка</p>
                <p><input type="checkbox" name="answer2" value="Rock">Рок</p>
                <p><input type="checkbox" name="answer2" value="Hip-Hop">Хип-хоп</p>
                <p><input type="checkbox" name="answer2" value="Ticktonik">Тиктоник</p>
            </td>
            <td>
                <p><b>Tell us about yourself</b></p>
                <textarea name="comment" cols="50" rows="6"></textarea>
            </td>
        </tr>
        <tr>
                <td>
                <p><input align="center" type="reset" value="Clear">
                    <input type="submit" value="Send my vote!"></p>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
