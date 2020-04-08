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
    <a href="/catalog" style="color:white">
        <p class="headerLink" style="font-size:25px">Inventory</p>
    </a>
</div>
<div class="navbar">
    <a href="/">
        <button class="navButton"> Home </button>
    </a>
    <a href="/catalog" >
        <button class="navButton"> Catalog </button>
    </a>
    <a href="/orders">
        <button class="navButton"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton"  style="background-color:#7d7d8c"> Inventory </button>
    </a>
</div>
<section style="padding: 100px;display: flex;flex-direction: row;">
    <div>
        <p style="font-size:25px; color:#1abc9c; font-weight: bold">Box Info:</p>
        <table>
            <tr>
                <th>Box ID</th>
                <th>Pallet ID</th>
                <th>Shipping to</th>
            </tr>
            <tr>
                <td>${container_id}</td>
                <td>${pallet_id}</td>
                <td>${warehouse_loc}</td>
            </tr>
        </table>
        <br>
        <br>
        <hr>
        <br>
    <p style="font-size:25px; color:#1abc9c; font-weight: bold">Contents:</p>
        <table>
        <tbody>
        <tr>
            <th>Name</th>
            <th>ID</th>
            <th>Serial Number</th>
            <th></th>
        </tr>
        <#list table as row>
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </#list>
        </tbody>
    </table>
        <br>
        <br>
        <a href="/inventory">
        <button class="fancyButton">Back to Inventory</button>
        </a>
    </div>
</section>
</body>
</html>