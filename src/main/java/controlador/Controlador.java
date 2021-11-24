/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import daos.DaoDepto;
import daos.DaoDeptoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Departamento;
import static utilidades.Conexion.conexion;

/**
 *
 * @author DAW-A
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoDepto daoDep = new DaoDeptoImpl();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        if (accion.equals("insertar")) {
            response.sendRedirect("datosInsercion.jsp");
            
            
        } else if (accion.equals("mostrar")) {
            
            request.setAttribute("laListaDeptos", daoDep.getDepartamentos());
            RequestDispatcher rd = request.getRequestDispatcher("mostrarDeptos.jsp");
            rd.forward(request, response);//hay que enviar el resultado de RequestDistpacher
        } else if (accion.equals("guardarDep")) {
            
            Departamento d = new Departamento();
            d.setNumD(Integer.parseInt(request.getParameter("depto")));
            d.setNombre(request.getParameter("nombre"));
            d.setLocalidad(request.getParameter("localidad"));
            if( daoDep.insertarDepto(d)){
                String msg = "Departamento insertado correctamente.";
                response.sendRedirect("index.html?elMsg="+msg);
            } else {
                String msg = "Departamento NO SE HA INSERTADO.";
                response.sendRedirect("datosInsercion.html?elMsg="+msg);
            }
        } else if(accion.equals("modificar")){
            response.sendRedirect("datosModificacion.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
