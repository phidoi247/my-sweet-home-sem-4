/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.*;
import com.mysweethome.session.CategoryFacade;
import com.mysweethome.session.ContactDetailsFacade;
import com.mysweethome.session.CurrencyFacade;
import com.mysweethome.session.DistrictFacade;
import com.mysweethome.session.EstateFacade;
import com.mysweethome.session.ImageCategoryFacade;
import com.mysweethome.session.SubscribeFacade;
import com.mysweethome.session.TypeOfEstateFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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
    private Category category;
    private CategoryFacade categoryFacade;
    private TypeOfEstate typeOfEstate;
    private TypeOfEstateFacade typeofestateFacade;
    private City city;
    private Subscribe subscribe;
    private SubscribeFacade subscribeFacade;
    private District district;
    private DistrictFacade districtFacade;
    private Currency currency;
    private CurrencyFacade currencyFacade;
    private ImageCategory image;
    private ImageCategoryFacade imageFacade;
    private int firstArea=-1;
    private int lastArea=-1;
    private int firstValue=-1;
    private int lastValue=-1;   
    List<Estate> estateList;

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CurrencyFacade getCurrencyFacade() {
        return currencyFacade;
    }

    public void setCurrencyFacade(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    public ImageCategoryFacade getImageFacade() {
        return imageFacade;
    }

    public void setImageFacade(ImageCategoryFacade imageFacade) {
        this.imageFacade = imageFacade;
    }

    public SubscribeFacade getSubscribeFacade() {
        return subscribeFacade;
    }

    public void setSubscribeFacade(SubscribeFacade subscribeFacade) {
        this.subscribeFacade = subscribeFacade;
    }

    public TypeOfEstateFacade getTypeofestateFacade() {
        return typeofestateFacade;
    }

    public void setTypeofestateFacade(TypeOfEstateFacade typeofestateFacade) {
        this.typeofestateFacade = typeofestateFacade;
    }
    
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
        
    public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    public void setDistrictFacade(DistrictFacade districtFacade) {
        this.districtFacade = districtFacade;
    }
    private ContactDetails contactdetail;
    private ContactDetailsFacade contactFacade;

    public ContactDetailsFacade getContactFacade() {
        return contactFacade;
    }

    public void setContactFacade(ContactDetailsFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    public ContactDetails getContactdetail() {
        return contactdetail;
    }

    public void setContactdetail(ContactDetails contactdetail) {
        this.contactdetail = contactdetail;
    }

    public ImageCategory getImage() {
        return image;
    }

    public void setImage(ImageCategory image) {
        this.image = image;
    }

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Subscribe subscribe) {
        this.subscribe = subscribe;
    }   

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
        //category_name=category.getCategoryName();  
    }
    
    
    public String createEstate() {
        
        Estate estatetemp= new Estate();
        
        String result="False";
        try{
        int id= estateFacade.getLastRecordID();
        estatetemp.setEstateID(String.valueOf(id+1));
        
        estatetemp.setEstateTitle(estate.getEstateTitle());        
        estatetemp.setEstateStartDay(estate.getEstateStartDay());
        estatetemp.setEstateEndDay(estate.getEstateEndDay());
        estatetemp.setEstateAddress(estate.getEstateAddress());
        estatetemp.setEstateContent(estate.getEstateContent());
        estatetemp.setEstateArea(estate.getEstateArea());
        estatetemp.setEstateValue(estate.getEstateValue());
        estatetemp.setEstateDriveway(estate.getEstateDriveway());                
        estatetemp.setEstateDirection(estate.getEstateDirection());
        estatetemp.setEstateNumberOfRooms(estate.getEstateNumberOfRooms());
        estatetemp.setEstateNumberOfFloors(estate.getEstateNumberOfFloors());
        estatetemp.setEstateNumberOfToilets(estate.getEstateNumberOfToilets());
        estatetemp.setEstateNumOfView(estate.getEstateNumOfView());
        
        estatetemp.setIsEnabled("false");
        estatetemp.setIsPaid("false");
        
        estatetemp.setCurrencyID(currencyFacade.find(currency.getCurrencyID()));
        estatetemp.setSubscribeID(subscribeFacade.find(subscribe.getSubscribeID()));
        estatetemp.setTypeOfEstateID(typeofestateFacade.find(typeOfEstate.getTypeOfEstateID()));
        estatetemp.setCategoryID(categoryFacade.find(category.getCategoryID()));
        
        // get username from session
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String username=(String) session.getAttribute("user");        
        estatetemp.setUserName(estateFacade.find(username).getUserName());        
        
        estatetemp.setDistrictID(districtFacade.find(district.getDistrictID()));
        estatetemp.setContactDetailsID(contactFacade.find(contactdetail.getContactDetailsID()));
        estatetemp.setImageCategoryID(imageFacade.find(image.getImageCategoryID()));
        
        // set sumvalue
         int feeperDay= Integer.valueOf(subscribeFacade.find(subscribe.getSubscribeID()).getFeePerDay());
         int songaydang = estate.getEstateEndDay().compareTo(estate.getEstateStartDay());
         int rate= Integer.valueOf(currencyFacade.find(currency.getCurrencyID()).getVNDRate());
         int sumvalue = feeperDay*rate*songaydang;
         
        estatetemp.setSumValue(String.valueOf(sumvalue));
        
        estateFacade.create(estatetemp);
        result="True";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
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
