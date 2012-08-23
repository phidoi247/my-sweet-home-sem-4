/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Welcome
 */
@Named(value = "fileUpload")
@SessionScoped
public class FileUpload implements Serializable {

    /**
     * Creates a new instance of FileUpload
     */
    public FileUpload() {
    }
    
    private String destination = "C:\\tmp\\";
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }
    
    public void setFile(UploadedFile file) {
        this.file = file; 
    }
   
    public void transferFile(String fileName, InputStream in){
        try {
            OutputStream out = new  FileOutputStream(new File(destination + fileName));
            int reader = 0;
            byte[] bytes = new byte[(int)getFile().getSize()];
            
            while ((reader = in.read(bytes)) != -1){
                out.write(bytes, 0, reader);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
   
    
    public void upload() {
        String extValidate;
        if (getFile() != null) {
            String ext = getFile().getFileName();
            
            if (ext != null) {
                extValidate = ext.substring(ext.indexOf(".")+1);
                
            } else {
                extValidate = "null";
            }
            
            if (extValidate.equals("pdf")) {
                try {
                    transferFile(getFile().getFileName(), getFile().getInputstream() );
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Wrong", "Error uploading file"));
                }
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("succeed", "Uploading file successfully"));
                
            }
            
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "You need select a file"));
        }
        
        
    }
}
