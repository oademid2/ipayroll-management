package iPAYROLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kitan
 */
public class CompensationRecordsAdapter {
     
     Connection connection;

    public CompensationRecordsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                  
                stmt.execute("DROP TABLE CompensationRecords");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {

                stmt.execute("CREATE TABLE CompensationRecords ("
                        + "ID VARCHAR(20) NOT NULL PRIMARY KEY, "//VARCHAR(9) NOT NULL PRIMARY KEY, "
                        + "PayDate DATE, "//VARCHAR(70), "
                        + "NetPay Double, "
                        + "PayAccountNo VARCHAR(20)"
                        + ")");
                
               
            }
        }
    }



    public void insertCompensation(String ID, CompensationRecords compensation) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO CompensationRecords (ID, PayDate, NetPay, PayAccountNo) "
                + "VALUES ('"
                + ID + "','"
                + compensation.getPayDate() + "', "
                + compensation.getNetPay() + ", '"
                + compensation.getPayAccountNo() + "')"    
     
        );
    }
    
   /* public void insertCompensation(String ID, Date date, double netpay, String account) throws SQLException {
        Statement stmt = connection.createStatement();
        
        stmt.executeUpdate("INSERT INTO CompensationRecords (ID, PayDate, NetPay, PayAccountNo) "
                + "VALUES ('"
                + ID + "','"
                + date + "', "
                + netpay + ", '"
                + account + "')"   
                     
        );
    }*/
    
    
    public CompensationRecords findCompensation(String ID) throws SQLException {
        //THIS FUNCTION IS HAVING PROBLEMS....
        ResultSet rs;
        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT MIN(PayDate) FROM CompensationRecords WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        
        CompensationRecords type = new CompensationRecords();

        while(rs.next()){
            type.setNetPay(rs.getDouble(3));
            type.setPayDate(rs.getDate(2));
            type.setPayAccountNo(rs.getString(4));
        }
        
       return type;
    }
    
    

    
}
