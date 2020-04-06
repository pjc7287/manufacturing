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
		<p style="font-size:25px">Inventory Management</p>
	</div>
	<hr>
		<div id="PartContainer">
			<h2>Parts to Container</h2>
			<div>
				<form action="/InvManagement" method ="post" id="PartsContainer">
				
					<label for="serial_num">Serial Number: </label>
					<input type="text" id="serial_num" name="serial_num">
					
					<label for="cont_id">Container ID: </label>
					<input type="text" id="cont_id" name="cont_id">
					
					<input type="submit" value="Save Part">
				</form>
			</div>				
		</div>
		<div id="ProductContainer">
			<h2>Products to Container</h2>
			<div>
				<form action="/InvManagement" method ="post" id="ProductContainer">
				
					<label for="serial_num">Serial Number: </label>
					<input type="text" id="serial_num" name="serial_num">
					
					<label for="cont_id">Container ID: </label>
					<input type="text" id="cont_id" name="cont_id">
					
					<input type="submit" value="Save Product">
				</form>				
			</div>					
		</div>
		<div id="ContainerPallet">
			<h2>Containers to Pallet</h2>
			<div>
				<form action="/InvManagement" method ="post" id="ContainerPallet">
				
					<label for="cont_id">Container ID: </label>
					<input type="text" id="cont_id" name="cont_id">
					
					<label for="pallet_id">Pallet ID: </label>
					<input type="text" id="pallet_id" name="pallet_id">
					
					<input type="submit" value="Save Container">
				</form>
			</div>
		</div>
	</body>
</html>