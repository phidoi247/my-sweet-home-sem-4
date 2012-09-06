/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.News;
import com.mysweethome.session.NewsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Welcome
 */

@ManagedBean(name="newsMBean")
@SessionScoped
public class NewsMBean {
    @EJB
    public NewsFacade newsFacade;
    public News news, other;
    public String newsID;
    public String newsTitle;
    public String newsContent;
    List<News> getNewsList;
    List<News> filteredNews;

    public List<News> getGetNewsList() {
        return getNewsList = newsFacade.findAll();
    }

    public void setGetNewsList(List<News> getNewsList) {
        this.getNewsList = getNewsList;
    }
    

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getNewsContent() {
        return news.getNewsContents();
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public List<News> getFilteredNews() {
        return filteredNews = getNewsList;
    }

    public void setFilteredNews(List<News> filteredNews) {
        this.filteredNews = filteredNews;
    }

    public NewsFacade getNewsFacade() {
        return newsFacade;
    }

    public void setNewsFacade(NewsFacade newsFacade) {
        this.newsFacade = newsFacade;
    }

    public String getNewsID() {
        return news.getNewsID();
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return news.getNewsTitle();
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    
    
    /**
     * Creates a new instance of NewsMBean
     */
    public NewsMBean() {
        newsFacade = new NewsFacade();
        news = new News();
        other = new News();
        newsID = news.getNewsID();
        newsTitle = news.getNewsTitle();
        newsContent = news.getNewsContents();
        getNewsList = new ArrayList<News>();
        filteredNews = new ArrayList<News>();
    }
    
    
    
    public void createNews() {
        
        
        try{
            News otherNews = new News();
            //newSub = subfacade.find(subscribeID);
        
            int id= getNewsFacade().getLastRecordID();
            otherNews.setNewsID(String.valueOf(id+1));
            otherNews.setNewsTitle(other.getNewsTitle());
            otherNews.setNewsContents(other.getNewsContents());
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
              
    }
    
    
    public void editNews(){
        
        String str = getNews().getNewsID();
        News editNews = getNewsFacade().getNewsID(str);
        editNews.setNewsID(newsID);
        editNews.setNewsTitle(newsTitle);
        editNews.setNewsContents(newsContent);
        
        getNewsFacade().edit(editNews);
    }
    
    
    public void removeNews() {
        String str = getNews().getNewsID();
        getNews().setNewsID(str);
        getNewsFacade().remove(getNews());
    }
    
    
    
    
    
}
