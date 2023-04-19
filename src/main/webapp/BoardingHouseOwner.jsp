<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="cache-control" content="no-cache, must-revalidate, post-check=0, pre-check=0">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="pragma" content="no-cache">
    <title>My Homepage</title>
    <link rel="stylesheet" type="text/css" href="Style/home.css">
</head>
<body onload="setTimeout(noBack, 0);" onpageshow="if (event.persisted) noBack();" onunload="">
<script>
    function noBack() {
        window.history.forward();
    }
</script>
<!-- Navigation bar -->
<div class="navbar">
    <a href="BoardingHouseOwner.jsp">Home Page</a>
    <a href="ViewBooking.jsp">View Bookings</a>
    <a href="BoardingHouseManage.jsp">Manage Boarding House</a>
    <a href="BoardingHouse.jsp">AddBoarding</a>
    <a href="BoardingOwnerProfile.jsp">User Profile</a>
    <form action="<%=request.getContextPath()%>/logout" method="GET">
        <button type="submit">Logout</button>
    </form>
</div>

<!-- Page content -->
<div class="container">
    <h1>Welcome to Pet Lover Service</h1>
    <p>This is a Home page dedicated for Boarding House Owner. Start your business by adding details in Manage Boarding System</p>
    <a href="BoardingOwnerProfile.jsp" class="cta-button">Get Started</a>
</div>

</body>
</html>

