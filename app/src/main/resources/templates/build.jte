@import hexlet.code.dto.BuildPage
@param BuildPage page

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
        <form action="/urls" method="post">
            <div>
                <label>
                    URL
                    <input type="text" name="url" value="${page.getUrl()}" />
                </label>
            </div>
            <input type="submit" value="Добавить" />
        </form>
    </div>

    `
)