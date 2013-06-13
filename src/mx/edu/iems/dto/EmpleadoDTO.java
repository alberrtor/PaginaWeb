package mx.edu.iems.dto;

public class EmpleadoDTO {

	private int id_usuario;
	private String nom_usuario;
	private String pat_usuario;
	private String mat_usuario;
	private String area;
	private String fecha_nacimiento;
	private String login;
	private boolean activo;
	private String cumple;
	private boolean tiene_foto;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}
	public String getPat_usuario() {
		return pat_usuario;
	}
	public void setPat_usuario(String pat_usuario) {
		this.pat_usuario = pat_usuario;
	}
	public String getMat_usuario() {
		return mat_usuario;
	}
	public void setMat_usuario(String mat_usuario) {
		this.mat_usuario = mat_usuario;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getCumple() {
		return cumple;
	}
	public void setCumple(String cumple) {
		this.cumple = cumple;
	}
	public boolean isTiene_foto() {
		return tiene_foto;
	}
	public void setTiene_foto(boolean tiene_foto) {
		this.tiene_foto = tiene_foto;
	}
	
}
