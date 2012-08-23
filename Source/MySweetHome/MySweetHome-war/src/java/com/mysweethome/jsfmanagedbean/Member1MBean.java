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
    }
    
    
    public boolean insertMember(){
        mem.getAddress();
        mem.getUserName();
        member1Facade.create(mem);
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
    
}
