@import hexlet.code.dto.BuildPage
@param BuildPage page

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
        <form action="/urls" method="post">
            <div>
                <label>
                    URL
                    <input type="text" name="url" value="https://example.com:8080/test1231/test.php?param=laksdjf&param22=222" />
                </label>
            </div>
            <input type="submit" value="Добавить" />
        </form>
    </div>

    `
)