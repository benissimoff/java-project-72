@import hexlet.code.dto.UrlPage
@param UrlPage page

@template.layout.page(
content = @`
    @if(page.getFlash() != null)
        <div>
            <p>${page.getFlash()}</p>
        </div>
    @endif
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
        @if(page.getUrl() != null)
            <p>${page.getUrl().getId()} ${page.getUrl().getUrl()} ${page.getUrl().getCreatedAt().toString()}</p>
        @else
            <p>Страница не существует</p>
        @endif
    </div>

`
)