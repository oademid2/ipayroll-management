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
public class Administrators extends iPAYROLLUsers{
    private final ObjectProperty<Date> dateHired;
    private final ObjectProperty<Date> dateFinished;

    public Administrators() {
        this.dateHired = new SimpleObjectProperty<>();
        this.dateFinished = new SimpleObjectProperty<>();
    }

    public void setDateHired(Date _date) {
        dateHired.set(_date);
    }
    public ObjectProperty<Date> DateHiredProperty() {
        return dateHired;
    }
    public Date getDateHired() {
        return dateHired.get();
    }
       
    public void setDateFinished(Date _date) {
        dateFinished.set(_date);
    }
    public ObjectProperty<Date> DateFinishedProperty() {
        return dateFinished;
    }
    public Date getDateFinished() {
        return dateFinished.get();
    }
}
