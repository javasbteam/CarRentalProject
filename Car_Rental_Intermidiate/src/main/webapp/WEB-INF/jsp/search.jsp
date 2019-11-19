<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome To Car Rental Service </h1>

<form action="/searchCar">
<select id="city" name="city">
   <option value="0">--- Select ---</option> 
   <option value="1">Pune</option>
   <option value="2">Mumbai</option>
   <option value="3">Hydrabad</option>
</select> 


<select id="carType" name="carType">
   <option value="0">--- Select ---</option> 
   <option value="1">Sedan</option>
   <option value="2">Suv</option>
   <option value="3">Hatchback</option>
   <option value="4">Tuvk</option>   
</select> 

<label for="start">Start date:</label>

<input type="date" id="start" name="fromDate"
       value="2019-11-22"
       min="2019-01-01" max="2019-12-31">
       
       
       <label for="end">Start date:</label>

<input type="date" id="end" name="toDate"
       value="2019-11-22"
       min="2019-01-01" max="2019-12-31">

<input type="submit" value ="submit">
</form>
</body>
</html>