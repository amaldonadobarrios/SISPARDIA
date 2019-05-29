package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EFECTIVO database table.
 * 
 */
@Entity
@NamedQuery(name="Efectivo.findAll", query="SELECT e FROM Efectivo e")
public class Efectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EFECTIVO_IDEFECTIVO_GENERATOR", sequenceName="SEC_EFECTIVO",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EFECTIVO_IDEFECTIVO_GENERATOR")
	private long idefectivo;

	private String apemat;

	private String apepat;

	private String cip;

	private String correo;

	private String dni;

	private String domicilio;

	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fechamod;

	@Temporal(TemporalType.DATE)
	private Date fechareg;

	private String grado;

	private int idarea;

	private int idcargo;

	private int idjerarquia;

	private int idmodalidad;

	private String nombres;

	private String telefono;

	private String usumod;

	private String usureg;

	public Efectivo() {
	}

	public long getIdefectivo() {
		return this.idefectivo;
	}

	public void setIdefectivo(long idefectivo) {
		this.idefectivo = idefectivo;
	}

	public String getApemat() {
		return this.apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getApepat() {
		return this.apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getCip() {
		return this.cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Date fechamod) {
		this.fechamod = fechamod;
	}

	public Date getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public int getIdarea() {
		return this.idarea;
	}

	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}

	public int getIdcargo() {
		return this.idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public int getIdjerarquia() {
		return this.idjerarquia;
	}

	public void setIdjerarquia(int idjerarquia) {
		this.idjerarquia = idjerarquia;
	}

	public int getIdmodalidad() {
		return this.idmodalidad;
	}

	public void setIdmodalidad(int idmodalidad) {
		this.idmodalidad = idmodalidad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsumod() {
		return this.usumod;
	}

	public void setUsumod(String usumod) {
		this.usumod = usumod;
	}

	public String getUsureg() {
		return this.usureg;
	}

	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}

	/**
	 * @param idefectivo
	 * @param apemat
	 * @param apepat
	 * @param cip
	 * @param correo
	 * @param dni
	 * @param domicilio
	 * @param estado
	 * @param fechamod
	 * @param fechareg
	 * @param grado
	 * @param idarea
	 * @param idcargo
	 * @param idjerarquia
	 * @param idmodalidad
	 * @param nombres
	 * @param telefono
	 * @param usumod
	 * @param usureg
	 */
	public Efectivo(long idefectivo, String apemat, String apepat, String cip, String correo, String dni,
			String domicilio, int estado, Date fechamod, Date fechareg, String grado, int idarea, int idcargo,
			int idjerarquia, int idmodalidad, String nombres, String telefono, String usumod, String usureg) {
		super();
		this.idefectivo = idefectivo;
		this.apemat = apemat;
		this.apepat = apepat;
		this.cip = cip;
		this.correo = correo;
		this.dni = dni;
		this.domicilio = domicilio;
		this.estado = estado;
		this.fechamod = fechamod;
		this.fechareg = fechareg;
		this.grado = grado;
		this.idarea = idarea;
		this.idcargo = idcargo;
		this.idjerarquia = idjerarquia;
		this.idmodalidad = idmodalidad;
		this.nombres = nombres;
		this.telefono = telefono;
		this.usumod = usumod;
		this.usureg = usureg;
	}

}