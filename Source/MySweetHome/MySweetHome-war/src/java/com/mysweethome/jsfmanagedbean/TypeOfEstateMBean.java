/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.TypeOfEstate;
import com.mysweethome.session.TypeOfEstateFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="TypeofEstateMBean")
@SessionScoped
public class TypeOfEstateMBean {

    /**
     * Creates a new instance of TypeOfEstateMBean
     */
    public TypeOfEstateMBean() {
    }
    @EJB
    TypeOfEstate type;

    public TypeOfEstate getType() {
        return type;
    }

    public void setType(TypeOfEstate type) {
        this.type = type;
    }

    public List<TypeOfEstate> getTypeEstateList() {
        return typefacade.findAll();
    }

    public void setTypeEstateList(List<TypeOfEstate> typeEstateList) {
        this.typeEstateList = typeEstateList;
    }

    public TypeOfEstateFacade getTypefacade() {
        return typefacade;
    }

    public void setTypefacade(TypeOfEstateFacade typefacade) {
        this.typefacade = typefacade;
    }
    TypeOfEstateFacade typefacade;
    List<TypeOfEstate> typeEstateList = new ArrayList<TypeOfEstate>();
}
