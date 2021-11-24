/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Connection;

/**
 *
 * @author DAW-A
 */
public class ProbarConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = utilidades.Conexion.getConexion();
        System.out.println(conexion);
        /*Establecer varias conexiones nos dirá que ya están establecidas*/
        Connection conexion2 = utilidades.Conexion.getConexion();
        System.out.println(conexion2);
        Connection conexion3 = utilidades.Conexion.getConexion();
        System.out.println(conexion3);
    }
    
}
