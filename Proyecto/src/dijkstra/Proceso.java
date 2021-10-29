package dijkstra;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Proceso {

    public int[] distancia = new int[60]; //Esta matriz guarda las distancias
    public int[][] peso = new int[60][60]; //Matriz de pesos que se llena en la clase Dijkstra

    //Este método calcula la distancia entre puntos
    public void calcular(int numnodos, int origen) {

        int aux[] = new int[numnodos + 1];
        int minpos = 1;
        int c;
        int minimo;

        for (int i = 1; i <= numnodos; i++) {
            aux[i] = 0;
            this.distancia[i] = this.peso[origen][i];
        }
        c = 2; //número de nodos entre los que se hallará la distancia final

        while (c <= numnodos) {
            minimo = 9999;

            for (int k = 1; k <= numnodos; k++) {

                if (this.distancia[k] < minimo && aux[k] != 1) {
                    minimo = this.distancia[k];
                    minpos = k;
                }
            }

            aux[minpos] = 1;
            c++;

            for (int k = 1; k <= numnodos; k++) {

                if (this.distancia[minpos] + this.peso[minpos][k] < this.distancia[k] && aux[k] != 1) {

                    this.distancia[k] = this.distancia[minpos] + this.peso[minpos][k];
                }
            }
        }

    }
}
