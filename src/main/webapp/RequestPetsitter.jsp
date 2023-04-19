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
    <a href="PetOwnerProfile.jsp">User Profile</a>
    <form action="<%=request.getContextPath()%>/logout" method="GET">
        <button type="submit">Logout</button>
    </form>
</div>

<!-- Page content -->
<div class="container">
    <h1>Request PetSitter</h1>
    <form action="<%=request.getContextPath()%>/requestPetSitter" method="post">
        <table style="with: 90%">
            <tr>
                <td>Title</td>
                <td><input type="text" id="title" name="title" placeholder="Enter Title" required></td>
            </tr>
            <tr>
                <td>Location</td>
                <td><input type="text" id="location" name="location" placeholder="location" required> </td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" id="city" name="city" placeholder="city" required></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="number" id="salary" name="salary" placeholder="salary" required></td>
            </tr>
            <tr>
                <td>Working Hour</td>
                <td><input type="text" id="workinghour" name="workinghour" placeholder="workinhhour" size="50" required></td>
            </tr>
            <tr>
                <td>Extra Details</td>
                <td><input type="text" id="info" name="info" placeholder="Extra Details"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><button type="add">Add Request</button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
