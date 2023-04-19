<%@ page import="com.example.demopetservice.model.Job" %>
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
  <h1>View Job Application List</h1>
  <table style="width:100%;border:1px solid black;">
    <thead>
    <tr>
      <th scope="col">PetSitter Name</th>
      <th scope="col">PetSitter Contact</th>
      <th scope="col">Job Address</th>
      <th scope="col">Job salary</th>
      <th scope="col">Working Hour</th>
      <th scope="col">Job status</th>
    </tr>
    </thead>
    <%
      Job applied = new Job();
      List<Job> jobList = applied.viewAppliedList();
      if (jobList != null){
        for(Job apply : jobList){
    %>
    <tr>
      <td border="1"> <%=apply.getPetSitterName()%> </td>
      <td border="1"> <%=apply.getPetSitterContact()%> </td>
      <td border="1"> <%=apply.getJobAdd()%> </td>
      <td border="1"> <%=apply.getJobSalary()%> </td>
      <td border="1"> <%=apply.getJobHour()%> </td>
      <td border="1"> <%=apply.getJobConfirm()%></td>
    </tr>
    <%
      }
      }
    %>
  </table>
</div>
</body>
</html>

