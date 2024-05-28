
package com.emergentes.controlador;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JHOMARA
 */
@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        //eliminamos la sesion 
        ses.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
                
        
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String producto=request.getParameter("producto");
        //obtener la sesion
        HttpSession ses= request.getSession();
        //crear  la vsriable de tipo lista
        ArrayList<String> lista=(ArrayList<String>)ses.getAttribute("lista");
        //adicionar el producto a la lista
        lista.add(producto);
        response.sendRedirect(request.getContextPath()+"/index.jsp"); 
    }


}
