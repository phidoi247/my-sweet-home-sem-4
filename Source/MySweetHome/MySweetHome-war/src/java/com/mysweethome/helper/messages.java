/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mysweethome.helper;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
/**
 *
 * @author Ngo Quang Huy
 */
public class messages {
 public static void taoTB(Severity s,String tieuDe,String noiDung){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(s,tieuDe,noiDung));
    }
}
