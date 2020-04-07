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
            <button class="navButton"> Catalog </button>
        </a>
        <a href="/orders">
            <button class="navButton"> Orders </button>
        </a>
        <a href="/inventory">
            <button class="navButton"  style="background-color:#7d7d8c"> Inventory </button>
        </a>
        <a href="/budget">
            <button class="navButton"> Budget </button>
        </a>
    </div>
    <div style="display:flex;justify-content:center">
    <a href="/inventory/new_pallet">
        <button class="fancyButton">Buy Pallet</button>
    </a>
    </div>
    <section class="palletDisplay">

        <#list palletHash as pallet_id, boxes>
            <div>
                <div class="pallet">
                    <#list boxes as box_id>
                    <div>
                        <label for="${box_id}">Empty</label>
                        <div class="box" id="${box_id}">
                            <p>Box ID: ${box_id}</p>
                        </div>
                    </div>
                    </#list>
                </div>
                <p>Pallet ID: ${pallet_id}</p>
                <p>Outgoing Warehouse: Rochester, NY</p>
            </div>
        </#list>
    </section>

</body>
</html>