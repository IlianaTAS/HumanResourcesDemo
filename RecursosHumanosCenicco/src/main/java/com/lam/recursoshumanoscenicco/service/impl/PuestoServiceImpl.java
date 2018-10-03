/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.service.impl;

import com.lam.recursoshumanoscenicco.dao.PuestoDao;
import com.lam.recursoshumanoscenicco.model.Puesto;
import com.lam.recursoshumanoscenicco.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iperez
 */
@Service
public class PuestoServiceImpl extends GenericAbstractService<Puesto, Long> implements PuestoService {

    private PuestoDao puestoDao;

    @Autowired
    public PuestoServiceImpl(PuestoDao puestoDao) {
        super(puestoDao);
        this.puestoDao = puestoDao;
    }

}
