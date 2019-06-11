<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty View</title>
</head>
<body>
<strong><h1>Add Results</h1></strong><br>
<br> 
<form action="AddResultController">
Student ID: <input type="text" name="studentid"><br>
Subject ID: <input type="text" name="subjectid"><br>
Exam Type: <select name="examtype"><option value="Mid-Sem 1">Mid Sem 1</option>
<option value="Mid-Sem 2">Mid Sem 2</option><option value="Comprehensive">Comprehensive</option></select><br>
Marks Obtained: <input type="text" name="marks"><br>
Max Marks: <input type="text" name="maxmarks"><br>
<input type="submit" value="Add Result"><br>
</form>
</body>
</html>