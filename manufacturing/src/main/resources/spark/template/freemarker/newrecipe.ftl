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
    <p style="font-size:25px">Recipes</p>
</div>
<hr>
<section id="options">
    <div>
        <label for="newRecipeForm">Define a recipe: </label>
        <form action="/recipes" method ="post" id="newRecipeForm">

            <label for="id">Recipe ID:</label><br>
            <input type="text" id="id" name="id"><br><br>

            <label for="title">Recipe Name:</label><br>
            <input type="text" id="title" name="title"><br><br>

            <label for="prod_id">Product ID:</label><br>
            <input type="text" id="prod_id" name="prod_id"><br><br>

            <label for="desc">Description: </label><br>
            <input type="text" id="desc" name="desc"><br><br>

            <input type="submit" value="Save Recipe">
        </form>
    </div>
    <div>
        <label for="newIngredientForm">Add an Ingredient: </label>
        <form action="./new" method ="post" id="newIngredientForm">

            <label for="rid">Recipe ID:</label><br>
            <input type="text" id="rid" name="rid"><br><br>

            <label for="part_id">Part Number:</label><br>
            <input type="text" id="part_id" name="part_id"><br><br>

            <label for="part_name">Part Name:</label><br>
            <input type="text" id="part_name" name="part_name"><br><br>

            <label for="quantity">Quantity in Recipe:</label><br>
            <input type="text" id="quantity" name="quantity"><br><br>

            <label for="part_desc">Description: </label><br>
            <input type="text" id="part_desc" name="part_desc"><br><br>

            <input type="submit" value="Add Part">
        </form>
    </div>
</section>

</body>
</html>