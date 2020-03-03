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
        <form action="/recipes" method ="post" id="newRecipeForm">

            <label for="id">Recipe ID:</label><br>
            <input type="text" id="id" name="id"><br><br>

            <label for="title">Recipe Name:</label><br>
            <input type="text" id="title" name="title"><br><br>

            <label for="prod_id">Product ID:</label><br>
            <input type="text" id="prod_id" name="prod_id"><br><br>

            <input type="submit" value="Save">

        </form>
    </div>
</section>

</body>
</html>
