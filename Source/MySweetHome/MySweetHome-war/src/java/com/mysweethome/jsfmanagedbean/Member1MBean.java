/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.helper.MD5;
import com.mysweethome.helper.RandomCode;
import com.mysweethome.helper.messages;
import com.mysweethome.session.Member1Facade;
import com.mysweethome.session.TypeOfMemberFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean(name = "Member1MBean")
@SessionScoped
public class Member1MBean {

    @EJB
    private Member1Facade member1Facade;
    private Member1 mem;
    private TypeOfMemberFacade typeOfMemberFace;
    List<String> members = new ArrayList<String>();
    List<Member1> memberList;

    public List<Member1> getMemberList() {
        return member1Facade.getAll();
    }

    public void setMemberList(List<Member1> memberList) {
        this.memberList = memberList;
    }
    String username;
    String password;
    String confirmPass;
    String fullName;
    String email;
    Date birthday;
    String gender;
    String address;
    String phone;
    String company;
    String typeOfMemberID;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTypeOfMemberID() {
        return typeOfMemberID;
    }

    public void setTypeOfMemberID(String typeOfMemberID) {
        this.typeOfMemberID = typeOfMemberID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Member1 getMem() {
        return mem;
    }

    public void setMem(Member1 mem) {
        this.mem = mem;
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
        typeOfMemberFace = new TypeOfMemberFacade();
        member1Facade = new Member1Facade();
    }

    public List<Member1> getAllMember() {
        return member1Facade.findAll();
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public void createMember() {
        Member1 member = new Member1();
        member = member1Facade.find(username);
        if (member != null) {
            messages.taoTB(FacesMessage.SEVERITY_WARN, "User name had already", "This username had already. Please select another username.");
        } else {
            mem.setUserName(username);
            mem.setPassword(MD5.getMD5(password));
            mem.setFullName(fullName);
            mem.setEmail(email);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            mem.setDateOfBirth(dateFormat.format(birthday).toString());
            mem.setGender(gender);
            mem.setAddress(address);
            mem.setTelephone(phone);
            mem.setCompany(company);
            mem.setIsEnabled("false");
            //set randome code
            String code = new RandomCode().createRandomString();
            mem.setCode(code);
            mem.setRole("Member");
            mem.setTypeOfMemberID(member1Facade.getTypeOfMemberFromID(typeOfMemberID));
            member1Facade.create(mem);
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Register success", "Registration success. Please check your email to active account before login to system.");
        }
    }

    public void removeMember() {
        String str = getMem().getUserName();
        getMem().setUserName(str);
        getMember1Facade().remove(getMem());
    }
}
