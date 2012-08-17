/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Estate", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estate.findAll", query = "SELECT e FROM Estate e"),
    @NamedQuery(name = "Estate.findByEstateID", query = "SELECT e FROM Estate e WHERE e.estateID = :estateID"),
    @NamedQuery(name = "Estate.findByEstateTitle", query = "SELECT e FROM Estate e WHERE e.estateTitle = :estateTitle"),
    @NamedQuery(name = "Estate.findByEstateStartDay", query = "SELECT e FROM Estate e WHERE e.estateStartDay = :estateStartDay"),
    @NamedQuery(name = "Estate.findByEstateEndDay", query = "SELECT e FROM Estate e WHERE e.estateEndDay = :estateEndDay"),
    @NamedQuery(name = "Estate.findByEstateAddress", query = "SELECT e FROM Estate e WHERE e.estateAddress = :estateAddress"),
    @NamedQuery(name = "Estate.findByEstateContent", query = "SELECT e FROM Estate e WHERE e.estateContent = :estateContent"),
    @NamedQuery(name = "Estate.findByEstateArea", query = "SELECT e FROM Estate e WHERE e.estateArea = :estateArea"),
    @NamedQuery(name = "Estate.findByEstateValue", query = "SELECT e FROM Estate e WHERE e.estateValue = :estateValue"),
    @NamedQuery(name = "Estate.findByEstateDriveway", query = "SELECT e FROM Estate e WHERE e.estateDriveway = :estateDriveway"),
    @NamedQuery(name = "Estate.findByEstateDirection", query = "SELECT e FROM Estate e WHERE e.estateDirection = :estateDirection"),
    @NamedQuery(name = "Estate.findByEstateNumberOfRooms", query = "SELECT e FROM Estate e WHERE e.estateNumberOfRooms = :estateNumberOfRooms"),
    @NamedQuery(name = "Estate.findByEstateNumberOfFloors", query = "SELECT e FROM Estate e WHERE e.estateNumberOfFloors = :estateNumberOfFloors"),
    @NamedQuery(name = "Estate.findByEstateNumberOfToilets", query = "SELECT e FROM Estate e WHERE e.estateNumberOfToilets = :estateNumberOfToilets"),
    @NamedQuery(name = "Estate.findByEstateNumOfView", query = "SELECT e FROM Estate e WHERE e.estateNumOfView = :estateNumOfView"),
    @NamedQuery(name = "Estate.findByIsEnabled", query = "SELECT e FROM Estate e WHERE e.isEnabled = :isEnabled"),
    @NamedQuery(name = "Estate.findByIsPaid", query = "SELECT e FROM Estate e WHERE e.isPaid = :isPaid"),
    @NamedQuery(name = "Estate.findBySumValue", query = "SELECT e FROM Estate e WHERE e.sumValue = :sumValue"),
    
    //search advance
    @NamedQuery(name = "Estate.searchAdvance", 
        query = "SELECT e FROM Category ct, TypeOfEstate t, City c, Subscribe s, IN(c.districtList) d, IN(d.estateList) e"
        + " WHERE c.cityName LIKE '%:cityName%' AND d.districtName LIKE '%:districtName%' AND"
              + " ct.categoryName LIKE '%:categoryName%' AND t.typeOfEstateName LIKE '%:typeOfEstateName%' AND"
              + " e.estateNumberOfRooms LIKE '%:estateNumberOfRooms%' AND e.estateNumberOfToilets LIKE '%:estateNumberOfToilets%' AND"
              + " e.estateArea BETWEEN :firstArea AND :lastArea AND"
              + " e.sumValue BETWEEN :firstValue AND :lastValue AND"
              + " :dateNow BETWEEN e.estateStartDay AND e.estateEndDay AND"
              + " e.isEnabled = 'true' AND e.isPaid = 'true' AND"
              + " e MEMBER OF s.estateList"
              + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC" ),
    
    //search estate of member: dang duoc dang va chua het han
    @NamedQuery(name = "Estate.searchEstateOfMemberInPost", query = "SELECT e FROM Estate e, Subscribe s WHERE e.userName = :userName AND"
        + " e MEMBER OF s.estateList AND"
        + " :dateNow BETWEEN e.estateStartDay AND e.estateEndDay AND"
        + " e.isEnabled = 'true' AND e.isPaid = 'true'"
        + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC"),
    
    //search estate of member: da het han
    @NamedQuery(name = "Estate.searchEstateOfMemberExpired", query = "SELECT e FROM Estate e, Subscribe s WHERE e.userName = :userName AND"
        + " e MEMBER OF s.estateList AND"
        + " e.estateEndDay < :dateNow AND"
        + " e.isEnabled = 'true' AND e.isPaid = 'true'"
        + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC"),
    
    //search estate of member: chua duoc dang
    @NamedQuery(name = "Estate.searchEstateOfMemberNotPost", query = "SELECT e FROM Estate e, Subscribe s WHERE e.userName = :userName AND"
        + " e MEMBER OF s.estateList AND"
        + " e.isEnabled = 'false' OR e.isPaid = 'false'"
        + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC"),
    
    //search estate by type of estate
    @NamedQuery(name = "Estate.searchEstateByType", query = "SELECT e FROM TypeOfEstate t, Subscribe s, IN(t.estateList) e"
        + " WHERE t.typeOfEstateName = :typeOfEstateName AND"
        + " e MEMBER OF s.estateList AND"
        + " :dateNow BETWEEN e.estateStartDay AND e.estateEndDay AND"
        + " e.isEnabled = 'true' AND e.isPaid = 'true'"
        + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC"),
    
    //search estate by category name
    @NamedQuery(name = "Estate.searchEstateByCategory", query = "SELECT e FROM Category ct, Subscribe s, IN(ct.estateList) e"
        + " WHERE ct.categoryName = :categoryName AND"
        + " e MEMBER OF s.estateList AND"
//        + " :dateNow BETWEEN e.estateStartDay AND e.estateEndDay AND"
        + " e.estateStartDay < :dateMow AND e.estateEndDay > :dateNow AND"
        + " e.isEnabled = 'true' AND e.isPaid = 'true'"
        + " ORDER BY s.subscribeID DESC, e.estateStartDay DESC")
})

public class Estate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Estate_ID", nullable = false, length = 30)
    private String estateID;
    @Size(max = 300)
    @Column(name = "Estate_Title", length = 300)
    private String estateTitle;
    @Size(max = 15)
    @Column(name = "Estate_Start_Day", length = 15)
    private String estateStartDay;
    @Size(max = 15)
    @Column(name = "Estate_End_Day", length = 15)
    private String estateEndDay;
    @Size(max = 200)
    @Column(name = "Estate_Address", length = 200)
    private String estateAddress;
    @Size(max = 1073741823)
    @Column(name = "Estate_Content", length = 1073741823)
    private String estateContent;
    @Size(max = 50)
    @Column(name = "Estate_Area", length = 50)
    private String estateArea;
    @Size(max = 30)
    @Column(name = "Estate_Value", length = 30)
    private String estateValue;
    @Size(max = 50)
    @Column(name = "Estate_Driveway", length = 50)
    private String estateDriveway;
    @Size(max = 30)
    @Column(name = "Estate_Direction", length = 30)
    private String estateDirection;
    @Size(max = 30)
    @Column(name = "Estate_Number_Of_Rooms", length = 30)
    private String estateNumberOfRooms;
    @Size(max = 30)
    @Column(name = "Estate_Number_Of_Floors", length = 30)
    private String estateNumberOfFloors;
    @Size(max = 30)
    @Column(name = "Estate_Number_Of_Toilets", length = 30)
    private String estateNumberOfToilets;
    @Size(max = 100)
    @Column(name = "Estate_NumOfView", length = 100)
    private String estateNumOfView;
    @Size(max = 5)
    @Column(name = "Is_Enabled", length = 5)
    private String isEnabled;
    @Size(max = 5)
    @Column(name = "Is_Paid", length = 5)
    private String isPaid;
    @Size(max = 20)
    @Column(name = "SumValue", length = 20)
    private String sumValue;
    @JoinColumn(name = "TypeOfEstate_ID", referencedColumnName = "TypeOfEstate_ID")
    @ManyToOne
    private TypeOfEstate typeOfEstateID;
    @JoinColumn(name = "Subscribe_ID", referencedColumnName = "Subscribe_ID")
    @ManyToOne
    private Subscribe subscribeID;
    @JoinColumn(name = "UserName", referencedColumnName = "UserName")
    @ManyToOne
    private Member1 userName;
    @JoinColumn(name = "Image_Category_ID", referencedColumnName = "Image_Category_ID")
    @ManyToOne
    private ImageCategory imageCategoryID;
    @JoinColumn(name = "District_ID", referencedColumnName = "District_ID")
    @ManyToOne
    private District districtID;
    @JoinColumn(name = "Currency_ID", referencedColumnName = "Currency_ID")
    @ManyToOne
    private Currency currencyID;
    @JoinColumn(name = "Contact_Details_ID", referencedColumnName = "Contact_Details_ID")
    @ManyToOne
    private ContactDetails contactDetailsID;
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    @ManyToOne
    private Category categoryID;

    public Estate() {
    }

    public Estate(String estateID) {
        this.estateID = estateID;
    }

    public String getEstateID() {
        return estateID;
    }

    public void setEstateID(String estateID) {
        this.estateID = estateID;
    }

    public String getEstateTitle() {
        return estateTitle;
    }

    public void setEstateTitle(String estateTitle) {
        this.estateTitle = estateTitle;
    }

    public String getEstateStartDay() {
        return estateStartDay;
    }

    public void setEstateStartDay(String estateStartDay) {
        this.estateStartDay = estateStartDay;
    }

    public String getEstateEndDay() {
        return estateEndDay;
    }

    public void setEstateEndDay(String estateEndDay) {
        this.estateEndDay = estateEndDay;
    }

    public String getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(String estateAddress) {
        this.estateAddress = estateAddress;
    }

    public String getEstateContent() {
        return estateContent;
    }

    public void setEstateContent(String estateContent) {
        this.estateContent = estateContent;
    }

    public String getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(String estateArea) {
        this.estateArea = estateArea;
    }

    public String getEstateValue() {
        return estateValue;
    }

    public void setEstateValue(String estateValue) {
        this.estateValue = estateValue;
    }

    public String getEstateDriveway() {
        return estateDriveway;
    }

    public void setEstateDriveway(String estateDriveway) {
        this.estateDriveway = estateDriveway;
    }

    public String getEstateDirection() {
        return estateDirection;
    }

    public void setEstateDirection(String estateDirection) {
        this.estateDirection = estateDirection;
    }

    public String getEstateNumberOfRooms() {
        return estateNumberOfRooms;
    }

    public void setEstateNumberOfRooms(String estateNumberOfRooms) {
        this.estateNumberOfRooms = estateNumberOfRooms;
    }

    public String getEstateNumberOfFloors() {
        return estateNumberOfFloors;
    }

    public void setEstateNumberOfFloors(String estateNumberOfFloors) {
        this.estateNumberOfFloors = estateNumberOfFloors;
    }

    public String getEstateNumberOfToilets() {
        return estateNumberOfToilets;
    }

    public void setEstateNumberOfToilets(String estateNumberOfToilets) {
        this.estateNumberOfToilets = estateNumberOfToilets;
    }

    public String getEstateNumOfView() {
        return estateNumOfView;
    }

    public void setEstateNumOfView(String estateNumOfView) {
        this.estateNumOfView = estateNumOfView;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getSumValue() {
        return sumValue;
    }

    public void setSumValue(String sumValue) {
        this.sumValue = sumValue;
    }

    public TypeOfEstate getTypeOfEstateID() {
        return typeOfEstateID;
    }

    public void setTypeOfEstateID(TypeOfEstate typeOfEstateID) {
        this.typeOfEstateID = typeOfEstateID;
    }

    public Subscribe getSubscribeID() {
        return subscribeID;
    }

    public void setSubscribeID(Subscribe subscribeID) {
        this.subscribeID = subscribeID;
    }

    public Member1 getUserName() {
        return userName;
    }

    public void setUserName(Member1 userName) {
        this.userName = userName;
    }

    public ImageCategory getImageCategoryID() {
        return imageCategoryID;
    }

    public void setImageCategoryID(ImageCategory imageCategoryID) {
        this.imageCategoryID = imageCategoryID;
    }

    public District getDistrictID() {
        return districtID;
    }

    public void setDistrictID(District districtID) {
        this.districtID = districtID;
    }

    public Currency getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Currency currencyID) {
        this.currencyID = currencyID;
    }

    public ContactDetails getContactDetailsID() {
        return contactDetailsID;
    }

    public void setContactDetailsID(ContactDetails contactDetailsID) {
        this.contactDetailsID = contactDetailsID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estateID != null ? estateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estate)) {
            return false;
        }
        Estate other = (Estate) object;
        if ((this.estateID == null && other.estateID != null) || (this.estateID != null && !this.estateID.equals(other.estateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.Estate[ estateID=" + estateID + " ]";
    }
    
}
