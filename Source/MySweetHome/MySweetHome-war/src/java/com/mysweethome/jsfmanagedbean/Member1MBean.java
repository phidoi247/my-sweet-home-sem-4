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
    private Member1 member;

    public Member1 getMember() {
        return member;
    }

    public void setMember(Member1 member) {
        this.member = member;
    }

    /**
     * Creates a new instance of MemberMBean
     */
    public Member1MBean() {
        member = new Member1();
        member1Facade= new Member1Facade();
//        cities.put("Istanbul");  
//        cities.put("Ankara");  
//        cities.put("Izmir");
//        
        members.add("daf");
        members.add("daf");
        members.add("daf");
        
        Map<String,String> suburbsIstanbul = new HashMap<String, String>();  
        suburbsIstanbul.put("Kadikoy", "Kadikoy");  
        suburbsIstanbul.put("Levent", "Levent");  
        suburbsIstanbul.put("Cengelkoy", "Cengelkoy");  
          
        Map<String,String> suburbsAnkara = new HashMap<String, String>();  
        suburbsAnkara.put("Kecioren", "Kecioren");  
        suburbsAnkara.put("Cankaya", "Cankaya");  
        suburbsAnkara.put("Yenimahalle", "Yenimahalle");  
          
        Map<String,String> suburbsIzmir = new HashMap<String, String>();  
        suburbsIzmir.put("Cesme", "Cesme");  
        suburbsIzmir.put("Gumuldur", "Gumuldur");  
        suburbsIzmir.put("Foca", "Foca");  
          
        suburbsData.put("Istanbul", suburbsIstanbul);  
        suburbsData.put("Ankara", suburbsAnkara);  
        suburbsData.put("Izmir", suburbsIzmir);
    }
    
    
    public boolean insertMember(){
        member.getAddress();
        member.getUserName();
        
        member1Facade.create(member);
        
        
        return true;
    }
    
    public List<Member1> getMemberList()
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
    
    
    
//    public void handleCityChange() {  
//        if(city !=null && !city.equals(""))  
//            suburbs = suburbsData.get(city);  
//        else  
//            suburbs = new HashMap<String, String>();  
//    } 
}
