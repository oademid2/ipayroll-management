/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abdelkader
 */
public class EmployeeProfiles extends iPAYROLLUsers {

    private final StringProperty city;
    private final StringProperty region;
    private final StringProperty postalCode;
    private final StringProperty phone;
    private final StringProperty SIN;
    private final StringProperty martialStatus;
    private final StringProperty jobName;
    private final StringProperty skillCode;
    private final StringProperty payForm;
    private final DoubleProperty workHours;
    private final IntegerProperty exempt;
    private final DoubleProperty ratePerHour;
    private final ObjectProperty<Date> DOB;
    private final ObjectProperty<Date> DOH;
    private final ObjectProperty<Date> DOR;
    private final ObjectProperty<Date> DOLR;
    private final ObjectProperty<Date> DOLP;
    private final ObjectProperty<Date> DOLPC;
    private final ObjectProperty<Date> DOLCC;
    private final ObjectProperty<Date> DOT;
    private final DoubleProperty vactionAccrualRate;
    private final DoubleProperty vactionAccrued;
    private final DoubleProperty vactionUsed;
    private final DoubleProperty sickAccrualRate;
    private final DoubleProperty sickAccrued;
    private final DoubleProperty sickUsed;
    private final StringProperty earningStatmentType;

    public EmployeeProfiles() {
        super();
        this.city = new SimpleStringProperty();
        this.region = new SimpleStringProperty();
        this.postalCode = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.SIN = new SimpleStringProperty();
        this.martialStatus = new SimpleStringProperty();
        this.jobName = new SimpleStringProperty();
        this.skillCode = new SimpleStringProperty();
        this.payForm = new SimpleStringProperty();
        this.workHours = new SimpleDoubleProperty();
        this.exempt = new SimpleIntegerProperty();
        this.ratePerHour = new SimpleDoubleProperty();
        this.DOB = new SimpleObjectProperty<>();
        this.DOH = new SimpleObjectProperty<>();
        this.DOR = new SimpleObjectProperty<>();
        this.DOLR = new SimpleObjectProperty<>();
        this.DOLP = new SimpleObjectProperty<>();
        this.DOLPC = new SimpleObjectProperty<>();
        this.DOLCC = new SimpleObjectProperty<>();
        this.DOT = new SimpleObjectProperty<>();
        this.vactionAccrualRate = new SimpleDoubleProperty();
        this.vactionAccrued = new SimpleDoubleProperty();
        this.vactionUsed = new SimpleDoubleProperty();
        this.sickAccrualRate = new SimpleDoubleProperty();
        this.sickAccrued = new SimpleDoubleProperty();
        this.sickUsed = new SimpleDoubleProperty();
        this.earningStatmentType = new SimpleStringProperty();
    }
    
    
    public void setCity(String _code) {
        city.set(_code);
    }
    public void setRegion(String _code) {
        region.set(_code);
    }    
    public void setPostalCode(String _code) {
        postalCode.set(_code);
    }
    public void setPhone(String _code) {
        phone.set(_code);
    }
    public void setSIN(String _code) {
        SIN.set(_code);
    }
    public void setMartialStatus(String _code) {
        martialStatus.set(_code);
    }
    public void setJobName(String _code) {
        jobName.set(_code);
    }
    public void setSkillCode(String _code) {
        skillCode.set(_code);
    }
    public void setPayForm(String _code) {
        payForm.set(_code);
    }
               
    public void setWorkHours(double amount) {
        workHours.set(amount);
    }
                   
    public void setExempt(int value) {
        exempt.set(value);
    }
               
    public void setRatePerHour(double amount) {
        ratePerHour.set(amount);
    }
    
    public void setDOB(Date _date) {
        DOB.set(_date);
    }
    
    public void setDOH(Date _date) {
        DOH.set(_date);
    }
    
    public void setDOR(Date _date) {
        DOR.set(_date);
    }
    
    public void setDOLR(Date _date) {
        DOLR.set(_date);
    }
    
    public void setDOLP(Date _date) {
        DOLP.set(_date);
    }
    
    public void setDOLPC(Date _date) {
        DOLPC.set(_date);
    }
    
    public void setDOLCC(Date _date) {
        DOLCC.set(_date);
    }
    
    public void setDOT(Date _date) {
        DOT.set(_date);
    }
               
    public void setVactionAccrualRate(double amount) {
        vactionAccrualRate.set(amount);
    }
               
    public void setVactionAccrued(double amount) {
        vactionAccrued.set(amount);
    }
               
    public void setVactionUsed(double amount) {
        vactionUsed.set(amount);
    }
               
