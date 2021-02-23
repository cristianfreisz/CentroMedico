
public class Especialidad {
	private Integer codigo;
	private String nombre;
	private double valor;
	
	
	public Especialidad (String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
}
	
	public boolean equals2 (Especialidad o) {
		   return this.nombre == o.getNombre();
		 } 

	@Override
	public String toString() {
		return "Especialidad [nombre=" + nombre + ", valor=" + valor + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
