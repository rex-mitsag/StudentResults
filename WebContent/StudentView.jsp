<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student View</title>
</head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
</style>
<body>
<form action="ResultsController">
Semester: <select name="sem"><option value="1">Semester 1</option>
<option value="2">Semester 2</option><option value="3">Semester 3</option>
<option value="4">Semester 4</option><option value="5">Semester 5</option>
<option value="6">Semester 6</option><option value="7">Semester 7</option>
<option value="8">Semester 8</option></select><br>
<input type="submit" value="Get Results">

</form>
</body>
</html>