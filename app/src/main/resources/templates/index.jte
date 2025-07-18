@import hexlet.code.dto.IndexPage
@import hexlet.code.model.Url
@param IndexPage page

@template.layout.page(
    content = @`

        <h3>Сайты</h3>
    @for(Url item : page.getUrls())
        <div>
            <p>${item.getId()} ${item.getUrl()} ${item.getCreatedAt().toString()}</p>
        </div>
    @endfor
    `
)