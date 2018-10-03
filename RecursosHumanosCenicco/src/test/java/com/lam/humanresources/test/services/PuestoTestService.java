/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.humanresources.test.services;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Puesto;
import com.lam.recursoshumanoscenicco.service.PuestoService;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author iperez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationcontext.xml" })
public class PuestoTestService {
    
    @Autowired
    private PuestoService puestoService;
    
//    @Test
    @Ignore
    public void crearPuesto() throws ServiceException {
        System.out.println("DEBUG IIPG --> Estoy en el test crearPuesto::::");
        Puesto puesto = new Puesto();
        puesto.setDescripcion("Java Developer Sr.");
        
        Long idPuesto = this.puestoService.guardar(puesto);
        System.out.println("DEBUG IIPG --> El id del puesto con el que se creo: " + idPuesto);
    }
    
    @Test
    public void consultarPuesto() throws ServiceException {
        System.out.println("DEBUG IIPG --> Estoy en el test consultarPuesto");
        List<Puesto> puestos = this.puestoService.buscarTodo();
        System.out.println("DEBUG IIP --> El size de la lista: " + puestos.size());
    }
    
}
