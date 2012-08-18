/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Category;
import com.mysweethome.session.CategoryFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="CategoryMBean")
@SessionScoped
public class CategoryMBean {

    /**
     * Creates a new instance of CategoryMBean
     */
    public CategoryMBean() {
    }
    
    @EJB
    Category category;
    CategoryFacade catefacade;
    
    public List<Category> getListCategory(){
        return catefacade.getAllCategory();
    }
}
