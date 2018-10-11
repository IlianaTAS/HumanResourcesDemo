/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.utils;

import java.util.Collection;

/**
 *
 * @author iperez
 */
public class Util {

    /**
     * Método que permite imprimir la información de un objeto.
     *
     * @param o Objeto que se desea imprimir.
     * @return la información completa que contiene el objeto.
     */
    public static String debugImprimirContenidoObjecto(Object o) {
        if (null == o) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("Objeto clase: ").append(o.getClass().getName()).append(" - ")
                .append(o.toString()).append('\n');
        try {
            for (java.lang.reflect.Field f : o.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                sb = sb.append(f.getName()).append(" - ").append(f.get(o)).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Método que imprime una lista completa de objetos.
     *
     * @param lista Lista de la que deseamos conocer la información que
     * contiene.
     * @return la información que contiene la lista.
     */
    public static String debugImprimirContenidoListaObjeto(Collection<? extends Object> lista) {
        if (null == lista) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("Collection clase: ").append(lista.getClass().getName()).append(" - ")
                .append(lista.toString()).append('\n');
        try {
            for (Object o : lista) {
                sb = sb.append("Objeto clase: ").append(o.getClass().getName()).append(" - ").append(o.toString())
                        .append('\n');
                for (java.lang.reflect.Field f : o.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    sb = sb.append(f.getName()).append(" - ").append(f.get(o)).append('\n');
                }
                sb = sb.append("=============================\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
