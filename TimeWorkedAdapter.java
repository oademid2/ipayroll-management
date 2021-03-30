/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sun.util.calendar.BaseCalendar.Date;
//

/**
 *
 * @author Kitan
 */
public class TimeWorkedAdapter {
    
    Connection connection;

    public TimeWorkedAdapter(Connection conn, Boolean reset) throws SQLException{
        
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                
                stmt.execute("DROP TABLE TimeWorked");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {

                stmt.execute("CREATE TABLE TimeWorked ("
                        + "ID VARCHAR(20) NOT NULL PRIMARY KEY, "
                        + "DayTimeStamp DATE, "
                        + "TimeIn DATE, "
                        + "TimeOut DATE"
                        + ")");
                
             
            }
        }
    }


    public void insertTimeWorkedSheet(String ID, Date timestamp, Date timein, Date timeout) throws SQLException {
        Statement stmt = connection.createStatement();
        
        stmt.executeUpdate("INSERT INTO TimeWorked (ID, DayTimeStamp, TimeIn, TimeOut) "
                + "VALUES ('"
                + ID + "', "
                + (java.sql.Date)timestamp + ", "
                + (java.sql.Date)timein + ", "
                + (java.sql.Date)timeout + ")"
        );
        
        //String sql = "select * from person where uid=?";
        //PreparedStatement pstmt = connection.prepareStatement(sql);
        //pstmt.setDate(1, (java.sql.Date) new Date());
    }


    public Date getDateData(String title , String ID, Date date) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM TimeWorked WHERE ID = '" + ID + "' AND DayTimeStamp = " + (java.sql.Date)date + "";
        rs = stmt.executeQuery(sqlStatement);
        
        Date type = new Date();//FIX Date
        while(rs.next()){
            type = rs.getDate(title);
        }
        
       return type;
    }
    
    public Date getTimeIn(String ID, Date date) throws SQLException {
        
        String title = "TimeIn";
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM TimeWorked WHERE ID = '" + ID + "' AND DayTimeStamp = " + (java.sql.Date)date + "";
        rs = stmt.executeQuery(sqlStatement);
        
        Date type = new Date();//FIX Date
        while(rs.next()){
            type = rs.getDate(title);
        }
        
       return type;
    }
    
    public Date getTimeOut(String ID, Date date) throws SQLException {
        
        String title = "TimeOut";
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM TimeWorked WHERE ID = '" + ID + "' AND DayTimeStamp = " + (java.sql.Date)date + "";
        rs = stmt.executeQuery(sqlStatement);
        
        Date type = new Date();//FIX Date
        while(rs.next()){
            type = rs.getDate(title);
        }
        
       return type;
    }
    
    
    
}
