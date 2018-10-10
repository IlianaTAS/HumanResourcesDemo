package com.lam.humanresources.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Menu;
import com.lam.recursoshumanoscenicco.service.MenuService;

/**
 * 
 * @author Raul Garcia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationcontext.xml" })
public class MenuTestService {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private  MenuService menuService;
	
	@Test
	public void guardar() {
		Menu menu=new  Menu();
		menu.setNombre("Exámenes Psicométricos");
		menu.setIcono("ui-icon-clipboard");
		menu.setUrl("../../configuracion/catalogosReclutamiento/examenPsicometrico.xhtml");
		menu.setModulo("configuracion");
		
		try {
			menuService.guardar(menu);
		} catch (ServiceException e) {
			logger.error("Error al guardar menu", e);
		}
	}

}
