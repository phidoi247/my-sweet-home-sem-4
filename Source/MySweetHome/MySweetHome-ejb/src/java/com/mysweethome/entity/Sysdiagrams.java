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
@Table(name = "sysdiagrams", catalog = "MySweetHome", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"principal_id", "name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sysdiagrams.findAll", query = "SELECT s FROM Sysdiagrams s"),
    @NamedQuery(name = "Sysdiagrams.findByName", query = "SELECT s FROM Sysdiagrams s WHERE s.name = :name"),
    @NamedQuery(name = "Sysdiagrams.findByPrincipalId", query = "SELECT s FROM Sysdiagrams s WHERE s.principalId = :principalId"),
    @NamedQuery(name = "Sysdiagrams.findByDiagramId", query = "SELECT s FROM Sysdiagrams s WHERE s.diagramId = :diagramId"),
    @NamedQuery(name = "Sysdiagrams.findByVersion", query = "SELECT s FROM Sysdiagrams s WHERE s.version = :version")})
public class Sysdiagrams implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "principal_id", nullable = false)
    private int principalId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagram_id", nullable = false)
    private Integer diagramId;
    @Column(name = "version")
    private Integer version;
    @Lob
    @Column(name = "definition")
    private byte[] definition;

    public Sysdiagrams() {
    }

    public Sysdiagrams(Integer diagramId) {
        this.diagramId = diagramId;
    }

    public Sysdiagrams(Integer diagramId, String name, int principalId) {
        this.diagramId = diagramId;
        this.name = name;
        this.principalId = principalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    public Integer getDiagramId() {
        return diagramId;
    }

    public void setDiagramId(Integer diagramId) {
        this.diagramId = diagramId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public byte[] getDefinition() {
        return definition;
    }

    public void setDefinition(byte[] definition) {
        this.definition = definition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagramId != null ? diagramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sysdiagrams)) {
            return false;
        }
        Sysdiagrams other = (Sysdiagrams) object;
        if ((this.diagramId == null && other.diagramId != null) || (this.diagramId != null && !this.diagramId.equals(other.diagramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.Sysdiagrams[ diagramId=" + diagramId + " ]";
    }
    
}
