<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="Style/register.css">
</head>
<body>
<div class="container">
    <h1>Register</h1>
    <form action="<%= request.getContextPath()%>/SignUpServlet" method="post">
        <input type="text" id="name" name="name" placeholder="Enter your full name" required>
        <input type="text" id="age" name="age" placeholder="Enter your age">
        <input type="text" id="email" name="email" placeholder="Enter your email" required>
        <input type="text" id="contact" name="contact" placeholder="Enter your contact number" required>
        <input type="text" id="address" name="address" placeholder="Enter your address" required>
        <input type="text" id="city" name="city" placeholder="Enter your city">
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
        <select class="input-style" id="type" name="usertype" required>
            <option value="1">PetOwner</option>
            <option value="2">PetSitter</option>
            <option value="3">BoardingHouseOwner</option>
        </select>
        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="index.jsp">Login</a></p>
</div>
</body>
</html>
