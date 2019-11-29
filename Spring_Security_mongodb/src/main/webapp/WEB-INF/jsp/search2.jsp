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

	<form:form action="/searchCar" method="post" modelAttribute="search">
		<label>Select City</label>
		<!-- <select id="city" name="*">
			<option value="">--- Select ---</option>
			<option value="PUNE">Pune</option>
			<option value="MUMBAI">Mumbai</option>
			<option value="HYDREBAD">Hydrabad</option>
		</select> -->
		<form:select path="city">
		    <form:option value="">--- Select ---  </form:option> 
			<form:option value="PUNE">Pune       </form:option> 
			<form:option value="MUMBAI">Mumbai    </form:option> 
			<form:option value="HYDREBAD">Hydrabad</form:option> 
		</form:select>    <form:errors path="city" />                               
		
		<label>Select CarType</label>
		<form:select path="carType" >
			<form:option value="">--- Select ---    </form:option>
			<form:option value="SEDAN">Sedan        </form:option>
			<form:option value="Suv">Suv            </form:option>
			<form:option value="Hatchback">Hatchback</form:option>
			<form:option value="Tuvk">Tuvk          </form:option>
		</form:select><form:errors path="carType" />
		
		<label for="start">Start date:</label>
		<input type="date" id="start" name="startDt" /><form:errors path="*" />
		<label for="end">Start date:</label>
		<input type="date" id="end" name="endDt"><form:errors path="*" />
		<input type="submit" value="submit" />
	</form:form>
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
					<td><img
						src="images/${element.carType}/${element.carModel}.jpg"
						width="300" height="300" /><a
						href="http://localhost:8080/bookcar?carId=${element.carId}">BOOK</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div>${msg1}</div>
	<div>${msg}</div>
</body>
</html>