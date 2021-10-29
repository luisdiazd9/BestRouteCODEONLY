package estructuradedatos;

/**
 *
 * @author 000347393
 */
public class Persona {

    //Los datos que habrá de cada persona
    private int triage; //Triage para controlar su prioridad
    private int edad; //Edad de la persona
    private String nombre; //Nombre de la persona

    //Constructor
    public Persona(int triage, int edad, String nombre) {
        this.triage = triage;
        this.edad = edad;
        this.nombre = nombre;
    }

    //Getteres and setters
    public int getTriage() {
        return triage;
    }

    public void setTriage(int triage) {
        this.triage = triage;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
}
