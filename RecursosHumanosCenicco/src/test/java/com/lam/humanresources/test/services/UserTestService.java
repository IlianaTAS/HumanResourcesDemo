package com.lam.humanresources.test.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Menu;
import com.lam.recursoshumanoscenicco.model.Perfil;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationcontext.xml" })
public class UserTestService {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	@Ignore
	public void createTest() {

		Usuario usuario=new Usuario();
		usuario.setFechaRegistro(new Date());
		usuario.setEliminado(0);
		usuario.setApellidoPaterno("Perez");
		usuario.setApellidoMaterno("Garcia");
		usuario.setNombre("Iliana");
		usuario.setEstatus("A");
		usuario.setNombreUsuario("ilianaPG");
		usuario.setContrasena("1234");
		Perfil perfil=new Perfil();
		perfil.setIdPerfil(1l);
		usuario.setPerfil(perfil);
//                usuarioService.guardar(usuario);
		fail("Not yet implemented");
	}

	@Test
//	@Ignore
	public void findUserTest() {
		Usuario usuario;
		try {
			usuario = usuarioService.findUsuarioBy("angelraulgs");
			Perfil perfil=usuario.getPerfil();
			Set<Menu>menus=perfil.getMenus();
			
			System.out.println(usuario.getPerfil().getRol().size());
		} catch (ServiceException e) {
			logger.error("Error consultar Usuario",e);
		}
		
	}
}
