<#import "parts/common.ftl" as c>
<@c.page>


    <#if user.username??>
        ${user.username}
    </#if>
    <#if user.email??>
        ${user.email}
    </#if>
    <#if user.createdAt??>
        ${user.createdAt}
    </#if>
    <br>
    <#list usersartcl as usrA>
        <a href = "/article/${usrA.id}" >  ${usrA.title}  </a> <b>
        <#--<a href = "/articleedit/${usrA.id}/${usrA.user.id}" >  edit </a> <b>-->
        <a href = "/articleedit/${usrA.id}" >  edit </a> <b>
        <a href = "/articledelete/${usrA.id}/${usrA.user.id}" >  delete  </a>
        <br>
        <#else > no articles
    </#list>

<#if deletemsg??>
    ${deletemsg}
</#if>
<a href="/"> main </a>
</@c.page>
