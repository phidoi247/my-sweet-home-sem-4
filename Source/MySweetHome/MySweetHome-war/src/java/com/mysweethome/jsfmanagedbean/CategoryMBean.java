/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Category;
import com.mysweethome.session.CategoryFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Garena
 */
@ManagedBean (name ="CategoryMBean")
@SessionScoped
public class CategoryMBean {
    @EJB
    private CategoryFacade categoryFacade;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    private Category category;
    

    /**
     * Creates a new instance of CategoryMBean
     */
    public CategoryMBean() {
        
        category =new Category();
        categoryFacade=new CategoryFacade();
    }
    public void createCategory(){
        category.getCategoryID();
        category.getCategoryName();
        category.getEstateList();
        
        categoryFacade.create(category);
    }
    
    public void editCategory(){
        String str=category.getCategoryID();
        Category cate=categoryFacade.getCategoryID(str);
        cate.setCategoryName(category.getCategoryName());
        cate.setEstateList(category.getEstateList());
        
        categoryFacade.edit(cate);
    }
    
    public void removeCategory(){
        String str=category.getCategoryID();
        category.setCategoryID(str);
        categoryFacade.remove(category);
    }
}
