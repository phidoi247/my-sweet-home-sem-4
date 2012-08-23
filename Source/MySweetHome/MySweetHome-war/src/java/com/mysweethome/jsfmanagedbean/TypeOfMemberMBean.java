/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.TypeOfMember;
import com.mysweethome.session.TypeOfMemberFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@ManagedBean(name="TypeOfMemberMBean")
@SessionScoped
public class TypeOfMemberMBean {

    /**
     * Creates a new instance of TypeOfMemberMBean
     */
    @EJB
    TypeOfMemberFacade typefacade;
    TypeOfMember typemem;
    
    public TypeOfMemberMBean() {
        
    }
    
    private List<TypeOfMember> typeList=new ArrayList<TypeOfMember>();

    public List<TypeOfMember> getTypeList() {
        return typefacade.getAll();
    }

    public void setTypeList(List<TypeOfMember> typeList) {
        this.typeList = typeList;
    }

    public TypeOfMemberFacade getTypefacade() {
        return typefacade;
    }

    public void setTypefacade(TypeOfMemberFacade typefacade) {
        this.typefacade = typefacade;
    }

    public TypeOfMember getTypemem() {
        return typemem;
    }

    public void setTypemem(TypeOfMember typemem) {
        this.typemem = typemem;
    }
    
    public void displayLocation() {  
        FacesMessage msg = new FacesMessage("Selected", "Member type:");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
}
