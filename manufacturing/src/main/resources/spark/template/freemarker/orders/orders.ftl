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
        <p style="font-size:25px">Work Orders</p>
    </div>
    <hr>

    <section style="display:flex; flex-direction:row">
        <div>
            <a href="/orders/new_order">
                <button class="fancyButton">Add Work Order</button>
            </a>
            <table id="workorderlist">
                <tbody>
                <tr>
                    <th>Work Order ID</th>
                    <th>Action</th>
                    <th>Quantity</th>
                    <th>Warehouse</th>
                    <th>Product ID</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <#list table as row>
                    <tr>
                        <#list row as str>
                            <td>${str}</td>
                        </#list>
                        <td>
                            <button class="del" id="del">Delete</button>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>

</body>
</html>