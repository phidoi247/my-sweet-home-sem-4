/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    @Override
    public void create(Category category) {
        em.persist(category);
    }

    @Override
    public void edit(Category category) {
        em.merge(category);
    }

    @Override
    public void remove(Category category) {
        em.remove(em.merge(category));
    }
    
    public Category getCategoryID(String categoryID){
        Category cate=null;
        try{
        Query query=em.createNamedQuery("Category.findByCategoryID");
        query.setParameter("categoryID", categoryID);
        cate=(Category) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cate;
    }
    
    
    public Category getCategoryName(String categoryName){
        Category cate=null;
        try{
        Query query=em.createNamedQuery("Category.findByCategoryName");
        query.setParameter("categoryName", categoryName);
        cate=(Category) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cate;
    }
}
