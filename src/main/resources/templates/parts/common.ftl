<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>blog</title>
        <a href="/main">Main page</a>
        <br>
        <a href="/page"> page</a>
        <br>
        <a href="/addarticle"> add article</a>
        <br>
        <a href="/userpage"> my page</a>
        <br>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>