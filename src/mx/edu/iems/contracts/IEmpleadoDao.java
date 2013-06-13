package mx.edu.iems.contracts;

import java.util.ArrayList;

import mx.edu.iems.dto.EmpleadoDTO;

public interface IEmpleadoDao {
	
	public ArrayList<EmpleadoDTO> getAll();
	
	public boolean add(EmpleadoDTO em);
	
	public boolean update(EmpleadoDTO em);
}
