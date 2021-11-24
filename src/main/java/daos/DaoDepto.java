/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import modelo.Departamento;

/**
 *
 * @author DAW-A
 */
public interface DaoDepto {

    /**
     *Insertar un departamento en la base de datos
     * @param d
     * @return
     */
    public boolean insertarDepto(Departamento d);
    
    /**
     *Obtener todos los Departamentos
     * @return
     */
    public ArrayList<Departamento> getDepartamentos();
    
    public boolean modificarDepto(int numD, Departamento d);
    
}
