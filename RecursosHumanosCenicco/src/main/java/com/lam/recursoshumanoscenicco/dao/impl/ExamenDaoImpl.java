package com.lam.recursoshumanoscenicco.dao.impl;

import org.springframework.stereotype.Repository;

import com.lam.recursoshumanoscenicco.dao.ExamenDao;
import com.lam.recursoshumanoscenicco.exception.CodigoErrorEnum;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.model.Examen;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

@Repository
public class ExamenDaoImpl extends GenericDaoImpl<Examen, Long> implements ExamenDao {

    /**
     *
     */
    private static final long serialVersionUID = 1411460588334327245L;

    @Override
    public List<Examen> buscarExamenesPor(CatalogoParametro catalogoParametro) throws DaoException {
        try {
            CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Examen> query = builder.createQuery(Examen.class);
            Root<Examen> root = query.from(Examen.class);
            query.select(root).where(builder.equal(root.get("catalogoParametro"), catalogoParametro));
            Query<Examen> q = getSessionFactory().getCurrentSession().createQuery(query);
            List<Examen> list = q.getResultList();
            return list;
        } catch (Exception e) {
            throw new DaoException(CodigoErrorEnum.ERROR_CONSULTAR_BD,
                    "Error al consultar los exámenes por tipo".concat(catalogoParametro.getDescripcion()), e);
        }

    }

}
