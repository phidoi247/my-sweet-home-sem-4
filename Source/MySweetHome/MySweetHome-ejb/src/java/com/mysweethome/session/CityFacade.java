/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.City;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }
    
    @Override
    public void create(City city) {
        em.persist(city);
    }

    @Override
    public void edit(City city) {
        em.merge(city);
    }

    @Override
    public void remove(City city) {
        em.remove(em.merge(city));
    }
    
    public List<City> getCityList(){
        List<City> cityList=null;
        try{
            Query q = em.createNamedQuery("Estate.findAll");
            cityList = q.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    public City getCityByID(String cityID){
        City ct=null;
        try{
            Query query=em.createNamedQuery("City.findByCityID");
            query.setParameter("cityID", cityID);
            ct=(City) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ct;
    }
    public City getCityByName(String cityName){
        City ct=null;
        try{
            Query query=em.createNamedQuery("City.findByCityName");
            query.setParameter("cityName", cityName);
            ct=(City) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ct;
    }
    
    public int getLastRecordID(){
        Query q= em.createNamedQuery("City.findAll");
        List<City> citylist= q.getResultList();
                
        int i=citylist.size();
        i=i-1;
        
        int j=Integer.parseInt(citylist.get(i).getCityID());
        return j;
    }
    public List<City> selectAllCity(){
        Query q= em.createNamedQuery("City.findAll");
        return q.getResultList();
    }
    
}
