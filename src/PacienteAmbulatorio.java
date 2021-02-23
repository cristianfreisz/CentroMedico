//Hereda a Paciente

public class PacienteAmbulatorio extends Paciente {
		private Medico medico;
		private String tratamiento;

	public PacienteAmbulatorio(String nombre, int hC, Fecha nac) {
		super(nombre, hC, nac);
		this.medico = null;
		this.tratamiento = null;
	}
	
	void agregarTratamiento(Medico medico, String atencion) {
		this.medico = medico;
		this.tratamiento = atencion;
		actualizarDeuda(this.medico.getHonorarios()); //Agrega los nuevos costos
	}

	@Override
	public String toString() {
		return "PacienteAmbulatorio [medico: " + medico + ", tratamiento: " + tratamiento + "]";
	}

	
}
