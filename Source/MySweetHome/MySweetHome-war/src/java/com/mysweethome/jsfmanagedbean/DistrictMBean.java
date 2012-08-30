/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.City;
import com.mysweethome.entity.District;
import com.mysweethome.session.CityFacade;
import com.mysweethome.session.DistrictFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    private District district, districtedit;
    private List<City> cityList= new ArrayList<City>();

    public List<City> getCityList() {
        cityList= cityfacade.selectAllCity();
        return cityList;
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
    private CityFacade cityfacade;
    private String districtName,cityID, cityIDtemp;

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
    
    List<District> districtList;

    public List<District> getDistrictList() {
        districtList=districtFacade.findAll();
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
    }
    
    public void createDistrict(){
        District tmp= new District();
        int id= districtFacade.getLastRecordID();
        tmp.setDistrictID(String.valueOf(id));
        tmp.setDistrictName(district.getDistrictName());
        tmp.setCityID(cityfacade.find(cityID));
                        
        districtFacade.create(district);
    }
    
    public void editDistrict(){
        String str=districtedit.getDistrictID();
        District ds=districtFacade.getDistrictID(str);
        ds.setCityID(districtedit.getCityID());
        ds.setDistrictName(districtedit.getDistrictName());
//        ds.setEstateList(districtedit.getEstateList());
        
        districtFacade.edit(ds);
        
        
    }
      public void removeDistrict(String districtID){
       District districttemp= this.getDistrictFacade().find(districtID);
       
       districtFacade.remove(districttemp);                      
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
