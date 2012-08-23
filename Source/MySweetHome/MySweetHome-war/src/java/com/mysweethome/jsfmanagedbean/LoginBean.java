/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.helper.operationSession;
import com.mysweethome.session.Member1Facade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
    @EJB
    private Member1Facade member1Facade;
    private Member1 member=new Member1();
    private String username;
    private String password;

    public Member1 getMember() {
        return member;
    }

    public void setMember(Member1 member) {
        this.member = member;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        member= new Member1();
        member1Facade= new Member1Facade();
    }
    
    public void doLogin(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;
        
        if (username.length() == 0) {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Username is not empty .");
        } else if (password.length() == 0) {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Password is not empty .");
        } else {
            Member1 mem = member1Facade.getUserName(username);
            if (mem != null) {    
                if(mem.getIsEnabled().equalsIgnoreCase("true")){
                    if (mem.getPassword().equals(password)) {
                        loggedIn=true;
                        operationSession.createSession("username", mem.getUserName());
                        operationSession.createSession("role", mem.getRole());
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", mem.getUserName());                         
                    } else {
                        msg= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorect", "Please input password");
                    }
                }
                else{
                    msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Account hasn't actived jet.","Please active your account before.");
                }
            } else {
                msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username incorect", "Please input correct user name");
            }
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    public void doLogout() throws IOException{
        operationSession.deleteGTsession("username");
        operationSession.deleteGTsession("role");
        this.username=null;
        this.password=null;
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect("../faces/index.xhtml");
    }
}
