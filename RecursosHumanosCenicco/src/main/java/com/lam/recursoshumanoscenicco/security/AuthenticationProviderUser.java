package com.lam.recursoshumanoscenicco.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lam.recursoshumanoscenicco.model.Rol;
import com.lam.recursoshumanoscenicco.service.UsuarioService;

public class AuthenticationProviderUser implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.lam.recursoshumanoscenicco.model.Usuario usuario = null;
    	if (username == null) throw new UsernameNotFoundException("No se ha encontrado el usuario que se desea logear. usuario es nulo.");

		try {
			usuario = this.usuarioService.findUsuarioBy(username);
			if (usuario != null) {
				


				final List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

				for (Rol rol : usuario.getPerfil().getRol()) {
					authList.add(new SimpleGrantedAuthority(rol.getNombre()));
				}

				return new User(username, usuario.getContrasena(), true, true, true, true, authList);

			} else {
	            throw new DataRetrievalFailureException("Error en el authentication provider, no se pudo encontrar al usuario[" + username + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
            throw new DataRetrievalFailureException("Error en el authentication provider, no se pudo encontrar al usuario[" + username + "]");
		}

	}

}
