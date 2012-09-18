/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Member", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByUserName", query = "SELECT m FROM Member1 m WHERE m.userName = :userName"),
    @NamedQuery(name = "Member1.findByPassword", query = "SELECT m FROM Member1 m WHERE m.password = :password"),
    @NamedQuery(name = "Member1.findByEmail", query = "SELECT m FROM Member1 m WHERE m.email = :email"),
    @NamedQuery(name = "Member1.findByFullName", query = "SELECT m FROM Member1 m WHERE m.fullName = :fullName"),
    @NamedQuery(name = "Member1.findByDateOfBirth", query = "SELECT m FROM Member1 m WHERE m.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Member1.findByGender", query = "SELECT m FROM Member1 m WHERE m.gender = :gender"),
    @NamedQuery(name = "Member1.findByAddress", query = "SELECT m FROM Member1 m WHERE m.address = :address"),
    @NamedQuery(name = "Member1.findByTelephone", query = "SELECT m FROM Member1 m WHERE m.telephone = :telephone"),
    @NamedQuery(name = "Member1.findByCompany", query = "SELECT m FROM Member1 m WHERE m.company = :company"),
    @NamedQuery(name = "Member1.findByIsEnabled", query = "SELECT m FROM Member1 m WHERE m.isEnabled = :isEnabled"),
    @NamedQuery(name = "Member1.findByCode", query = "SELECT m FROM Member1 m WHERE m.code = :code"),
    @NamedQuery(name = "Member1.findByImageUrl", query = "SELECT m FROM Member1 m WHERE m.imageUrl = :imageUrl"),
    @NamedQuery(name = "Member1.findByRole", query = "SELECT m FROM Member1 m WHERE m.role = :role"),
    @NamedQuery(name = "Member1.findByTypeOfMemberID", query = "SELECT m FROM TypeOfMember t, IN(t.member1List) m WHERE t.typeOfMemberID = :typeOfMemberID")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UserName", nullable = false, length = 100)
    private String userName;
    @Size(max = 100)
    @Column(name = "Password", length = 100)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email", length = 100)
    private String email;
    @Size(max = 200)
    @Column(name = "Full_Name", length = 200)
    private String fullName;
    @Size(max = 20)
    @Column(name = "Date_Of_Birth", length = 20)
    private String dateOfBirth;
    @Size(max = 30)
    @Column(name = "Gender", length = 30)
    private String gender;
    @Size(max = 200)
    @Column(name = "Address", length = 200)
    private String address;
    @Size(max = 50)
    @Column(name = "Telephone", length = 50)
    private String telephone;
    @Size(max = 50)
    @Column(name = "Company", length = 50)
    private String company;
    @Size(max = 10)
    @Column(name = "Is_Enabled", length = 10)
    private String isEnabled;
    @Size(max = 100)
    @Column(name = "Code", length = 100)
    private String code;
    @Size(max = 250)
    @Column(name = "ImageUrl", length = 250)
    private String imageUrl;
    @Size(max = 10)
    @Column(name = "Role", length = 10)
    private String role;
    @JoinColumn(name = "Type_Of_Member_ID", referencedColumnName = "TypeOfMemberID")
    @ManyToOne
    private TypeOfMember typeOfMemberID;
    @OneToMany(mappedBy = "userName")
    private List<TransactionDetails> transactionDetailsList;
    @OneToMany(mappedBy = "userName")
    private List<Estate> estateList;

    public Member1() {
    }

    public Member1(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TypeOfMember getTypeOfMemberID() {
        return typeOfMemberID;
    }

    public void setTypeOfMemberID(TypeOfMember typeOfMemberID) {
        this.typeOfMemberID = typeOfMemberID;
    }

    @XmlTransient
    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    @XmlTransient
    public List<Estate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<Estate> estateList) {
        this.estateList = estateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.Member1[ userName=" + userName + " ]";
    }
}
