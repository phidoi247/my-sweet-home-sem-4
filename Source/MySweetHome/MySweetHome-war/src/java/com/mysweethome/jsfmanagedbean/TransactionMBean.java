/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Account;
import com.mysweethome.helper.messages;
import com.mysweethome.services.TransferService_Service;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="transactionMBean")
@SessionScoped
public class TransactionMBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/transferService/transferService.wsdl")
    private TransferService_Service service;

    /**
     * Creates a new instance of TransactionMBean
     */
    public TransactionMBean() {
        
    }

    public TransferService_Service getService() {
        return service;
    }

    public void setService(TransferService_Service service) {
        this.service = service;
    }
    private String from, password, balance;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void transfer(){
        String result = doTransfer(getFrom(), getPassword(),"MySweetHome", getBalance());
        if(result.equals("Transfer successful")){
            try {
                messages.taoTB(FacesMessage.SEVERITY_WARN, "Success!", "Transfer successful");
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.sendRedirect("../index.jsf");
            } catch (IOException ex) {
                Logger.getLogger(TransactionMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            messages.taoTB(FacesMessage.SEVERITY_WARN, "Transfer failed", result);
        }
    }

    private String doTransfer(java.lang.String accNumber, java.lang.String password, java.lang.String transferTo, java.lang.String balance) {
        com.mysweethome.services.TransferService port = service.getTransferServicePort();
        return port.doTransfer(accNumber, password, transferTo, balance);
    }
}
