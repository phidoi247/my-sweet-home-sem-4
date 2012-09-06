/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Subscribe;
import com.mysweethome.helper.messages;
import com.mysweethome.session.SubscribeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PC
 */
@ManagedBean(name="SubscribeMBean")
@SessionScoped
public class SubscribeMBean {

    @EJB
    SubscribeFacade subfacade;
    Subscribe subscribe;
    Subscribe other;
    String subscribeID;
    String subscribeName;
    String feePerDay;
    List<Subscribe> subscribeList;
    List<Subscribe> filteredSubscribe; 

    public String getFeePerDay() {
        return subscribe.getFeePerDay();
    }

    public void setFeePerDay(String feePerDay) {
        this.feePerDay = feePerDay;
    }

    public String getSubscribeID() {
        return subscribe.getSubscribeID();
    }

    public void setSubscribeID(String subscribeID) {
        this.subscribeID = subscribeID;
    }

    public String getSubscribeName() {
        return subscribe.getSubscribeName();
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public List<Subscribe> getFilteredSubscribe() {
        return filteredSubscribe = subscribeList;
    }

    public void setFilteredSubscribe(List<Subscribe> filteredSubscribe) {
        this.filteredSubscribe = filteredSubscribe;
    }
    /**
     * Creates a new instance of SubscribeMBean
     */
    public SubscribeMBean() {
        subfacade = new SubscribeFacade();
        subscribe = new Subscribe();
        other = new Subscribe();
        subscribeID = subscribe.getSubscribeID();
        subscribeName = subscribe.getSubscribeName();
        feePerDay = subscribe.getFeePerDay();
        subscribeList = new ArrayList<Subscribe>();
        filteredSubscribe = new ArrayList<Subscribe>();
        
    }
    
    String name;
    private String result="10";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   

    public SubscribeFacade getSubfacade() {
        return subfacade;
    }

    public void setSubface(SubscribeFacade subfacade) {
        this.subfacade = subfacade;
    }

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Subscribe subscribe) {
        this.subscribe = subscribe;
    }

    public List<Subscribe> getSubscribeList() {
        return subscribeList = subfacade.findAll();
    }

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
    }
    
    public void handleClick(){
        System.out.println(name);
        setResult(name);
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
    
    
    public void createSubscribe() {
        
        
        try{
            Subscribe newSub = new Subscribe();
            //newSub = subfacade.find(subscribeID);
        
            int id= getSubfacade().getLastRecordID();
            newSub.setSubscribeID(String.valueOf(id+1));
            
            newSub.setSubscribeName(other.getSubscribeName());
            newSub.setFeePerDay(other.getFeePerDay());
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
//        if (newSub != null) {
//            messages.taoTB(FacesMessage.SEVERITY_WARN, "User name had already", "This username had already. Please select another username.");
//        } else {
//            subscribe.setSubscribeID(subscribeID);
//            subscribe.setSubscribeName(subscribeName);
//            subscribe.setFeePerDay(feePerDay);
//            subfacade.create(newSub);
//            
//            messages.taoTB(FacesMessage.SEVERITY_INFO, "Register success", "Registration success. Please check your email to active account before login to system.");
//        }
        
    }
    
    
    public void editSubscribe(){
        
        String str = getSubscribe().getSubscribeID();
        Subscribe editSub = getSubfacade().getSubscribeID(str);
        editSub.setSubscribeID(subscribeID);
        editSub.setSubscribeName(subscribeName);
        editSub.setFeePerDay(feePerDay);   
        getSubfacade().edit(editSub);
    }
    
    
    public void removeSubscribe() {
        String str = getSubscribe().getSubscribeID();
        getSubscribe().setSubscribeID(str);
        getSubfacade().remove(getSubscribe());
    }
    
    
}
