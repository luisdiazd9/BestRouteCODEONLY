package dijkstra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Dijkstra {

    public Proceso p = new Proceso();  //p es el proceso que ejecutará el dijkstra
    private int matriz[][] = new int[30][30];  //Esta matriz guarda el grafo SOLO CUANDO SE LEE DEL ARCHIVO
    public int validaCamino[] = new int[42]; //Guarda el estado de los caminos, 0 si está abierto o 1 si está cerrado
    public int distancia; //Devolverá la distancia de acuerdo al caso, esto por los botones que se manejaron en la vista Home
    private int numnodos = 30; //Número total de nodos

    //Getters y setters
    public Proceso getP() {
        return p;
    }

    public void setP(Proceso p) {
        this.p = p;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    //Este método lee la matriz desde el archivo y la almacena en matriz
    public void muestraContenidoMatriz(String archivo) throws FileNotFoundException, IOException {
        String[] cadena;

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        for (int i = 0; i < 30; i++) {
            cadena = b.readLine().split(";");
            for (int j = 0; j < 30; j++) {
                matriz[i][j] = Integer.parseInt(cadena[j]);
            }
        }
        b.close();
    }

    //Método para llamar a muestraContenidoMatriz de acuerdo a la ubicación del archivo
    public void leeArchivoMatriz() throws IOException {
        muestraContenidoMatriz("GrafoMatriz.txt");
    }

    //Este método cierra los caminos, recibe el ID del camino que se va a cerrar y reemplaza su peso por 9999 para que
    //el algoritmo no lo tenga en cuenta, p.peso es la matriz que utiliza el dijkstra, no se usa la que se leyó directamente
    //del archivo porque se ignora la posición 0, puesto que no se buscaba tener un nodo enumerado como CERO
    public void cerrarCamino(int camino) {
        switch (camino) {
            case 1:
                p.peso[8][9] = 9999;
                p.peso[9][8] = 9999;
                matriz[7][8]=matriz[8][7]=9999;
                validaCamino[1] = 1;
                break;
            case 2:
                p.peso[30][1] = 9999;
                p.peso[1][30] = 9999;
                matriz[29][0]=matriz[0][29]=9999;
                validaCamino[2] = 1;
                break;
            case 3:
                p.peso[1][8] = 9999;
                p.peso[8][1] = 9999;
                matriz[0][7]=matriz[7][0]=9999;
                validaCamino[3] = 1;
                break;
            case 4:
                p.peso[1][2] = 9999;
                p.peso[2][1] = 9999;
                matriz[0][1]=matriz[1][0]=9999;
                validaCamino[4] = 1;
                break;
            case 5:
                p.peso[2][7] = 9999;
                p.peso[7][2] = 9999;
                matriz[1][6]=matriz[6][1]=9999;
                validaCamino[5] = 1;
                break;
            case 6:
                p.peso[8][7] = 9999;
                p.peso[7][8] = 9999;
                matriz[7][6]=matriz[6][7]=9999;
                validaCamino[6] = 1;
                break;
            case 7:
                p.peso[6][7] = 9999;
                p.peso[7][6] = 9999;
                matriz[5][6]=matriz[6][5]=9999;
                validaCamino[7] = 1;
                break;
            case 8:
                p.peso[3][6] = 9999;
                p.peso[6][3] = 9999;
                matriz[2][5]=matriz[5][2]=9999;
                validaCamino[8] = 1;
                break;
            case 9:
                p.peso[2][3] = 9999;
                p.peso[3][2] = 9999;
                matriz[1][2]=matriz[2][1]=9999;
                validaCamino[9] = 1;
                break;
            case 10:
                p.peso[3][4] = 9999;
                p.peso[4][3] = 9999;
                matriz[2][3]=matriz[3][2]=9999;
                validaCamino[10] = 1;
                break;
            case 11:
                p.peso[4][5] = 9999;
                p.peso[5][4] = 9999;
                matriz[3][4]=matriz[4][3]=9999;
                validaCamino[11] = 1;
                break;
            case 12:
                p.peso[5][6] = 9999;
                p.peso[6][5] = 9999;
                matriz[4][5]=matriz[5][4]=9999;
                validaCamino[12] = 1;
                break;
            case 13:
                p.peso[5][29] = 9999;
                p.peso[29][5] = 9999;
                matriz[4][28]=matriz[28][4]=9999;
                validaCamino[13] = 1;
                break;
            case 14:
                p.peso[28][29] = 9999;
                p.peso[29][28] = 9999;
                matriz[27][28]=matriz[28][27]=9999;
                validaCamino[14] = 1;
                break;
            case 15:
                p.peso[25][28] = 9999;
                p.peso[28][25] = 9999;
                matriz[27][24]=matriz[24][27]=9999;
                validaCamino[15] = 1;
                break;
            case 16:
                p.peso[5][25] = 9999;
                p.peso[25][5] = 9999;
                matriz[4][24]=matriz[24][4]=9999;
                validaCamino[16] = 1;
                break;
            case 17:
                p.peso[24][25] = 9999;
                p.peso[25][24] = 9999;
                matriz[23][24]=matriz[24][23]=9999;
                validaCamino[17] = 1;
                break;
            case 18:
                p.peso[23][24] = 9999;
                p.peso[24][23] = 9999;
                matriz[22][23]=matriz[23][22]=9999;
                validaCamino[18] = 1;
                break;
            case 19:
                p.peso[22][23] = 9999;
                p.peso[23][22] = 9999;
                matriz[21][22]=matriz[22][21]=9999;
                validaCamino[19] = 1;
                break;
            case 20:
                p.peso[25][26] = 9999;
                p.peso[26][25] = 9999;
                matriz[24][25]=matriz[25][24]=9999;
                validaCamino[20] = 1;
                break;
            case 21:
                p.peso[27][28] = 9999;
                p.peso[28][27] = 9999;
                matriz[26][27]=matriz[27][26]=9999;
                validaCamino[21] = 1;
                break;
            case 22:
                p.peso[20][27] = 9999;
                p.peso[27][20] = 9999;
                matriz[19][26]=matriz[26][19]=9999;
                validaCamino[22] = 1;
                break;
            case 23:
                p.peso[26][27] = 9999;
                p.peso[27][26] = 9999;
                matriz[25][26]=matriz[26][25]=9999;
                validaCamino[23] = 1;
                break;
            case 24:
                p.peso[19][26] = 9999;
                p.peso[26][19] = 9999;
                matriz[18][25]=matriz[25][18]=9999;
                validaCamino[24] = 1;
                break;
            case 25:
                p.peso[16][22] = 9999;
                p.peso[22][16] = 9999;
                matriz[15][21]=matriz[21][15]=9999;
                validaCamino[25] = 1;
                break;
            case 26:
                p.peso[18][22] = 9999;
                p.peso[22][18] = 9999;
                matriz[17][21]=matriz[21][17]=9999;
                validaCamino[26] = 1;
                break;
            case 27:
                p.peso[16][17] = 9999;
                p.peso[17][16] = 9999;
                matriz[15][16]=matriz[16][15]=9999;
                validaCamino[27] = 1;
                break;
            case 28:
                p.peso[15][16] = 9999;
                p.peso[16][15] = 9999;
                matriz[14][15]=matriz[15][14]=9999;
                validaCamino[28] = 1;
                break;
            case 29:
                p.peso[14][15] = 9999;
                p.peso[15][14] = 9999;
                matriz[13][14]=matriz[14][13]=9999;
                validaCamino[29] = 1;
                break;
            case 30:
                p.peso[15][17] = 9999;
                p.peso[17][15] = 9999;
                matriz[14][16]=matriz[16][14]=9999;
                validaCamino[30] = 1;
                break;
            case 31:
                p.peso[17][18] = 9999;
                p.peso[18][17] = 9999;
                matriz[16][17]=matriz[17][16]=9999;
                validaCamino[31] = 1;
                break;
            case 32:
                p.peso[18][19] = 9999;
                p.peso[19][18] = 9999;
                matriz[17][18]=matriz[18][17]=9999;
                validaCamino[32] = 1;
                break;
            case 33:
                p.peso[19][20] = 9999;
                p.peso[20][19] = 9999;
                matriz[18][19]=matriz[19][18]=9999;
                validaCamino[33] = 1;
                break;
            case 34:
                p.peso[20][21] = 9999;
                p.peso[21][20] = 9999;
                matriz[19][20]=matriz[20][19]=9999;
                validaCamino[34] = 1;
                break;
            case 35:
                p.peso[10][21] = 9999;
                p.peso[21][10] = 9999;
                matriz[9][20]=matriz[20][9]=9999;
                validaCamino[35] = 1;
                break;
            case 36:
                p.peso[10][11] = 9999;
                p.peso[11][10] = 9999;
                matriz[9][10]=matriz[10][9]=9999;
                validaCamino[36] = 1;
                break;
            case 37:
                p.peso[11][12] = 9999;
                p.peso[12][11] = 9999;
                matriz[10][11]=matriz[11][10]=9999;
                validaCamino[37] = 1;
                break;
            case 38:
                p.peso[12][13] = 9999;
                p.peso[13][12] = 9999;
                matriz[11][12]=matriz[12][11]=9999;
                validaCamino[38] = 1;
                break;
            case 39:
                p.peso[13][19] = 9999;
                p.peso[19][13] = 9999;
                matriz[12][18]=matriz[18][12]=9999;
                validaCamino[39] = 1;
                break;
            case 40:
                p.peso[13][14] = 9999;
                p.peso[14][13] = 9999;
                matriz[12][13]=matriz[13][12]=9999;
                validaCamino[40] = 1;
                break;
            case 41:
                p.peso[9][10] = 9999;
                p.peso[10][9] = 9999;
                matriz[8][9]=matriz[9][8]=9999;
                validaCamino[41] = 1;
                break;
        }
    }

    //Este método abre el camino, misma metodología de cerrarCamino, solo que este devuelve el peso original que tenía al inicio
    public void abrirCamino(int camino) {
        switch (camino) {
            case 1:
                p.peso[8][9] = 244;
                p.peso[9][8] = 244;
                matriz[7][8]=matriz[8][7]=244;
                validaCamino[1] = 0;
                break;
            case 2:
                p.peso[30][1] = 85;
                p.peso[1][30] = 85;
                matriz[29][0]=matriz[0][29]=85;
                validaCamino[2] = 0;
                break;
            case 3:
                p.peso[1][8] = 62;
                p.peso[8][1] = 62;
                matriz[0][7]=matriz[7][0]=62;
                validaCamino[3] = 0;
                break;
            case 4:
                p.peso[1][2] = 43;
                p.peso[2][1] = 43;
                matriz[0][1]=matriz[1][0]=43;
                validaCamino[4] = 0;
                break;
            case 5:
                p.peso[2][7] = 58;
                p.peso[7][2] = 58;
                matriz[1][6]=matriz[6][1]=58;
                validaCamino[5] = 0;
                break;
            case 6:
                p.peso[8][7] = 61;
                p.peso[7][8] = 61;
                matriz[7][6]=matriz[6][7]=61;
                validaCamino[6] = 0;
                break;
            case 7:
                p.peso[6][7] = 59;
                p.peso[7][6] = 59;
                matriz[5][6]=matriz[6][5]=59;
                validaCamino[7] = 0;
                break;
            case 8:
                p.peso[3][6] = 62;
                p.peso[6][3] = 62;
                matriz[2][5]=matriz[5][2]=62;
                validaCamino[8] = 0;
                break;
            case 9:
                p.peso[2][3] = 58;
                p.peso[3][2] = 58;
                matriz[1][2]=matriz[2][1]=58;
                validaCamino[9] = 0;
                break;
            case 10:
                p.peso[3][4] = 62;
                p.peso[4][3] = 62;
                matriz[2][3]=matriz[3][2]=62;
                validaCamino[10] = 0;
                break;
            case 11:
                p.peso[4][5] = 62;
                p.peso[5][4] = 62;
                matriz[3][4]=matriz[4][3]=62;
                validaCamino[11] = 0;
                break;
            case 12:
                p.peso[5][6] = 61;
                p.peso[6][5] = 61;
                matriz[4][5]=matriz[5][4]=61;
                validaCamino[12] = 0;
                break;
            case 13:
                p.peso[5][29] = 58;
                p.peso[29][5] = 58;
                matriz[4][28]=matriz[28][4]=58;
                validaCamino[13] = 0;
                break;
            case 14:
                p.peso[28][29] = 58;
                p.peso[29][28] = 58;
                matriz[27][28]=matriz[28][27]=58;
                validaCamino[14] = 0;
                break;
            case 15:
                p.peso[25][28] = 62;
                p.peso[28][25] = 62;
                matriz[27][24]=matriz[24][27]=9999;
                validaCamino[15] = 0;
                break;
            case 16:
                p.peso[5][25] = 58;
                p.peso[25][5] = 58;
                matriz[4][24]=matriz[24][4]=58;
                validaCamino[16] = 0;
                break;
            case 17:
                p.peso[24][25] = 61;
                p.peso[25][24] = 61;
                matriz[23][24]=matriz[24][23]=61;
                validaCamino[17] = 0;
                break;
            case 18:
                p.peso[23][24] = 29;
                p.peso[24][23] = 29;
                matriz[22][23]=matriz[23][22]=29;
                validaCamino[18] = 0;
                break;
            case 19:
                p.peso[22][23] = 48;
                p.peso[23][22] = 48;
                matriz[21][22]=matriz[22][21]=48;
                validaCamino[19] = 0;
                break;
            case 20:
                p.peso[25][26] = 60;
                p.peso[26][25] = 60;
                matriz[24][25]=matriz[25][24]=60;
                validaCamino[20] = 0;
                break;
            case 21:
                p.peso[27][28] = 45;
                p.peso[28][27] = 45;
                matriz[27][26]=matriz[26][27]=45;
                validaCamino[21] = 0;
                break;
            case 22:
                p.peso[20][27] = 55;
                p.peso[27][20] = 55;
                matriz[19][26]=matriz[26][19]=55;
                validaCamino[22] = 0;
                break;
            case 23:
                p.peso[26][27] = 37;
                p.peso[27][26] = 37;
                matriz[25][26]=matriz[26][25]=37;
                validaCamino[23] = 0;
                break;
            case 24:
                p.peso[19][26] = 69;
                p.peso[26][19] = 69;
                matriz[25][18]=matriz[18][25]=69;
                validaCamino[24] = 0;
                break;
            case 25:
                p.peso[16][22] = 43;
                p.peso[22][16] = 43;
                matriz[15][21]=matriz[21][15]=43;
                validaCamino[25] = 0;
                break;
            case 26:
                p.peso[18][22] = 89;
                p.peso[22][18] = 89;
                matriz[17][21]=matriz[21][17]=89;
                validaCamino[26] = 0;
                break;
            case 27:
                p.peso[16][17] = 90;
                p.peso[17][16] = 90;
                matriz[15][16]=matriz[16][15]=9999;
                validaCamino[27] = 0;
                break;
            case 28:
                p.peso[15][16] = 146;
                p.peso[16][15] = 146;
                matriz[14][15]=matriz[15][14]=146;
                validaCamino[28] = 0;
                break;
            case 29:
                p.peso[14][15] = 182;
                p.peso[15][14] = 182;
                matriz[13][14]=matriz[14][13]=182;
                validaCamino[29] = 0;
                break;
            case 30:
                p.peso[15][17] = 150;
                p.peso[17][15] = 150;
                matriz[14][16]=matriz[16][14]=150;
                validaCamino[30] = 0;
                break;
            case 31:
                p.peso[17][18] = 41;
                p.peso[18][17] = 41;
                matriz[17][16]=matriz[16][17]=41;
                validaCamino[31] = 0;
                break;
            case 32:
                p.peso[18][19] = 66;
                p.peso[19][18] = 66;
                matriz[17][18]=matriz[18][17]=66;
                validaCamino[32] = 0;
                break;
            case 33:
                p.peso[19][20] = 39;
                p.peso[20][19] = 39;
                matriz[19][18]=matriz[18][19]=39;
                validaCamino[33] = 0;
                break;
            case 34:
                p.peso[20][21] = 82;
                p.peso[21][20] = 82;
                matriz[19][20]=matriz[20][19]=82;
                validaCamino[34] = 0;
                break;
            case 35:
                p.peso[10][21] = 34;
                p.peso[21][10] = 34;
                matriz[9][20]=matriz[29][9]=34;
                validaCamino[35] = 0;
                break;
            case 36:
                p.peso[10][11] = 33;
                p.peso[11][10] = 33;
                matriz[9][10]=matriz[10][9]=33;
                validaCamino[36] = 0;
                break;
            case 37:
                p.peso[11][12] = 123;
                p.peso[12][11] = 123;
                matriz[10][11]=matriz[11][10]=123;
                validaCamino[37] = 0;
                break;
            case 38:
                p.peso[12][13] = 108;
                p.peso[13][12] = 108;
                matriz[11][12]=matriz[12][11]=108;
                validaCamino[38] = 0;
                break;
            case 39:
                p.peso[13][19] = 135;
                p.peso[19][13] = 135;
                matriz[12][18]=matriz[18][12]=135;
                validaCamino[39] = 0;
                break;
            case 40:
                p.peso[13][14] = 475;
                p.peso[14][13] = 475;
                matriz[12][13]=matriz[13][12]=474;
                validaCamino[40] = 0;
                break;
            case 41:
                p.peso[9][10] = 490;
                p.peso[10][9] = 490;
                matriz[9][8]=matriz[8][9]=490;
                validaCamino[41] = 0;
                break;

        }
    }

    //Este método llena la matriz de pesos que está en la clase proceso; lo hace de acuerdo a la matriz del archivo con el grafo
    //se hacen dos matrices para ignorar el nodo 0
    public void llenarPesos() throws IOException {

        muestraContenidoMatriz("GrafoComas.csv");
        for (int i = 1; i <= numnodos; i++) {
            for (int j = 1; j <= numnodos; j++) {
                p.peso[i][j] = matriz[i - 1][j - 1];
                if (p.peso[i][j] == 0) {
                    p.peso[i][j] = 9999;
                }
            }
        }
        for (int i = 0; i < numnodos; i++) {
            for (int j = 0; j < numnodos; j++) {
                if (matriz[i][j] == 0) {
                    matriz[i][j] = 9999;
                }
            }
        }
    }

    //Acá se ejecutará el algoritmo, recibo el nodo de inicio y el final, ejecutará el proceso y cambiará el valor de "distancia"
    //que al ser público se podrá acceder con mayor facilidad
    public void algoritmoDijkstra(int inicio, int fin) {

        p.calcular(numnodos, inicio);
        if (inicio == fin) { //Valida si el inicio es igual al fin, si no es no hace el proceso, solo retorna distancia 0
            distancia = 0;
        } else {
            for (int i = 1; i <= numnodos; i++) {
                if (i != inicio) {
                    //JOptionPane.showMessageDialog(null, "Desde el nodo " + inicio + " a el nodo " + i + " exite una distancia mínima de: "+ p.distancia[i]);
                    if (i == fin) {
                        distancia = p.distancia[i];
                    }

                }
            }
        }
    }

    /* ------------------------------------------------------------------------------------------------------------------*/
    //Esta sección se añadió para mostrar el camino
    private int[] ultimo;// este guarda el camino mas corto
    private int[] D;// distancias
    private int[][] pesos; //Matriz auxiliar
    private boolean[] F;// matriz de marcado 
    private int s, n; // "S" es el vértice de origen y "N" es el número de vértices
    public String textoCamino = "";

    public void iniciarDijkstra(int inicial) {
        textoCamino = "";
        n = 30;
        s = inicial;
        pesos = matriz;
        ultimo = new int[n];
        D = new int[n];
        F = new boolean[n];
    }

    public void caminoMinimo() {
        // valores iniciales de f,d y ultimo con las conexiones del vertice, sus distancias y vertices de camino mas corto
        for (int i = 0; i < n; i++) {
            F[i] = false;// marca
            D[i] = pesos[s][i];// distancias de el vertice inicial a todos los vertices
            ultimo[i] = s;// de almacen los vertices por donde pasa buscando el camino mas corto
        }
        F[s] = true;
        D[s] = 0;// esta es la distancia con la que comienza
        // Pasos para marcar los n-1 vértices
        for (int i = 0; i < n; i++) {
            int v = minimo();
            //selecciona vértice no marcado de menor distancia (sola la posicion)
            F[v] = true;
            // actualiza distancia de vértices no marcados
            for (int w = 0; w < n; w++) {
                if (!F[w]) {
                    if ((D[v] + pesos[v][w]) < D[w]) {
                        D[w] = D[v] + pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }

    private int minimo() {
        // escoje el menor numero de la matriz
        int mx = Integer.MAX_VALUE;
        int v = 1;
        for (int j = 0; j < n; j++) {
            if (!F[j] && (D[j] <= mx)) {
                mx = D[j];
                v = j;
            }
        }

        return v;
    }

    public void recuperaCamino(int v) {
        // V es el vertice al que se desea llegar 
        int anterior = ultimo[v];
        if (v != s) {
            recuperaCamino(anterior); // vuelve al último del último
            textoCamino+= (v+1)+ " - ";
        } else {
            textoCamino+= (s+1)+ " - ";
        }
    }

}
