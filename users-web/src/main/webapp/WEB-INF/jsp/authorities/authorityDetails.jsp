<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group details ${authority.authority}</title>
</head>
<body>

<c:url value="/authorities" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<label>Authority:</label> ${authority.authority}<br>
<label>Description:</label> ${authority.description}<br>
</body>
</html>