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
@Table(name = "District", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findByDistrictID", query = "SELECT d FROM District d WHERE d.districtID = :districtID"),
    @NamedQuery(name = "District.findByDistrictName", query = "SELECT d FROM District d WHERE d.districtName = :districtName"),
    @NamedQuery(name = "District.findByCityID", query = "SELECT d FROM City c, IN(c.districtList) d WHERE c.cityID = :cityID")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "District_ID", nullable = false, length = 30)
    private String districtID;
    @Size(max = 200)
    @Column(name = "District_Name", length = 200)
    private String districtName;
    @OneToMany(mappedBy = "districtID")
    private List<Estate> estateList;
    @JoinColumn(name = "City_ID", referencedColumnName = "City_ID")
    @ManyToOne
    private City cityID;

    public District() {
    }

    public District(String districtID) {
        this.districtID = districtID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @XmlTransient
    public List<Estate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<Estate> estateList) {
        this.estateList = estateList;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtID != null ? districtID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtID == null && other.districtID != null) || (this.districtID != null && !this.districtID.equals(other.districtID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.District[ districtID=" + districtID + " ]";
    }
}
