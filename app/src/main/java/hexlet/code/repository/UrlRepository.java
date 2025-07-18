package hexlet.code.repository;

import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.model.Url;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UrlRepository extends BaseRepository {
    public static void save(Url url) throws SQLException {
        // sql

        String sql = "INSERT INTO urls (url, created_at) VALUES (?, ?)";
        HikariDataSource dataSource = BaseRepository.getDataSource();
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, url.getUrl());
            preparedStatement.setTimestamp(2, url.getCreatedAt());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохраненную сущность
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Url> findById(int id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id = ?";
        var localDateSource = BaseRepository.getDataSource();
        try (var conn = localDateSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var urlString = resultSet.getString("url");
                var createdAt = resultSet.getTimestamp("created_at");
                var url = new Url(urlString, createdAt);
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static Optional<Url> findByUrl(String urlString) throws SQLException {
        var sql = "SELECT * FROM urls WHERE url = ?";
        var localDateSource = BaseRepository.getDataSource();
        try (var conn = localDateSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, urlString);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var createdAt = resultSet.getTimestamp("created_at");
                var id = resultSet.getInt("id");
                var url = new Url(urlString, createdAt);
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static List<Url> getEntities() throws SQLException {
        var sql = "SELECT * FROM urls";
        var localDateSource = BaseRepository.getDataSource();
        try (var conn = localDateSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Url>();
            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var make = resultSet.getString("url");
                var model = resultSet.getTimestamp("created_at");
                var url = new Url(make, model);
                url.setId(id);
                result.add(url);
            }
            return result;
        }
    }

}
