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
    </div>
    <div style="display:flex;justify-content:center">
        <a href="/inventory/part_inventory">
            <button class="fancyButton">View In Stock Parts</button>
        </a>
        <a href="/inventory/new_pallet">
            <button class="fancyButton">Buy Pallet</button>
        </a>
        <a href="/inventory/new_part">
            <button class="stubButton">STUB: Request Part</button>
        </a>

    </div>
    <section class="palletDisplay">

        <#list palletViews as pallet>
            <div style="padding:14px">
                <div class="pallet">
                    <#list pallet.getBoxes() as box>
                    <div>
                        <label for="${box.getId()}">${box.getType()}</label>
                        <div class="box" <#if box.getNumberOfItems() gt 0>style="background-color:yellow;"</#if> id="${box.getId()}">
                            <a href="/inventory/box/${box.getId()}">
                            <p>Box ID: ${box.getId()}</p>
                            </a>
                        </div>
                    </div>
                    </#list>
                </div>
        <p><span style="font-weight:bold;">Pallet ID: </span>${pallet.getId()} </p>
        <p><span style="font-weight:bold;">Outgoing Warehouse: </span>${pallet.getLocation()} </p>
        <p><span style="font-weight:bold;">Total Items: </span>${pallet.getNumberOfItems()} </p>
            <#if pallet.getNumberOfItems() gt 0>
                <form action="/inventory/ship_pallet" method="post">
                <button value="${pallet.getId()}" name="pallet_id" class="ship">Ship Pallet</button>
                </form>
            <#else>
                <button class="cantship" disabled>Ship Pallet</button>
            </#if>
            </div>
        </#list>
    </section>

</body>
</html>