/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.session.Member1Facade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="Member1MBean")
@SessionScoped
public class Member1MBean {
    @EJB
    private Member1Facade member1Facade;
    private Member1 mem;
    String newAddress, newEmail, newFullName, newDateOfBirth, newGender, newTelephone, newCompany, newRole;

    public String getNewAddress() {
        return mem.getAddress();
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewCompany() {
        return mem.getCompany();
    }

    public void setNewCompany(String newCompany) {
        this.newCompany = newCompany;
    }

    public String getNewDateOfBirth() {
        return mem.getDateOfBirth();
    }

    public void setNewDateOfBirth(String newDateOfBirth) {
        this.newDateOfBirth = newDateOfBirth;
    }

    public String getNewEmail() {
        return mem.getEmail();
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewFullName() {
        return mem.getFullName();
    }

    public void setNewFullName(String newFullName) {
        this.newFullName = newFullName;
    }

    public String getNewGender() {
        return mem.getGender();
    }

    public void setNewGender(String newGender) {
        this.newGender = newGender;
    }

    public String getNewRole() {
        return mem.getRole();
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }

    public String getNewTelephone() {
        return mem.getTelephone();
    }

    public void setNewTelephone(String newTelephone) {
        this.newTelephone = newTelephone;
    }

    

    List<Member1> filterList;
    List<Member1> memberList;
    
    public List<Member1> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Member1> filterList) {
        this.filterList = filterList;
    }

    public Member1 getMem() {
        return mem;
    }

    public void setMem(Member1 mem) {
        this.mem = mem;
    }

    public void setMemberList(List<Member1> memberList) {
        this.memberList = memberList;
    }

    public Member1Facade getMember1Facade() {
        return member1Facade;
    }

    public void setMember1Facade(Member1Facade member1Facade) {
        this.member1Facade = member1Facade;
    }

    /**
     * Creates a new instance of MemberMBean
     */
    public Member1MBean() {
        mem = new Member1();
        member1Facade= new Member1Facade();
        newAddress = mem.getAddress();
        newEmail = mem.getEmail();
        newFullName = mem.getFullName();
        newDateOfBirth = mem.getDateOfBirth();
        newGender = mem.getGender();
        newTelephone = mem.getTelephone();
        newCompany = mem.getCompany();
        newRole = mem.getRole();
    }
    
    
    public String createMember(){
        Member1 memtemp= new Member1();
        
        String result="False";
        try{
            
        int id= getMember1Facade().getLastRecordID();
        memtemp.setUserName(String.valueOf(id+1));
        memtemp.setPassword(getMem().getPassword());  
        memtemp.setAddress(getMem().getAddress());        
        memtemp.setEmail(getMem().getEmail());        
        memtemp.setFullName(getMem().getFullName());        
        memtemp.setDateOfBirth(getMem().getDateOfBirth());        
        memtemp.setGender(getMem().getGender());        
        memtemp.setCompany(getMem().getCompany());        
        memtemp.setRole(getMem().getRole());        
        memtemp.setTelephone(getMem().getTelephone());
        
        getMember1Facade().create(memtemp);
        result="True";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public List<Member1> getAllMember()
    {
        return member1Facade.findAll();
    }
    
    //private Map<String,String> members = new HashMap<String, String>();
    private List<String> members=new ArrayList<String>();

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
    
    private Map<String,Map<String,String>> suburbsData = new HashMap<String, Map<String,String>>();
    private String city;  
    
    public Map<String, Map<String, String>> getSuburbsData() {
        return suburbsData;
    }

    public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {
        this.suburbsData = suburbsData;
    }
    
     
    
    public void removeMember(){
        String str=getMem().getUserName();
        getMem().setUserName(str);
        getMember1Facade().remove(getMem());
    }
    
    public void editMember(){
        
        String str=getMem().getUserName();
        Member1 member1=getMember1Facade().getUserName(str);
        member1.setAddress(newAddress);  
        //getMember1Facade().edit(member1);
        member1.setEmail(newEmail);  
        //getMember1Facade().edit(member1);
        member1.setFullName(newFullName);  
        //getMember1Facade().edit(member1);
        member1.setDateOfBirth(newDateOfBirth);  
        //getMember1Facade().edit(member1);
        member1.setGender(newGender);  
        //getMember1Facade().edit(member1);
        member1.setTelephone(newTelephone);  
        //getMember1Facade().edit(member1);
        member1.setCompany(newCompany);  
        //getMember1Facade().edit(member1);
        member1.setRole(newRole);  
        getMember1Facade().edit(member1);
    }
    
}
