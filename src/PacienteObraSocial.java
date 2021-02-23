import java.util.ArrayList;
import java.util.List;

//Hereda a Paciente
public class PacienteObraSocial extends Paciente{
	
	private String nombreObraSocial;
	private double porcentajeDescuento;
	private List<Internacion> internaciones;
	
	//Constructor
	public PacienteObraSocial(String nombre, int hC, Fecha nac, String nombreObraSocial, double p) {
		super(nombre, hC, nac);
		this.nombreObraSocial = nombreObraSocial;
		this.porcentajeDescuento = p;
		this.internaciones = new ArrayList<Internacion>();
	}
	
	//Agrega una nueva internacion a la lista
	public void agregarInternacion(Paciente paciente, Fecha ingreso, String area) {
		if(!existeInternacion(ingreso)) { //si la fecha de ingreso es igual a otra fecha de ingreso
			internaciones.add(new Internacion(ingreso, area));
		}		
	}
	
	//Auxiliares para agregar internacion
	public boolean existeInternacion(Fecha fecha) {
		if(!internaciones.isEmpty()) {
			for (Internacion internacion : internaciones) {
				if(estaIngresado(internacion, fecha)) {
					return true;
					}
			}
		}return false;
	}

	public Internacion getInternacion(Fecha fecha) {
		Internacion internacionAux = null;
		for (Internacion internacion : internaciones) {
			Fecha fecha2 = internacion.getFechaIngreso();
				if(fecha.igual(fecha2)) {
					internacionAux = internacion;
				}
		}return internacionAux;
	}
	
	//Revisa si dada una fecha si este ya se ecuentra ingresada
	public boolean estaIngresado(Internacion inter, Fecha fecha) {
		//Si la fecha es mayor igual al ingreso y no fue dado de alta
		if(inter.getFechaIngreso().esDespues(fecha)&&inter.getFechaAlta()==null)
			return false;
		//Si ya fue dado de alta
		if(inter.getFechaAlta()!=null) {
			if(inter.getFechaAlta().esAntes(fecha)&&inter.getFechaIngreso().esAntes(fecha))
				return false;
		}
		return true;
	}
	
	//Verifica si el paciente esta dado de alta
	public boolean tieneAlta(Fecha fecha) {
		for (Internacion internacion : internaciones) {
			if(internacion.getFechaAlta() == null)
				return true;
		}
		return false;
	}

	public Internacion estaIngresado(Fecha fecha) {
		Internacion internacion = null;
		for (Internacion inter : internaciones) {
			if(inter.getFechaAlta()==null) {
				if(inter.getFechaIngreso().esDespues(fecha)||inter.getFechaAlta().igual(fecha))
					internacion = inter;
			}
		}return internacion;
	}
	//Da el alta de una paciente y actualiza la deuda del paciente
	public void darAlta(Fecha fechaAlta) {
		for (Internacion internacion : internaciones) {
			if(internacion.getFechaAlta()==null && (fechaAlta.esAntes(internacion.getFechaIngreso()) || fechaAlta.igual(fechaAlta)) ) {
				internacion.setFechaAlta(fechaAlta);
				double deuda = internacion.conseguirCosto(internacion.getFechaIngreso(), fechaAlta)*(this.porcentajeDescuento); //Busca costos
				actualizarDeuda(deuda); //Agrega los nuevos costos a la deuda
			}
		}
	}
	
		
	@Override
	public String toString() {
		return "PacienteObraSocial [nombreObraSocial=" + nombreObraSocial + ", porcentajeDescuento="
				+ porcentajeDescuento + ", internaciones=" + internaciones + "]";
	}
	
}
