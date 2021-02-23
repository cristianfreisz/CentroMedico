
public class Paciente {
	private Integer numeroHistoriaClinica;
	private String nombre;
	private Fecha fechaNacimiento;
	private double deuda;
	
	public Paciente(String nombre, int hC, Fecha nac) {
		this.numeroHistoriaClinica = hC;
		this.nombre = nombre;
		this.fechaNacimiento = nac;
		this.deuda = 0;
	}

	@Override
	public String toString() {
		return "Paciente [numeroHistoriaClinica=" + numeroHistoriaClinica + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", deuda=" + deuda + "]";
	}

	public Integer getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}

	public String getNombre() {
		return nombre;
	}


	public double getDeuda() {
		return deuda;
	}

	public void pagarDeuda(double deuda) {
		this.deuda = this.deuda-deuda;
	}
	
	public void actualizarDeuda(double deuda) {
		this.deuda = this.deuda+deuda;
	}
	
	public void sumarDeuda(double deuda) {
		this.deuda = deuda;
	}
	
}
