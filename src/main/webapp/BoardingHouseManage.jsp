<%@ page import="com.example.demopetservice.model.BoardingHouse" %>
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
    <h1>View Boarding House Profile</h1>
    <form>
        <table style="width:100%;border:1px solid black;">
            <%
                BoardingHouse house = new BoardingHouse();
                BoardingHouse profile = house.getBoardingprofile();
            %>
            <tr>
                <th scope="col">Boarding Name</th>
                <td border="1"> <%=profile.getBoardingName()%> </td>
            </tr>
            <tr>
                <th scope="col">Location</th>
                <td border="1"> <%=profile.getLocation()%> </td>
            </tr>
            <tr>
                <th scope="col">Available Space</th>
                <td border="1"> <%=profile.getSpaceAvailable()%> </td>
            </tr>
            <tr>
                <th scope="col">Facility</th>
                <td border="1"> <%=profile.getFacility()%> </td>
            </tr>
            <tr>
                <th scope="col">Pay</th>
                <td border="1"> <%=profile.getPay()%> </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <h1>Update Boarding Profile</h1>
    <form action="<%=request.getContextPath()%>/updateBoarding" method="post">
        <table style="with: 100%">
            <tr
                <td><input type="hidden" name="boardName" value="">profile.getBoardingName()</td>
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
                <td colspan="2" style="text-align: right;"><button type="Update">Add</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

