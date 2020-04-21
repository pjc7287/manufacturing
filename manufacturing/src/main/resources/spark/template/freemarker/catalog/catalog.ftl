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
        <p style="font-size:25px">Catalog</p>
    </div>
    <div class="navbar">
        <a href="/">
            <button class="navButton"> Home </button>
        </a>
        <a href="/catalog">
            <button class="navButton" style="background-color:#7d7d8c"> Catalog </button>
        </a>
        <a href="/orders">
            <button class="navButton"> Orders </button>
        </a>
        <a href="/inventory">
            <button class="navButton"> Inventory </button>
        </a>
    </div>



    <section style="padding: 100px;display: flex;flex-direction: row;justify-content:space-between">
        <section>
            <p style="font-size:50px">Products</p>
            <#if permissions = "MANAGER">
            <a href="/catalog/new/define_product">
                <button class="fancyButton">Define New Product</button>
            </a>
            </#if>
        <table id="productlist">
                <tbody>
                    <tr>
                        <th style="width:100px">Product ID</th>
                        <th style="width:150px">Name</th>
                        <th style="width:80px">Cost</th>
                        <th style="width:80px">Type</th>
                        <th style="width:400px">Description</th>
                        <th></th>
                    </tr>
                <#list product_table as row>
                    <tr>
                        <td>${row[0]}</td>
                        <td><a href="./catalog/info/${row[0]}">${row[1]}</a></td>
                        <td>${row[2]}</td>
                        <td>${row[3]}</td>
                        <td>${row[4]}</td>
                        <td>
                            <#if permissions = "MANAGER">
                            <form action=/catalog/delete/product method="post">
                                <button class="del" name="product_id" value="${row[0]}">Delete</button>
                            </form>
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </section>
        <section>
            <p style="font-size:50px">Parts</p>
            <#if permissions = "MANAGER">
            <a href="/catalog/new/define_part">
                <button class="fancyButton">Define New Part</button>
            </a>
            </#if>
        <table id="partList" style= "border: 1px solid black;width: 80%;border-collapse: collapse;">
                <tbody>
                <tr>
                    <th style="width:80px">Part ID</th>
                    <th style="width:150px">Name</th>
                    <th style="width:80px">Cost</th>
                    <th style="width:300px">Description</th>
                    <#if permissions = "MANAGER">
                    <th></th>
                    </#if>
                </tr>
                <#list part_table as row>
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                    <td>${row[2]}</td>
                    <td>${row[3]}</td>
                    <#if permissions = "MANAGER">
                    <td>
                        <form action=/catalog/delete/part method="post">
                            <button class="del" name="part_id" value="${row[0]}">Delete</button>
                        </form>
                    </td>
                    </#if>
                </tr>
                </#list>
                </tbody>
            </table>
        </section>
    </section>
</body>
</html>