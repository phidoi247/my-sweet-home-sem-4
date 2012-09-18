/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.News;
import com.mysweethome.helper.messages;
import com.mysweethome.session.NewsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

    public News getOther() {
        return other;
    }

    public void setOther(News other) {
        this.other = other;
    }
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
        if (other.getNewsID() != null) {
            News temp = new News();
            temp = getNewsFacade().getNewsID(other.getNewsID());
            if (temp != null) {
                messages.taoTB(FacesMessage.SEVERITY_WARN, "Duplicate!", "This News had already");
            } else {
                News newtemp = new News();
                newtemp.setNewsID(other.getNewsID());
                newtemp.setNewsTitle(other.getNewsTitle());
                newtemp.setNewsContents(other.getNewsContents());
                getNewsFacade().create(newtemp);
                messages.taoTB(FacesMessage.SEVERITY_INFO, "Create success!", "Create success!");
            }
        }
        this.other = new News();
    }
    public void editNews(){
        
        String str = getNews().getNewsID();
        News editNews = getNewsFacade().getNewsID(str);
        editNews.setNewsID(newsID);
        editNews.setNewsTitle(newsTitle);
        editNews.setNewsContents(newsContent);
        
        getNewsFacade().edit(editNews);
    }
    public void editNews(News news) {
        getNewsFacade().edit(news);
        messages.taoTB(FacesMessage.SEVERITY_INFO, "Edit success", "Edit success");
        this.news = new News();
    }
    
    public void removeNews() {
        String str = getNews().getNewsID();
        getNews().setNewsID(str);
        getNewsFacade().remove(getNews());
        this.news= new News();
    }                    
}
