package com.lam.recursoshumanoscenicco.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.lam.recursoshumanoscenicco.dto.UsuarioDTO;
import com.lam.recursoshumanoscenicco.model.Usuario;

public class SpringSecurityUtils {
	
	public static Usuario getUsuarioAutenticado() {
		Usuario usuarioActual=null;
		final SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			final Authentication auth = context.getAuthentication();
			if (auth != null) {
				UsuarioDTO dto = (UsuarioDTO) auth.getPrincipal();
				usuarioActual=dto.getUsuario();
			}
		}

		return usuarioActual;
	}

}
