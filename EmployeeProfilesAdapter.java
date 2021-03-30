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
 * @author Abdelkader
 */
public class EmployeeProfilesAdapter {

    Connection connection;

    public EmployeeProfilesAdapter(Connection conn, Boolean reset) throws SQLException {
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
                stmt.execute("DROP TABLE EmployeeProfiles");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of teams
                stmt.execute("CREATE TABLE EmployeeProfiles ("
                        + "ID CHAR(9) NOT NULL PRIMARY KEY, "
                        + "Name VARCHAR(50), "
                        + "City VARCHAR(20), "
                        + "Region VARCHAR(20),"
                        + "PostalCode VARCHAR(20),"
                        + "Phone VARCHAR(20),"
                        + "SIN VARCHAR(20),"
                        + "MartialStatus VARCHAR(20),"
                        + "JobName VARCHAR(50),"
                        + "SkillCode VARCHAR(20),"
                        + "PayForm VARCHAR(20),"
                        + "WorkHours DOUBLE,"
                        + "Exempt INT,"
                        + "RatePerHour DOUBLE,"
                        + "DOB DATE,"
                        + "DOH DATE,"
                        + "DOR DATE,"
                        + "DOLR DATE,"
                        + "DOLP DATE,"
                        + "DOLPC DATE,"
                        + "DOLCC DATE,"
                        + "DOT DATE,"
                        + "VactionAccrualRate DOUBLE,"
                        + "VactionAccrued DOUBLE,"
                        + "VactionUsed DOUBLE,"
                        + "SickAccrualRate DOUBLE,"
                        + "SickAccrued DOUBLE,"
                        + "SickUsed DOUBLE,"
                        + "EarningStatmentType VARCHAR(20)"
                        + ")");
                populateSampls();
            }
        }
    }

    private void populateSampls() throws SQLException {
        // Add some teams
        EmployeeProfiles oneProfile = new EmployeeProfiles();
        oneProfile.setID("123456789");
        oneProfile.setName("Name 1");
        oneProfile.setCity("Ciy 1");
        oneProfile.setRegion("Region 1");
        oneProfile.setPostalCode("aaa 111");
        oneProfile.setPhone("111 111 1111");
        oneProfile.setSIN("333 333 333");
        oneProfile.setMartialStatus("Single");
        oneProfile.setJobName("Job 1");
        oneProfile.setSkillCode("Skill 1");
        java.util.Date uDate = new java.util.Date();
        oneProfile.setDOB(new java.sql.Date(uDate.getTime()));
        oneProfile.setDOH(new java.sql.Date(uDate.getTime()));
        oneProfile.setDOLP(new java.sql.Date(uDate.getTime()));

        this.insertEmpolyee(oneProfile);
    }

    public void insertEmpolyee(EmployeeProfiles data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO EmployeeProfiles (ID, Name, City, Region, PostalCode, Phone, SIN, MartialStatus, JobName, SkillCode, DOB, DOH, DOLP) "
                + "VALUES ('"
                + data.getID() + "', '"
                + data.getName() + "', '"
                + data.getCity() + "', '"
                + data.getRegion() + "', '"
                + data.getPostalCode() + "', '"
                + data.getPhone() + "', '"
                + data.getSIN() + "', '"
                + data.getMartialStatus() + "', '"
                + data.getJobName() + "', '"
                + data.getSkillCode() + "', '"
                + data.getDOB() + "', '"
                + data.getDOH() + "', '"
                + data.getDOLP() + "')"
        );
    }

    public void updateEmpolyee(EmployeeProfiles data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE EmployeeProfiles "
                + "SET Name = '" + data.getName() + "', "
                + "City = '" + data.getCity() + "', "
                + "Region = '" + data.getRegion() + "', "
                + "PostalCode = '" + data.getPostalCode() + "', "
                + "Phone = '" + data.getPhone() + "', "
                + "SIN = '" + data.getSIN() + "', "
                + "MartialStatus = '" + data.getMartialStatus() + "', "
                + "JobName = '" + data.getJobName() + "', "
                + "SkillCode = '" + data.getSkillCode() + "', "
                + "DOB = '" + data.getDOB() + "', "
                + "DOH = '" + data.getDOH() + "', "
                + "DOLP = '" + data.getDOLP() + "' "
                + "WHERE ID = "
                + "'" + data.getID() + "'");
    }

        public void updateWages(EmployeeProfiles data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE EmployeeProfiles "
                + "SET WorkHours = " + data.getWorkHours() + ", "
                + "Exempt = " + data.getExempt() + ", "
                + "PayForm = '" + data.getPayForm() + "', "
                + "RatePerHour = " + data.getRatePerHour() + " "
                + "WHERE ID = "
                + "'" + data.getID() + "'");
    }
        
    public void deleteEmpolyee(String ID) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM EmployeeProfiles WHERE ID = '" + ID + "'");
    }

    public ObservableList<String> getEmployeeIDs() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT ID FROM EmployeeProfiles";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }

    public EmployeeProfiles findProfile(String ID) throws SQLException {
        EmployeeProfiles profile = new EmployeeProfiles();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT * FROM EmployeeProfiles WHERE ID = '" + ID + "'";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);
        while (rs.next()) {
            profile.setID(rs.getString("ID"));
            profile.setName(rs.getString("Name"));
            profile.setCity(rs.getString("City"));
            profile.setRegion(rs.getString("Region"));
            profile.setPhone(rs.getString("Phone"));
            profile.setPostalCode(rs.getString("PostalCode"));
            profile.setSIN(rs.getString("SIN"));
            profile.setMartialStatus(rs.getString("MartialStatus"));
            profile.setJobName(rs.getString("JobName"));
            profile.setSkillCode(rs.getString("SkillCode"));
            profile.setDOB(rs.getDate("DOB"));
            profile.setDOH(rs.getDate("DOH"));
            profile.setDOLP(rs.getDate("DOLP"));
            profile.setExempt(rs.getInt("Exempt"));
            profile.setWorkHours(rs.getDouble("WorkHours"));
            profile.setPayForm(rs.getString("PayForm"));
            profile.setRatePerHour(rs.getDouble("RatePerHour"));
        }
        return profile;
    }
    
     public double getDoubleData(String title , String ID) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM EmployeeProfiles WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        
        double type = 0;
        while(rs.next()){
            type = rs.getDouble(title);
        }
        
       return type;
    }
     
     public String getStringData(String title , String ID) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM EmployeeProfiles WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        
        String type = "EMPTY";
        while(rs.next()){
            type = rs.getString(title);
        }
        
       return type;
    }
     
     public int getIntData(String title , String ID) throws SQLException {
        
        ResultSet rs;

        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT " + title +" FROM EmployeeProfiles WHERE ID = '" + ID + "'";
        rs = stmt.executeQuery(sqlStatement);
        
        int type = 0;
        while(rs.next()){
            type = rs.getInt(title);
        }
        
       return type;
    }
     
      public void setDoubleData(String title , String ID, double info) throws SQLException {
        
        Statement stmt = connection.createStatement();
        ResultSet rs;
        String sqlStatement = "UPDATE EmployeeProfiles " + "SET " + title + " = " + info +" Where ID = '" + ID +"'" ;
        stmt.executeUpdate(sqlStatement);
    }
}
