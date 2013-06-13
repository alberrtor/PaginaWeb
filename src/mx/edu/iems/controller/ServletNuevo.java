package mx.edu.iems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.iems.contracts.IEmpleadoDao;
import mx.edu.iems.dao.EmpleadoDaoImp;
import mx.edu.iems.dto.EmpleadoDTO;


@WebServlet("/ServletNuevo")
public class ServletNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletNuevo() {
        super();      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IEmpleadoDao dao = new EmpleadoDaoImp();
		EmpleadoDTO em = new EmpleadoDTO();
		em.setNom_usuario(request.getParameter("nom_usuario"));
		em.setPat_usuario(request.getParameter("pat_usuario"));
		em.setMat_usuario(request.getParameter("mat_usuario"));
		em.setArea(request.getParameter("area"));
		em.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
		em.setLogin(request.getParameter("login"));
		em.setCumple(request.getParameter("cumple"));
		
		if (dao.add(em)){
			PrintWriter out = response.getWriter();
			out.print("{success:true}");
		}
		
		
	}

}
