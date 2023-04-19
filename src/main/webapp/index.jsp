<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="Style/login.css">
</head>
<body>
<h1>Welcome to PetLover</h1>
<% if(request.getAttribute("message") != null) { %>
<div class="error-message">
    <%= request.getAttribute("message") %>
</div>
<% } %>
<div class="container">
    <h1>Login</h1>
    <form action="<%=request.getContextPath()%>/LogInServlet" method="post">
        <table style="with: 90%">
            <tr>
                <td>Email</td>
                <td><input type="text" id="email" name="email" placeholder="Enter your email" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" id="password" name="password" placeholder="Enter your password" required></td>
            </tr>
            <tr>
                <td>Usertype</td>
                <td><select class="input-style" id="usertype" name="usertype" required>
                    <option value="1">PetOwner</option>
                    <option value="2">PetSitter</option>
                    <option value="3">BoardingHouseOwner</option>
                </select> </td>
            </tr>
        </table>
        <button type="submit">Login</button>
    </form>
    <p>Don't have an account? <a href="SignUp.jsp">Sign up</a></p>
</div>
</body>
</html>
