/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.District;
import com.mysweethome.session.DistrictFacade;
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
    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    /**
     * Creates a new instance of DistrictMBean
     */
    public DistrictMBean() {
        district = new District();
        districtFacade = new DistrictFacade();
    }
    
    public void createDistrict(){
        district.getCityID();
        district.getDistrictID();
        district.getDistrictName();
        district.getEstateList();
        
        districtFacade.create(district);
    }
    
    public void editDistrict(){
        String str=district.getDistrictID();
        District ds=districtFacade.getDistrictID(str);
        ds.setCityID(district.getCityID());
        ds.setDistrictName(district.getDistrictName());
        ds.setEstateList(district.getEstateList());
        
        districtFacade.edit(ds);
        
        
    }
      public void removeDistrict(){
       String str=district.getDistrictID();
       district.setDistrictID(str);
       
       districtFacade.remove(district);
        
        
    }
}
