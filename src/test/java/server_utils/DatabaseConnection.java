package server_utils;
import utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static Connection con = null;

    public static Connection ConnectionInstance(){
        try {

            con = DriverManager.getConnection("jdbc:mysql://"+ Constants.SERVER+":"+Constants.PORT, Constants.USER_NAME, Constants.PASSWORD);
        }
        catch ( SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static Connection getConnection()
    {
        return con;
    }
}




//    public ConnectionSingleton() throws Exception {
//        getConnectionInstance();
//    }
//
//    public  static Connection getConnectionInstance() throws Exception {
//        if (con == null){
//            try {
//                con = DriverManager.getConnection("jdbc:mysql://" + Constants.SERVER + ":" + Constants.PORT, Constants.USER_NAME, Constants.PASSWORD);
//            }catch (SQLException e){
//                System.out.println("Can't backup to dB");
//                con = DriverManager.getConnection(getConnectionFromXML());
//            }
//        }
//        return con;
//    }
//    public static String getConnectionFromXML() throws Exception {
//            return XMLConfig.getConnection();
//
//    }
//}
