/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DAW-A
 */
public class Departamento {
    private int numD;
    private String nombre;
    private String localidad;

    public Departamento() {
    }

    public Departamento(int numD, String nombre, String localidad) {
        this.numD = numD;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getNumD() {
        return numD;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
