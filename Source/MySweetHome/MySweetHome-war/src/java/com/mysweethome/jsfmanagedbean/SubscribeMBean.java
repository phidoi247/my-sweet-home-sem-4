/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Subscribe;
import com.mysweethome.session.SubscribeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    SubscribeFacade subface;
    Subscribe subscribe;
    /**
     * Creates a new instance of SubscribeMBean
     */
    public SubscribeMBean() {
    }
    
    String name;
    private String result="10";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    List<Subscribe> subscribeList=new ArrayList<Subscribe>();

    public SubscribeFacade getSubface() {
        return subface;
    }

    public void setSubface(SubscribeFacade subface) {
        this.subface = subface;
    }

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Subscribe subscribe) {
        this.subscribe = subscribe;
    }

    public List<Subscribe> getSubscribeList() {
        return subface.findAll();
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
    
}
