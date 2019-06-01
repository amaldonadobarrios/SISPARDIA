package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EFECTIVO_SITUACION database table.
 * 
 */
@Entity
@Table(name="EFECTIVO_SITUACION")
@NamedQuery(name="EfectivoSituacion.findAll", query="SELECT e FROM EfectivoSituacion e")
public class EfectivoSituacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EFECTIVO_SITUACION_IDEFESIT_GENERATOR", sequenceName="SEC_EFECTIVO_SITUACION", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EFECTIVO_SITUACION_IDEFESIT_GENERATOR")
	private int idefesit;

	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechaini;



	private int idefectivo;

	private int idsituacion;

	public int getIdefesit() {
		return idefesit;
	}

	public void setIdefesit(int idefesit) {
		this.idefesit = idefesit;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}


	public int getIdefectivo() {
		return idefectivo;
	}

	public void setIdefectivo(int idefectivo) {
		this.idefectivo = idefectivo;
	}

	public int getIdsituacion() {
		return idsituacion;
	}

	public void setIdsituacion(int idsituacion) {
		this.idsituacion = idsituacion;
	}

	public int getIndeterminado() {
		return indeterminado;
	}

	public void setIndeterminado(int indeterminado) {
		this.indeterminado = indeterminado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getUsureg() {
		return usureg;
	}

	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}

	private int indeterminado;

	private String observaciones;

	private String usureg;

	public EfectivoSituacion() {
	}

	/**
	 * @param idefesit
	 * @param estado
	 * @param fechafin
	 * @param fechaini
	 * @param fechareg
	 * @param idefectivo
	 * @param idsituacion
	 * @param indeterminado
	 * @param observaciones
	 * @param usureg
	 */
	public EfectivoSituacion(int idefesit, int estado, Date fechafin, Date fechaini, int idefectivo,
			int idsituacion, int indeterminado, String observaciones, String usureg) {
		super();
		this.idefesit = idefesit;
		this.estado = estado;
		this.fechafin = fechafin;
		this.fechaini = fechaini;

		this.idefectivo = idefectivo;
		this.idsituacion = idsituacion;
		this.indeterminado = indeterminado;
		this.observaciones = observaciones;
		this.usureg = usureg;
	}



}