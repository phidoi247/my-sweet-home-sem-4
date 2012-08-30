/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.*;
import com.mysweethome.helper.operationSession;
import com.mysweethome.session.ContactDetailsFacade;
import com.mysweethome.session.EstateFacade;
import com.mysweethome.session.ImageCategoryFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@ManagedBean(name = "EstateMBean")
@SessionScoped
public class EstateMBean {

    @EJB
    private EstateFacade estateFacade;
    private ContactDetailsFacade contactFacade;

    public ContactDetailsFacade getContactFacade() {
        return contactFacade;
    }

    public void setContactFacade(ContactDetailsFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    public ImageCategoryFacade getImageFacade() {
        return imageFacade;
    }

    public void setImageFacade(ImageCategoryFacade imageFacade) {
        this.imageFacade = imageFacade;
    }
    private ImageCategoryFacade imageFacade;
    private Estate estate;
    private int firstArea = -1;
    private int lastArea = -1;
    private int firstValue = -1;
    private int lastValue = -1;
    List<Estate> estateList;
    List<Subscribe> subscribeList;
    String title;
    Date startDay;
    Date endDay;
    String value;
    String content;
    String images;
    List<TypeOfEstate> typeOfEstateList;
    List<Category> categoryList;
    List<City> cityList;
    List<District> districtList;
    String area;
    List<Currency> currencyList;
    String address;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getSubscribeID() {
        return subscribeID;
    }

    public void setSubscribeID(String subscribeID) {
        this.subscribeID = subscribeID;
    }

    public String getSumvalue() {
        return sumvalue;
    }

    public void setSumvalue(String sumvalue) {
        this.sumvalue = sumvalue;
    }

    public String getTypeOfEstateID() {
        return typeOfEstateID;
    }

    public void setTypeOfEstateID(String typeOfEstateID) {
        this.typeOfEstateID = typeOfEstateID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    String subscribeID;
    String currencyID;
    String typeOfEstateID;
    String categoryID;
    String username;
    String sumvalue;
    String districtID;

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDriverWay() {
        return driverWay;
    }

    public void setDriverWay(String driverWay) {
        this.driverWay = driverWay;
    }

    public String getNoFloor() {
        return noFloor;
    }

    public void setNoFloor(String noFloor) {
        this.noFloor = noFloor;
    }

    public String getNoRoom() {
        return noRoom;
    }

    public void setNoRoom(String noRoom) {
        this.noRoom = noRoom;
    }

    public String getNoToilet() {
        return noToilet;
    }

    public void setNoToilet(String noToilet) {
        this.noToilet = noToilet;
    }
    String driverWay;
    String direction;
    String noToilet;
    String noFloor;
    String noRoom;
    String contactName;
    String contactAddress;
    String contactTel;
    String contactEmail;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Currency> getCurrencyList() {
        currencyList = estateFacade.getCurrencyList();
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<District> getDistrictList() {
        districtList = estateFacade.getDistrictList();
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<City> getCityList() {
        cityList = estateFacade.getCityList();
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<Category> getCategoryList() {
        categoryList = estateFacade.getCategoryList();
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<TypeOfEstate> getTypeOfEstateList() {
        typeOfEstateList = estateFacade.getTypeOfEstateList();
        return typeOfEstateList;
    }

    public void setTypeOfEstateList(List<TypeOfEstate> typeOfEstateList) {
        this.typeOfEstateList = typeOfEstateList;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public List<Subscribe> getSubscribeList() {
        subscribeList = estateFacade.getSubscribeList();
        return subscribeList;
    }

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
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

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    /**
     * Create new estate
     *
     * @author Ngo Quang Huy
     * @since 29-08-2012
     */
    public void createEstate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String id = estateFacade.getLastRecordID();
        estate.setEstateID(id);
        estate.setEstateTitle(title);
        estate.setEstateStartDay(formatter.format(startDay));
        estate.setEstateEndDay(formatter.format(endDay));
        estate.setEstateAddress(address);
        estate.setEstateContent(content);
        estate.setEstateArea(area);
        estate.setEstateValue(value);
        estate.setEstateDriveway(driverWay);
        estate.setEstateDirection(direction);
        estate.setEstateNumberOfRooms(noRoom);
        estate.setEstateNumberOfFloors(noFloor);
        estate.setEstateNumberOfToilets(noToilet);
        estate.setEstateNumOfView("0");
        estate.setIsEnabled("false");
        estate.setIsPaid("false");
        estate.setCurrencyID(estateFacade.getCurrencyByID(currencyID));
        estate.setSubscribeID(estateFacade.getSubscribeByID(subscribeID));
        estate.setTypeOfEstateID(estateFacade.getTypeOfEstateByID(typeOfEstateID));
        estate.setCategoryID(estateFacade.getCategoryByID(categoryID));
        estate.setUserName(estateFacade.getMember((String) operationSession.getSession("username")));
        estate.setDistrictID(estateFacade.getDistrictByID(districtID));

        //create new contactDetail object
        ContactDetails contactObj = new ContactDetails();
        contactObj.setContactDetailsID(id);
        contactObj.setContactName(contactName);
        contactObj.setContactAddress(contactAddress);
        contactObj.setContactEmail(contactEmail);
        contactObj.setContactTelephone(contactTel);
        contactFacade.create(contactObj);

        //create image category
        ImageCategory imageObj = new ImageCategory();
        imageObj.setImageCategoryID(id);
        if (images != null && !images.isEmpty()) {
            imageObj.setImage1(images);
        }
        imageFacade.create(imageObj);

        estate.setContactDetailsID(contactObj);
        estate.setImageCategoryID(imageObj);

        //create
        estateFacade.create(estate);
    }

    public void editEstate(Estate estate) {
        estateFacade.edit(estate);
        FacesContext face = FacesContext.getCurrentInstance();
        face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Profile Success.", "Update Profile Success."));

    }

    public void deleteEstate() {
        estateFacade.remove(estate);
    }

    public String searchAdvance() {
//        String cityName=city.getCityName();
//        String districtName=district.getDistrictName();
//        String categoryName=category.getCategoryName();
//        String typeOfEstateName=typeOfEstate.getTypeOfEstateName();
        String estateNumberOfRooms = estate.getEstateNumberOfRooms();
        String estateNumberOfToilets = estate.getEstateNumberOfToilets();
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
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dateNow = format.format(date.getTime());
        estateList = new ArrayList<Estate>();
        //setEstateList(estateFacade.searchAdvance(cityName, districtName, categoryName, typeOfEstateName, estateNumberOfRooms, estateNumberOfToilets, firstArea, lastArea, firstValue, lastValue, dateNow));
        setEstateList(estateFacade.searchAdvance("", "", "", "", estateNumberOfRooms, estateNumberOfToilets, firstArea, lastArea, firstValue, lastValue, dateNow));
        return "/ViewEstate";
    }

    public String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date(sdf.format(cal.getTime()));
        return today.toString();
    }

    public String validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        //chuyen sang kieu datetime
        Date date2 = new Date(date);
        String result = sdf.format(date2);
        Date date3 = new Date(result);
        return date3.toString();
    }
}
