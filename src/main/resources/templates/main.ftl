
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as log>
    <@c.page >
    <div id="for-body">

        <@log.logout />
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" name="text" placeholder="Введите сообщение" />
            <input type="text" name="tag" placeholder="Тэг">
            <button type="submit">Добавить</button>
        </form>
        <form method="post" action="filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" name="filter">
            <button type="submit">Найти</button>
        </form>

        <#list users as usr>
        <#if usr.username??>
            ${usr.username}
        </#if>
        <b>
            <#if usr.email??>
                ${usr.email}
            </#if>
            <br>
            <#else> no users
        </#list>
    </div>
    </@c.page>
