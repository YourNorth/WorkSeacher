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
<form modelAttribute="userForm" method="post" action="/user/add">
    <input type="email" name="email" placeholder="email"/>
    <input type="text" name="role_from_form" placeholder="role" about="you can choose 'ROLE_USER', 'ROLE_ADMIN', 'ROLE_EMPLOYER'"/><#--fixme -->
    <input type="password" name="password" placeholder="password"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>