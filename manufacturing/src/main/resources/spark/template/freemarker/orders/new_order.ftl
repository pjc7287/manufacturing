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
    <a href="/orders"  style="color:white">
        <p class="headerLink" style="font-size:25px">Work Orders</p>
    </a>
</div>
<div class="navbar">
    <a href="/">
        <button class="navButton"> Home </button>
    </a>
    <a href="/catalog">
        <button class="navButton"> Catalog </button>
    </a>
    <a href="/orders">
        <button class="navButton" style="background-color:#7d7d8c"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton"> Inventory </button>
    </a>
</div>
    <section style="display:flex; flex-direction:row">
        <div>
            <p style="font-size: 2.0em">Make New Order:</p><br><br>
            <form action="/orders/new" method ="post" id="newOrderForm">

                <select id="command" name="command" form="newOrderForm" required="required">
                    <option value="" selected>Type of Order</option>
                    <option value="assemble">Assembly</option>
                    <!--<option value="fix">Fix</option> -->
                    <!--<option value="disassemble">Disassemble</option> -->
                </select>
                <br><br>
                <input type="text" id="warehouse_loc" name="warehouse_loc" required="required" placeholder="Warehouse Location"><br><br>
                <select id="product_id" name="product_id" form="newOrderForm" required="required">
                        <option value="" selected>Product</option>
                    <#list productsInfo as key, value>
                        <option value="${key}">${value}</option>
                    </#list>
                </select>
                <br><br>
                <input type="text" id="info" name="info" required="required" placeholder="Description"><br><br>
                <input type="submit" value="Submit Order" class="fancyButton">
            </form>
            <hr>
            <br>
            <br>
            </a>
            <a href="/orders">
                <button class="fancyButton">Back to Orders</button>
            </a>
        </div>
    </section>
</body>
</html>
