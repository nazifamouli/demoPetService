<%@ page import="com.example.demopetservice.model.User" %>
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
  <a href="PetSitterHome.jsp">Home Page</a>
  <a href="ViewJobOffer.jsp">View JobOffer</a>
  <a href="PetSitterApplication.jsp">Apply History</a>
  <a href="PetSitterProfile.jsp">User Profile</a>
  <form action="<%=request.getContextPath()%>/logout" method="GET">
    <button type="submit">Logout</button>
  </form>
</div>

<!-- Page content -->
<div class="container">
  <h1>View UserProfile</h1>
  <form>
    <table style="width:100%;border:1px solid black;">
      <%
        User user = new User();
        User profile = user.userProfile();
      %>
      <tr>
        <th scope="col">Name</th>
        <td border="1"> <%=profile.getName()%> </td>
      </tr>
      <tr>
        <th scope="col">Age</th>
        <td border="1"> <%=profile.getAge()%> </td>
      </tr>
      <tr>
        <th scope="col">email</th>
        <td border="1"> <%=profile.getEmail()%> </td>
      </tr>
      <tr>
        <th scope="col">Contact</th>
        <td border="1"> <%=profile.getContact()%> </td>
      </tr>
      <tr>
        <th scope="col">Address</th>
        <td border="1"> <%=profile.getAddress()%> </td>
      </tr>
      <tr>
        <th scope="col">City</th>
        <td border="1"> <%=profile.getCity()%> </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

