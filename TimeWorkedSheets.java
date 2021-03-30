/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


/**
 *
 * @author Abdelkader
 */
public class TimeWorkedSheets {
    private final ObjectProperty<Date> dayTimeStamp;
    private final ObjectProperty<Date> timeIn;
    private final ObjectProperty<Date> timeOut;


    public TimeWorkedSheets() {
        this.dayTimeStamp = new SimpleObjectProperty<>();
        this.timeIn = new SimpleObjectProperty<>();
        this.timeOut = new SimpleObjectProperty<>();
    }
   
    public void setDayTimeStamp(Date _date) {
        dayTimeStamp.set(_date);
    }
    public ObjectProperty<Date> DayTimeStampProperty() {
        return dayTimeStamp;
    }
    public Date getDayTimeStamp() {
        return dayTimeStamp.get();
    }
       
    public void setTimeIn(Date _date) {
        timeIn.set(_date);
    }
    public ObjectProperty<Date> TimeInProperty() {
        return timeIn;
    }
    public Date getTimeIn() {
        return timeIn.get();
    }
           
    public void setTimeOut(Date _date) {
        timeOut.set(_date);
    }
    public ObjectProperty<Date> TimeOutProperty() {
        return timeOut;
    }
    public Date getTimeOut() {
        return timeOut.get();
    }
}
