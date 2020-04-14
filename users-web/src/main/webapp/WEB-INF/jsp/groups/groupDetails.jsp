<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group details ${group.groupName}</title>
</head>
<body>

<c:url value="/groups" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<label>Group Name:</label> ${group.groupName}<br>
<label>Description:</label> ${group.description}<br>
</body>
</html>