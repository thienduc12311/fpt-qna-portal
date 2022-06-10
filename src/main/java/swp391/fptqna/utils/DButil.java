package swp391.fptqna.utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    public static Connection getMyConnection() throws Exception {
        Connection conn = null;
        String user = "swpadmin";
        String pass = "@@swp391";
        String connString = "jdbc:sqlserver://portalstudent.database.windows.net:1433;database=swp391;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        //1
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2
        conn = DriverManager.getConnection(connString, user, pass);
        return conn;
    }

}
