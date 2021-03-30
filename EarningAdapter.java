/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Kitan
 */
public class EarningAdapter {
    
     Connection connection;

    public EarningAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                // We drop Matches first because it refrences the table Teams
                //    stmt.execute("DROP TABLE TimeWorkedSheets");
                //    stmt.execute("DROP TABLE Earnings");
                //    stmt.execute("DROP TABLE Deuctions");
                //    stmt.execute("DROP TABLE CompensationRecords");  
                //    stmt.execute("DROP TABLE UserAccounts");            
                stmt.execute("DROP TABLE Earning");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {

                stmt.execute("CREATE TABLE Earning ("
                        + "ID VARCHAR(20) NOT NULL PRIMARY KEY, "//VARCHAR(9) NOT NULL PRIMARY KEY, "
                        + "Code VARCHAR(20), "
                        + "Type VARCHAR(20)"
                        + ")");
                populateSampls();
            }
        }
    }

    private void populateSampls() throws SQLException {
        Earning oneEarning = new Earning("Wages", "Hourly");
        this.insertEarning("123456789", oneEarning);
    }

    public void insertEarning(String ID, Earning data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Earning (ID, Code, Type) "
                + "VALUES ('"
                + ID + "', '"
                + data.getCode() + "', '"
                + data.getType() + "')"
        );
    }


    public String getStringData(String title , String ID) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM Earning WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        String type = "EMPTY";
        
        while(rs.next()){
        type = rs.getString(title);
        }
        
        
       return type;
    }
    
    public String getPayType(String ID) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT PayType FROM Earning WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        String type = "EMPTY";
        
        while(rs.next()){
        type = rs.getString("PayType");
        }
        
        
       return type;
    }
    
}
