package hexlet.code.controllers;

import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.dto.BuildPage;
import hexlet.code.dto.IndexPage;
import hexlet.code.dto.UrlPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {
    public static void build(Context ctx) {
        String message = "Hello, World!";
        var page = new BuildPage(message, "");
        ctx.render("build.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        int urlId = ctx.pathParamAsClass("id", Integer.class).get();
        String message = "Hello, World!";
        Url url = UrlRepository.find(urlId).orElseThrow();
        var page = new UrlPage(message, url);
        ctx.render("show.jte", model("page", page));
    }

    public static void index(Context ctx) throws SQLException {
        List<Url> urls = UrlRepository.getEntities();
        IndexPage page = new IndexPage("index", urls);
        ctx.render("index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        // POST
        String fullUrl = ctx.formParam("url");
        System.out.println(" !!! =============== FULL URL " + fullUrl);
        // refine url
        // create object url
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        Url url = new Url(fullUrl, timestamp);

        // insert into db
        UrlRepository.save(url);

    }

    public static void update(Context ctx) {

    }
}
