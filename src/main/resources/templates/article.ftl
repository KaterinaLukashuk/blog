
<#import "parts/common.ftl" as c>
<@c.page>

    <#if article.title??>
        ${article.title}
    </#if>
    <br>
    <#if article.user.username??>
        ${article.user.username}
    </#if>
    <br>
    <#if article.createdAt??>
        ${article.createdAt}
    </#if>
    <br>
    <#if article.updatedAt??>
        ${article.updatedAt}
    </#if>
    <br>
    <#if article.text??>
        ${article.text}
    </#if>
    <br>
     <div>
         <#--#show all comments-->


         <#list articlecomments as cmnt>
             ${cmnt.author} <b>
             ${cmnt.createdAt}<br>
             ${cmnt.message} <br>
             <#else > No comments
         </#list>

     </div>
    <div>
        <form action = "/newcomment" method = "post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type= "hidden" value = "${article.id}" name="articleId">
            <input type = "text" name = "message"/>
            <button type = "submit"> Comment </button>
        </form>
    </div>

<a href="/"> main </a>
</@c.page>
