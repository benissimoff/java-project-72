package hexlet.code.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;

public class BaseRepository {
    @Setter
    @Getter
    private static HikariDataSource dataSource;
}
