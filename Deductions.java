/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Abdelkader
 */
public class Deductions {
    private final StringProperty code;
    private final ObjectProperty<Date> startDate;
    private final ObjectProperty<Date> stopDate;
    private final DoubleProperty definedPercentage;
    private final DoubleProperty fixedAmount;

    public Deductions(String _code, Date _startDate, Date _stopDate, double _percentage, double _fixedAmount) {
        this.code = new SimpleStringProperty(_code);
        this.startDate = new SimpleObjectProperty<>(this, "startDate", _startDate);
        this.stopDate = new SimpleObjectProperty<>(this, "stopDate", _stopDate);
        this.definedPercentage = new SimpleDoubleProperty(_percentage);
        this.fixedAmount = new SimpleDoubleProperty(_fixedAmount);
    }

    public void setCode(String _code) {
        code.set(_code);
    }
    public StringProperty CodeProperty() {
        return code;
    }
    public String getCode() {
        return code.get();
    }
   
    public void setStartDate(Date _date) {
        startDate.set(_date);
    }
    public ObjectProperty<Date> StartDateProperty() {
        return startDate;
    }
    public Date getStartDate() {
        return startDate.get();
    }
       
    public void setStoptDate(Date _date) {
        stopDate.set(_date);
    }
    public ObjectProperty<Date> StopDateProperty() {
        return stopDate;
    }
    public Date getStopDate() {
        return stopDate.get();
    }
    
    public void setDefinedPercentage(double per) {
        definedPercentage.set(per);
    }
    public DoubleProperty DefinedPercentageProperty() {
        return definedPercentage;
    }
    public double getDefinedPercentage() {
        return definedPercentage.get();
    }
        
    public void setFixedAmount(double amount) {
        fixedAmount.set(amount);
    }
    public DoubleProperty FixedAmountProperty() {
        return fixedAmount;
    }
    public double getFixedAmount() {
        return fixedAmount.get();
    }
}
