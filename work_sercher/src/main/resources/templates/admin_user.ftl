<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form action="/user" method="get">
        <input name="keyword" type="text" placeholder="user id or 'all'"/>
        <input type="submit" value="search"/>
    </form>
</div>
<div>
    <#list users as user>
        <span>${user.id}    ${user.email}
            <form action="/user/delete" method="post">
        <input type="hidden" name="keyword" value="${user.id}">
        <input type="submit" value="delete"/>
    </form>
    </span><br><br>
    <#--<script>
        id: JSON.stringify({ company_id: ${company.id})
    </script>
<form action="/comp/delete" method="post">
    <input id="${company.id}" type="button" value="delete"/>
</form>-->
    </#list>
</div>
</body>
</html>
</body>
</html>