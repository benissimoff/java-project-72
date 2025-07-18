package hexlet.code.utils;

public class NamedRoutes {
    public static String rootPath() {
        return "/";
    }

    public static String urlsPath() {
        return "/urls";
    }

    public static String urlPath(int id) {
        return urlPath(String.valueOf(id));
    }

    public static String urlPath(String id) {
        return urlsPath() + "/" + id;
    }
}
