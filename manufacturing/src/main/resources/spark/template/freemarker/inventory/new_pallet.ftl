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
    <p style="font-size:25px" class="headerLink">Catalog</p>
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
        <button class="navButton"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton" style="background-color:#7d7d8c"> Inventory </button>
    </a>
</div>
    <section style="display:flex; flex-direction:row">
        <div>
            <p style="font-size: 2.0em">Buy New Pallet:</p><br><br>
            <form action="/inventory/buy_pallet" method ="post" id="newPalletForm">
                <p>Part Information:</p><br>
                <input type="text" id="warehouse_loc" name="warehouse_loc" required="required" placeholder="Outgoing Warehouse Location"><br><br>
                <input type="number" min="1" max="4" step="any" id="boxquantity" name="boxquantity" required="required" placeholder="Number of Boxes"/><br><br>
                <br><br>
                <input type="submit" value="Purchase" class="fancyButton">
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
