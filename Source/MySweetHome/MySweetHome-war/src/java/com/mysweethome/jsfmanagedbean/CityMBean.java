/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.City;
import com.mysweethome.helper.messages;
import com.mysweethome.session.CityFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cp201008e8508
 */
@ManagedBean(name = "CityMBean")
@SessionScoped
public class CityMBean {

    @EJB
    private CityFacade cityFacade;
    private City city;
    private City city2;
    private City city3;

    public City getCity3() {
        return city3;
    }

    public void setCity3(City city3) {
        this.city3 = city3;
    }
    String name;
    String cityID;
    List<City> citylist;
    List<City> filteredCity;
    String newID;
    String newCityName;

    public String getNewCityName() {
        return newCityName;
    }

    public void setNewCityName(String newCityName) {
        this.newCityName = newCityName;
    }

    public String getNewID() {
        int id = getCityFacade().getLastRecordID();
        id += 1;
        newID = String.valueOf(id);
        return newID;
    }

    public void setNewID(String newID) {
        this.newID = newID;
    }

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

    /**
     * Creates a new instance of CityMBean
     */
    public CityMBean() {
        city = new City();
        city2 = new City();
        cityFacade = new CityFacade();
        name = city.getCityName();
        citylist = new ArrayList<City>();
        filteredCity = new ArrayList<City>();
    }
//    public void init(){
//        city.getCityID();
//        city.getCityName();
//    }

    public void createCity() {
        if (city2.getCityID() != null) {
            City temp = new City();
            temp = cityFacade.getCityByID(city2.getCityID());
            if (temp != null) {
                messages.taoTB(FacesMessage.SEVERITY_WARN, "Duplicate cityID!", "This cityID had already");
            } else {
                City citytemp = new City();
                citytemp.setCityID(city2.getCityID());
                citytemp.setCityName(city2.getCityName());
                getCityFacade().create(citytemp);
                messages.taoTB(FacesMessage.SEVERITY_INFO, "Create city success!", "Create city success!");
            }
        }
        this.city2 = new City();
    }

    public void editCity(City city) {
        getCityFacade().edit(city);
        messages.taoTB(FacesMessage.SEVERITY_INFO, "Edit success", "Edit success");
        this.city = new City();
    }

    public void removeCity(String cityID) {
        if (cityID != null) {
            City temp = new City();
            temp = cityFacade.getCityByID(city.getCityID());
            getCityFacade().remove(temp);
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Delete success", "Delete success");
        }
        this.city = new City();
    }

    public List<City> getAllCity() {
        return getCityFacade().findAll();
    }

    public String getCityNameFromID() {
        String str = city.getCityID();
        city2 = cityFacade.find(str);
        return city2.getCityName();
    }
}
