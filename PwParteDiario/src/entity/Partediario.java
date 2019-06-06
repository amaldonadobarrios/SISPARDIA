package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PARTEDIARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Partediario.findAll", query="SELECT p FROM Partediario p")
public class Partediario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTEDIARIO_IDPARTEDIARIO_GENERATOR", sequenceName="SEC_PARTEDIARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTEDIARIO_IDPARTEDIARIO_GENERATOR")
	private int idpartediario;

	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fechaparte;

	@Temporal(TemporalType.DATE)
	private Date fechareg;

	@Lob
	private byte[] reporte;

	private String usureg;

	public Partediario() {
	}

	public int getIdpartediario() {
		return this.idpartediario;
	}

	public void setIdpartediario(int idpartediario) {
		this.idpartediario = idpartediario;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaparte() {
		return this.fechaparte;
	}

	public void setFechaparte(Date fechaparte) {
		this.fechaparte = fechaparte;
	}

	public Date getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public byte[] getReporte() {
		return this.reporte;
	}

	public void setReporte(byte[] reporte) {
		this.reporte = reporte;
	}

	public String getUsureg() {
		return this.usureg;
	}

	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}

}