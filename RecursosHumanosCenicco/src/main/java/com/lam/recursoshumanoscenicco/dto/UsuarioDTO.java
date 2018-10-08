package com.lam.recursoshumanoscenicco.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.lam.recursoshumanoscenicco.model.Usuario;

public class UsuarioDTO  extends User{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 893887045192211401L;
	
	private Usuario usuario;

	public UsuarioDTO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,Usuario usuario) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.usuario=usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
