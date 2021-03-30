/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iPAYROLL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abdelkader
 */
public class iPAYROLLUsers {
    private final StringProperty ID;
    private final StringProperty name;
    private final UserAccounts account;

    public iPAYROLLUsers() {
        this.ID = new SimpleStringProperty();
        this.name = new SimpleStringProperty(); 
        account = new UserAccounts(null, null);
    }
    
    public void setID(String id) {
      ID.set(id);
    }
    public StringProperty IDProperty() {
        return ID;
    }
    public String getID() {
        return ID.get();
    }
        
    public void setName(String id) {
      name.set(id);
    }
    public StringProperty NameProperty() {
        return name;
    }
    public String getName() {
        return name.get();
    }
    
}
