/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.City;
import com.mysweethome.entity.District;
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
public class DistrictFacade extends AbstractFacade<District> {

    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistrictFacade() {
        super(District.class);
    }

    @Override
    public void create(District district) {
        em.persist(district);
    }

    @Override
    public void edit(District district) {
        em.merge(district);
    }

    @Override
    public void remove(District district) {
        em.remove(em.merge(district));
    }

    public District getDistrictByID(String districtID) {
        District ds = null;
        try {
            Query query = em.createNamedQuery("District.findByDistrictID");
            query.setParameter("districtID", districtID);
            ds = (District) query.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }

    public District getDistrictByName(String districtName) {
        District ds = null;
        try {
            Query query = em.createNamedQuery("District.findByDistrictName");
            query.setParameter("districtName", districtName);
            ds = (District) query.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }

    public City getCityFromID(String id) {
        Query query = em.createNamedQuery("City.findByCityID");
        query.setParameter("cityID", id);
        try {
            City city = new City();
            city = (City) query.getResultList().get(0);
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    public int getLastRecordID() {
        Query q = em.createNamedQuery("District.findAll");
        List<District> distlist = q.getResultList();

        int i = distlist.size();
        i = i - 1;

        int j = Integer.parseInt(distlist.get(i).getDistrictID());
        return j;
    }

    public List<City> getListCity() {
        Query query = em.createNamedQuery("City.findAll");
        return query.getResultList();

    }
}
