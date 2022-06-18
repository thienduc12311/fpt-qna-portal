package swp391.fptqna.utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    public static Connection getMyConnection() throws Exception {
        Connection conn = null;
        String user = "swpadmin";
        String pass = "admin123@";
        String connString = "jdbc:sqlserver://fpt-qna-portal.database.windows.net:1433;database=fpt-qna-portal-db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        //1
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2
        conn = DriverManager.getConnection(connString, user, pass);
        return conn;
    }

}
