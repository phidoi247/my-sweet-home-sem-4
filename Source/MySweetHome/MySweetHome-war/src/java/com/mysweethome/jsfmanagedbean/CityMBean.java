/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.City;
import com.mysweethome.session.CityFacade;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    private City city;

    /** Creates a new instance of CityMBean */
    public CityMBean() {
        city=new City();
        cityFacade=new CityFacade();
    }
    
    public void  createCity(){
        city.getCityID();
        city.getCityName();
        city.getDistrictList();
        
        cityFacade.create(city);
    }
    public void editCity(){
        
        String str=city.getCityID();
        City ct=cityFacade.getCityID(str);
        ct.setCityName(city.getCityName());
        ct.setDistrictList(city.getDistrictList());
        
        cityFacade.edit(ct);
    }
    
    public void removeCity(){
        String str=city.getCityID();
        city.setCityID(str);
        cityFacade.remove(city);
    }


}
