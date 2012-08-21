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
    private City city;

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
        cityFacade=new CityFacade();
    }
    
    public String createCity(){
        City citytemp= new City();
        
        String result="False";
        try{
        int id= cityFacade.getLastRecordID();
        citytemp.setCityID(String.valueOf(id+1));
        citytemp.setCityName(getCity().getCityName());        
        
        cityFacade.create(citytemp);
        result="True";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public void editCity(){
        
        String str=getCity().getCityID();
        City ct=getCityFacade().getCityID(str);
        ct.setCityName(getCity().getCityName());
        ct.setDistrictList(getCity().getDistrictList());
        
        getCityFacade().edit(ct);
    }
    
    public void removeCity(){
        String str=getCity().getCityID();
        getCity().setCityID(str);
        getCityFacade().remove(getCity());
    }


}
