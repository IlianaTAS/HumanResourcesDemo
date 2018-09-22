package com.lam.recursoshumanoscenicco.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Rol;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.UsuarioService;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	         
	        Usuario usuario;
			try {
				usuario = this.usuarioService.findUsuarioBy(name);
			} catch (ServiceException e) {
				logger.error("Error consultar usuario {}", name,e);
				usuario=null;
			}
			if (usuario != null) {
				


				final List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

				for (Rol rol : usuario.getPerfil().getRol()) {
					authList.add(new SimpleGrantedAuthority(rol.getNombre()));
				}

	            return new UsernamePasswordAuthenticationToken(
	              name, password, authList);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
