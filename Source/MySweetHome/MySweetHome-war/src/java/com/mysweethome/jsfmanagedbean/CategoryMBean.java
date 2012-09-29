/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Category;
import com.mysweethome.helper.messages;
import com.mysweethome.session.CategoryFacade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author LongVu
 */
@ManagedBean(name = "CategoryMBean")
@SessionScoped
public class CategoryMBean {

    @EJB
    Category category;
    Category catenew;
    CategoryFacade categoryFacede;
    List<String> categoryName = new ArrayList<String>();
    List<Category> catelist;
    List<Category> filteredCategory;
    /**
     * Creates a new instance of CategoryMBean
     */
    public CategoryMBean() {
    }

    public CategoryFacade getCategoryFacede() {
        return categoryFacede;
    }

    public void setCategoryFacede(CategoryFacade categoryFacede) {
        this.categoryFacede = categoryFacede;
    }

    public Category getCatenew() {
        return catenew;
    }

    public void setCatenew(Category catenew) {
        this.catenew = catenew;
    }


    public List<Category> getFilteredCategory() {
        filteredCategory = catelist;
        return filteredCategory;
    }

    public void setFilteredCategory(List<Category> filteredCategory) {
        this.filteredCategory = filteredCategory;
    }

    public CategoryFacade getCatefacade() {
        return catefacade;
    }

    public void setCatefacade(CategoryFacade catefacade) {
        this.catefacade = catefacade;
    }

    public List<Category> getCatelist() {
        catelist = getCategoryFacede().findAll();
        return catelist;
    }

    public void setCatelist(List<Category> catelist) {
        this.catelist = catelist;
    }

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

    public List<Category> getListCategory() {
        return catefacade.getAllCategory();
    }

    public List<String> getListCategoryName() {
        List<Category> a = catefacade.getAllCategory();
        List<String> results = new ArrayList<String>();
        Iterator iterator = a.iterator();
//        for (int i = 0; i < a.size(); i++) {  
//            results.add(a.(i).getCategoryName());
//        }  

        while (iterator.hasNext()) {
            Category cate = (Category) iterator.next();
            System.out.println(cate.getCategoryName());
            results.add(cate.getCategoryName());
        }
        return results;
    }

    public List<String> getColumnCategoryName() {
        //List<String> categoryName= new ArrayList<String>();
        setCategoryName(catefacade.getColumnCategoryName());
//         return "/test2";
        return categoryName;
    }

    public SelectItem[] getTypeOfEstateName() {
        List<Category> types = catefacade.getAllCategory();
        SelectItem[] type1 = null;
        if (types != null) {
            type1 = new SelectItem[types.size()];
            for (int i = 0; i < types.size(); i++) {
                type1[i] = new SelectItem(types.get(i).getCategoryName(), types.get(i).getCategoryName());
            }
        }
        return type1;
    }
//
//    public void editCategory(Category cate) {
//        getCatefacade().edit(cate);
//        messages.taoTB(FacesMessage.SEVERITY_INFO, "Edit success", "Edit success");
//        this.category = new Category();
//    }
//
//    public void removeCategory(String id) {
//        if (id != null) {
//            Category temp = new Category();
//            temp = getCategoryFacede().getCategoryID(id);
//            getCatefacade().remove(temp);
//            messages.taoTB(FacesMessage.SEVERITY_INFO, "Delete success", "Delete success");
//        }
//        this.category = new Category();
//    }
////    
//
//    public void createCategory() {
//        if (catenew.getCategoryID() != null) {
//            Category temp = new Category();
//            temp = getCategoryFacede().getCategoryID(catenew.getCategoryID());
//            if (temp != null) {
//                messages.taoTB(FacesMessage.SEVERITY_WARN, "Duplicate!", "This ID had already");
//            } else {
//                Category categorytemp = new Category();
//                categorytemp.setCategoryID(catenew.getCategoryID());
//                categorytemp.setCategoryName(catenew.getCategoryName());
//                getCategoryFacede().create(categorytemp);
//                messages.taoTB(FacesMessage.SEVERITY_INFO, "Create success!", "Create category success!");
//            }
//        }
//        this.catenew = new Category();
//    }
}
