package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
    private final JdbcTemplate jdbcTemplate;

    public HelloDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(final String name) {
        String SQL = "INSERT INTO HELLO (name) VALUES (?)";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    public int countByName(final String name) {
        String sql = "SELECT COUNT(1) FROM hello WHERE name=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}
