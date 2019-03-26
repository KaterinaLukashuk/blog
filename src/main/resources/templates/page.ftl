
<#import "parts/common.ftl" as c>
    <@c.page>

        <#list articles as artcl>
            <a href = "/article/${artcl.id}" >  ${artcl.title} </a> <br>
            ${artcl.id}<br>
            ${artcl.user}<br>
            ${artcl.createdAt}<br>
            ${artcl.updatedAt}<br>
            <#else> no articles
        </#list>

<form action=" main " method="get">
    <input name="go" type="submit" value="start">
</form>

    </@c.page>

