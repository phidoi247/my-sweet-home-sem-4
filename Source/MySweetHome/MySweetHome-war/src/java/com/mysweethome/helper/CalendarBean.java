/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.helper;

/**
 *
 * @author Garena
 */
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="calendarBean")
@SessionScoped
public class CalendarBean {

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Creates a new instance of CalendarBean
     */
    java.util.Date data;
    public void saveData() {
        System.out.println(data);
    }
}
