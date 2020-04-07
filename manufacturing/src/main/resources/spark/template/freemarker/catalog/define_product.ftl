<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>KennUware</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script type="text/javascript">
        var id = 1;
        function addIngredientForm()
        {
            id = id+1;

            var label = document.createElement("P")
            label.innerText = "Component " + id

            var inputId = document.createElement("P")

            var code = `<select id="part_id`+id+`" name="part_id`+id+`" form="newProductForm" required="required">
                    <option value="" selected>Select A Part</option>
                    <#list partsInfo as key, value>
                     <option value="${key}">${value}</option>
                    </#list>
                </select>
            `

            inputId.innerHTML = code;

            var br1 = document.createElement("BR")
            var br2 = document.createElement("BR")

            var inputQuantity = document.createElement("INPUT")
            inputQuantity.setAttribute("type", "number")
            inputQuantity.setAttribute("min", "1")
            inputQuantity.setAttribute("id", "quantity" + id)
            inputQuantity.setAttribute("required", "required")
            inputQuantity.setAttribute("name", "quantity" + id)
            inputQuantity.setAttribute("placeholder", "Quantity in Product")

            var insertPoint = document.getElementById("placeholder")

            insertPoint.insertAdjacentElement("beforeBegin",label)
            insertPoint.insertAdjacentElement("beforeBegin",inputId)
            insertPoint.insertAdjacentElement("beforeBegin", br1)
            insertPoint.insertAdjacentElement("beforeBegin", br2)
            insertPoint.insertAdjacentElement("beforeBegin",inputQuantity)

            document.getElementById("partCount").value = id;
        }
    </script>
</head>
<body>
<div class="smallheader">
    <a href="/" style="color:white">
        <h1>KennUware</h1>
    </a>
    <a href="/catalog"  style="color:white">
        <p class="headerLink" style="font-size:25px">Catalog</p>
    </a>
</div>
<div class="navbar">
    <a href="/">
        <button class="navButton"> Home </button>
    </a>
    <a href="/catalog" >
        <button class="navButton" style="background-color:#7d7d8c"> Catalog </button>
    </a>
    <a href="/orders">
        <button class="navButton"> Orders </button>
    </a>
    <a href="/inventory">
        <button class="navButton"> Inventory </button>
    </a>
    <a href="/budget">
        <button class="navButton"> Budget </button>
    </a>
</div>
    <section style="display:flex; flex-direction:row">
        <div>
            <p style="font-size: 2.0em">Define New Product:</p><br><br>
            <form action="/catalog/new/product" method ="post" id="newProductForm">
                <p>Product Information:</p><br>
                <input type="text" id="title" name="title" required="required" placeholder="Product Name"><br><br>
                <input type="number" min=".01" step="any" id="cost" name="cost" required="required" placeholder="Cost"/><br><br>
                <select id="category" name="category" form="newProductForm" required="required">
                    <option value="" selected>Category</option>
                    <option value="F">Fashions</option>
                    <option value="C">Comforts</option>
                    <option value="H">Healthies</option>
                    <option value="A">Activites</option>
                </select>
                <br><br>
                <input type="text" id="info" name="info" required="required" placeholder="Description"><br><br>
                <br><br>
                <p>Component 1:</p><br><br>
                <select id="part_id1" name="part_id1" form="newProductForm" required="required">
                        <option value="" selected>Select A Part</option>
                    <#list partsInfo as key, value>
                        <option value="${key}">${value}</option>
                    </#list>
                </select>
                <br><br>
                <input type="number" id="quantity1" min="1" required="required" name="quantity1" placeholder="Quantity in Product"><br>
                <p id="placeholder"></p><br><br>
                <input type="hidden" id="partCount" name="partCount" value="1">
                <button class="fancyButton" category="button" onclick="addIngredientForm()">Add Existing Part to Product </button><br><br>
                <input type="submit" value="Save Product" class="fancyButton">
            </form>
            <hr>
            <br>
            <a href="/catalog/new/define_part">
            <button category="button" class="fancyButton"> Define New Part </button><br><br>
            </a>
            <a href="/catalog">
                <button class="fancyButton">Back to Catalog</button>
            </a>
        </div>
    </section>
</body>
</html>
