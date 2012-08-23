/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;



import com.mysweethome.entity.ImageCategory;
import com.mysweethome.session.ImageCategoryFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Welcome
 */
@ManagedBean(name = "imageMBean")
@SessionScoped
public class ImageMBean implements Serializable {
    @EJB
    public ImageCategoryFacade imageCategoryFacade;

    /**
     * Creates a new instance of ImageMBean
     */
    ImageCategory imageCate;

    public ImageCategory getImageCate() {
        return imageCate;
    }

    public void setImageCate(ImageCategory imageCate) {
        this.imageCate = imageCate;
    }

    public ImageCategoryFacade getImageCategoryFacade() {
        return imageCategoryFacade;
    }

    public void setImageCategoryFacade(ImageCategoryFacade imageCategoryFacade) {
        this.imageCategoryFacade = imageCategoryFacade;
    }

    public List<ImageCategory> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<ImageCategory> imagesList) {
        this.imagesList = imagesList;
    }
    
    public List<ImageCategory> imagesList;

    public List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

  
    
    public ImageMBean() {
    }
    
    @PostConstruct
    public void init() {
        images=getImageOfEstate("1");
    }
    
    public List<String> getImageOfEstate(String estateID){
        images=imageCategoryFacade.getImagesOfEstate(estateID);
        return images;
    }
}