    public void setSickAccrualRate(double amount) {
        sickAccrualRate.set(amount);
    }
               
    public void setSickAccrued(double amount) {
        sickAccrued.set(amount);
    }
               
    public void setSickUsed(double amount) {
        sickUsed.set(amount);
    }
               
    public void setEarningStatmentType(String _code) {
        earningStatmentType.set(_code);
    }   

    public String getCity() {
        return city.get();
    }
    public String getRegion() {
        return region.get();
    }    
    public String getPostalCode() {
        return postalCode.get();
    }
    public String getPhone() {
        return phone.get();
    }
    public String getSIN() {
        return SIN.get();
    }
    public String getMartialStatus() {
        return martialStatus.get();
    }
    public String getJobName() {
        return jobName.get();
    }
    public String getSkillCode() {
        return skillCode.get();
    }
    public String getPayForm() {
        return payForm.get();
    }

    public Double getWorkHours( ) {
        return workHours.get();
    }
                   
    public int getExempt( ) {
        return exempt.get();
    }
               
    public Double getRatePerHour( ) {
        return ratePerHour.get();
    }
    
    public Date getDOB( ) {
        return DOB.get();
    }
    
    public Date getDOH( ) {
        return DOH.get();
    }
    
    public Date getDOR( ) {
        return DOR.get();
    }
    
    public Date getDOLR( ) {
        return DOLR.get();
    }
    
    public Date getDOLP( ) {
        return DOLP.get();
    }
    
    public Date getDOLPC( ) {
        return DOLPC.get();
    }
    
    public Date getDOLCC( ) {
        return DOLCC.get();
    }
    
   public Date getDOT( ) {
        return DOT.get();
    }
               
    public Double getVactionAccrualRate( ) {
        return vactionAccrualRate.get();
    }
               
    public Double getVactionAccrued( ) {
        return vactionAccrued.get();
    }
               
    public Double getVactionUsed( ) {
        return vactionUsed.get();
    }
               
    public Double getSickAccrualRate( ) {
        return sickAccrualRate.get();
    }
               
    public Double getSickAccrued( ) {
        return sickAccrued.get();
    }
               
    public Double getSickUsed( ) {
        return sickUsed.get();
    }
               
    public String getEarningStatmentType( ) {
        return earningStatmentType.get();
    }   
    
 
        
        
    public StringProperty CityProperty() {
        return city;
    }

    public StringProperty RegionProperty() {
        return region;
    }

    public StringProperty PostalCodeProperty() {
        return postalCode;
    }

    public StringProperty PhoneProperty() {
        return phone;
    }

    public StringProperty SINProperty() {
        return SIN;
    }

    public StringProperty MartialStatusProperty() {
        return martialStatus;
    }

    public StringProperty JobNameProperty() {
        return jobName;
    }

    public StringProperty SkillCodeProperty() {
        return skillCode;
    }

    public StringProperty PayFormProperty() {
        return payForm;
    }
    public DoubleProperty WorkHoursProperty() {
        return workHours;
    }
    public IntegerProperty ExemptProperty() {
        return exempt;
    }
        public DoubleProperty RatePerHourProperty() {
        return ratePerHour;
    }
        
    public ObjectProperty<Date> DOBProperty() {
        return DOB;
    }
        
    public ObjectProperty<Date> DOHProperty() {
        return DOH;
    }        
    public ObjectProperty<Date> DORProperty() {
        return DOR;
    }        
    public ObjectProperty<Date> DOLRProperty() {
        return DOLR;
    }        
    public ObjectProperty<Date> DOLPProperty() {
        return DOLP;
    }        
    public ObjectProperty<Date> DOLPCProperty() {
        return DOLPC;
    }        
    public ObjectProperty<Date> DOLCCProperty() {
        return DOLCC;
    }        
    public ObjectProperty<Date> DOTProperty() {
        return DOT;
    }             
    
    public DoubleProperty VactionAccrualRateProperty() {
        return vactionAccrualRate;
    }
    public DoubleProperty VactionAccruedProperty() {
        return vactionAccrued;
    }
    public DoubleProperty VactionUsedProperty() {
        return vactionUsed;
    }
     public DoubleProperty SickAccrualRateProperty() {
        return sickAccrualRate;
    }
    public DoubleProperty SickAccruedProperty() {
        return sickAccrued;
    }
    public DoubleProperty SickUsedProperty() {
        return sickUsed;
    }
    public StringProperty EarningStatmentTypeProperty() {
        return earningStatmentType;
    }
       
}
