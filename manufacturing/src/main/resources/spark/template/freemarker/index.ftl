<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>KennUware</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="smallheader">
	<a href="/" style="color:white">
		<h1>KennUware</h1>
	</a>
	<p style="font-size:25px">Welcome, ${firstName}</p>
</div>
<div class="navbar">
	<a href="/">
		<button class="navButton" style="background-color:#7d7d8c"> Home </button>
	</a>
	<a href="/catalog">
		<button class="navButton"> Catalog </button>
	</a>
	<a href="/orders">
		<button class="navButton"> Orders </button>
	</a>
	<a href="/inventory">
		<button class="navButton"  > Inventory </button>
	</a>
</div>

<section style="display:flex; flex-direction:row">
    <br>
    <br>
    <br>
    <div>
        <h1>Employee Profile</h1>
        <p>Name: ${lastName}, ${firstName}</p>
		<p>ID#:  ${employeeId}</p>
		<p>Role: ${roleName}</p>
		<p>Manager ID: ${managerId}</p>
	</div>
    <div>
        <a href="/signOut">
        <button class="navButton"  > Sign out </button>
        </a>
    </div>
</section>

</body>
</html>