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
    <p style="font-size:25px">Recipe Info</p>
</div>
<hr>
<section id="options">
    <div>
        <table>
            <tr>
                <th>Recipe ID</th>
                <th>Name</th>
                <th>Product ID</th>
                <th>Description</th>
            </tr>
            <tr>
                <td>${rid}</td>
                <td>${rname}</td>
                <td>${pid}</td>
                <td>${desc}</td>
            </tr>
        </table>
    <label for="ingredientList">Ingredient List:</label>
    <table id="ingredientList">
        <tbody>
        <tr>
            <th>Part ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Description</th>
            <th></th>
        </tr>
        <#list table as row>
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[3]}</td>
            <td>${row[4]}</td>
        </tr>
        </#list>
        </tbody>
    </table>
        <a href="/recipes">
        <button>Back</button>
        </a>
    </div>
</section>
</body>
</html>