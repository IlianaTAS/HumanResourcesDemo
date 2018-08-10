/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bmtask.bpms.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author BMTHP02
 */
public class Util {

    public static void mensaje(String summary, String detail, FacesMessage.Severity severity) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
