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

    public Url(String inputUrl, Timestamp createdAtTimestamp) {
        this.url = inputUrl;
        this.createdAt = createdAtTimestamp;
    }

    public Url(String inputUrl) {
        this.url = inputUrl;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
