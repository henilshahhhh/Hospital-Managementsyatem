<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/banner3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/slider-bg-1.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/banner2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/22.jpg" class="d-block w-100" alt="..." height="500px">
			</div>

		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">

					<div class="col-md-6 p-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>"We're dedicated to advancing medical knowledge through
									cutting-edge research. Our team of researchers is constantly
									working to uncover new treatments and therapies, ensuring that
									our patients receive the most innovative and effective care
									available."</p>

							</div>
						</div>
					</div>



					<div class="col-md-6 p-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								<p>"From the moment you step into our hospital, you can rest
									assured that your safety is our number one concern. Our team of
									experts is fully committed to providing a secure and risk-free
									environment for every patient who walks through our doors."</p>

							</div>

						</div>

					</div>


					<div class="col-md-6 p-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								<p>"Our doctors aren't just experts in their field, they're
									also friendly and approachable. They understand that building a
									relationship with their patients is key to providing the best
									possible care."</p>

							</div>
						</div>
					</div>


					<div class="col-md-6 p-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Environment</p>
								<p>"At our hospital, cleanliness is not just a priority,
									it's a standard. Our dedicated staff work tirelessly to
									maintain a hygienic environment, providing a space where
									patients can focus on their recovery with peace of mind."</p>

							</div>

						</div>

					</div>




				</div>

			</div>

			<div class="col-md-4 p-2">
				<img alt="" src="img/th11.jpg" height="400px" style="margin-top:60px;margin-left:75px">
			</div>

		</div>

	</div>

	<hr>
	<div class="container p-2">
		<p class="text-center fs-2">Our specialist</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/1.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Jivraj Mehta</p>
						<p class="fs-7">(CEO & Chairman)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/3.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Rajesh Shah</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>


			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/2.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Savita Panchal</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/4.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Jayesh Sharma</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>


		</div>



	</div>
	<%@include file="component/footer.jsp"%>
</body>
</html>