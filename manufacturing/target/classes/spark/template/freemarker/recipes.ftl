
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
        <a href="/recipes/new">
            <button type="newrecipe_b">Add Recipe</button>
        </a>
        <table id="recipelist">
            <tbody>
                <tr>
                    <th>Recipe ID</th>
                    <th>Name</th>
                    <th>Product ID</th>
                    <th>Description</th>
                    <th></th>
                </tr>
            <#list table as row>
                <tr>
                    <td style="border: 1px solid black; margin: 0px;">${row[0]}</td>

                    <td style="border: 1px solid black; margin: 0px;"><a href="./recipes/info/${row[0]}">${row[1]}</a></td>

                    <td style="border: 1px solid black; margin: 0px;">${row[2]}</td>
                    <td style="border: 1px solid black; margin: 0px;">${row[3]}</td>
                    <td  style="border: 1px solid black;">
                        <form action=# method="post">
                            <button id="del" name="delete_id" value="${row[0]}">Delete</button>
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