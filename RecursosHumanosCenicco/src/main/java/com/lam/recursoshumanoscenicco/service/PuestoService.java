/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.service;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Puesto;
import java.util.List;

/**
 *
 * @author iperez
 */
public interface PuestoService extends GenericService<Puesto, Long>{
    
    public List<Puesto> findPuestos() throws ServiceException;
    
    
}
