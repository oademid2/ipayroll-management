/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Kitan
 */
public class AuditTrailAdapter {
    
    Connection connection;

    public AuditTrailAdapter(Connection conn, Boolean reset) throws SQLException {
        
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                 
                stmt.execute("DROP TABLE AuditTrail");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {

                stmt.execute("CREATE TABLE AuditTrail ("
                        + "ID VARCHAR(20), "// NOT NULL PRIMARY KEY, "//VARCHAR(9) NOT NULL PRIMARY KEY, "
                        + "DayTimeStamp DATE, "
                        + "Description VARCHAR(50), "
                        + "UserName VARCHAR(20)"
                        + ")");
                //populateSampls();
            }
        }
    }

    private void populateSampls() throws SQLException {
     
       
    }

    public void insertAuditTrail(String ID, Date timestamp, String description, String username) throws SQLException {
        Statement stmt = connection.createStatement();
       

        stmt.executeUpdate("INSERT INTO AuditTrail (ID, DayTimeStamp, Description, UserName) "
                + "VALUES ('"
                + ID + "','"
                + timestamp + "', '"
                + description + "',' "
                + username + "')"
        );
    }
    
}
