
public class Atencion {
	String FormasDePago;
	Medico medico;
	Especialidad especialidad;
	double costo;
	Fecha fecha;
	
	public Atencion() {
		this.costo = 0;
	}
	
	public Atencion(Medico medico) {
		this.medico = medico;
		this.especialidad = this.medico.getEspecialidad();
		this.costo = this.especialidad.getValor();
	}

	public double getCosto() {
		return costo;
	}


	@Override
	public String toString() {
		return "Atencion [medico=" + medico + ", especialidad=" + especialidad
				+ ", costo=" + costo + "]";
	}

	public Medico getMedico() {
		return medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}



}
