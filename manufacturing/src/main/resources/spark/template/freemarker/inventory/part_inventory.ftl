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
        <p style="font-size:25px">Inventory</p>
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
    <div style="display:flex;justify-content:center">
    <a href="/inventory">
        <button class="fancyButton">View Pallets</button>
    </a>
    <a href="/inventory/new_part">
        <button class="stubButton">STUB: Request Part</button>
    </a>
    </div>
    <p style="font-size:50px; text-align:center">Parts In Stock</p>
    <section style="display:flex;justify-content:center">
        <table id="partList" style= "border: 1px solid black;width: 80%;border-collapse: collapse;">
                <tbody>
                <tr>
                    <th style="width:80px">Part Name</th>
                    <th style="width:150px">Serial Num</th>
                </tr>
                <#list part_table as row>
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </section>
    </section>
</body>
</html>