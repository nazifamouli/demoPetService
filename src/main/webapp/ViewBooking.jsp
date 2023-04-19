<%@ page import="com.example.demopetservice.model.BooKBoarding" %>
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
  <a href="BoardingHouseOwner.jsp">Home Page</a>
  <a href="ViewBooking">View Bookings</a>
  <a href="BoardingHouseManage.jsp">Manage Boarding House</a>
  <a href="BoardingHouse.jsp">AddBoarding</a>
  <a href="BoardingOwnerProfile.jsp">User Profile</a>
  <form action="<%=request.getContextPath()%>/logout" method="GET">
    <button type="submit">Logout</button>
  </form>
</div>

<!-- Page content -->
<div class="container">
  <h1>View Boarding List</h1>
  <form action="<%= request.getContextPath()%>/ViewBooking" method="get">
    <table style="width:100%;border:1px solid black;">
      <thead>
      <tr>
        <th scope="col">Boarding House Name</th>
        <th scope="col">Customer Id</th>
        <th scope="col">Customer Name</th>
        <th scope="col">Customer Address</th>
        <th scope="col">Customer Contact</th>
      </tr>
      </thead>
      <%
        BooKBoarding booking = new BooKBoarding();
        List<BooKBoarding> houselist = booking.getBookingList();
        if (houselist != null){
          for(BooKBoarding book : houselist){
      %>
      <tr>
        <td border="1"> <%=book.getBoardName()%> </td>
        <td border="1"> <%=book.getCustomerId()%> </td>
        <td border="1"> <%=book.getCustomerName()%> </td>
        <td border="1"> <%=book.getCustomerAddress()%> </td>
        <td border="1"> <%=book.getCustomerContact()%> </td>
      </tr>
    <%
         }
      }
    %>
    </table>
  </form>
</div>


</body>
</html>

