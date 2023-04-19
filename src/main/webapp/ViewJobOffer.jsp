<%@ page import="com.example.demopetservice.model.PetSitter" %>
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
    <h1>View Available Job List</h1>
    <form action="<%= request.getContextPath() %>/viewJobOffer" method="get">
        <table style="width:100%;border:1px solid black;">
            <thead>
            <tr>
                <th scope="col">Job Id</th>
                <th scope="col">Employer Id</th>
                <th scope="col">Title</th>
                <th scope="col">location</th>
                <th scope="col">City</th>
                <th scope="col">Salary</th>
                <th scope="col">Job Hour</th>
                <th scope="col">Job Details</th>
            </tr>
            </thead>
            <%
                PetSitter job = new PetSitter();
                List<PetSitter> joblist = job.getJobList();
                if (joblist != null){
                    for(PetSitter jobs : joblist){
            %>
            <tr>
                <td border="1"><%=jobs.getIdJobOffer()%></td>
                <th border="1"><%=jobs.getRequesterId()%></th>
                <td border="1"><%=jobs.getTitle() %></td>
                <td border="1"><%=jobs.getLocation()%></td>
                <td border="1"><%=jobs.getCity()%></td>
                <td border="1"><%=jobs.getSalary()%></td>
                <td border="1"><%=jobs.getWorkingHour()%></td>
                <td border="1"><%=jobs.getDetails()%></td>
                <form action="<%=request.getContextPath()%>/applyJob" method="post">
                    <input type="hidden" name="idJob" value="<%=jobs.getIdJobOffer()%>">
                    <input type="hidden" name="employerId" value="<%=jobs.getRequesterId()%>">
                    <input type="hidden" name="jobAddress" value="<%=jobs.getLocation()%>">
                    <input type="hidden" name="jobSalary" value="<%=jobs.getSalary()%>">
                    <input type="hidden" name="jobHour" value="<%=jobs.getWorkingHour()%>">
                    <td colspan="2" style="text-align: right;"><button class="submit-button" type="submit">Apply</button></td>
                </form>
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


