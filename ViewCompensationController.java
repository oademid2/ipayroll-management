package iPAYROLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kitan
 */
public class ViewCompensationController implements Initializable {
    
    

    @FXML
    Button okBtn;
    @FXML
    Button cancelBtn;
    @FXML
    public ComboBox employeeBox;

    static public String publicid;
    
    final ObservableList<String> data = FXCollections.observableArrayList();
    EmployeeProfilesAdapter employees;
    CompensationRecordsAdapter compensation;
    private Connection conn;

    public void setModel(EmployeeProfilesAdapter _employees) {
        employees = _employees;
        buildData();
    }
    
     public void buildData() {
        try {
            data.addAll(employees.getEmployeeIDs());
  
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }


    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void okay() throws Exception {
        employees = new EmployeeProfilesAdapter(conn, false);
        compensation = new CompensationRecordsAdapter(conn, false);
        
        publicid  = (String)employeeBox.getValue();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CompensationViewer.fxml"));
        Parent okay = (Parent) fxmlLoader.load();
        CompensationViewerController compensationViewerController = (CompensationViewerController) fxmlLoader.getController();
        compensationViewerController.setModel(employees, compensation, publicid);
        
        Scene scene = new Scene(okay);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
        stage.setTitle("COMPENSATION RECORD");
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeBox.setItems(data);
  
    }
    
}
