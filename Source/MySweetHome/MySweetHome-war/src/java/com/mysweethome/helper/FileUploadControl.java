/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.helper;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Garena
 */
@ManagedBean(name="fileUpLoad")
@SessionScoped
public class FileUploadControl implements Serializable{
    private String destination="F:\\My Sweet Home\\Source\\MySweetHome\\MySweetHome-war\\web\\WEB-INF\\fileupload\\";

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    private UploadedFile file;
    /**
     * Creates a new instance of FileUploadControl
     */
    public FileUploadControl() {
        
    }
        public void TransferFile(String fileName, InputStream in){
        try{
            OutputStream out=new FileOutputStream(new File(destination+fileName));
            int reader=0;
            byte[] bytes=new byte[(int)getFile().getSize()];
            while((reader=in.read(bytes)) !=-1){
                out.write(bytes, 0 , reader);
            }
            in.close();
            out.flush();
            out.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
        public void upLoad(){
        String extValidate;
        if(getFile()!=null){
            String ext=getFile().getFileName();
            if(ext!=null){
                extValidate=ext.substring(ext.indexOf(".")+1);
            }else {extValidate="null";}

                if(extValidate.equals("jpg") || extValidate.equals("png")){
                    try{
                        TransferFile(getFile().getFileName(), getFile().getInputstream());
                    }catch(IOException e){
                          Logger.getLogger(FileUpLoad.class.getName()).log(Level.SEVERE,null,e);
                          FacesContext context=FacesContext.getCurrentInstance();
                          context.addMessage(null, new FacesMessage("Wrong","Error upLoading File"));

                        }
                    FacesContext context=FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Success", getFile().getFileName()+ "is upload. typecontent"+getFile().getContentType()+"tamafio"+getFile().getSize()));
                    }else{
                        FacesContext context=FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("WRONG_ext","only extensiton .png or jpg"));
                 }
                    }else{
                        FacesContext context=FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("WRONG_ext","select a file !!!"));
                    }
        

            }
}
