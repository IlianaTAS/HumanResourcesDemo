package com.lam.recursoshumanoscenicco.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lam.recursoshumanoscenicco.model.Menu;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.MenuService;
import com.lam.recursoshumanoscenicco.utils.SpringSecurityUtils;

public class InitMenuController {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	private MenuService menuService;
	
	private MenuModel menuModel;
	
	private Usuario usuario;
	
	private boolean habilitarModulo=false;
	
	@PostConstruct
	public void init() {
		menuModel=new DefaultMenuModel();
		usuario=SpringSecurityUtils.getUsuarioAutenticado();
		if(usuario!=null) {
			setHabilitarModulo(true);	
			String modulo=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("modulo");
			if(modulo!=null && !modulo.isEmpty()) {
				List<Menu> listMenu=usuario.getPerfil().getMenus().stream().
						filter(item-> item.getModulo().equals(modulo)).collect(Collectors.toList());
				listMenu.forEach(item->{
					DefaultMenuItem itemMenu=new DefaultMenuItem(item.getNombre());
					itemMenu.setUrl(item.getUrl());
					itemMenu.setIcon(item.getIcono());
					menuModel.addElement(itemMenu);
				});
			}
		}
			
	}

	public void construirMenuModulo(ActionEvent actionEvent) {
		String param = (String) actionEvent.getComponent().getAttributes().get("modulo");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("modulo", param);
		List<Menu> listMenu=usuario.getPerfil().getMenus().stream().
				filter(item-> item.getModulo().equals(param)).collect(Collectors.toList());
		String urlInicioModulo=listMenu.get(0).getUrl();
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
			context.getExternalContext().redirect(request.getContextPath().concat(urlInicioModulo));
		} catch (IOException e) {
			logger.error("Error al redireccionar pagina {}", urlInicioModulo,e);
		}
	}
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public boolean isHabilitarModulo() {
		return habilitarModulo;
	}

	public void setHabilitarModulo(boolean habilitarModulo) {
		this.habilitarModulo = habilitarModulo;
	}

}
