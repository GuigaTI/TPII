import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    public static Connection connection() throws SQLException {
        var jdbcURL = "jdbc:postgresql://localhost:5432/db_dsm";
        var user = "fatec";
        var pass = "fatec777";

        return DriverManager.getConnection(jdbcURL,user,pass);
    }
}