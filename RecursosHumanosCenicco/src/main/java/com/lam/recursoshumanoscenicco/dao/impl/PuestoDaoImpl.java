package com.lam.recursoshumanoscenicco.dao.impl;

import org.springframework.stereotype.Repository;

import com.lam.recursoshumanoscenicco.dao.PuestoDao;
import com.lam.recursoshumanoscenicco.exception.CodigoErrorEnum;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.Puesto;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

@Repository
public class PuestoDaoImpl extends GenericDaoImpl<Puesto, Long> implements PuestoDao {

    /**
     *
     */
    private static final long serialVersionUID = 6596272021454656230L;

    @Override
    public List<Puesto> findPuestos() throws DaoException {
        try {
            CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Puesto> query = builder.createQuery(Puesto.class);
            Root<Puesto> root = query.from(Puesto.class);
            query.select(root);
            Query<Puesto> q = getSessionFactory().getCurrentSession().createQuery(query);
            return q.getResultList();
        } catch (Exception e) { 
            throw new DaoException(CodigoErrorEnum.ERROR_CONSULTAR_BD,
                    "Error al consultar los puestos", e);
        }
    }

}
