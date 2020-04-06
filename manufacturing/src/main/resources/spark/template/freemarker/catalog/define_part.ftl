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
    <a href="/catalog"  style="color:white">
    <p style="font-size:25px" class="headerLink">Catalog</p>
    </a>
</div>
<hr>
    <section style="display:flex; flex-direction:row">
        <div>
            <p style="font-size: 2.0em">Define New Part:</p><br><br>
            <form action="/catalog/new/part" method ="post" id="newPartForm">
                <p>Part Information:</p><br>
                <input type="text" id="title" name="title" required="required" placeholder="Part Name"><br><br>
                <input type="number" min=".01" step="any" id="cost" name="cost" required="required" placeholder="Cost"/><br><br>
                <input type="text" id="info" name="info" required="required" placeholder="Description"><br><br>
                <br><br>
                <input type="submit" value="Save Part" class="fancyButton">
            </form>
            <hr>
            <br>
            <a href="/catalog">
                <button class="fancyButton">Back to Catalog</button>
            </a>
        </div>
    </section>
</body>
</html>
