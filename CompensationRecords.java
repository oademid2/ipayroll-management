/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abdelkader
 */
public class CompensationRecords {
    private final ObjectProperty<Date> payDate;
    private final ObjectProperty<Date> payBegin;
    private final ObjectProperty<Date> payEnd;
    private final DoubleProperty netPay;
    private final StringProperty payCheckNo;
    private final StringProperty payAccountNo;

    public CompensationRecords() {
        this.payDate = new SimpleObjectProperty<>();
        this.payBegin = new SimpleObjectProperty<>();
        this.payEnd = new SimpleObjectProperty<>();
        this.netPay = new SimpleDoubleProperty();
        this.payCheckNo = new SimpleStringProperty();
        this.payAccountNo = new SimpleStringProperty();
    }
   
    public void setPayDate(Date _date) {
        payDate.set(_date);
    }
    public ObjectProperty<Date> PayDateProperty() {
        return payDate;
    }
    public Date getPayDate() {
        return payDate.get();
    }
       
    public void setPayBegin(Date _date) {
        payBegin.set(_date);
    }
    public ObjectProperty<Date> PayBeginProperty() {
        return payBegin;
    }
    public Date getPayBegin() {
        return payBegin.get();
    }
           
    public void setPayEnd(Date _date) {
        payEnd.set(_date);
    }
    public ObjectProperty<Date> PayEndProperty() {
        return payEnd;
    }
    public Date getPayEnd() {
        return payEnd.get();
    }
    
    public void setNetPay(double net) {
        netPay.set(net);
    }
    public DoubleProperty NetPayProperty() {
        return netPay;
    }
    public double getNetPay() {
        return netPay.get();
    }
          
    public void setPayCheckNo(String num) {
        payCheckNo.set(num);
    }
    public StringProperty PayCheckNoProperty() {
        return payCheckNo;
    }
    public String getPayCheckNo() {
        return payCheckNo.get();
    }
              
    public void setPayAccountNo(String num) {
        payAccountNo.set(num);
    }
    public StringProperty PayAccountNoProperty() {
        return payAccountNo;
    }
    public String getPayAccountNo() {
        return payAccountNo.get();
    }
}
