package com.lam.recursoshumanoscenicco.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;

//@Component
//@Scope("session")
public class LoginController implements PhaseListener, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8548994735436731715L;
	
	
	private String userName;
	
	private String password;

	
	public String doLogin() throws IOException, ServletException {		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userName);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/login");
		
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();

		
		return null;
	}
	
	public void logOut() {
		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
					.getRequestDispatcher("/logout");
			dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (e instanceof BadCredentialsException) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas!",
                            "Verificar valores de entrada."));
        }else if(e instanceof UsernameNotFoundException) {
        	FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
        	.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error", "No existe el usuario"));
        }else if (e instanceof InternalAuthenticationServiceException) {
        	FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
        	.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error ", "El usuario no existe.."));
        }
		
	}

	public MenuModel getMenuModel() {
		MenuModel menuModel=new DefaultMenuModel();
		
		DefaultMenuItem item=new DefaultMenuItem("Exámenes Psicométricos");
		item.setUrl("../../configuracion/catalogosReclutamiento/examenPsicometrico.xhtml");
		item.setIcon("ui-icon-clipboard");
		menuModel.addElement(item);
		DefaultMenuItem item2=new DefaultMenuItem("Exámenes Técnicos");
		item.setUrl("../../configuracion/catalogosReclutamiento/examenTecnico.xhtml");
		item.setIcon("ui-icon-document");
		menuModel.addElement(item2);
		
		DefaultMenuItem item3=new DefaultMenuItem("Exámenes Técnicos");
		item.setUrl("../../configuracion/catalogosReclutamiento/examenTecnico.xhtml");
		item.setIcon("ui-icon-document");
		menuModel.addElement(item3);
		
		DefaultMenuItem item4=new DefaultMenuItem("Exámenes Técnicos");
		item.setUrl("../../configuracion/catalogosReclutamiento/examenTecnico.xhtml");
		item.setIcon("ui-icon-document");
		menuModel.addElement(item4);
		return menuModel;
	}
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
