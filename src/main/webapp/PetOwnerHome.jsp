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
    <a href="PetOwnerHome.jsp">Home Page</a>
    <a href="ViewBoardingList.jsp">View BoardingFacility</a>
    <a href="RequestPetsitter.jsp">Request PetSitter</a>
    <a href="AppliedPetsitter.jsp">Job Application</a>
    <a href="PetOwnerBooking.jsp">Booking History</a>
    <a href="PetOwnerProfile.jsp">User Profile</a>
    <form action="<%=request.getContextPath()%>/logout" method="GET">
        <button type="submit">Logout</button>
    </form>
</div>

<!-- Page content -->
<div class="container">
    <h1>Welcome to Pet Lover Service</h1>
    <p> This Pet Owner Home Page. You can start by adding your pet details in pet service. It will help you to orgainise specific info</p>
    <a href="PetOwnerProfile.jsp" class="cta-button">Get Started</a>
</div>

</body>
</html>
