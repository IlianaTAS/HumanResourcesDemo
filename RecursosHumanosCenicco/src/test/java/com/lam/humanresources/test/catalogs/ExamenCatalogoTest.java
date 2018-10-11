/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.humanresources.test.catalogs;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Examen;
import com.lam.recursoshumanoscenicco.model.Pregunta;
import com.lam.recursoshumanoscenicco.model.Respuesta;
import com.lam.recursoshumanoscenicco.service.CatalogoParametroService;
import com.lam.recursoshumanoscenicco.service.ExamenService;
import com.lam.recursoshumanoscenicco.service.PuestoService;
import java.util.HashSet;
import java.util.Set;
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
@ContextConfiguration(locations = {"file:src/main/resources/applicationcontext.xml"})
public class ExamenCatalogoTest {

    @Autowired
    private ExamenService examenService;

    @Autowired
    private PuestoService puestoService;

    @Autowired
    private CatalogoParametroService catalogoParametroService;

    @Test
    public void test() throws ServiceException {
        System.out.println("Estoy en el test:::::");
        Examen examen = new Examen();
        examen.setDescripcion("Agile LEAD");
        examen.setDuracion("1");
        examen.setCatalogoParametro(catalogoParametroService.buscarPorId(4L));
        examen.setPuesto(puestoService.buscarPorId(3L));
        examen.setPreguntas(this.armarPreguntas());
        Long id = examenService.guardar(examen);
        System.out.println("DEBUG IIPG --> El id del examen" + id);

    }

    private Set<Pregunta> armarPreguntas() throws ServiceException {
        Set<Pregunta> preguntas = new HashSet<>();
        Pregunta preguntaA = new Pregunta();
        preguntaA.setDescripcion("pregunta una");
        preguntaA.setCatalogoParametro(catalogoParametroService.buscarPorId(1L));
        Set<Respuesta> respuestas = armarRespuestas(preguntaA);
        preguntaA.getRespuestas().addAll(respuestas);
        System.out.println("DEBUG IIPG --> cuantas respuestas: " + preguntaA.getRespuestas().size());
        preguntas.add(preguntaA);
        return preguntas;
    }

    private Set<Respuesta> armarRespuestas(Pregunta pregunta) {
        System.out.println("Estoy agregando las respuestas:::::::::");
        Set<Respuesta> respuestas = new HashSet<>();
        Respuesta respuesta = new Respuesta();
        respuesta.setPregunta(pregunta);
        respuesta.setDescripcion("Respuesta correcta");
        respuesta.setEstado("1");
        respuestas.add(respuesta);
        return respuestas;
    }

}
