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
public class UserAccounts {
    private final StringProperty userName;
    private final StringProperty encryptrdPassword;

    public UserAccounts(String uName, String password) {
        this.userName = new SimpleStringProperty(uName);
        this.encryptrdPassword = new SimpleStringProperty(password);
    }

    public void setUserName(String uName) {
        userName.set(uName);
    }
    public StringProperty userNameProperty() {
        return userName;
    }
    public String getUserName() {
        return userName.get();
    }
   
    public void setEncryptrdPassword(String password) {
        encryptrdPassword.set(password);
    }
    public StringProperty encryptrdPasswordProperty() {
        return encryptrdPassword;
    }
    public String getEncryptrdPassword() {
        return encryptrdPassword.get();
    }
      
}
