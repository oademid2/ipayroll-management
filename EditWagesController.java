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
import javafx.scene.control.CheckBox;
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
public class EditWagesController implements Initializable {

    @FXML
    private ComboBox ID;
    @FXML
    private TextField Name;
    @FXML
    private ComboBox PayForm;
    @FXML
    private CheckBox Exempt;
    @FXML
    private TextField WorkHours;
    @FXML
    private TextField RatePerHour;

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
        if (oneEmpolyee.getExempt() == 1) {
            this.Exempt.setSelected(true);
        } else {
            this.Exempt.setSelected(false);
        }
        this.WorkHours.setText(oneEmpolyee.getWorkHours().toString());
        this.RatePerHour.setText(oneEmpolyee.getRatePerHour().toString());
        this.PayForm.setValue(oneEmpolyee.getPayForm());

    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() {
        try {
            EmployeeProfiles oneEmpolyee = new EmployeeProfiles();
            oneEmpolyee.setID(this.ID.getValue().toString());
            oneEmpolyee.setWorkHours(Double.parseDouble(this.WorkHours.getText()));
            oneEmpolyee.setRatePerHour(Double.parseDouble(this.RatePerHour.getText()));
            if (Exempt.isSelected()) {
                oneEmpolyee.setExempt(1);
            } else {
                oneEmpolyee.setExempt(0);
            }
            oneEmpolyee.setPayForm(this.PayForm.getValue().toString());

            employees.updateWages(oneEmpolyee);
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
        ObservableList<String> PayFormOptions
                = FXCollections.observableArrayList(
                        "Checks",
                        "Direct Deposite"
                );
        PayForm.setItems(PayFormOptions);

    }

}
