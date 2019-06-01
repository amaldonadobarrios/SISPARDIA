package entity;


public class ListaSituacionEfectivo {

	String fechareg;
	String situacion, fini,ffin,rango,obs,estado,usureg,vigencia;
	public String getFechareg() {
		return fechareg;
	}
	public void setFechareg(String fechareg) {
		this.fechareg = fechareg;
	}
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	public String getFini() {
		return fini;
	}
	public void setFini(String fini) {
		this.fini = fini;
	}
	public String getFfin() {
		return ffin;
	}
	public void setFfin(String ffin) {
		this.ffin = ffin;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsureg() {
		return usureg;
	}
	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}
	
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	/**
	 * @param fechareg
	 * @param situacion
	 * @param fini
	 * @param ffin
	 * @param rango
	 * @param obs
	 * @param estado
	 * @param usureg
	 * @param vigencia
	 */
	public ListaSituacionEfectivo(String fechareg, String situacion, String fini, String ffin, String rango, String obs,
			String estado, String usureg, String vigencia) {
		super();
		this.fechareg = fechareg;
		this.situacion = situacion;
		this.fini = fini;
		this.ffin = ffin;
		this.rango = rango;
		this.obs = obs;
		this.estado = estado;
		this.usureg = usureg;
		this.vigencia = vigencia;
	}


	
}
