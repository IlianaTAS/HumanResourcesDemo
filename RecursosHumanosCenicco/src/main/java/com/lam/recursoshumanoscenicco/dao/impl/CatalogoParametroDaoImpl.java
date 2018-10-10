package com.lam.recursoshumanoscenicco.dao.impl;

import com.lam.recursoshumanoscenicco.dao.CatalogoParametroDao;
import com.lam.recursoshumanoscenicco.exception.CodigoErrorEnum;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoParametroDaoImpl extends GenericDaoImpl<CatalogoParametro, Long> implements CatalogoParametroDao {

    /**
     *
     */
    private static final long serialVersionUID = -8867663537310802772L;

    @Override
    public CatalogoParametro findParametroBy(String valor) throws DaoException {
        CatalogoParametro parametro = null;
        try {
            CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<CatalogoParametro> query = builder.createQuery(CatalogoParametro.class);
            Root<CatalogoParametro> root = query.from(CatalogoParametro.class);
            query.select(root).where(builder.equal(root.get("valor"), valor));
            Query<CatalogoParametro> q = getSessionFactory().getCurrentSession().createQuery(query);
            List<CatalogoParametro> list = q.getResultList();
            if (list.size() > 0) {
                parametro = list.get(0);
            }

            return parametro;
        } catch (Exception e) {
            throw new DaoException(CodigoErrorEnum.ERROR_CONSULTAR_BD,
                    "Error el parametro por el valor: ".concat(valor), e);
        }
    }

}
