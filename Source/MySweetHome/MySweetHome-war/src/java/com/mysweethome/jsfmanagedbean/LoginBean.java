/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.helper.messages;
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
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    @EJB
    public Member1Facade member1Facade;
    public Member1 member = new Member1();
    public String username;
    public String password;

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
        member = new Member1();
        member1Facade = new Member1Facade();
    }

    public void doLogin() throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        boolean loggedIn = false;

        if (username.length() == 0) {
            messages.taoTB(FacesMessage.SEVERITY_WARN, "Login Error", "Username is not empty .");
        } else if (password.length() == 0) {
            messages.taoTB(FacesMessage.SEVERITY_WARN, "Login Error", "Password is not empty .");
        } else {
            Member1 mem = member1Facade.getUserName(username);
            if (mem != null) {
                if (mem.getIsEnabled().equalsIgnoreCase("true")) {
                    if (mem.getPassword().equals(password)) {
                        loggedIn = true;
                        operationSession.createSession("username", mem.getUserName());
                        operationSession.createSession("role", mem.getRole());
                        messages.taoTB(FacesMessage.SEVERITY_INFO, "Welcome", mem.getUserName());

//                        FacesContext context1=FacesContext.getCurrentInstance();
//                        String viewid=context1.getViewRoot().getViewId();
//                        ViewHandler handler=context1.getApplication().getViewHandler();
//                        UIViewRoot root=handler.createView(context1, viewid);
//                        root.setViewId(viewid);
//                        context1.setViewRoot(root);
                        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.jsf");
                    } else {
                        messages.taoTB(FacesMessage.SEVERITY_ERROR, "Password incorect", "Please input password");
                    }
                } else {
                    messages.taoTB(FacesMessage.SEVERITY_ERROR, "Account hasn't actived jet.", "Please active your account before.");
                }
            } else {
                messages.taoTB(FacesMessage.SEVERITY_ERROR, "Username incorect", "Please input correct user name.");
            }
        }
    }

    public void back() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/index.jsf");
    }

    public void doLogout() throws IOException {
        if(operationSession.getSession("username")!=null)
            operationSession.deleteGTsession("username");
        if(operationSession.getSession("role")!=null)
            operationSession.deleteGTsession("role");
        this.username = null;
        this.password = null;
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect("./index.jsf");
    }
}
