<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Meeting Summary</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!-- <style>
      body {
        padding-top: 30px;
        padding-bottom: 30px;
      }
    </style>  -->


<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
	padding-left: 10px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Project name</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">Username</a>
					</p>
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Sidebar</li>
						<li class="active"><a href="#">Link</a></li>
						<li><a href="#">Create Meeting Summary</a></li>
						<li><a href="#">View Profile</a></li>
						<li><a href="#">Link</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->

			<div class="span9">
				<div class="row-fluid">
					<div class="span9">
						<form class="form-horizontal">
							<fieldset>
								<legend>Meeting Summary</legend>
								<label>Meeting Date</label><input name="txtmeeting" type="date">
								<label>Apprentice </label> <input name="txtapprentice"
									type="text"> <label>Mentor </label> <input
									name="txtmentor" type="text"> <label>Meeting
									Place</label> <input name="txtmeetingplace" type="text"> <label>Start
									Time </label> <input name="tstart_time" type="time"> <label>Finish
									Time </label> <input name="tend_time" type="time"> <label>Total
									Time </label> <input name="txttotal_time" type="text"
									value="This field is calculated" readonly="readonly"> <label>Pre-planned
									purpose of meeting: </label>
								<textarea name="txtoldpurpose"></textarea>
								<label>Topics discussed or activities performed: </label>
								<textarea name="txtoldpurpose" rows="5" cols="50"></textarea>
								<label>Accomplishments / Mentor observations: </label>
								<textarea name="txtoldpurpose" rows="5" cols="50"></textarea>
								<label>Goals/Plan for next meeting: </label>
								<textarea name="txtoldpurpose" rows="5" cols="50"></textarea>
								<label>Apprentice needs to accomplish by/bring to next
									meeting:</label>
								<textarea name="txtoldpurpose" rows="5" cols="50"></textarea>
								<label>Mentor needs to bring to next meeting: </label>
								<textarea name="txtoldpurpose" rows="5" cols="50"></textarea>

								<span class="help-block">
									<button type="submit" class="btn btn-primary btn-large">Submit</button>
								</span>
							</fieldset>
						</form>


					</div>
					<!--/span-->
				</div>
				<!--/row-->

			</div>
			<!--/span-->
		</div>
		<!--/row-->
	</div>
</body>
</html>