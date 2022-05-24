package server_utils;

import utils.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databases {

    public static void createTable(Connection con, String name) throws SQLException {
        String statementToExecute = "CREATE TABLE " + Constants.DATABASE_NAME +".`"+name+"`( `name` VARCHAR(40) NOT NULL,`age` INT NOT NULL, `breed` VARCHAR(30) NOT NULL, PRIMARY KEY (`name`));";
        con.createStatement().execute(statementToExecute);
    }

     static void insertDog(Connection con, String name, int age, String breed) throws SQLException {
        String statementToExecute = "INSERT INTO " + Constants.DATABASE_NAME + ".dogs (`name`, `age`,`breed`) VALUES ('" + name + "', '" + age +"', '"+ breed + "');";
        con.createStatement().execute(statementToExecute);
    }

    static void getTableContentDogs(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM " + Constants.DATABASE_NAME + ".dogs;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            //Retrieve by column name
            String name = rs.getString("name");
//            int age  = rs.getInt("age");
//            String breed = rs.getString("breed");
            System.out.println("");


            //Display values
            System.out.print("name: " + name);
//            System.out.print(", Age: " + age);
//            System.out.print(", Age: " + breed);
        }
        rs.close();
    }
    static void deleteUserByName(Connection con, String name) throws SQLException {
        String statementToExecute = "DELETE FROM `" + Constants.DATABASE_NAME + "`.`dogs` WHERE `name`='"+name+"';";
        con.createStatement().execute(statementToExecute);
    }

     static void updateUserName(Connection con, int age, String name) throws SQLException {
        String statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`dogs` SET `age`='"+age+"' WHERE `name`='"+name+"';";
        con.createStatement().executeUpdate(statementToExecute);
    }
}
