
public class Medico {
	private String nombreMedico;
	private Integer nroMatricula;
	private Especialidad especialidad;
	private double honorarios;
	
	public Medico(String nombre, int nroMatricula, Especialidad especialidad, double honorarios) {
		if(matriculaValida(nroMatricula) && honorariosValidos(honorarios)) {
			this.nroMatricula = nroMatricula;
			this.nombreMedico = nombre;
			this.especialidad = especialidad;
			this.honorarios = honorarios;
		}
	}
	//Revisa que la matricula sea mayor que cero
	public boolean matriculaValida(int nroMatricula) {
		if(nroMatricula>0)
			return true;
		else
			return false;
	}
	//Revisa que honorarios sean mayor que cero
	public boolean honorariosValidos(double honorarios) {
		if(honorarios>0)
			return true;
		else
			return false;
 }
	public String getNombreMedico() {
		return nombreMedico;
	}
	public Integer getNroMatricula() {
		return nroMatricula;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public double getHonorarios() {
		return honorarios;
	}
	public void setHonorarios(double honorarios) {
		this.honorarios = honorarios;
	}
	@Override
	public String toString() {
		return "Medico [nombreMedico=" + nombreMedico + "]";
	}
	
}
