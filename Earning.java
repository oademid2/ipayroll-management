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
public class Earning {
    private final StringProperty code;
    private final StringProperty type;

    public Earning(String _code, String _type) {
        this.code = new SimpleStringProperty(_code);
        this.type = new SimpleStringProperty(_type);
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
   
    public void setType(String _type) {
        type.set(_type);
    }
    public StringProperty TypeProperty() {
        return type;
    }
    public String getType() {
        return type.get();
    }
      
}
