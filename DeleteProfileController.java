/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdelkader
 */
public class DeleteProfileController implements Initializable {
  @FXML
    private ComboBox ID;
    @FXML
    private TextField Name;
   
    @FXML
    Button cancelBtn;
    @FXML
    Button saveBtn;

    final ObservableList<String> data = FXCollections.observableArrayList();
    EmployeeProfilesAdapter employees;

    public void setModel(EmployeeProfilesAdapter _employees) {
        employees = _employees;
        buildData();
    }

    @FXML
    public void getProfile() {
        EmployeeProfiles oneEmpolyee = null;
        try {
            oneEmpolyee = employees.findProfile(this.ID.getValue().toString());

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        this.Name.setText(oneEmpolyee.getName()); 
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void delete() {
        try {
            employees.deleteEmpolyee(this.ID.getValue().toString());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void buildData() {
        try {
            data.addAll(employees.getEmployeeIDs());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
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
        ID.setItems(data);
    }
    
}
