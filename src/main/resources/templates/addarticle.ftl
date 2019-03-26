<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
    <#--<meta charset="UTF-8">-->
    <#--<title>Title</title>-->
<#--</head>-->
<#--<body>-->
<#import "parts/common.ftl" as c>
<@c.page>

<form action= "addarticle" method = "post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <select name= "status">
        <option value = "PUBLIC">PUBLIC</option>
        <option value = "DRAFT">DRAFT</option>
    </select>
    <input type = "text" name = "title">
    <!--<input type = "text" name = "text">-->
    <textarea name="text">

    </textarea>

    <input name = "go" type="submit" value="add">
</form>

</@c.page>
<#--</body>-->
<#--</html>-->