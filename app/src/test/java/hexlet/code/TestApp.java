package hexlet.code;

//import hexlet.code.repository.UrlRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

public class TestApp {

    private Javalin app;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
//        UrlRepository.removeAll();
    }

    @Test
    public void testMainPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testBuildUrlPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testUrlPageNotFound() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/0");
            assertThat(response.code()).isEqualTo(404);
        });
    }

    @Test
    public void testCreateUrlViaRepository() {
        JavalinTest.test(app, (server, client) -> {
            var urlString = "https://www.example.com";
            var testUrl = new Url(urlString);
            UrlRepository.save(testUrl);
            var id = testUrl.getId();
            System.out.println("!!! ========== id " + id);
            var response = client.get("/urls/" + id);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(urlString);
        });
    }

    @Test
    public void testCreateUrlViaHttp() {
        JavalinTest.test(app, (server, client) -> {
            var urlString = "https://www.example.com";
            var requestBody = "url=" + urlString;
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            response = client.get("/urls/" + 1);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(urlString);
        });
    }
}
