/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Category;
import com.mysweethome.session.CategoryFacade;
import java.util.ArrayList;
import java.util.Iterator;
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
    List<String> categoryName= new ArrayList<String>();

    public List<String> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(List<String> categoryName) {
        this.categoryName = categoryName;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    CategoryFacade catefacade;
    
    public List<Category> getListCategory(){
        return catefacade.getAllCategory();
    }
    
    public List<String> getListCategoryName(){
        List<Category> a=catefacade.getAllCategory();   
        List<String> results = new ArrayList<String>();  
          Iterator iterator = a.iterator();
//        for (int i = 0; i < a.size(); i++) {  
//            results.add(a.(i).getCategoryName());
//        }  
          
          while(iterator.hasNext()){
              Category cate = (Category) iterator.next();
              System.out.println(cate.getCategoryName());
              results.add(cate.getCategoryName());
          }
        return results;  
    }
    
    public List<String> getColumnCategoryName(){
         //List<String> categoryName= new ArrayList<String>();
//         setCategoryName(catefacade.getColumnCategoryName());
//         return "/test2";
         return catefacade.getColumnCategoryName();
    }
}
