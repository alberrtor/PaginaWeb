package mx.edu.iems.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.iems.contracts.IEmpleadoDao;
import mx.edu.iems.dao.EmpleadoDaoImp;
import mx.edu.iems.dto.EmpleadoDTO;

import com.google.gson.Gson;

@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		IEmpleadoDao dao = new EmpleadoDaoImp();

		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();

		sb.append(line + "\n");

		reader.close();
		String data = sb.toString();

		// Convertimos el gson a dto
		Gson gson = new Gson();
		EmpleadoDTO dto = gson.fromJson(data, EmpleadoDTO.class);

		try {
			dao.update(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
