package hexlet.code;

import io.javalin.Javalin;

public class App {
    private static final String DEFAULT_PORT = "7070";

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", DEFAULT_PORT);
        return Integer.parseInt(port);
    }

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/", ctx -> ctx.result("Hello World"));
        return app;
    }

    public static void main(String[] args) {
        var app = getApp();
        app.start(getPort());
    }
}
