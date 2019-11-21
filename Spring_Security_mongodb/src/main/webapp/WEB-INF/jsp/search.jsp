<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Car Rental Service</h1>

	<form action="/searchCar">
		<select id="city" name="city">
			<option value="0">--- Select ---</option>
			<option value="PUNE">Pune</option>
			<option value="MUMBAI">Mumbai</option>
			<option value="HYDREBAD">Hydrabad</option>
		</select> <select id="carType" name="carType">
			<option value="0">--- Select ---</option>
			<option value="SEDAN">Sedan</option>
			<option value="Suv">Suv</option>
			<option value="Hatchback">Hatchback</option>
			<option value="Tuvk">Tuvk</option>
		</select> <label for="start">Start date:</label> <input type="date" id="start"
			name="startDt" /> <label for="end">Start date:</label> <input
			type="date" id="end" name="endDt"> <input type="submit"
			value="submit" />
	</form>
	<c:if test="${!empty api1}">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Car Type</th>
				<th>From Date</th>
				<th>To Date</th>
				<th>FARE</th>
				<th>Car Model</th>
				<th>Book</th>
			</tr>
			<c:forEach items="${api1}" var="element">
				<tr>
					<td>${element.carId}</td>
					<td>${element.carType}</td>
					<td>${element.startDt}</td>
					<td>${element.endDt}</td>
					<td>${element.fare}</td>
					<td>${element.carModel}</td>
					<td><a
						href="http://localhost:8080/bookcar?carId=${element.carId}">BOOK</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div>${msg}</div>
</body>
</html>