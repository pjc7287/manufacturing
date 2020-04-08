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
        <p class="headerLink" style="font-size:25px">Catalog</p>
    </a>
</div>
<div class="navbar">
    <a href="/">
        <button class="navButton"> Home </button>
    </a>
    <a href="/catalog" >
        <button class="navButton" style="background-color:#7d7d8c"> Catalog </button>
    </a>
    <a href="/orders">
        <button class="navButton"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton"> Inventory </button>
    </a>
    <a href="/budget">
        <button class="navButton"> Budget </button>
    </a>
</div>
<section style="padding: 100px;display: flex;flex-direction: row;">
    <div>
        <p style="font-size:25px; color:#1abc9c; font-weight: bold">${title}:</p>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Cost</th>
                <th>Category</th>
                <th>Description</th>
            </tr>
            <tr>
                <td>${id}</td>
                <td>${title}</td>
                <td>${cost}</td>
                <td>${category}</td>
                <td>${info}</td>

            </tr>
        </table>
        <br>
        <br>
        <hr>
        <br>
    <p style="font-size:25px; color:#1abc9c; font-weight: bold">${title} Components:</p>
        <table>
        <tbody>
        <tr>
            <th>Part ID</th>
            <th>Name</th>
            <th>Cost of Part</th>
            <th>Description</th>
            <th>Quantity</th>
            <th></th>
        </tr>
        <#list table as row>
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td>${row[3]}</td>
            <td>${row[4]}</td>
        </tr>
        </#list>
        </tbody>
    </table>
        <br>
        <br>
        <a href="/catalog">
        <button class="fancyButton">Back to Catalog</button>
        </a>
    </div>
</section>
</body>
</html>