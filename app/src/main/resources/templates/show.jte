@import hexlet.code.dto.UrlPage
@param UrlPage page

@template.layout.page(
content = @`
    <h1>${page.getFlashMessage()}</h1>
    <%--    @if(page.getErrors() != null)--%>
    <%--        <div class="mb-3">--%>
    <%--            <ul>--%>
    <%--                @for(var validator : page.getErrors().values())--%>
    <%--                    @for(var error : validator)--%>
    <%--                        <li>${error.getMessage()}</li>--%>
    <%--                    @endfor--%>
    <%--                @endfor--%>
    <%--            </ul>--%>
    <%--        </div>--%>
    <%--    @endif--%>

    <div>
        <p>${page.getUrl().getId()} ${page.getUrl().getUrl()} ${page.getUrl().getCreatedAt().toString()}</p>
    </div>

`
)