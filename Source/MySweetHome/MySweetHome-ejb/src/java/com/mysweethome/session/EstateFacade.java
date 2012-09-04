/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author QuangVinh
 */
@Stateless
public class EstateFacade extends AbstractFacade<Estate> {

    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstateFacade() {
        super(Estate.class);
    }

    @Override
    public void create(Estate estate) {
        em.persist(estate);
    }

    @Override
    public void edit(Estate estate) {
        em.merge(estate);
    }

    @Override
    public void remove(Estate estate) {
        em.remove(em.merge(estate));
    }

    public Estate getEstateID(String estateID) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateID");
            q.setParameter("estateID", estateID);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateTitle(String estateTitle) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateTitle");
            q.setParameter("estateTitle", estateTitle);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateStartDay(String estateStartDay) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateStartDay");
            q.setParameter("estateStartDay", estateStartDay);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateEndDay(String estateEndDay) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateEndDay");
            q.setParameter("estateEndDay", estateEndDay);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateAddress(String estateAddress) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateStartDay");
            q.setParameter("estateAddress", estateAddress);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateContent(String estateContent) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateContent");
            q.setParameter("estateContent", estateContent);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateArea(String estateArea) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateArea");
            q.setParameter("estateArea", estateArea);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateValue(String estateValue) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateValue");
            q.setParameter("estateValue", estateValue);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateDriveway(String estateDriveway) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateDriveway");
            q.setParameter("estateDriveway", estateDriveway);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateDirection(String estateDirection) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateDirection");
            q.setParameter("estateDirection", estateDirection);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateNumberOfRooms(String estateNumberOfRooms) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfRooms");
            q.setParameter("estateNumberOfRooms", estateNumberOfRooms);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateNumberOfFloors(String estateNumberOfFloors) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfFloors");
            q.setParameter("estateNumberOfFloors", estateNumberOfFloors);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateNumberOfToilets(String estateNumberOfToilets) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfToilets");
            q.setParameter("estateNumberOfToilets", estateNumberOfToilets);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getEstateNumOfView(String estateNumOfView) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByEstateNumOfView");
            q.setParameter("estateNumOfView", estateNumOfView);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getIsEnabled(String isEnabled) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByIsEnabled");
            q.setParameter("isEnabled", isEnabled);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getIsPaid(String isPaid) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findByIsPaid");
            q.setParameter("isPaid", isPaid);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public Estate getSumValue(String sumValue) {
        Estate estate = null;
        try {
            Query q = em.createNamedQuery("Estate.findBySumValue");
            q.setParameter("sumValue", sumValue);
            estate = (Estate) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public List<Estate> searchAdvance(String cityName, String districtName, String categoryName, String typeOfEstateName, String estateNumberOfRooms,
            String estateNumberOfToilets, int firstArea, int lastArea, int firstValue, int lastValue, String dateNow) {
        List<Estate> estateList = null;
        try {
            Query q = em.createNamedQuery("Estate.searchAdvance");
            q.setParameter("cityName", cityName);
            q.setParameter("districtName", districtName);
            q.setParameter("categoryName", categoryName);
            q.setParameter("typeOfEstateName", typeOfEstateName);
            q.setParameter("estateNumberOfRooms", estateNumberOfRooms);
            q.setParameter("estateNumberOfToilets", estateNumberOfToilets);
            q.setParameter("firstArea", firstArea);
            q.setParameter("lastArea", lastArea);
            q.setParameter("firstValue", firstValue);
            q.setParameter("lastValue", lastValue);
            q.setParameter("dateNow", dateNow);

            estateList = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estateList;
    }

    //search advanced
//    public List<Estate> searchEstateAdvanced(String strSearch) {
//        List<Estate> estates = null;
//        try{
//            Query q = em.createNamedQuery("Estate.searchAdvance");
//            q.setParameter("strSearch", strSearch);
//            estates = q.getResultList();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return estates;
//    }
    //search estate of member: dang duoc dang va chua het han
    public List<Estate> searchEstatePosted(String strSearch) {
        List<Estate> estates = null;
        try {
            Query q = em.createNamedQuery("Estate.searchEstateOfMemberInPost");
            q.setParameter("strSearch", strSearch);
            estates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    //search estate of member: da het han
    public List<Estate> searchEstateExpired(String strSearch) {
        List<Estate> estates = null;
        try {
            Query q = em.createNamedQuery("Estate.searchEstateOfMemberExpired");
            q.setParameter("strSearch", strSearch);
            estates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    //search estate of member: chua duoc dang
    public List<Estate> searchEstateNotPosted(String strSearch) {
        List<Estate> estates = null;
        try {
            Query q = em.createNamedQuery("Estate.searchEstateOfMemberNotPost");
            q.setParameter("strSearch", strSearch);
            estates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    //search estate by type of estate
    public List<Estate> searchByTypeOfEstate(String strSearch) {
        List<Estate> estates = null;
        try {
            Query q = em.createNamedQuery("Estate.searchEstateByType");
            q.setParameter("strSearch", strSearch);
            estates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    //search estate by category name
    public List<Estate> searchByCategoryName(String categoryName, Date dateNow) {
        List<Estate> estates = null;
        try {
            Query q = em.createNamedQuery("Estate.searchEstateByCategory");
            q.setParameter("categoryName", categoryName);
            q.setParameter("dateNow", dateNow);
            estates = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    public String getLastRecordID() {
        Query q = em.createNamedQuery("Estate.findAll");
        List<Estate> estatelist = q.getResultList();
        if(estatelist.isEmpty()){
            return "1";
        }
        else
            return estatelist.get(estatelist.size()-1).getEstateID();
    }
    
    public List<Subscribe> getSubscribeList() {
        Query q = em.createNamedQuery("Subscribe.findAll");
        return q.getResultList();
    }
    
    public Subscribe getSubscribeByID(String id) {
        Query q = em.createNamedQuery("Subscribe.findBySubscribeID");
        q.setParameter("subscribeID", id);
        return (Subscribe) q.getSingleResult();
    }
    
    public List<TypeOfEstate> getTypeOfEstateList() {
        Query q = em.createNamedQuery("TypeOfEstate.findAll");
        return q.getResultList();
    }
    
    public TypeOfEstate getTypeOfEstateByID(String id) {
        Query q = em.createNamedQuery("TypeOfEstate.findByTypeOfEstateID");
        q.setParameter("typeOfEstateID", id);
        return (TypeOfEstate) q.getSingleResult();
    }
    
    public List<Category> getCategoryList() {
        Query q = em.createNamedQuery("Category.findAll");
        return q.getResultList();
    }
    
    public Category getCategoryByID(String id) {
        Query q = em.createNamedQuery("Category.findByCategoryID");
        q.setParameter("categoryID", id);
        return (Category) q.getSingleResult();
    }
    
    public List<City> getCityList() {
        Query q = em.createNamedQuery("City.findAll");
        return q.getResultList();
    }
    
    public City getCityByID(String id) {
        Query q = em.createNamedQuery("City.findByCityID");
        q.setParameter("cityID", id);
        return (City) q.getSingleResult();
    }
    
    public List<District> getDistrictList() {
        Query q = em.createNamedQuery("District.findAll");
        return q.getResultList();
    }
    
    public District getDistrictByID(String id) {
        Query q = em.createNamedQuery("District.findByDistrictID");
        q.setParameter("districtID", id);
        return (District) q.getSingleResult();
    }
    
    public List<Currency> getCurrencyList() {
        Query q = em.createNamedQuery("Currency.findAll");
        return q.getResultList();
    }
    
    public Currency getCurrencyByID(String id) {
        Query q = em.createNamedQuery("Currency.findByCurrencyID");
        q.setParameter("currencyID", id);
        return (Currency) q.getSingleResult();
    }
    
    public Member1 getMember(String username){
        Query q=em.createNamedQuery("Member1.findByUserName");
        q.setParameter("userName", username);
        return (Member1)q.getSingleResult();
    }
    
    public List<District> getDistrictList(String cityID){
        Query q=em.createNamedQuery("District.findByCityID");
        q.setParameter("cityID", cityID);
        return q.getResultList();
    }
}