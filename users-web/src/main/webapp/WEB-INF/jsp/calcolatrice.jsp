<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcolatrice</title>
</head>
<body>
	<c:url value="/calc" var="submitUrl" />
	<form action="${submitUrl}">
		<label>Op1</label> <input name="op1" type="number" value="${param.op1}">
		<label>Op2</label> <input name="op2" type="number" value="${param.op2}">
		<input type="submit" name="somma" value="+">
		<input type="submit" name="sottrai" value="-">
		<input type="submit" name="moltiplica" value="*">
		<input type="submit" name="dividi" value="/">
	</form>
	<c:if test="${not empty risultato}">
		<h1>Il risultato della ${operazione} &egrave;</h1>
		<h2>
			&clubs; ${risultato} &clubs;
		</h2>
	</c:if>
</body>
</html>