/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.News;
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
public class NewsFacade extends AbstractFacade<News> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }
    
    @Override
    public void create(News news) {
        em.persist(news);
    }

    @Override
    public void edit(News news) {
        em.merge(news);
    }

    @Override
    public void remove(News news) {
        em.remove(em.merge(news));
    }  
    
    
    public News getNewsID(String newsID){
        News news1=null;
        try{
            Query query=em.createNamedQuery("News.findByNewsID");
            query.setParameter("newsID", newsID);
            news1=(News) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return news1;
    }
    
    public News getNewsTitle(String newsTitle){
        News news1=null;
        try{
            Query query=em.createNamedQuery("News.findByNewsTitle");
            query.setParameter("newsTitle", newsTitle);
            news1=(News) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return news1;
    }
    
    public News getNewsContent(String newsContents){
        News news1=null;
        try{
            Query query=em.createNamedQuery("News.findByNewsContents");
            query.setParameter("newsContents", newsContents);
            news1=(News) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return news1;
    }
    
    
    public int getLastRecordID(){
        Query q= em.createNamedQuery("News.findAll");
        List<News> newsList= q.getResultList();
                
        int i=newsList.size();
        i=i-1;
        
        int j=Integer.parseInt(newsList.get(i).getNewsID());
        return j;
    }
    
}
