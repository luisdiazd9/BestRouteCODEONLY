/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradedatos;

/**
 *
 * @author admin
 */
public interface IGrafo {

    public void llenar(); //Llena el grafo

    public void agregarPersona(int posicion, Persona personaNueva); //Permite agregar una nueva persona

    public void eliminarPersona(int posicion); //Permite eliminar una persona

    public boolean vacia(); //Valida si el grafo está vacío

    public void agregar(Nodo nodo); //Agrega un nodo al grafo

    public void buscar(int posicion); //Lo que en realidad hace es imprimir por posicion
    
    public void buscarPersonaPorPosicion(int posicion); //este sí busca la persona por su posición en el grafo
    
    public boolean hayPersonas(); //para saber si ya hay personas o no
    
    public void triageMayor(); //Halla la persona con mayor triague
    
    public void mostrarTriage(int pos); //Muestra la persona de acuerdo a la posición que se ontiene con triageMayor
    
    public void cuentaPersonas(); //Cuenta la cantidad de personas que hay

}
