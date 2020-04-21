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
    <a href="/catalog"  style="color:white">
    <p style="font-size:25px" class="headerLink">Inventory</p>
    </a>
</div>
<div class="navbar">
    <a href="/">
        <button class="navButton"> Home </button>
    </a>
    <a href="/catalog">
        <button class="navButton" > Catalog </button>
    </a>
    <a href="/orders">
        <button class="navButton"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton" style="background-color:#7d7d8c"> Inventory </button>
    </a>
</div>
    <section style="display:flex; flex-direction:row">
        <div>
            <p style="font-size: 2.0em">Get New Part:</p><br><br>
            <form action="/inventory/save_part" method ="post" id="newPartForm">
                <p>Part Information:</p><br>
                <select id="part_id" name="part_id" form="newPartForm" required="required">
                    <option value="" selected>Select A Part To Request</option>
                    <#list partsInfo as key, value>
                    <option value="${key}">${value}</option>
                </#list>
                </select>
                <br>
                <br>
                <input type="submit" value="Submit Part Request" class="fancyButton">
            </form>
            <hr>
            <br>
            <a href="/inventory">
                <button class="fancyButton">Back to Inventory</button>
            </a>
        </div>
    </section>
</body>
</html>
