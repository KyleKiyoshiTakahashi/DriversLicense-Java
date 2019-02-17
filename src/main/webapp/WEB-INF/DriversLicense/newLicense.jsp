<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<h1>New License</h1>

<form:form action="/licenses" method="POST" modelAttribute="license">
    <form:label path="person">Name:
				<form:select path="person">
					<c:forEach items="${allPersons}" var="p">
        					<form:option value="${p.id}"><c:out value="${p.firstName} ${p.lastName}"/></form:option>
   					</c:forEach>
				</form:select>
			</form:label>
    
    <form:label path="state">State: </form:label>
        <form:errors path="state"/>
    <form:input path="state"/>
     
     <form:label path="expiration_date">Exp Date:
		<form:errors path="expiration_date"/>
		<form:input path="expiration_date" type="date"/>
	</form:label>
     
    <input type="submit" value="Create"/>
</form:form> 

</body>
</html>