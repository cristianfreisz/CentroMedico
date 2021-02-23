
public class Internacion {
	private Fecha fechaIngreso;
	private Fecha fechaAlta;
	private String areaInternacion;
	private Integer nroHabitacion;
	private Integer costo;
	
	 public Internacion(Fecha fechaIngreso, String areaInternacion) {
		 this.fechaIngreso = fechaIngreso;
		 this.areaInternacion = areaInternacion;
		 this.fechaAlta = null;
		 this.nroHabitacion = 0;
		 this.costo = 5000; //Metodo que calcule el costo
	 }
	 public double conseguirCosto(Fecha fechaIngreso, Fecha fechaAlta) {
		 int dias = cantDiasInternacion(fechaIngreso, fechaAlta);
		 return (this.costo*dias);
		 
	 }
	 //Dada una fecha de ingreso y otra de alta calcula la cantidad de dias internado
	 public int cantDiasInternacion(Fecha fechaIngreso, Fecha fechaAlta) {
		 if(fechaIngreso.igual(fechaAlta)) { //Si le dan el alta el mismo dia
			 return 1;
		 }else {
		 int dias=0;
			while(fechaIngreso.esAntes(fechaAlta)) { //Cantidad de dias
				fechaIngreso.diaSiguiente();
				dias++;
			}
			return dias;
		 }
	 }

	 
	public Fecha getFechaIngreso() {
		return fechaIngreso;
	}

	public Fecha getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Fecha fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getAreaInternacion() {
		return areaInternacion;
	}

	public void setAreaInternacion(String areaInternacion) {
		this.areaInternacion = areaInternacion;
	}

	@Override
	public String toString() {
		return "Internacion [fechaIngreso=" + fechaIngreso + ", fechaAlta=" + fechaAlta + ", areaInternacion="
				+ areaInternacion + ", nroHabitacion=" + nroHabitacion + ", costo=" + costo + "]";
	}

	
}
