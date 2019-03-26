<#import "parts/common.ftl" as c>
<@c.page>
    <strong>Article editor</strong>
    <form action="/savearticle" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <select name= "status">
            <option value = "PUBLIC">PUBLIC</option>
            <option value = "DRAFT">DRAFT</option>
        </select>
        <input type = "text" name = "title" value = ${article.title} >
        <textarea name="text">
            ${article.text}
        </textarea>
        <input type="hidden" value="${article.id}" name="articleId">
        <button type="submit">Save</button>
    </form>
</@c.page>