<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="refresh" content="30000"> <!-- Refresh every 15 minutes -->
    <title>KennUware</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="smallheader">
        <a href="/" style="color:white">
            <h1>KennUware</h1>
        </a>
        <p style="font-size:25px">Work Orders</p>
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
            <#if permissions = "MANAGER">
            <a href="/orders/new_order">
                <button class="fancyButton">Add Work Order</button>
            </a>
            <form action="/heartbeat" method="POST">
                <button class="stubButton">STUB: Simulate heartbeat tick</button>
            </form>
            </#if>
            <table id="workorderlist">
                <tbody>
                <tr>
                    <th>Work Order ID</th>
                    <th>Action</th>
                    <th>Progress</th>
                    <th>Warehouse</th>
                    <th>Product Serial Number</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <#list table as row>
                    <tr>
                        <td>${row[0]}</td>
                        <td>${row[1]}</td>
                        <td <#if row[2]="100.0"> style="background-color:#8cff94" </#if>>${row[2]}%</td>
                        <td>${row[3]}</td>
                        <td>${row[4]}</td>
                        <td>${row[5]}</td>

                        <td><#if row[2]="100.0">
                            <form action="/orders/pack" method="post">
                                <button class="pack" name="workorder_id" value="${row[0]}"id="pack">Pack</button>
                            </form></#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <p>Assembly Line Message: </P>
            <P>${assemblyMessage}</P>
        </div>
    </section>

</body>
</html>