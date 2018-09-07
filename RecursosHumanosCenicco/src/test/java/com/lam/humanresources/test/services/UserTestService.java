package com.lam.humanresources.test.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lam.recursoshumanoscenicco.model.Perfil;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationcontext.xml" })
public class UserTestService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Test
//	@Ignore
	public void createTest() {
		Usuario usuario=new Usuario();
		usuario.setFechaRegistro(new Date());
		usuario.setEliminado(0);
		usuario.setApellidoPaterno("Garcia");
		usuario.setApellidoMaterno("Saldivar");
		usuario.setNombre("Anegel");
		usuario.setEstatus("A");
		usuario.setNombreUsuario("angelraulgs");
		usuario.setContrasena("1234");
		Perfil perfil=new Perfil();
		perfil.setIdPerfil(1l);
		usuario.setPerfil(perfil);
		usuarioService.saveUsuario(usuario);
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void findUserTest() {
		Usuario usuario=usuarioService.findUsuarioBy("angelraulgs");
		
		System.out.println(usuario.getPerfil().getRol().size());
	}
}
