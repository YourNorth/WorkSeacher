<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form action="/comp" method="get">
        <input name="keyword" type="text" placeholder="company id or "all/>
        <input type="submit" value="search"/>
    </form>
</div>
<div>
    <#list companies as company>
    <span>${company.id}    ${company.name}
    <form action="/comp/delete" method="post">
        <input type="hidden" name="keyword" value="${company.id}">
        <input type="submit" value="delete" />
    </form>
    </span><br><br>
</#list>
</div>
</body>
</html>