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
    <h1>List Boarding House</h1>
    <form action="<%=request.getContextPath()%>/AddBoardingHouse" method="post">
        <table style="with: 100%">
            <tr>
                <td>BoardingName</td>
                <td><input type="text" id="boardingName" name="boardingName" placeholder="Enter boardingName" required></td>
            </tr>
            <tr>
                <td>Location</td>
                <td><input type="text" id="location" name="location" placeholder="location" size="20" required> </td>
            </tr>
            <tr>
                <td>Available Space</td>
                <td><input type="number" id="spaceAvailable" name="spaceAvailable" placeholder="spaceAvailable" required></td>
            </tr>
            <tr>
                <td>Facility</td>
                <td><input type="text" id="facility" name="facility" placeholder="facility" size="30" required></td>
            </tr>
            <tr>
                <td>Pay per Day</td>
                <td><input type="number" id="pay" name="pay" placeholder="pay" required></td>
            </tr>
            <tr>
                <td>Extra Details</td>
                <td><input type="text" id="info" name="info" placeholder="Extra Details" size="40"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><button type="add">Add</button></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>

