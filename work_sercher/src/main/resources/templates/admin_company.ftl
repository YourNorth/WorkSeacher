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
    <#--<form action="/comp/delete" method="post">
        <input id="${company.id}" type="button" value="delete" onClick="deleteComp(this)"/>
    </form>-->
    </span><br>
</#list>
<#--<script>
     function deleteComp(obj) {
        let id = obj.id;
     }
     result = JSON.stringify(id);
     var url = "/comp/delete" + new Date().getTime();
     request.open("POST", url, true);
     request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     request.send(result);
</script>-->
</div>
</body>
</html>