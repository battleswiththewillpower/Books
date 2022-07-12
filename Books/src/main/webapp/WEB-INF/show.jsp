<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Title: <c:out value="${book.title}"/></h1>
<p>DESC: <c:out value="${book.description}"/></p>
<p>Lang: <c:out value="${book.language}"/></p>
<p>Num of pages: <c:out value="${book.numberOfPages}"/></p>
<a href="/books">Go Back</a>

</body>
</html>