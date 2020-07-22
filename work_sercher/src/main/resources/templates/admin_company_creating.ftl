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
<form modelAttribute="companyForm" method="post" action="/comp/add">
    <#--name,amount,category,experience, gender,job_type,link_img,location,qualification-->
    <input type="text" name="name" placeholder="name"/>
    <input type="text" name="amount" placeholder="amount"/>
    <input type="text" name="category" placeholder="category"/>
    <input type="text" name="experience" placeholder="experience">
    <input type="text" name="gender" placeholder="gender">
    <input type="text" name="job_type" placeholder="job_type">
    <input type="text" name="location" placeholder="location">
    <input type="text" name="qualification" placeholder="qualification">

    <input type="submit" value="submit"/>
</form>
</body>
</html>