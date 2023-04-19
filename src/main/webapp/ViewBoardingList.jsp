<%@ page import="com.example.demopetservice.model.BoardingHouse" %>
<%@ page import="java.util.List" %>
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
    <h1>View Boarding List</h1>
    <form action="<%= request.getContextPath() %>/viewBoardingHouse" method="get">
        <table style="width:100%;border:1px solid black;">
            <thead>
            <tr>
                <th scope="col">Boarding Owner Id</th>
                <th scope="col">Boarding House Name</th>
                <th scope="col">location</th>
                <th scope="col">Available Space</th>
                <th scope="col">Facility</th>
                <th scope="col">Pay</th>
                <th scope="col">Extra Details</th>
            </tr>
            </thead>
            <%
                BoardingHouse house = new BoardingHouse();
                List<BoardingHouse> houselist = house.getBoardingHouseList();
                for(BoardingHouse boardhouse : houselist){
            %>
            <tr>
                <td border="1"><%=boardhouse.getOwnerId()%></td>
                <td border="1"><%=boardhouse.getBoardingName() %></td>
                <td border="1"><%=boardhouse.getLocation()%></td>
                <td border="1"><%=boardhouse.getSpaceAvailable()%></td>
                <td border="1"><%=boardhouse.getFacility()%></td>
                <td border="1"><%=boardhouse.getPay()%></td>
                <td border="1"><%=boardhouse.getExtraInfo()%></td>
                <form action="<%= request.getContextPath() %>/bookBoarding" method="post">
                    <input type="hidden" name="ownerId" value="<%=boardhouse.getOwnerId()%>">
                    <input type="hidden" name="boardingName" value="<%=boardhouse.getBoardingName()%>">
                    <td colspan="2" style="text-align: right;"><button class="submit-button" type="submit">Book</button></td>
                </form>
            </tr>
            <%
                }
            %>
        </table>
    </form>
</div>

</body>
</html>
