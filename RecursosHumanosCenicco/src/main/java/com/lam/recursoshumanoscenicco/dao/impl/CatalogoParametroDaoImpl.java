package com.lam.recursoshumanoscenicco.dao.impl;

import com.lam.recursoshumanoscenicco.dao.CatalogoParametroDao;
import com.lam.recursoshumanoscenicco.exception.CodigoErrorEnum;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String,CatalogoParametro> findParametroBy(String parametro) throws DaoException {
        Map<String,CatalogoParametro> mapCatalogoParam = new HashMap<>();
        try {
            CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<CatalogoParametro> query = builder.createQuery(CatalogoParametro.class);
            Root<CatalogoParametro> root = query.from(CatalogoParametro.class);
            query.select(root).where(builder.equal(root.get("parametro"), parametro));
            Query<CatalogoParametro> q = getSessionFactory().getCurrentSession().createQuery(query);
            List<CatalogoParametro> list = q.getResultList();
            if (list.size() > 0) {
                list.forEach((param) -> {
                    String key = param.getValor();
                    if (mapCatalogoParam.get(key) == null) {
                        mapCatalogoParam.put(key, param);
                    }
                });
            }
            return mapCatalogoParam;
        } catch (Exception e) {
            throw new DaoException(CodigoErrorEnum.ERROR_CONSULTAR_BD,
                    "Error el parametro por el parámetro: ".concat(parametro), e);
        }
    }

}
