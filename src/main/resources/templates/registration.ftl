

<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as log>
    <@c.page>
Add new user


        <#if msg??>
            ${msg}
        </#if>
        <form action="/registration" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><label> E-mail: <input type="text" name="email"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>

    </@c.page>

