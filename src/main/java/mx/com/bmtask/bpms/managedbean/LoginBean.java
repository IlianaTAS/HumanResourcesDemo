/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bmtask.bpms.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * @author BMTHP02
 */
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

    private String user;
    private String password;

    protected String inicio_;

    public LoginBean() {

    }

    @PostConstruct
    private void init() {
        this.user = "";
        this.password = "";
    }

    public void login() throws IOException {
        FacesMessage msg;

        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", this.user);

        FacesContext.getCurrentInstance().addMessage(null, msg);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        ec.redirect(ec.getRequestContextPath() + "/principal.xhtml");

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
