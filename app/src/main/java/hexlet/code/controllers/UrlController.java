package hexlet.code.controllers;

import hexlet.code.dto.BuildPage;
import hexlet.code.dto.IndexPage;
import hexlet.code.dto.UrlPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.net.URL;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {
    public static void build(Context ctx) {
        String message = "Hello, World!";
        var page = new BuildPage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));

        ctx.render("build.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        int urlId = ctx.pathParamAsClass("id", Integer.class).get();
        String message = "Hello, World!";
        Url url = UrlRepository.findById(urlId).orElseThrow();
        var page = new UrlPage(url);
        ctx.render("show.jte", model("page", page));
    }

    public static void index(Context ctx) throws SQLException {
        List<Url> urls = UrlRepository.getEntities();
        IndexPage page = new IndexPage(urls);
        ctx.render("index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException, URISyntaxException, MalformedURLException {
        // POST
        String urlString = ctx.formParamAsClass("url", String.class).getOrDefault("").toLowerCase();
        System.out.println(" !!! =============== URL STRING " + urlString);
        URI uriObject = new URI(urlString);
        System.out.println(" !!! =============== URI uriObject " + uriObject);
        try {
            URL urlObject = uriObject.toURL();
            String cleanUrl = uriObject.getScheme()
                    + "://" + uriObject.getHost()
                    + ((uriObject.getPort() > -1) ? ":" + uriObject.getPort() : "");
            System.out.println(" !!! =============== cleanUrl " + cleanUrl);

            boolean isUrlExist = UrlRepository.findByUrl(cleanUrl).isEmpty();

            if (isUrlExist) {
                Date currentDate = new Date();
                Timestamp timestamp = new Timestamp(currentDate.getTime());
                Url url = new Url(cleanUrl, timestamp);

                UrlRepository.save(url);
            } else {
                ctx.sessionAttribute("flash", "Страница уже существует");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(" !!! =============== IllegalArgumentException " + e.getMessage());
            ctx.sessionAttribute("flash", "Некорректный URL");
        } catch (Exception e) {
            System.out.println(" !!! =============== OTHER EXCEPTION " + e.getMessage());
            ctx.sessionAttribute("flash", "OTHER EXCEPTION");
        }

        System.out.println(" !!! =============== EVEN IF URL INCORRECT STILL RUNNING ");

        ctx.redirect("/");
    }

    public static void update(Context ctx) {

    }
}
