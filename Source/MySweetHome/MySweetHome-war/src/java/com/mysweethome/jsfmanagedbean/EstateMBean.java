/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.*;
import com.mysweethome.session.EstateFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public EstateFacade getEstateFacade() {
        return estateFacade;
    }

    public void setEstateFacade(EstateFacade estateFacade) {
        this.estateFacade = estateFacade;
    }

    public List<Estate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<Estate> estateList) {
        this.estateList = estateList;
    }

    public int getFirstArea() {
        return firstArea;
    }

    public void setFirstArea(int firstArea) {
        this.firstArea = firstArea;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getLastArea() {
        return lastArea;
    }

    public void setLastArea(int lastArea) {
        this.lastArea = lastArea;
    }

    public int getLastValue() {
        return lastValue;
    }

    public void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }

    public TypeOfEstate getTypeOfEstate() {
        return typeOfEstate;
    }

    public void setTypeOfEstate(TypeOfEstate typeOfEstate) {
        this.typeOfEstate = typeOfEstate;
    }
    private Category category;
    private TypeOfEstate typeOfEstate;
    private City city;
    private Subscribe subscribe;
    private District district;
    private int firstArea=-1;
    private int lastArea=-1;
    private int firstValue=-1;
    private int lastValue=-1;
    
    List<Estate> estateList;

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
        category = new Category();
        category_name=category.getCategoryName();  
    }
    
    
    public void createEstate() {
        //get all properties 
        String str=estate.getEstateID();   
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
    
    public String searchAdvance(){
//        String cityName=city.getCityName();
//        String districtName=district.getDistrictName();
//        String categoryName=category.getCategoryName();
//        String typeOfEstateName=typeOfEstate.getTypeOfEstateName();
        String estateNumberOfRooms=estate.getEstateNumberOfRooms();
        String estateNumberOfToilets=estate.getEstateNumberOfToilets();
//        int firstArea=this.firstArea;
//        int lastArea=this.lastArea;
//        int firstValue=this.firstValue;
//        int lastValue=this.lastValue;
//        if(lastArea==-1){
//            lastArea=2147483647;
//        }
//        if(lastValue==-1){
//            lastValue=2147483647;
//        }
        //get date time of system
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        String dateNow=format.format(date.getTime());
        estateList=new ArrayList<Estate> ();
        //setEstateList(estateFacade.searchAdvance(cityName, districtName, categoryName, typeOfEstateName, estateNumberOfRooms, estateNumberOfToilets, firstArea, lastArea, firstValue, lastValue, dateNow));
        setEstateList(estateFacade.searchAdvance("", "", "", "", estateNumberOfRooms, estateNumberOfToilets, firstArea, lastArea, firstValue, lastValue, dateNow));
        return "/ViewEstate";
    }
}
