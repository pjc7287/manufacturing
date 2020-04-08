<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>KennUware</title>
		<link rel="stylesheet" category="text/css" href="/css/style.css">
	</head>
	<body>
	<div class="smallheader">
		<a href="/" style="color:white">
			<h1>KennUware</h1>
		</a>
		<p style="font-size:25px">Pallet Inventory</p>
	</div>
	<hr>
		<section id="options">
			<div>
				<table id="recipelist">
					<tbody>
						<tr>
							<th>Pallet ID</th>
							<th>Warehouse Location</th>
							<th></th>
						</tr>
						<#list table as row>
							<tr>
								<#list row as str>
									<td style="border: 1px solid black; margin: 0px;">${str}</td>
								</#list>
							</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</section>
	</body>
</html>
