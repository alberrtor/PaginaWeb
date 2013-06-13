package mx.edu.iems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mx.edu.iems.contracts.IEmpleadoDao;
import mx.edu.iems.dao.EmpleadoDaoImp;
import mx.edu.iems.dto.EmpleadoDTO;


public class ServletConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletConsultar() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		IEmpleadoDao dao = new EmpleadoDaoImp();
		ArrayList<EmpleadoDTO> listaEmpleados = null;
		
		listaEmpleados = dao.getAll();
		
		Gson json = new Gson();
		
		String objJSON = json.toJson(listaEmpleados);
		
		System.out.println("{\"empleados\":" + objJSON + "}");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("{\"empleados\":" + objJSON + "}");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
