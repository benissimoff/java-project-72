@import hexlet.code.dto.IndexPage
@param IndexPage page

@template.layout.page(
    content = @`
        <h1>${page.getMessage()}</h1>
    `
)