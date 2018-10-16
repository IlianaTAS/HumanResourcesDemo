/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bmtask.bpms.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author BMT
 */
public class AlarmaBean implements Serializable {

    protected List<String> alarmas;
    protected int numeroAlertas;

    public AlarmaBean() {
        this.alarmas = new ArrayList<>();
    }

    public void mostrarAlarma() {
        alarmas = new ArrayList<>();
        alarmas.add("Requerimiento próximo a vencer: Desarrolador Java Sr.|IBM|Monterrey");
        alarmas.add("Nuevo requerimiento: Analista de Sistemas.|NUBAJ|D.F");
        alarmas.add("Verificación de referencias: Vacante 001|Iliana Pérez|Líder de Proyecto");
     }

    public void clickButtonAlerta() {
//        for (Object object : list) {
//            if (object instanceof Historicoalarmas) {
//                Historicoalarmas historicoA = (Historicoalarmas) object;
//                mostrarMensajeAlarma(historicoA);
//            }
//        }
    }

    
    public int getNumeroAlertas() {
        return numeroAlertas;
    }

    public void setNumeroAlertas(int numeroAlertas) {
        this.numeroAlertas = numeroAlertas;
    }

    public List<String> getAlarmas() {
        return alarmas;
    }
}