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
        <p style="font-size:25px">Orders</p>
    </div>
    <hr>

    <section id="options">
        <div>
            <a href="/recipes/new">
                <button type="newworkorder_b">Add Work Order</button>
            </a>
            <table id="workorderlist">
                <tbody>
                <tr>
                    <th>Work Order ID</th>
                    <th>Action</th>
                    <th>Product ID</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <#list table as row>
                    <tr>
                        <#list row as str>
                            <td style="border: 1px solid black; margin: 0px;">${str}</td>
                        </#list>
                        <td  style="border: 1px solid black;">
                            <button id="del">Delete</button>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>

</body>
</html>