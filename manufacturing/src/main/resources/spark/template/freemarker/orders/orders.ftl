<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="refresh" content="3"> <!-- Refresh every 15 minutes -->
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
                    <th>Progress</th>
                    <th>Warehouse</th>
                    <th>Product Serial Number</th>
                    <th>Description</th>
                    <th></th>
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

                        <td>
                            <form action="/orders/pack" method="post">
                                <#if row[2]="100.0"> <button class="pack" id="pack">Pack</button> </#if>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>

</body>
</html>