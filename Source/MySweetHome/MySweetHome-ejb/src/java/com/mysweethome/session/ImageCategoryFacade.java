/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.ImageCategory;
import java.util.ArrayList;
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
public class ImageCategoryFacade extends AbstractFacade<ImageCategory> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImageCategoryFacade() {
        super(ImageCategory.class);
    }
    
    @Override
    public void create(ImageCategory imagecategory) {
        em.persist(imagecategory);
    }

    @Override
    public void edit(ImageCategory imagecategory) {
        em.merge(imagecategory);
    }

    @Override
    public void remove(ImageCategory imagecategory) {
        em.remove(em.merge(imagecategory));
    }  
    
    public List<String> getImagesOfEstate(String estateID){
        List<String> images=new ArrayList<String>();
        Query q=em.createNamedQuery("ImageCategory.findByImageCategoryID");
        q.setParameter("imageCategoryID", estateID);
        ImageCategory ct=(ImageCategory) q.getSingleResult();
        if (ct != null) {
                if(ct.getImage1()!=null && ct.getImage1().length()>0){
                    images.add(ct.getImage1());
                }
                if(ct.getImage2()!=null && ct.getImage2().length()>0){
                    images.add(ct.getImage2());
                }
                if(ct.getImage3()!=null && ct.getImage3().length()>0){
                    images.add(ct.getImage3());
                }
                if(ct.getImage4()!=null && ct.getImage4().length()>0){
                    images.add(ct.getImage4());
                }
                if(ct.getImage5()!=null && ct.getImage5().length()>0){
                    images.add(ct.getImage5());
                }
                if(ct.getImage6()!=null && ct.getImage6().length()>0){
                    images.add(ct.getImage6());
                }
        }
        return images;
    }
}
