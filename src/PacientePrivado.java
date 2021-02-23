import java.util.HashMap;

//Hereda a Paciente
public class PacientePrivado extends Paciente{
	private HashMap<Fecha, Atencion> listaXGuardia;
	//private HashMap<String, Atencion> atenciones;
	private HashMap<Fecha, Atencion> listaXConsultorio;

	public PacientePrivado(String nombre, int hC, Fecha nac) {
		super(nombre, hC, nac);
		//atenciones = new HashMap<String, Atencion>();
		listaXGuardia = new HashMap<Fecha, Atencion>();
		listaXConsultorio = new HashMap<Fecha, Atencion>();
		
	}
	//Atencion por consultorio
	public void atencionConsultorio(Paciente paciente, Fecha fecha, Medico medico){
		String fechaAux = fecha.toString();
		if(!listaXConsultorio.containsKey(fechaAux)) {
			Atencion atencion = new Atencion(medico);
			if(!listaXConsultorio.containsKey(fecha)) { //Reviso que no tenga atenciones ese dia
				//Actualizo la deuda
				sumarDeuda(calcularCosto(getDeuda(), atencion.getCosto()));
				//Agrego a lista de atenciones
				listaXConsultorio.put(fecha, atencion);
			}
		}
	}
	public void atencionGuardia(Paciente paciente, Fecha fecha){
		String fechaAux = fecha.toString();
		if(!(listaXGuardia.containsKey(fechaAux))) {
			Atencion atencion = new Atencion();
			sumarDeuda(calcularCosto(getDeuda(), atencion.getCosto())); //No es necesario, pero si cambian los costos
			listaXGuardia.put(fecha, atencion);
		}
	}

	
	public double calcularCosto(double costo1, double costo2) {
		return costo1 + costo2;
	}
	@Override
	public String toString() {
		return "PacientePrivado [atenciones=" + ", listaXConsultorio=" + listaXConsultorio + "]";
	}
	public HashMap<Fecha, String> getListaXConsultorio() {
		HashMap<Fecha, String> listaC = new HashMap<Fecha, String>();
		for (Fecha fecha : listaXConsultorio.keySet() ) {
			
			Atencion atencion = listaXConsultorio.get(fecha);
			
			Especialidad especialidad = atencion.getEspecialidad();
			String nombreEspacialidad = especialidad.getNombre();
			listaC.put(fecha, nombreEspacialidad);
		}
		return listaC;
	}

	
	
	
}
