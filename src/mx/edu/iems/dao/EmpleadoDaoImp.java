package mx.edu.iems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.iems.conn.EscolarConnectionFactory;
import mx.edu.iems.conn.PaginaWebConnectionFactory;
import mx.edu.iems.contracts.IEmpleadoDao;
import mx.edu.iems.dto.EmpleadoDTO;

public class EmpleadoDaoImp implements IEmpleadoDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	
	public ArrayList<EmpleadoDTO> getAll() {
		ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		
		try {
			conn = PaginaWebConnectionFactory.getInstance().getConnection();
			String query = "select * from usuario";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			EmpleadoDTO emp;
			
			while(rs.next()){
				emp = new EmpleadoDTO();
				emp.setId_usuario(rs.getInt(1));
				emp.setNom_usuario(rs.getString(2));
				emp.setPat_usuario(rs.getString(3));
				emp.setMat_usuario(rs.getString(4));
				emp.setArea(rs.getString(5));
				emp.setFecha_nacimiento(rs.getString(6));
				emp.setLogin(rs.getString(7));
				emp.setActivo(rs.getBoolean(8));
				emp.setCumple(rs.getString(9));
				emp.setTiene_foto(rs.getBoolean(10));
				
				empleados.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return empleados;
	}


	@Override
	public boolean add(EmpleadoDTO em) {
		boolean valor = false;
		
		try {
			em.setId_usuario(getMaxidUsuario()+1);
			em.setActivo(true);
			em.setTiene_foto(true);
			
			
			conn = PaginaWebConnectionFactory.getInstance().getConnection();
			String sql = "insert into usuario values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, em.getId_usuario());
			ps.setString(2, em.getNom_usuario());
			ps.setString(3, em.getPat_usuario());
			ps.setString(4, em.getMat_usuario());
			ps.setString(5, em.getArea());
			ps.setString(6, em.getFecha_nacimiento());
			ps.setString(7, em.getLogin());
			ps.setBoolean(8, em.isActivo());
			ps.setString(9, em.getCumple());
			ps.setBoolean(10, em.isTiene_foto());
			
			if (ps.executeUpdate() > 0){
				valor = true;
			}
					
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return valor;
	}
	
	private int getMaxidUsuario(){
		int max = 0;
		
		try {
			conn = PaginaWebConnectionFactory.getInstance().getConnection();
			String sql = "select MAX(id_usuario) as maximo from usuario";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()){
				max = rs.getInt("maximo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return max;
	}


	@Override
	public boolean update(EmpleadoDTO em) {
		boolean valor = false;
		
		try {
			conn = PaginaWebConnectionFactory.getInstance().getConnection();
			String sql = "update usuario set nom_usuario = ?, pat_usuario = ?, mat_usuario = ?, area = ?, fecha_nacimiento = ?, login = ?, activo = ?, cumple = ?, tiene_foto = ? where id_usuario = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, em.getNom_usuario());
			ps.setString(2, em.getPat_usuario());
			ps.setString(3, em.getMat_usuario());
			ps.setString(4, em.getArea());
			ps.setString(5, em.getFecha_nacimiento());
			ps.setString(6, em.getLogin());
			ps.setBoolean(7, em.isActivo());
			ps.setString(8, em.getCumple());
			ps.setBoolean(9, em.isTiene_foto());
			ps.setInt(10, em.getId_usuario());
			
			if (ps.executeUpdate() > 0){
				valor = true;
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return valor;
	}

	
}
