/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.City;
import com.mysweethome.session.CityFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cp201008e8508
 */
@ManagedBean (name = "CityMBean")
@SessionScoped
public class CityMBean {
    @EJB
    private CityFacade cityFacade;
    private City city;
    private City city2;
    String name;
    String cityID;
    List<City> citylist;
    List<City> filteredCity;

    public String getCityID() {
        return city.getCityID();
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return city.getCityName();
    }

    public void setName(String name) {
        this.name = name;
    }
    public City getCity2() {
        return city2;
    }

    public void setCity2(City city2) {
        this.city2 = city2;
    }

    

    public List<City> getCitylist() {
        return citylist = cityFacade.findAll();
    }

    public List<City> getFilteredCity() {
        return filteredCity = citylist;
    }

    public void setFilteredCity(List<City> filteredCity) {
        this.filteredCity = filteredCity;
    }

    public void setCitylist(List<City> citylist) {
        this.setCitylist(citylist);
    }
    
    public CityFacade getCityFacade() {
        return cityFacade;
    }

    public void setCityFacade(CityFacade cityFacade) {
        this.cityFacade = cityFacade;
    }
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    

    /** Creates a new instance of CityMBean */
    public CityMBean() {
        city=new City();
        city2 = new City();
        cityFacade=new CityFacade();
        name=city.getCityName();
        citylist = new ArrayList<City>();
        filteredCity = new ArrayList<City>();
    }
//    public void init(){
//        city.getCityID();
//        city.getCityName();
//    }
    public String createCity(){
        City citytemp= new City();
        
        String result="False";
        try{
        int id= getCityFacade().getLastRecordID();
        citytemp.setCityID(String.valueOf(id+1));
        citytemp.setCityName(city2.getCityName());        
        
        getCityFacade().create(citytemp);
        result="True";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;       
    }
    public void editCity(){
        
        String str=getCity().getCityID();
        City ct=getCityFacade().getCityID(str);
        ct.setCityName(name);
        
        
        getCityFacade().edit(ct);
    }
      public void editCity(City city1){                  
        
        getCityFacade().edit(city1);
    }
    public void removeCity(){
        String str=getCity().getCityID();
        getCity().setCityID(str);
        getCityFacade().remove(getCity());
    }
     public void removeCity(String cityID){
        City citytemp=this.getCityFacade().find(cityID);
        getCityFacade().remove(citytemp);
    }
    public List<City> getAllCity(){
        return getCityFacade().findAll();
    }

    public String getCityNameFromID(){
        String str=city.getCityID();
        city2= cityFacade.find(str); 
        return city2.getCityName();
    }

    
    

}
