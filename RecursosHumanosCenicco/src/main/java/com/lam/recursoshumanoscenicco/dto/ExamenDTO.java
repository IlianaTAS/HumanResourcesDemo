/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.dto;

import com.lam.recursoshumanoscenicco.model.Pregunta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iperez
 */
public class ExamenDTO {
    
    private int peguntasAbiertas;
    private int preguntasCerradas;
    private int preguntasMultiples;
    
    private List<Pregunta> preguntas = new ArrayList<>();

    public int getPeguntasAbiertas() {
        return peguntasAbiertas;
    }

    public void setPeguntasAbiertas(int peguntasAbiertas) {
        this.peguntasAbiertas = peguntasAbiertas;
    }

    public int getPreguntasCerradas() {
        return preguntasCerradas;
    }

    public void setPreguntasCerradas(int preguntasCerradas) {
        this.preguntasCerradas = preguntasCerradas;
    }

    public int getPreguntasMultiples() {
        return preguntasMultiples;
    }

    public void setPreguntasMultiples(int preguntasMultiples) {
        this.preguntasMultiples = preguntasMultiples;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
}
