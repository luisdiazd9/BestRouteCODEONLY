package estructuradedatos;

/**
 *
 * @author 000347393
 */
public class Nodo {

    //Acá está lo que contendrá cada nodo
    private int id; //ID de nodo para facilitar su búsqueda
    private Persona persona; //Una persona (puede ser null)
    private Nodo nodoSiguiente; //Referencia al siguiente nodo

    //Constructor que recibe todos los parámetros que contiene cada nodo
    public Nodo(int id, Persona persona, Nodo nodoSiguiente) {
        this.id = id;
        this.persona = persona;
        this.nodoSiguiente = nodoSiguiente;
    }

    //Método que permite mostrar la información del nodo
    public String mostrarInformacion() {
        try {
            return "Nombre: " + persona.getNombre() + " Edad: " + persona.getEdad() + " Triage: " + persona.getTriage();
        } catch (Exception e) {
            return null;
        }
    }
   
    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
