package com.lam.recursoshumanoscenicco.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import com.lam.recursoshumanoscenicco.dao.UsuarioDao;
import com.lam.recursoshumanoscenicco.model.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Long>  implements UsuarioDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public Usuario findUsuarioBy(String nombreUsuario) {
		Usuario usuario=null;
		try {
			CriteriaBuilder builder =getSessionFactory().getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
			Root<Usuario> root = query.from(Usuario.class);
	        query.select(root).where(builder.equal(root.get("nombreUsuario"), nombreUsuario));
			Query<Usuario> q=getSessionFactory().getCurrentSession().createQuery(query);
			List<Usuario> list=q.getResultList();
			if(list.size()>0) 
				usuario=list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
