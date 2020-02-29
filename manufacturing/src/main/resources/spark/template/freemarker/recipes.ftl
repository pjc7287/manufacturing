<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>KennUware</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="smallheader">
        <a href="./" style="color:white">
        <h1>KennUware</h1>
        </a>
        <p style="font-size:25px">Recipes</p>
    </div>
    <hr>

    <section id="options">
    <div>
        <table id="recipelist">
            <tbody>
            <#list table.iterator() as row>
                <tr>
                    <#list row.iterator() as cell>
                        <td style="border: 1px solid black;">${cell.data()}</td>
                    </#list>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    </section>



</body>
</html>