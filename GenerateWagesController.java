package iPAYROLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kitan
 */
public class GenerateWagesController implements Initializable {


    @FXML
    Button generateWageBtn, cancelBtn;
    @FXML
    ComboBox selectEmployeeBox;
    @FXML
    TextField password;
    
    final ObservableList<String> data = FXCollections.observableArrayList();
    
    EmployeeProfilesAdapter employees;
    EarningAdapter earning;
    TimeWorkedAdapter timeSheets;
    CompensationRecordsAdapter compensation;
    AuditTrailAdapter audit;

    public void setModel(EmployeeProfilesAdapter _employees, EarningAdapter _earning, TimeWorkedAdapter _timesheet, CompensationRecordsAdapter _compensation, AuditTrailAdapter _audit) {
        employees = _employees;
        earning  = _earning;
        timeSheets  = _timesheet;
        compensation = _compensation;
        audit = _audit;
        buildData();
    }
    
     public void buildData() {
        try {
            data.addAll(employees.getEmployeeIDs());
            data.addAll("ALL");
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
    public void generateEmployeeWage() throws ParseException {
        
       
       
       Date TimeStart;
       Date TimeEnd;
       double hours;
       
       hours = 0;
       String EmployeeName = (String)selectEmployeeBox.getValue();
       String EarningType = "NOT RECEIVED";
       int Exempt = 0;
       double EarningCalculated = 0;
       double DeductionsCalculated  = 0;
       double DeductionRate = 2.5;
       double WageCalculated = 0;
        
     try{
       
        //Get employee hourly rate for employee
        double payrate = employees.getDoubleData("RatePerHour", (String)selectEmployeeBox.getValue());

        //IF ONLY ONE EMPLOYEE IS SELECTED.....
        if(!"ALL".equals((String)selectEmployeeBox.getValue())){
            
            //FIND OUT IF THEY ARE EXEMPT AND THEY'RE PAY TYPE
            EarningType = earning.getStringData("Type", EmployeeName);
            Exempt = employees.getIntData("Exempt", EmployeeName);
            
            //IF THEIR TYPE IS HOURLY WITH A TIME CARD....
            if("Hourly".equals(EarningType)){

                hours = employees.getDoubleData("WorkHours", EmployeeName); 
                employees.setDoubleData("WorkHours", EmployeeName, 0);
            }
            
           
            //CALCULATE THEIR EARNINGS...
            EarningCalculated = payrate*hours*5*4;//pay*hrs*days/week*weeks/month
            
            //IF THEY ARE NOT EXEMPT GIVE THEM A DEDUCTION RATE OF 2.5...
            if(Exempt == 0){
              DeductionRate  = 2.5;
            }else{
                 //IF THEY ARE EXEMPT GIVE THEM A DEDUCTION RATE OF 0...
                DeductionRate = 0;
            }
            
            //CALCULATE DEDUCTIONS...
            DeductionsCalculated = EarningCalculated*DeductionRate;
            
            //CALCULATE WAGE....
            WageCalculated = EarningCalculated - DeductionsCalculated;
            
            //GET CHECK NUMBER....
            String CheckNumber = "C-"+EmployeeName;
            //GET ACCOUNT NUMBER....
            String AccountNumber  = "A00-"+EmployeeName+"";
            //ADD COMPENSATION...
            
            java.util.Date DateOfWage = new java.util.Date();
            CompensationRecords newrecord = new CompensationRecords();
            newrecord.setNetPay(WageCalculated);
            newrecord.setPayAccountNo(AccountNumber);
            newrecord.setPayDate(new java.sql.Date(DateOfWage.getTime()));
            
           // compensation.insertCompensation(EmployeeName, new java.sql.Date(DateOfWage.getTime()), WageCalculated, AccountNumber);
            compensation.insertCompensation(EmployeeName, newrecord);
            audit.insertAuditTrail(EmployeeName, new java.sql.Date(DateOfWage.getTime()),"generated a wage", "Kitan");//record in audit trail

        }
        
        //IF MULTIPLE EMPLOYEES ARE SELECTED, MAKE A LOOP AND PERFORM ACTION FOR EACH EMPLOYEE
        else if("ALL".equals((String)selectEmployeeBox.getValue()) ){
            
            for(int i=0;i<data.size()-1;i++){
              
              
               // java.sql.Date sqlDate = new java.sql.Date(StartDate.getTime());
                hours = 0;
                EarningCalculated = 0;
                DeductionsCalculated  = 0;
                DeductionRate = 2.5;
                
                EmployeeName = data.get(i);
                //FIND OUT IF THEY ARE EXEMPT AND THEY'RE PAY TYPE
                 //FIND OUT IF THEY ARE EXEMPT AND THEY'RE PAY TYPE
            EarningType = earning.getStringData("Type", EmployeeName);
            Exempt = employees.getIntData("Exempt", EmployeeName);
            
            //IF THEIR TYPE IS HOURLY WITH A TIME CARD....
            if(!"Hourly".equals(EarningType)){

                hours = employees.getDoubleData("WorkHours", EmployeeName); 
                employees.setDoubleData("WorkHours", EmployeeName, 0);
            }
            
           
            //CALCULATE THEIR EARNINGS...
             EarningCalculated = payrate*hours*5*4;//pay*hrs*days/week*weeks/month
            
            //IF THEY ARE NOT EXEMPT GIVE THEM A DEDUCTION RATE OF 2.5...
            if(Exempt == 0){
              DeductionRate  = 2.5;
            }else{
                 //IF THEY ARE EXEMPT GIVE THEM A DEDUCTION RATE OF 0...
                DeductionRate = 0;
            }
            
            //CALCULATE DEDUCTIONS...
            DeductionsCalculated = EarningCalculated*DeductionRate;
            
            //CALCULATE WAGE....
            WageCalculated = EarningCalculated - DeductionsCalculated;
            
            //GET CHECK NUMBER....
            String CheckNumber = "C-"+EmployeeName;
            //GET ACCOUNT NUMBER....
            String AccountNumber  = "A00-"+EmployeeName+"";
            //ADD COMPENSATION...
            
            java.util.Date DateOfWage = new java.util.Date();
            CompensationRecords newrecord = new CompensationRecords();
            newrecord.setNetPay(WageCalculated);
            newrecord.setPayAccountNo(AccountNumber);
            newrecord.setPayDate(new java.sql.Date(DateOfWage.getTime()));
            
           // compensation.insertCompensation(EmployeeName, new java.sql.Date(DateOfWage.getTime()), WageCalculated, AccountNumber);
            compensation.insertCompensation(EmployeeName, newrecord);
            audit.insertAuditTrail(EmployeeName, new java.sql.Date(DateOfWage.getTime()),"generated a wage", "Kitan");//record in audit trail

            }
         
        }
        
        
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
        selectEmployeeBox.setItems(data);
        

    }

}
