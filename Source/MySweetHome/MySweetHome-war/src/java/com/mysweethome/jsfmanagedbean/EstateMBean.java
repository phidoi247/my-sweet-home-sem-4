/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Estate;
import com.mysweethome.session.EstateFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author QuangVinh
 */
@ManagedBean (name = "EstateMBean")
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
    
    
    
}
