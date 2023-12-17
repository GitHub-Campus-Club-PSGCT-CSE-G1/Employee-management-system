import java.sql.*;

import Database.ConnectionHelper;

public class Main {

    

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionHelper connectionHelper = new ConnectionHelper();
        //connectionHelper.printAllTables();

        
        try {
            connectionHelper.createEmployeeTable();
            
        }
        catch (SQLException e) {
            try {
                connectionHelper.deleteEmployeeTable();            
                connectionHelper.createEmployeeTable();
            } catch (SQLException e1) {
                
                e1.printStackTrace();
            }

        }
        System.out.println("Hello World!");
    }
}
