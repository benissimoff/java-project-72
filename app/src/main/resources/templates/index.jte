@import hexlet.code.dto.IndexPage
@import hexlet.code.model.Url
@param IndexPage page

@template.layout.page(
    content = @`
        <h1>${page.getMessage()}</h1>
    @for(Url item : page.getUrls())
        <div>
            <p>${item.getId()} ${item.getUrl()} ${item.getCreatedAt().toString()}</p>
        </div>
    @endfor
    `
)