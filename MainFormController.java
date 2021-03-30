/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

-hard code deductions and hours
-adapter for earnings, timesheet and compensation records
 */
package iPAYROLL;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class MainFormController implements Initializable {

    @FXML
    private MenuBar mainMenu;

    private EmployeeProfilesAdapter employees;
    private EarningAdapter earning;
    private TimeWorkedAdapter timeSheet;
    private CompensationRecordsAdapter compensation;
    private AuditTrailAdapter audit;
    private Connection conn;

    public void showAbout() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void createResetDB() {
        try {
            employees = new EmployeeProfilesAdapter(conn, true);
            displayAlert("EmployeeProfiles table has been created");
            
            earning = new EarningAdapter(conn, true);
            displayAlert("Earning table has been created");
            
            timeSheet = new TimeWorkedAdapter(conn, true);
            displayAlert("TimeWorked table has been created");
            
            compensation = new CompensationRecordsAdapter(conn, true);
            displayAlert("Compensation table has been created");
            
            audit = new AuditTrailAdapter(conn, true);
            displayAlert("AuditTrail table has been created");
            
            
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

    }

    @FXML
    public void addNewProfile() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddNewProfile.fxml"));
        Parent addNewProfile = (Parent) fxmlLoader.load();
        AddNewProfileController addNewProfileController = (AddNewProfileController) fxmlLoader.getController();
        addNewProfileController.setModel(employees);
        
        Scene scene = new Scene(addNewProfile);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("Add New Employee Profile Data");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    @FXML
    public void modifyProfile() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyProfile.fxml"));
        Parent modifyProfile = (Parent) fxmlLoader.load();
        ModifyProfileController modifyProfileController = (ModifyProfileController) fxmlLoader.getController();
        modifyProfileController.setModel(employees);
        
        Scene scene = new Scene(modifyProfile);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("Modify Employee Profile Data");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    @FXML
    public void deleteProfile() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeleteProfile.fxml"));
        Parent deleteProfile = (Parent) fxmlLoader.load();
        DeleteProfileController deleteProfileController = (DeleteProfileController) fxmlLoader.getController();
        deleteProfileController.setModel(employees);
        
        Scene scene = new Scene(deleteProfile);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("Modify Employee Profile Data");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    @FXML
    public void editWages() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditWages.fxml"));
        Parent editWages = (Parent) fxmlLoader.load();
        EditWagesController editWagesController = (EditWagesController) fxmlLoader.getController();
        editWagesController.setModel(employees);
        
        Scene scene = new Scene(editWages);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("Add/Edit Wages Information");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
   
    @FXML
    public void generateWages() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        earning = new EarningAdapter(conn, false);
        timeSheet = new TimeWorkedAdapter(conn, false);
        compensation = new CompensationRecordsAdapter(conn, false);
        audit = new AuditTrailAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenerateWages.fxml"));
        Parent generateWages = (Parent) fxmlLoader.load();
        GenerateWagesController generateWagesController = (GenerateWagesController) fxmlLoader.getController();
        generateWagesController.setModel(employees, earning, timeSheet, compensation, audit);
        
        Scene scene = new Scene(generateWages);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("Generate Wages");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    @FXML
    public void viewCompensation() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewCompensation.fxml"));
        Parent viewCompensation = (Parent) fxmlLoader.load();
        ViewCompensationController viewCompensationController = (ViewCompensationController) fxmlLoader.getController();
        viewCompensationController.setModel(employees);
        
        Scene scene = new Scene(viewCompensation);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("View Compensation");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:iPAYROLLDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {
            displayAlert(ex.getMessage());
        }
    }

}
