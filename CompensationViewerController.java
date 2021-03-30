/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class CompensationViewerController implements Initializable {

    @FXML
    Button btnClose;
    
    @FXML
    Label timeStamp;
    
    @FXML
    Label idlabel;
    
    @FXML
    Label netpaylabel;
    /**
     * Initializes the controller class.
     */
    
    CompensationRecords record = new CompensationRecords(); 
    String employeeAcc;
    double netpayy;

    EmployeeProfilesAdapter employees;
    CompensationRecordsAdapter compensation;
    final ObservableList<CompensationRecords> data = FXCollections.observableArrayList();
    
    public void setModel(EmployeeProfilesAdapter _employees, CompensationRecordsAdapter _compensation, String _employeeAcc){
        employees = _employees;
        compensation = _compensation;
        employeeAcc = ViewCompensationController.publicid;
        buildData();
    }
    
    public void buildData() {
 /*  try {
          
          //record = compensation.findCompensation(ViewCompensationController.publicid);
        
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }*/

    }
  
    @FXML
    public void dismiss(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
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

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //CompensationRecords record = new CompensationRecords();
   
        //THIS IS THE CODE TO GET THE ARCHIVED BUT FOR SOME REASON find compensation is causing and issue when ever ..
        /*    try {
          
          record = compensation.findCompensation(ViewCompensationController.publicid);
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }*/
        
       
        String date = ""+ record.getPayDate()+"";
        timeStamp.setText(date);
        String netpaystring = ""+record.getNetPay()+"";
        netpaylabel.setText(netpaystring);
        idlabel.setText(ViewCompensationController.publicid);
        
        
       
        
    }    
    
}