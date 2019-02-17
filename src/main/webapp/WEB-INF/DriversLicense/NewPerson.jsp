<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/persons" method="POST" modelAttribute="person">
      <p>
        <form:label path="firstName">First Name: </form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
     </p>
    <p>
        <form:label path="lastName">Last Name: </form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>    
    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>