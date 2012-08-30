/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.session.CurrencyFacade;
import com.mysweethome.entity.Currency;
import com.mysweethome.helper.messages;
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
    Currency currency;
    String currency_ID;
    String currencyName;
    String rate;

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
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrency_ID() {
        return currency_ID;
    }

    public void setCurrency_ID(String currency_ID) {
        this.currency_ID = currency_ID;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    /**
     * Creates a new instance of CurrencyMBean
     */
    public CurrencyMBean() {
        currency = new Currency();
        currencyFacade = new CurrencyFacade();
        currency_ID = currency.getCurrencyID();
        currencyName = currency.getCurrencyName();
        rate = currency.getVNDRate();
    }
    
    
    public List<Currency> getCurrencyList() {
        return currencyFacade.findAll();
    }
    
    
    public void createCurrency() {
        Currency newCurrency = new Currency();
        newCurrency = currencyFacade.find(currency_ID);
        if (newCurrency != null) {
            messages.taoTB(FacesMessage.SEVERITY_WARN, "User name had already", "This username had already. Please select another username.");
        } else {
            currency.setCurrencyID(currency_ID);
            currency.setCurrencyName(currencyName);
            currency.setVNDRate(rate);
            currencyFacade.create(newCurrency);
            
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Register success", "Registration success. Please check your email to active account before login to system.");
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
