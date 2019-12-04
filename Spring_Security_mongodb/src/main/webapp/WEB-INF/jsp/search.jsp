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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body class="text-center">
	<h1 align="center">Welcome To Car Rental Service</h1>

	<form:form action="/searchCar" method="get" modelAttribute="search">
		<div align="center">
			<table>
				<tr>
					<td><label>Select City</label></td>
					<td><form:select path="city">
							<form:option value="">--- Select ---  </form:option>
							<form:option value="PUNE">Pune       </form:option>
							<form:option value="MUMBAI">Mumbai    </form:option>
							<form:option value="HYDREBAD">Hydrabad</form:option>
						</form:select></td>
					<td><form:errors path="city" /></td>
				</tr>
				<tr>
					<td><label>Select CarType</label></td>
					<td><form:select path="carType">
							<form:option value="">--- Select --- </form:option>
							<form:option value="SEDAN">Sedan </form:option>
							<form:option value="Suv">Suv</form:option>
							<form:option value="Hatchback">Hatchback</form:option>
							<form:option value="Tuvk">Tuvk          </form:option>
						</form:select></td>

					<td><form:errors path="carType" /></td>
				</tr>
				<tr>
					<td><label for="start">Start date:</label></td>
					<td><input type="date" id="start" name="startDt" /></td>
					<td><form:errors path="startDt" /></td>
				</tr>
				<tr>
					<td><label for="end">Start date:</label></td>
					<td><input type="date" id="end" name="endDt"></td>
					<td><form:errors path="endDt" /></td>
				</tr>
				<tr style="column-span: 3">
					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	<div align="center">
		<c:if test="${!empty api}">
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
				<c:forEach var="entry" items="${api}">
					<c:if test="${!empty entry.value}">
						<c:forEach items="${entry.value}" var="element">
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
									href="http://localhost:8082/bookcar?carId=${element.carId}&apiID=${element.apiAddress}">BOOK</a></td>
							</tr>
						</c:forEach>

					</c:if>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<div style="color: red;">${msg1}</div>
	<div style="color: green;">${msg}</div>
</body>
</html>