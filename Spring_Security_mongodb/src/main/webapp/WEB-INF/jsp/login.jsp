
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<<html>
    <head>
        <title>Login</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
        <link rel="stylesheet" href="/css/style.css" />
    </head>
    <body class="text-center">
    <h1 align="center">Welcome To Rental Services</h1>
        <div layout:fragment="content">
            <form class="form-signin" action="/login" method="post">
                <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72" />
                <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                <div>
                <c:if test="${param.error}">
                    Invalid email and password.
                    </c:if>
                </div>
                <div >
                  <c:if test="${param.logout}">
                    You have been logged out.
                    </c:if>
                </div>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required="" />
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <form class="form-signin" action="/signup" method="get">
                <button class="btn btn-md btn-success btn-block" type="Submit">Signup Here</button>
            </form>
        </div>
    </body>
</html>
