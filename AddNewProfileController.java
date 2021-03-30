/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdelkader
 */
public class AddNewProfileController implements Initializable {

    @FXML
    private TextField ID;
    @FXML
    private TextField Name;
    @FXML
    private TextField City;
    @FXML
    private TextField Region;
    @FXML
    private TextField Phone;
    @FXML
    private TextField SIN;
    @FXML
    private TextField PostalCode;    
    @FXML
    private TextField MartialStatus;
    @FXML
    private TextField JobName;
    @FXML
    private TextField SkillCode;
    @FXML
    private DatePicker DOB;
    @FXML
    private DatePicker DOH;
    @FXML
    private DatePicker DOLP;
    @FXML
    Button cancelBtn;
    @FXML
    Button saveBtn;

    EmployeeProfilesAdapter employees;

    public void setModel(EmployeeProfilesAdapter _employees) {
        employees = _employees;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save() {
        try {
            EmployeeProfiles oneEmpolyee = new EmployeeProfiles();
            oneEmpolyee.setID(this.ID.getText());
            oneEmpolyee.setName(this.Name.getText());
            oneEmpolyee.setCity(this.City.getText());
            oneEmpolyee.setCity(this.Region.getText());
            oneEmpolyee.setCity(this.PostalCode.getText());            
            oneEmpolyee.setPhone(this.Phone.getText());
            oneEmpolyee.setSIN(this.SIN.getText());
            oneEmpolyee.setMartialStatus(this.MartialStatus.getText());
            oneEmpolyee.setJobName(this.JobName.getText());
            oneEmpolyee.setSkillCode(this.SkillCode.getText());
            oneEmpolyee.setDOB(java.sql.Date.valueOf(this.DOB.getValue()));
            oneEmpolyee.setDOH(java.sql.Date.valueOf(this.DOH.getValue()));
            oneEmpolyee.setDOLP(java.sql.Date.valueOf(this.DOLP.getValue()));
 
            employees.insertEmpolyee(oneEmpolyee);
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
