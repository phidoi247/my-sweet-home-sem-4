/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.helper.*;
import com.mysweethome.session.Member1Facade;
import com.mysweethome.session.TypeOfMemberFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;

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
    public List<Member1> memberList = new ArrayList<Member1>();
    public String username;
    public String password;
    public String confirmPass;
    public String fullName;
    public String email;
    public Date birthday;
    public String gender;
    public String address;
    public String phone;
    public String company;
    public String typeOfMemberID;
    public String role;
    public String telephone;

    public List<Member1> getMemberList() {
        return member1Facade.findAll();
    }

    public void setMemberList(List<Member1> memberList) {
        this.memberList = memberList;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
            //send mail to user to active account
            try {
                String from = "quanghuy9289@gmail.com";
                String to = email;
                String subject = "My Sweet Home";
                String body = "Dear " + username + ",\n";
                body += "Wellcome to my website!\n";
                body += "You had registed a new account. Please active this account by clicking below link:\n";
                body += "http://localhost:8080/MySweetHome-war/activeAccount.jsf?username=" + username + "&code=" + code + "\n";
                body += "Thanks you!\n";
                body += "--------------------------\n";
                body += "My group:\n";
                body += "Ngo Quang Huy\n";
                body += "Vu Long\n";
                body += "Nguyen Anh Tan\n";
                body += "Huynh Quang Vinh\n";
                body += "Le Xuan Trung";
                MailConfig config = new MailConfig();
                Message message = config.createMessage(from, to, subject, body);
                config.sendEmail(message);
            } catch (MessagingException ex) {
            }
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Register success", "Registration success. Please check your email to active account before login to system.");
        }
    }

    public void removeMember() {
        String str = getMem().getUserName();
        getMem().setUserName(str);
        getMember1Facade().remove(getMem());
    }

    public void removeMember(String username) {
        Member1 memtemp = this.getMember1Facade().find(username);

        getMember1Facade().remove(memtemp);
    }

    public void editMember() {

        String str = getMem().getUserName();
        Member1 member1;
        member1 = getMember1Facade().getUserName(str);
        member1.setEmail(email);
        member1.setAddress(address);
        member1.setFullName(fullName);
        member1.setGender(gender);
        member1.setCompany(company);
        member1.setTelephone(phone);
        member1.setRole(role);

        getMember1Facade().edit(member1);
    }
    
    public void activeAccount() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String user = (String) requestMap.get("username");
        String codeActive = (String) requestMap.get("code");
        Member1 member = new Member1();
        member=member1Facade.find(user);
        if(member!=null){
            if(member.getIsEnabled().equalsIgnoreCase("false")){
                member.setIsEnabled("true");
                getMember1Facade().edit(member);
                messages.taoTB(FacesMessage.SEVERITY_INFO, "Active success", "Active success!");
            }
        }
    }
}
