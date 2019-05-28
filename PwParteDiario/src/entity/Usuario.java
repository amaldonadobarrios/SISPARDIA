package entity;

public class Usuario {

//definimos los atributos de la clase usuario

	int idusuario, estado;
	String apepat, apemat, nombres, cip, password, usumod, usureg, grado;
	// fecha reg y fechamod lo registramos desde bd
	// creamos los metodos set y get

	public int getIdusuario() {
		return idusuario;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsumod() {
		return usumod;
	}

	public void setUsumod(String usumod) {
		this.usumod = usumod;
	}

	public String getUsureg() {
		return usureg;
	}

	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}

	// creamos contructor
	public Usuario(int idusuario, int estado, String apepat, String apemat, String nombres, String cip, String password,
			String usumod, String usureg, String grado) {
		super();
		this.idusuario = idusuario;
		this.estado = estado;
		this.apepat = apepat;
		this.apemat = apemat;
		this.nombres = nombres;
		this.cip = cip;
		this.password = password;
		this.usumod = usumod;
		this.usureg = usureg;
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", estado=" + estado + ", apepat=" + apepat + ", apemat=" + apemat
				+ ", nombres=" + nombres + ", cip=" + cip + ", password=" + password + ", usumod=" + usumod
				+ ", usureg=" + usureg + ", grado=" + grado + "]";
	}


}
