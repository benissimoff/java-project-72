package hexlet.code.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;

@Setter
public class BaseRepository {
    private static HikariDataSource dataSource;
}
