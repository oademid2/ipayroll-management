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

/**
 *
 * @author Abdelkader
 */
public class AuditTrails {
    private final ObjectProperty<Date> timeStamp;
    private final StringProperty description;
    private final iPAYROLLUsers user;

    public AuditTrails() {
        this.timeStamp = new SimpleObjectProperty<>();
        this.description = new SimpleStringProperty(); 
        user = new iPAYROLLUsers();
    }
    
    public void setTimeStamp(Date _date) {
        timeStamp.set(_date);
    }
    public ObjectProperty<Date> TimeStampProperty() {
        return timeStamp;
    }
    public Date getTimeStamp() {
        return timeStamp.get();
    }
        
    public void setDescription(String id) {
      description.set(id);
    }
    public StringProperty DescriptionProperty() {
        return description;
    }
    public String getDescription() {
        return description.get();
    }
    
}
