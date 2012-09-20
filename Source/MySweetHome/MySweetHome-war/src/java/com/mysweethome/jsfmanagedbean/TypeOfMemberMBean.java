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
import javax.faces.model.SelectItem;

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
    private SelectItem[] typeMember;

    public SelectItem[] getTypeMember() {
        return typeMember;
    }

    public void setTypeMember(SelectItem[] typeMember) {
        this.typeMember = typeMember;
    }
    
    public TypeOfMemberMBean() {
        typemem=new TypeOfMember();
        typefacade =new TypeOfMemberFacade();
    }
    
    private List<TypeOfMember> typeList=new ArrayList<TypeOfMember>();

    public List<TypeOfMember> getTypeList() {
        return typefacade.findAll();
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
    
    public TypeOfMember getTypeOfMemberFromID(String id){
        typemem=typefacade.find(id);
        return typemem;
    }
    public SelectItem[] getTypeOfMember()
    {
        List<TypeOfMember> type = typefacade.getAll();
         typeMember = null;
        if (type != null) {
            typeMember = new SelectItem[type.size() + 1];
            typeMember[0] = new SelectItem("", "Select");
            for (int i = 0; i < type.size(); i++) {
                typeMember[i + 1] = new SelectItem(type.get(i).getTypeOfMemberID(), type.get(i).getTypeName());
            }
        }
        return typeMember;
    }
    
    public void displayLocation() {  
        FacesMessage msg = new FacesMessage("Selected", "Member type:");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
}
