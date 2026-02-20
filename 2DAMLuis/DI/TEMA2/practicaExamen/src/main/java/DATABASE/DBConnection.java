package DATABASE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection  {
    private static final String URL = "jdbc:mysql://localhost:3306/tiendaonlineluis";
    private static final String USER = "root";
    private static final String PASSWORD = "3306";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a BD establecida");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la BD: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión a BD cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Erro en la conexión : " + e.getMessage());
        }
    }
}