/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mysweethome.helper;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ngo Quang Huy
 */
public class operationSession {
    public static void createSession(String name, Object value) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute(name, value);
    }
      public static Object getSession(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        return session.getAttribute(name);
    }

    public static void deleteGTsession(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.removeAttribute(name);
    }
}
