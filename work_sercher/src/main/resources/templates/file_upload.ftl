<html>
<body>
<h1>New file</h1>
<form method="post" enctype="multipart/form-data" action="/file">
    Upload File: <input type="file" name="file">
    <br/><br/><input type="submit">
</form>
<#if (fileInfo)??>
    <div>
        <h1>Uploaded file url is: <a id = "link" href="/files/${fileInfo.url}"> </a></h1>
    </div>
    <script>
        var a = document.getElementById("link");
        a.innerHTML = location.host + "/files/${fileInfo.url}";
    </script>
</#if>
</body>
</html>