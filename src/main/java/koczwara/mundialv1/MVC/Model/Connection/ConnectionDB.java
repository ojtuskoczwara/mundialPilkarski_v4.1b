package koczwara.mundialv1.MVC.Model.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    private static void connect() {
        try {
            Class.forName("org.postgresql.Driver");

            String USER = "postgres";
            String PASSWORD = "90szkola12";
            //String DB_URL = "jdbc:postgresql://localhost:5432/mundial_v4.3";
            //String DB_URL = "jdbc:postgresql://localhost:5432/praca_inz_v4.4";
            String DB_URL = "jdbc:postgresql://localhost:5432/praca_inz_v4.5";

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Połączono z bazą danych.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void disconnect(ResultSet resultSet) throws Exception {
        if (resultSet.getStatement() != null) {
            resultSet.getStatement().close();
            System.out.println("Statement close.");
        }
        if (resultSet != null) {
            resultSet.close();
            System.out.println("ResultSet close.");
        }
    }
    public static void close(Connection  connection){
        try {
            if(connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
