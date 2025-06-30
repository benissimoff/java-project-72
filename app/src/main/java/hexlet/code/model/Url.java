package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class Url {
    private int id;
    private String url;
    private Timestamp createdAt;

    Url(String url, Timestamp createdAt) {
        this.url = url;
        this.createdAt = createdAt;
    }

    Url(String url) {
        this.url = url;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
