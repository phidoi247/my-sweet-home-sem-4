/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.session.Member1Facade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author QuangVinh
 */
@ManagedBean(name="MemberMBean")
@SessionScoped
public class MemberMBean {
    @EJB
    private Member1Facade member1Facade;
    private Member1 member;

    public Member1Facade getMember1Facade() {
        return member1Facade;
    }

    public void setMember1Facade(Member1Facade member1Facade) {
        this.member1Facade = member1Facade;
    }
    
    public List<Member1> getAllMember(){
        return member1Facade.findAll();
    }
    
    FacesContext face;

    public Member1 getMember() {
        return member;
    }

    public void setMember(Member1 member) {
        this.member = member;
    }

    /**
     * Creates a new instance of MemberMBean
     */
    public MemberMBean() {
        face = FacesContext.getCurrentInstance();
        member = new Member1();
        member1Facade= new Member1Facade();
    }
    
    
    public boolean insertMember(){
        //get all properties
        member.getUserName();
        member.getPassword();
        member.getAddress();
        member.getDateOfBirth();
        member.getCompany();
        member.getEmail();
        member.getFullName();
        member.getGender();
        member.getImageUrl();
        member.getIsEnabled();
        member.getRole();
        member.getTelephone();
   
        member1Facade.create(member);
        
        
        return true;
    }
    
    
     public void editMember() {
        String str = member.getUserName();
        Member1  mem = member1Facade.getUserName(str);
        
        mem.setPassword(member.getPassword());
        mem.setAddress(member.getAddress());
        mem.setCompany(member.getCompany());
        mem.setDateOfBirth(member.getDateOfBirth());
        mem.setCode(member.getCode());
        mem.setEmail(member.getEmail());
        mem.setFullName(member.getFullName());
        mem.setGender(member.getGender());
        mem.setImageUrl(member.getImageUrl());
        mem.setIsEnabled(member.getIsEnabled());
        mem.setRole(member.getRole());
        mem.setTelephone(member.getTelephone());
        
        
        
        member1Facade.edit(mem);
        //setUserSession(admin);
        
        face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Profile Success.", "Update Profile Success."));

    }

    
    public void removeEstate(){
        String str = member.getUserName();
        member.setUserName(str);
        
        
        if (str != null) {
            member1Facade.remove(member);
            face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Successfully.", "Delete Successfully."));
        }else {
            face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Failed.", "Delete Failed."));
        }
        
    }
    
    public String showDetails(Member1 mem){
        this.member=mem;
        return "/MemberDetails";
    }
}
