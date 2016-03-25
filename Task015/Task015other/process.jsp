<%--
  Created by IntelliJ IDEA.
  User: ruslanzigansin
  Date: 25.03.16
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method='post' action='/process'><textarea rows='10' cols='45' name='text'></textarea><br>
    <select name='Choice'>
    <option value='Amount of Characters'>Amount of Characters</option>
    <option value='Amount of Words'>Amount of Words</option>
    <option value='Amount of Sentences'>Amount of Sentences</option>
    <option value='Amount of Paragraphs'>Amount of Paragraphs</option>
</select>
    <br><input type='submit' value='Process'>
</form>
</body>
</html>
