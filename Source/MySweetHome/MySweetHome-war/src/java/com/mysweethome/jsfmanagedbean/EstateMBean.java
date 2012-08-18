/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Estate;
import com.mysweethome.entity.Member1;
import com.mysweethome.session.EstateFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author QuangVinh
 */

@ManagedBean (name="EstateMBean")
@SessionScoped
public class EstateMBean {
    @EJB
    private EstateFacade estateFacade;
    private Estate estate;
   

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
    
    /**
     * Creates a new instance of EstateMBean
     */  
    public EstateMBean() {
        estate = new Estate();
        estateFacade = new EstateFacade();
    }
    
    
    public void createEstate() {
        //get all properties 
        estate.getEstateID();
        estate.getEstateTitle();
        estate.getEstateValue();
        estate.getEstateAddress();
        estate.getEstateArea();
        estate.getEstateContent();
        estate.getEstateDirection();
        estate.getEstateDriveway();     
        estate.getEstateNumOfView();
        estate.getEstateNumberOfFloors();
        estate.getEstateNumberOfRooms();
        estate.getEstateNumberOfToilets();
        estate.getEstateStartDay();
        estate.getEstateEndDay();
        estate.getIsPaid();
        estate.getSumValue();
        estate.getIsEnabled();
        
        //create estate
        estateFacade.create(estate);
    }
    
//    public void editEstate(){    
//        
////        String str=estate.getEstateID();        
////        Estate est = estateFacade.getEstateID(str);
////        est.setEstateArea(estate.getEstateArea());
////        estate.setEstateTitle(estate.getEstateTitle());
////        estate.getEstateValue();
////        estate.getEstateAddress();
////        estate.getEstateArea();
////        estate.getEstateContent();
////        estate.getEstateDirection();
////        estate.getEstateDriveway();     
////        estate.getEstateNumOfView();
////        estate.getEstateNumberOfFloors();
////        estate.getEstateNumberOfRooms();
////        estate.getEstateNumberOfToilets();
////        estate.getEstateStartDay();
////        estate.getEstateEndDay();
////        estate.getIsPaid();
////        estate.getSumValue();
////        estate.getIsEnabled();
////        estate.getTypeOfEstateID();
////        estateFacade.edit(est);   
//        
//    }
    
   
    
    public void editEstate() {
        estateFacade.edit(estate);
        //setUserSession(admin);
        FacesContext face = FacesContext.getCurrentInstance();
        face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Profile Success.", "Update Profile Success."));

    }

    
    public void deleteEstate(){
        String str = estate.getEstateID();
        estate.setEstateID(str);
        estateFacade.remove(estate);
    }
}
