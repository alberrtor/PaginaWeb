package mx.edu.iems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.edu.iems.contracts.IUsuarioDao;
import mx.edu.iems.dao.UsuarioDaoImp;
import mx.edu.iems.dto.UsuarioDTO;

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username").toUpperCase();
		String password = request.getParameter("password");
		

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setUsuario(username);
		usuario.setPassword(password);

		IUsuarioDao usuarioJDBC = new UsuarioDaoImp();

		if (usuarioJDBC.esUsuarioCorrecto(usuario)
				&& usuarioJDBC.isAdministrativo(usuario) ) {
						
			PrintWriter out = response.getWriter();
			out.print("{success:true}");
			
		} else {

			PrintWriter out = response.getWriter();
			out.print("{success:false}");
			
		}

	}

}
