import java.time.LocalDate;
import java.time.LocalDateTime;


public class Fecha {

    private int dia;
    private int mes;
    private int year;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }
    /*@Override
    public boolean equals(Object fecha) {
    	String fecha1 = fecha.toString();
    	String fecha2 = this.toString();
    	return fecha2.equals(fecha1);
    }
    */
    
    public boolean igual(Fecha fecha) {
    	LocalDate date= LocalDate.of(fecha.getYear(),fecha.getMes(), fecha.dia );
    	LocalDate dateClase = LocalDate.of(this.year, this.mes, this.dia);
    	return dateClase.equals(date);
    }
    /*
    public boolean igual(Fecha fecha) {
    	return (this.dia==fecha.getDia() &&this.mes==fecha.getMes()&&this.year==fecha.getYear());
    }*/
    public static Fecha hoy() {
    	LocalDate date = LocalDate.now();
    	Fecha dateAux = new Fecha(date.getDayOfMonth(),date.getMonthValue(),date.getYear());
    	return dateAux;
    }
    public boolean esDespues(Fecha fecha) {
    	LocalDate date= LocalDate.of(fecha.getYear(),fecha.getMes(), fecha.dia );
    	LocalDate dateClase = LocalDate.of(this.year, this.mes, this.dia);
    	return dateClase.isAfter(date);
    }
    public boolean esAntes(Fecha fecha) {
    	LocalDate date= LocalDate.of(fecha.getYear(),fecha.getMes(), fecha.dia );
    	LocalDate dateClase = LocalDate.of(this.year, this.mes, this.dia);
    	return dateClase.isBefore(date);
    }
    //setters y getters
   /*
    public void setDia(int d) {
        dia = d;
    }
    public void setMes(int m) {
        mes = m;
    }
    public void setYear(int a) {
        year = a;
    }
       */
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }
    public int getYear() {
        return year;
    }

    //Método para comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = year > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    //Método privado para comprobar si el año es bisiesto
    //Este método lo utiliza el método fechaCorrecta
    private boolean esBisiesto() {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    //Método que modifica la fecha cambiándola por la del día siguiente                                           
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                year++;
            }

        }
    }

    //Método toString para mostrar la fecha
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        sb.append("-");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("-");
        sb.append(year);
        return sb.toString();
    }
} //Fin de la clase Fecha