package swp391.fptqna.utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    public static Connection getMyConnection() throws Exception {
        Connection conn = null;
        String user = "sa";
        String pass = "Password123@";
        String connString = "jdbc:sqlserver://localhost:1433;databaseName=FPTQnAPortal;";
        //1
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2
        conn = DriverManager.getConnection(connString, user, pass);
        return conn;
    }
}
