import java.util.*;

import javax.swing.JOptionPane;

public class Centro {
	private String nombre;
	private String cuil;
	private Integer codigoCliente;
	
	private List<Especialidad>especialidades;
	private HashMap<Integer, Medico>medicos;  
	private HashMap<Integer, Paciente>pacientes;
	
	//Crear centro
	public Centro (String nombre, String cuil, int codigoCliente) {
		this.nombre = nombre;
		this.cuil = cuil;
		especialidades  = new ArrayList<Especialidad>();
		medicos = new HashMap<Integer, Medico>();
		pacientes = new HashMap<Integer, Paciente>();
	}
	
//Recibe un nombre y un valor llamando al constructor de especialidad
	public void agregarEspecialidad(String nombre, double valor) {
		if(especialidades.isEmpty()) {							//Si la lista está vacia agrega la especialidad
			especialidades.add(new Especialidad(nombre, valor));
		}
		//De lo contrario, ya tiene eespecialidades entonces revisa que esta no exista.
		else{
			if(!equalsNombreEspecialidad(nombre)) 
					especialidades.add(new Especialidad(nombre, valor));
			}
	}

	public boolean equalsNombreEspecialidad(String nombre) {
		for (Especialidad especialidad : especialidades) {
			if(nombre == especialidad.getNombre())
				return true;
			}
		 
		return false;
	}

		public Especialidad buscarEspecialidad(String nombre) {
			Especialidad aux = null;
			for (Especialidad especialidad : especialidades) {
				if(nombre == especialidad.getNombre()) {
					aux = especialidad;
				}
			}
			return aux;
		}
	
		public void agregarMedico(String nombre, int matricula, String nomEspecialidad, double valorTratamiento) {
			
				if(!medicoPertenece(matricula)) {
					medicos.put(matricula, new Medico(nombre, matricula, buscarEspecialidad(nomEspecialidad), valorTratamiento));
					
				}
			
		}
		
		public boolean medicoPertenece(int matricula) {
			return medicos.containsKey(matricula);
		}
		
		public Medico buscarMedico(int matricula) {
			return medicos.get(matricula);
		}
		
		public Paciente buscarPaciente(int hC)
		{
			return pacientes.get(hC);
		}
		
		public String toString() {
			return "Especialidad [nombre=" + nombre + ", valor=" + medicos + "especialidades" + especialidades + "]";
		}
		
	public void agregarPacientePrivado(String nombre, int hC, Fecha nac) {
		if(buscarPaciente(hC)==null)
			pacientes.put(hC, new PacientePrivado(nombre, hC, nac));
	}
	public void agregarPacienteAmbulatorio(String nombre, int hC, Fecha nac) {
		if(buscarPaciente(hC)==null)
			pacientes.put(hC, new PacienteAmbulatorio(nombre, hC, nac));
		}
	public void agregarPacienteObraSocial(String nombre, int hC, Fecha nac, String osocial, double p) {
		if(buscarPaciente(hC)==null)
			pacientes.put(hC, new PacienteObraSocial(nombre, hC, nac, osocial, p));
	}
	
	void agregarAtencion(int hC, Fecha fecha, int matricula) { //en el caso de atención en consultorio.
		Paciente paciente = buscarPaciente(hC);
		if(paciente instanceof PacientePrivado) {
			if(medicoPertenece(matricula)) {
				Medico medico= buscarMedico(matricula);
				 ((PacientePrivado) paciente).atencionConsultorio(paciente, fecha, medico);
			}
		}
	}
	public void agregarAtencion(int hC, Fecha fecha){   //en el caso de atención guardia.
			Paciente paciente = buscarPaciente(hC);
			if(paciente instanceof PacientePrivado) {
				 ((PacientePrivado) paciente).atencionGuardia(paciente, fecha);
			}
	}
	void agregarInternacion(int hC, String area, Fecha fingreso) { //ingresa el paciente a internación.
			Paciente paciente = buscarPaciente(hC);
			if(paciente instanceof PacienteObraSocial) { //El paciente no es vacio y no es de obra social
				((PacienteObraSocial) paciente).agregarInternacion(paciente, fingreso, area);
			}
	}
	void altaInternacion(int hC, Fecha fechaAlta) { //da de alta al paciente internado.
		Paciente paciente = buscarPaciente(hC);
		if(paciente instanceof PacienteObraSocial) {
			((PacienteObraSocial) paciente).darAlta(fechaAlta);
		}
	}
	// Paga saldo de un paciente recibiendo como dato su historia clinica
	void pagarSaldo(int hC){ 
		Paciente paciente=buscarPaciente(hC); //Busca al paciente
		double saldo = getSaldo(hC);	//Busca su deuda
		paciente.pagarDeuda(saldo);		//La paga
		}
	
	public List<Integer> listaInternacion(){
		List listaInternados = new ArrayList<Integer>();	//Creo lista vacia
		for(Integer hC : pacientes.keySet()) {				//Recorro por medio de su Historia Clinica
			Paciente paciente = buscarPaciente(hC);
			if(paciente instanceof PacienteObraSocial) {		// Si el paciente es de obra social
				if(((PacienteObraSocial) paciente).tieneAlta(Fecha.hoy())){		//Y si tiene alta
					listaInternados.add(paciente.getNumeroHistoriaClinica());	//Lo agrego
				}
			}	
		}
		return listaInternados;
	}
	
	void agregarTratamiento(int hC, int matricula, String atencion) {
		Paciente paciente=buscarPaciente(hC);
		Medico medico = buscarMedico(matricula);
		if(paciente instanceof PacienteAmbulatorio) {
			((PacienteAmbulatorio) paciente).agregarTratamiento(medico, atencion);
		} 
	}
	//Busca la deuda de un paciente
	public double getSaldo(int hC) {
		Paciente paciente=buscarPaciente(hC); //Busca cliente
		return paciente.getDeuda();
	}
	
	public Map<Fecha, String> atencionesEnConsultorio(int hC){
		Paciente paciente=buscarPaciente(hC);
		HashMap<Fecha, String>consultorio = null;
		if(paciente instanceof PacientePrivado)
			consultorio = ((PacientePrivado) paciente).getListaXConsultorio();
		return consultorio;
	}

	
}
