package estructuradedatos;

import java.io.IOException;
import javax.swing.JOptionPane;

public class GrafoImp implements IGrafo {

    //Las variables públicas lo son para facilitar su acceso
    private Nodo primero; //Referencia el primer nodo del grafo
    public int idTriagreMax, cantidadPersonas = 0; //la primera almacena el id de la persona con el mayor triage, la segunda 
    //guarda el número de personas que hay en total
    public boolean hayPersonaEnEsaPosicion = false; //Esta variable va a guardar si hay o no una persona en X posición

    //Cuenta cuántas personas hay entre todos los nodos
    @Override
    public void cuentaPersonas() {
        Nodo nodoActual = primero;
        do {
            if (nodoActual.getPersona() != null) {
                cantidadPersonas++;
            }
            nodoActual = nodoActual.getNodoSiguiente();
        } while (nodoActual != null);
    }

    //Recibe una posición y se muestra la persona en la misma, se usa solamente cuando la búsqueda se realiza de acuerdo al triage
    @Override
    public void mostrarTriage(int posicion) {
        Nodo nodoActual = primero;
        int cont = 1;
        while (cont < posicion) {
            nodoActual = nodoActual.getNodoSiguiente();
            cont++;
        }
        JOptionPane.showMessageDialog(null, "Destino:\n Intersección: " + posicion + " " + nodoActual.mostrarInformacion());
    }

    //Guarda el ID del nodo que tiene la persona con el triage mayor en idTriageMax (que es pública)
    @Override
    public void triageMayor() {
        //El triage máximo se manejó en prioridad, no en qué número es mayor
        try {
            Nodo nodoActual = primero;
            int triageMaximo = 0, posicionMax = 0, posicionM = 0;
            if (hayPersonas()) { //Valida que haya personas
                if (primero.getPersona() == null) { //Si no hay personas en la primera posición, se pone un
                    //triage que no exite para que sí o sí almacene el siguiente triage que haya
                    triageMaximo = 6;
                } else { //Como sí tiene personas, obtendrá el triage del primero 
                    triageMaximo = primero.getPersona().getTriage();
                }
                while (nodoActual != null) {
                    posicionM++;
                    if (nodoActual.getPersona() != null) { //valida si hay persona en esa posición
                        if (nodoActual.getPersona().getTriage() <= triageMaximo) {//si hay obtiene el triage y buscará si es o no el mayor
                            triageMaximo = nodoActual.getPersona().getTriage();
                            posicionMax = posicionM; //Guarda la posición en el grafo de dónde está el triage mayor
                        }
                    }
                    nodoActual = nodoActual.getNodoSiguiente();
                }
                idTriagreMax = posicionMax; //Guarda el ID de la ubicación del triage mayor
            } else {
                idTriagreMax = 10;
            }
        } catch (Exception e) {
        }
    }

    //Llena la el grafo con sus 30 nodos, sin personas, la referencia de la Estructura de datos
    //se da al llamar al método agregar, solo se incrementa el ID, de 1 a 30 
    @Override
    public void llenar() {
        for (int i = 0; i < 30; i++) {
            Nodo nuevoNodo = new Nodo(i + 1, null, null);
            agregar(nuevoNodo); //se agrega el nodo
        }
    }

    //Permite agregar una persona en X nodo del grafo
    @Override
    public void agregarPersona(int posicion, Persona personaNueva) {

        Nodo nodoActual = primero;
        int cont = 1;
        while (cont < posicion) {
            nodoActual = nodoActual.getNodoSiguiente();
            cont++;
        }
        nodoActual.setPersona(personaNueva);
    }

    //Elimina una persona en X nodo del grafo
    @Override
    public void eliminarPersona(int posicion) {

        Nodo nodoActual = primero;
        int cont = 1;
        while (cont < posicion) {
            nodoActual = nodoActual.getNodoSiguiente();
            cont++;
        }
        nodoActual.setPersona(null);
    }

    //Busca la persona en X nodo del grafo
    @Override
    public void buscar(int posicion) {
        Nodo nodoActual = primero;
        int cont = 1;
        while (cont < posicion) {
            nodoActual = nodoActual.getNodoSiguiente();
            cont++;
        }
        if (nodoActual.getPersona() != null) { //Si en la posición hay persona la muestra, de lo contrario muestra que no hay
            JOptionPane.showMessageDialog(null, "Intersección: " + posicion + " " + nodoActual.mostrarInformacion());
        } else {
            JOptionPane.showMessageDialog(null, "No hay personas en la intersección");
        }

    }

    //Similar a buscar, pero este solamente valida si hay o no una persona en X posición
    @Override
    public void buscarPersonaPorPosicion(int posicion) {
        Nodo nodoActual = primero;
        int cont = 1;
        while (cont < posicion) {
            nodoActual = nodoActual.getNodoSiguiente();
            cont++;
        }
        if (nodoActual.getPersona() != null) { //Si hay persona en esa posición, hayPersonaEnEsaPosición toma como valor TRUE
            hayPersonaEnEsaPosicion = true;
        } else { //Si no hay, la variable PÚBLICA toma valor false
            hayPersonaEnEsaPosicion = false;
        }
    }

    //Valida si la estructura está vacía, si retorna True lo está, False es porque no lo está
    @Override
    public boolean vacia() {
        return primero == null;
    }

    //Solo se usa cuando se llama en el método llenar(), añade en orden y coloca la referencia del nodo 
    //para forma la estructura de datos
    @Override
    public void agregar(Nodo nodo) {

        if (vacia()) {
            primero = nodo;
        } else {

            Nodo nodoActual = primero;

            while (nodoActual.getNodoSiguiente() != null) {
                nodoActual = nodoActual.getNodoSiguiente();
            }

            nodoActual.setNodoSiguiente(nodo);
        }
    }

    //Valida si hay o no personas en todo el grafo
    @Override
    public boolean hayPersonas() {
        Nodo nodoActual = primero;
        do {
            if (nodoActual.getPersona() != null) { //Encontró que sí hay personas, retorna True
                return true;
            }
            nodoActual = nodoActual.getNodoSiguiente();
        } while (nodoActual != null);
        return false; //No encontró personas, retorna False
    }

    //Getters y setters
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

}
