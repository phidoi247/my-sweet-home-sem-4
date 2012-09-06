/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.session.CurrencyFacade;
import com.mysweethome.entity.Currency;
import com.mysweethome.helper.messages;
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
@ManagedBean(name="currencyMBean")
@SessionScoped
public class CurrencyMBean {

    
    @EJB
    private CurrencyFacade currencyFacade;
    Currency currency, other;
    String currency_ID;
    String currencyName;
    String rate;
    List<Currency> currencyList;
    List<Currency> filteredCurrency;

    public Currency getOther() {
        return other;
    }

    public void setOther(Currency other) {
        this.other = other;
    }

    
    
    
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CurrencyFacade getCurrencyFacade() {
        return currencyFacade;
    }

    public void setCurrencyFacade(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    public String getCurrencyName() {
        return currency.getCurrencyName();
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrency_ID() {
        return currency.getCurrencyID();
    }

    public void setCurrency_ID(String currency_ID) {
        this.currency_ID = currency_ID;
    }

    public String getRate() {
        return currency.getVNDRate();
    }

    
    public List<Currency> getCurrencyList() {
        return currencyList = currencyFacade.findAll();
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
    
    public List<Currency> getFilteredCurrency() {
        return filteredCurrency = currencyList;
    }

    public void setFilteredCurrency(List<Currency> filteredCurrency) {
        this.filteredCurrency = filteredCurrency;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    /**
     * Creates a new instance of CurrencyMBean
     */
    public CurrencyMBean() {
        currency = new Currency();
        other = new Currency();
        currencyFacade = new CurrencyFacade();
        currency_ID = currency.getCurrencyID();
        currencyName = currency.getCurrencyName();
        rate = currency.getVNDRate();
        currencyList = new ArrayList<Currency>();
        filteredCurrency = new ArrayList<Currency>();
    }

    
    
    
    public void createCurrency() {
        try{
            Currency newCur = new Currency();
            //newSub = subfacade.find(subscribeID);
        
            int id= getCurrencyFacade().getLastRecordID();
            newCur.setCurrencyID(String.valueOf(id+1));
            
            newCur.setCurrencyName(other.getCurrencyName());
            newCur.setVNDRate(other.getVNDRate());
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void editCurrency(){
        String str=getCurrency().getCurrencyID();
        Currency editCur=getCurrencyFacade().getCurrencyID(str);
        editCur.setCurrencyID(currency_ID);
        editCur.setCurrencyName(currencyName);
        editCur.setVNDRate(rate);
        
        getCurrencyFacade().edit(editCur);
    }
    
    
    public void removeCurrency() {
        String str = getCurrency().getCurrencyID();
        getCurrency().setCurrencyID(str);
        getCurrencyFacade().remove(getCurrency());
    }
    
}
