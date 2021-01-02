package zsh.test;

import org.junit.Test;
import zsh.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author zsh
 * @create 2020-12-28-16:30
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }

    }
}
