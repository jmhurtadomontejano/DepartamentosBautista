/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;

/**
 *
 * @author DAW-A
 */
public class DaoDeptoImpl implements DaoDepto {

    Connection conexion;

    public DaoDeptoImpl(/*Connection conexion  /al final quito el parametro para que sea un constructor sin parametro */) {
        this.conexion = utilidades.Conexion.getConexion();
    }

    @Override
    public boolean insertarDepto(Departamento d) {
        boolean isInsertado = false;
        String sql = "INSERT INTO DEPARTAMENTOS VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, d.getNumD());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getLocalidad());

            int numFilas = ps.executeUpdate();//ps.executeUpdate devuelve un numero
            if (numFilas > 0) {
                isInsertado = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoDeptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return isInsertado;
        }

        //return false;//usado para que no de fallo mientras está vacio
    }

    @Override
    public ArrayList<Departamento> getDepartamentos() {
        ArrayList<Departamento> listaDeptos = new ArrayList<Departamento>();
        String sql = "SELECT *FROM DEPARTAMENTOS";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Departamento d = new Departamento();
                //las siguientes lineas construyen el objeto Departamento para cada linea
                d.setNumD(rs.getInt(1));
                d.setNombre(rs.getString(2));
                d.setLocalidad(rs.getString(3));
                listaDeptos.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoDeptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return listaDeptos;
        }

        // return null;//usado para que no de fallo mientras está vacio
    }

    @Override
    public boolean modificarDepto(int numD, Departamento d) {
        boolean isModificado = false;
        try {
            String sql = "UPDATE DEPARTAMENTOS SET DNOMBRE=?, LOC=? WHERE DEPT_NO=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(4, numD);
            ps.setInt(1, d.getNumD());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getLocalidad());
            
            int filas = ps.executeUpdate();
            
            isModificado = filas>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoDeptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            return isModificado;
        } 
        
    }

}
