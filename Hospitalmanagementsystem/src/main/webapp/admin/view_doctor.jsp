<%@page import="com.hospitalmanagment.entity.Doctor"%>
<%@page import="com.hospitalmanagement.dao.DoctorDao"%>
<%@page import="com.hospitalmanagment.entity.Specialist"%>
<%@ page import="com.hospitalmanagement.dao.SpecialistDao"%>
<%@ page import="com.hospitalmanagement.helper.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Doctor Page</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table table-striped table-hover">
							<thead class="table-light">
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								DoctorDao dao2 = new DoctorDao(Connectionprovider.connect());
								List<Doctor> list2 = dao2.getAllDoctor();
								for (Doctor d : list2) {
								%>
								<tr>
									<td><%=d.getFullname()%></td>
									<td><%=d.getDob()%></td>
									<td><%=d.getQualification()%></td>
									<td><%=d.getSpecialist()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getMobno()%></td>
									<td><a href="edit_doctor.jsp?id=<%=d.getId()%>"
										class="btn btn-sm btn-primary">Edit</a>
									 <a href="../DeleteDoctorServlet?id=<%=d.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>

					</div>
				</div>


			</div>



		</div>
	</div>
</body>
</html>
