/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.City;
import com.mysweethome.entity.District;
import com.mysweethome.helper.messages;
import com.mysweethome.session.CityFacade;
import com.mysweethome.session.DistrictFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Garena
 */
@ManagedBean (name ="DistrictMBean")
@SessionScoped
public class DistrictMBean {
    @EJB
    private DistrictFacade districtFacade;
    private District district, districtedit, districtNew;

    public District getDistrictNew() {
        return districtNew;
    }

    public void setDistrictNew(District districtNew) {
        this.districtNew = districtNew;
    }
    private List<City> cityList;
    List<District> districtList;
    List<District> filteredDistrict;
    private CityFacade cityfacade;
    private String districtID, districtName, cityID, cityIDtemp;

    public List<City> getCityList() {
        cityList= getDistrictFacade().getListCity();
        return cityList;
    }

    public String getDistrictID() {
        return district.getDistrictID();
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }     

    public District getDistrictedit() {
        return districtedit;
    }

    public void setDistrictedit(District districtedit) {
        this.districtedit = districtedit;
    }
    

    public String getCityIDtemp() {
        return cityIDtemp;
    }

    public void setCityIDtemp(String cityIDtemp) {
        this.cityIDtemp = cityIDtemp;
    }

   

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public List<District> getFilteredDistrict() {
        return filteredDistrict = districtList;
    }

    public void setFilteredDistrict(List<District> filteredDistrict) {
        this.filteredDistrict = filteredDistrict;
    }
    
    

    public List<District> getDistrictList() {
        districtList = districtFacade.findAll();
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }


    public String getDistrictName() {
        return district.getDistrictName();
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public CityFacade getCityfacade() {
        return cityfacade;
    }

    public void setCityfacade(CityFacade cityfacade) {
        this.cityfacade = cityfacade;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
       public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    public void setDistrictFacade(DistrictFacade districtFacade) {
        this.districtFacade = districtFacade;
    }
    /**
     * Creates a new instance of DistrictMBean
     */
    public DistrictMBean() {
        district = new District();
        districtFacade = new DistrictFacade();
        cityfacade = new CityFacade();
        districtedit = new District();
        districtList = new ArrayList<District>();
        filteredDistrict = new ArrayList<District>();
    }
    
    public void createDistrict(){
        if (district.getDistrictID() != null) {
            District temp = new District();
            temp = districtFacade.getDistrictByID(district.getDistrictID());
            if (temp != null) {
                messages.taoTB(FacesMessage.SEVERITY_WARN, "Duplicate district ID!", "This district ID had already");
            } else {
                District districtTemp = new District();
                districtTemp.setDistrictID(district.getDistrictID());
                districtTemp.setDistrictName(district.getDistrictName());
                City cityTemp=new City();
                cityTemp=getDistrictFacade().getCityFromID(cityID);
                districtTemp.setCityID(cityTemp);
                getDistrictFacade().create(districtTemp);
                messages.taoTB(FacesMessage.SEVERITY_INFO, "Create district success!", "Create district success!");
            }
        }
        this.district = new District();
    }
    
    public void editDistrict(District district){
        getDistrictFacade().edit(district);
        messages.taoTB(FacesMessage.SEVERITY_INFO, "Edit success", "Edit success");
        this.districtedit = new District();
    }
      public void removeDistrict(String districtID){
       if (districtID != null) {
            District temp = new District();
            temp = getDistrictFacade().getDistrictByID(districtID);
            getDistrictFacade().remove(temp);
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Delete success", "Delete success");
        }
        this.districtedit = new District();
    }
      
      public List<District> findAllDistrict(){
          return districtFacade.findAll();
      } 

      public String selectCityNameByID(String cityID){
          String id = null;
          if(cityID!=null){
              id=cityID.substring(36, cityID.length()-2);
          }
          City cityobj = districtFacade.getCityFromID(id);
          return cityobj.getCityName();
      }
  
}
