/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dijkstra.Dijkstra;
import estructuradedatos.GrafoImp;
import estructuradedatos.Persona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import login.Registro;

public class Home extends javax.swing.JFrame {

    //Se inicializan todas las variables
    GrafoImp grafo = new GrafoImp(); //Obtener datos del grafo
    Dijkstra algoritmo = new Dijkstra(); //algoritmo para hacer todo lo necesario con Dijkstra
    Registro mod; //Registro para obtener el usuario
    int inicial = 9, destino = 1, hayCerrado = 0, posicion = 0, personas = 0, personasRecogidas = 0;
    // Guarda la posición actual del vehículo de emergencia(es el nodo de origen); almacena el nodo de destino;
    // Valida si hay o no caminos cerrados; Posición es un auxiliar para el destino, esta guarda la ubicación
    // de la persona de acuerdo a su triage; almacena el número total de personas en X recorrigo; personas recogidas
    // en ese mismo recorrido

    public Home() throws IOException {
        //Este sirve para ejecutar el jFrame desde él mismo
        initComponents();
        grafo.llenar(); //Llena el grafo

        //Oculta botones no necesarios en el instante
        botonRecogio.setVisible(false);
        botonCancelar.setVisible(false);
        botonCaminoAbierto.setVisible(false);
        botonSiguiente.setVisible(false);
        botonEliminarPersona.setVisible(false);
        labelRecogidos.setVisible(false);
        labelDe.setVisible(false);
        muestraRecogidos.setVisible(false);
        muestraDe.setVisible(false);
        labelRuta.setVisible(false);
        muestraRuta.setVisible(false);

        setLocationRelativeTo(null);

        //Llena la matriz de pesos del dijkstra
        algoritmo.llenarPesos();
    }

    public Home(Registro mod) throws IOException {
       //Este ejectua el jFrame de acuerdo al registro o al login
        initComponents();
        this.mod = mod;
        //Muestra en pantalla el nombre del usuario
        lblNombre.setText(mod.getNombre());
        grafo.llenar(); //Llena el grafo

        //Oculta botones no necesarios en el instante
        botonRecogio.setVisible(false);
        botonCancelar.setVisible(false);
        botonCaminoAbierto.setVisible(false);
        botonSiguiente.setVisible(false);
        botonEliminarPersona.setVisible(false);
        labelRecogidos.setVisible(false);
        labelDe.setVisible(false);
        muestraRecogidos.setVisible(false);
        muestraDe.setVisible(false);
        labelRuta.setVisible(false);
        muestraRuta.setVisible(false);

        setLocationRelativeTo(null);

        //Llena la matriz de pesos del dijkstra
        algoritmo.llenarPesos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jDialog5 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        muestraRuta = new javax.swing.JLabel();
        labelRuta = new javax.swing.JLabel();
        labelBestRoute = new javax.swing.JLabel();
        muestraDe = new javax.swing.JLabel();
        labelDe = new javax.swing.JLabel();
        muestraRecogidos = new javax.swing.JLabel();
        labelRecogidos = new javax.swing.JLabel();
        botonRecogio = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        unidadMetros = new javax.swing.JLabel();
        muestraDistancia = new javax.swing.JLabel();
        labelDistancia = new javax.swing.JLabel();
        muestraDestino = new javax.swing.JLabel();
        labelDestino = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        btCalcular = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelGrafo = new javax.swing.JLabel();
        botonPosicion = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        labelPosicion = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonAgregarPersona = new javax.swing.JButton();
        botonCaminoAbierto = new javax.swing.JButton();
        botonEliminarPersona = new javax.swing.JButton();
        colorFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        muestraRuta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        muestraRuta.setForeground(new java.awt.Color(51, 51, 0));
        muestraRuta.setText("- - -");
        getContentPane().add(muestraRuta);
        muestraRuta.setBounds(590, 650, 600, 30);

        labelRuta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelRuta.setForeground(new java.awt.Color(102, 51, 0));
        labelRuta.setText("Ruta:");
        getContentPane().add(labelRuta);
        labelRuta.setBounds(540, 650, 40, 30);

        labelBestRoute.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelBestRoute.setForeground(new java.awt.Color(102, 51, 0));
        labelBestRoute.setText("Best Route");
        getContentPane().add(labelBestRoute);
        labelBestRoute.setBounds(430, -30, 210, 120);

        muestraDe.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        muestraDe.setForeground(new java.awt.Color(102, 51, 0));
        muestraDe.setText("XX");
        getContentPane().add(muestraDe);
        muestraDe.setBounds(380, 620, 60, 90);

        labelDe.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelDe.setForeground(new java.awt.Color(102, 51, 0));
        labelDe.setText("de");
        getContentPane().add(labelDe);
        labelDe.setBounds(330, 640, 50, 50);

        muestraRecogidos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        muestraRecogidos.setForeground(new java.awt.Color(51, 51, 0));
        muestraRecogidos.setText("XX");
        getContentPane().add(muestraRecogidos);
        muestraRecogidos.setBounds(270, 620, 40, 90);

        labelRecogidos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelRecogidos.setForeground(new java.awt.Color(102, 51, 0));
        labelRecogidos.setText("Recogidos:");
        getContentPane().add(labelRecogidos);
        labelRecogidos.setBounds(110, 640, 140, 50);

        botonRecogio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonRecogio.setForeground(new java.awt.Color(51, 204, 0));
        botonRecogio.setText("Persona recogida");
        botonRecogio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecogioActionPerformed(evt);
            }
        });
        getContentPane().add(botonRecogio);
        botonRecogio.setBounds(1010, 250, 160, 50);

        botonSiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSiguiente.setForeground(new java.awt.Color(0, 0, 255));
        botonSiguiente.setText("Siguiente Persona");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonSiguiente);
        botonSiguiente.setBounds(1010, 250, 160, 50);

        unidadMetros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        unidadMetros.setForeground(new java.awt.Color(51, 51, 0));
        unidadMetros.setText("metros");
        getContentPane().add(unidadMetros);
        unidadMetros.setBounds(1150, 460, 60, 50);

        muestraDistancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        muestraDistancia.setForeground(new java.awt.Color(51, 51, 0));
        muestraDistancia.setText("XX");
        getContentPane().add(muestraDistancia);
        muestraDistancia.setBounds(1110, 450, 40, 60);

        labelDistancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDistancia.setForeground(new java.awt.Color(102, 51, 0));
        labelDistancia.setText("Distacia:");
        getContentPane().add(labelDistancia);
        labelDistancia.setBounds(1040, 470, 70, 20);

        muestraDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        muestraDestino.setForeground(new java.awt.Color(51, 51, 0));
        muestraDestino.setText("X");
        getContentPane().add(muestraDestino);
        muestraDestino.setBounds(1110, 410, 40, 60);

        labelDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDestino.setForeground(new java.awt.Color(102, 51, 0));
        labelDestino.setText("Destino:");
        getContentPane().add(labelDestino);
        labelDestino.setBounds(1040, 430, 90, 20);

        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 0, 0));
        botonCancelar.setText("CANCELAR RUTA");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar);
        botonCancelar.setBounds(1020, 310, 140, 40);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 51, 0));
        lblNombre.setText("Usuario");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(10, 550, 490, 30);

        btCalcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btCalcular.setForeground(new java.awt.Color(102, 51, 0));
        btCalcular.setText("INICIAR RECORRIDO");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btCalcular);
        btCalcular.setBounds(60, 640, 210, 50);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 51, 0));
        jButton1.setText("REPORTAR CAMINO CERRADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 640, 250, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1190, 650, 80, 30);

        labelGrafo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grafoTotal.png"))); // NOI18N
        getContentPane().add(labelGrafo);
        labelGrafo.setBounds(10, 40, 994, 600);

        botonPosicion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonPosicion.setForeground(new java.awt.Color(102, 51, 0));
        botonPosicion.setText("Cambiar posición");
        botonPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPosicionActionPerformed(evt);
            }
        });
        getContentPane().add(botonPosicion);
        botonPosicion.setBounds(1010, 80, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("Posición actual:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1020, 130, 120, 20);

        labelPosicion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPosicion.setForeground(new java.awt.Color(102, 102, 0));
        labelPosicion.setText("9");
        getContentPane().add(labelPosicion);
        labelPosicion.setBounds(1140, 120, 30, 40);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonConsultar.setForeground(new java.awt.Color(102, 51, 0));
        botonConsultar.setText("Consultar intersección");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConsultar);
        botonConsultar.setBounds(1010, 180, 170, 40);

        botonAgregarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregarPersona.setForeground(new java.awt.Color(102, 51, 0));
        botonAgregarPersona.setText("Agregar Persona");
        botonAgregarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregarPersona);
        botonAgregarPersona.setBounds(1010, 250, 160, 40);

        botonCaminoAbierto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonCaminoAbierto.setForeground(new java.awt.Color(102, 51, 0));
        botonCaminoAbierto.setText("REPORTAR CAMINO ABIERTO");
        botonCaminoAbierto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCaminoAbiertoActionPerformed(evt);
            }
        });
        getContentPane().add(botonCaminoAbierto);
        botonCaminoAbierto.setBounds(580, 640, 260, 50);

        botonEliminarPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonEliminarPersona.setForeground(new java.awt.Color(102, 51, 0));
        botonEliminarPersona.setText("Eliminar Persona");
        botonEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminarPersona);
        botonEliminarPersona.setBounds(1010, 310, 160, 40);

        colorFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ColorFondo.png"))); // NOI18N
        colorFondo.setText("jLabel2");
        getContentPane().add(colorFondo);
        colorFondo.setBounds(0, -46, 1280, 770);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Este botón inicia el recorrido
    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed

        try {
            //Coloca la cantidad de personas como 0, por si no es el primer recorrido
            grafo.cantidadPersonas = 0;
            if (grafo.hayPersonas()) { //Si el grafo tiene personas hará el proceso
                grafo.cuentaPersonas();//Cuenta las personas que hay en el grafo
                personas = grafo.cantidadPersonas;
                grafo.triageMayor(); //Calcula la persona con el mayor triage
                posicion = grafo.idTriagreMax; //Almacena la posición del la persona con mayor triage
                grafo.mostrarTriage(posicion); //Muestra la persona a recoger y su ubicación
                algoritmo.algoritmoDijkstra(inicial, posicion); //Calcula la ruta
                algoritmo.iniciarDijkstra(inicial - 1);
                algoritmo.caminoMinimo();
                algoritmo.recuperaCamino(posicion - 1);

                //Control de botones necesarios o no en el instante
                botonAgregarPersona.setVisible(false);
                botonEliminarPersona.setVisible(false);
                botonCaminoAbierto.setVisible(false);
                jButton1.setVisible(false);
                btCalcular.setVisible(false);
                botonRecogio.setVisible(true);
                botonCancelar.setVisible(true);
                labelRecogidos.setVisible(true);
                labelDe.setVisible(true);
                muestraRecogidos.setVisible(true);
                muestraDe.setVisible(true);
                labelRuta.setVisible(true);
                muestraRuta.setVisible(true);

                //Coloca el texto en cada label de acuerdo a los datos calculados 
                muestraRecogidos.setText("0");
                muestraDe.setText(String.valueOf(personas));
                muestraDistancia.setText(String.valueOf(algoritmo.distancia));
                muestraDestino.setText(String.valueOf(posicion));
                muestraRuta.setText(algoritmo.textoCamino);
            } else { //Como no tiene personas, lo mostrará en un mensaje
                JOptionPane.showMessageDialog(null, "No hay personas ");
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btCalcularActionPerformed

    //Este botón permite cerrar un camino
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //Recibe el ID del camino que está cerrado
            int camino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del camino cerrado"));
            if (camino < 1 || camino > 41) { //Valida que el camino exista
                JOptionPane.showMessageDialog(null, "Digite un camino válido"); //Si no existe el camino
            } else { //Como exite el camino...
                if (algoritmo.validaCamino[camino] == 1) { //Valida si el camino ya estaba cerrado
                    JOptionPane.showMessageDialog(null, "El camino ya estaba cerrado");//Si estaba cerrado
                } else {//Como no estaba cerrado...
                    hayCerrado++;//Añade un camino más al contador de cerrados
                    algoritmo.cerrarCamino(camino); //Reemplaza el peso en la matriz
                    JOptionPane.showMessageDialog(null, "Camino cerrado");//Muestra que se cerró
                }
                if (hayCerrado > 0) { //Deja ver el botón para abrir caminos solo si hay alguno cerrado
                    botonCaminoAbierto.setVisible(true);
                }
            }
        } catch (Exception e) {//Valida que sí digite números
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Botón para salir del programa
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int n = JOptionPane.showConfirmDialog(null, "¿Seguro desea salir?", "", JOptionPane.OK_CANCEL_OPTION);

        if (n == 0) {
            this.dispose();
        } else {

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    //Botón para cambiar la posición del equipo de emergencia
    private void botonPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPosicionActionPerformed
        try {
            int inicialp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del camino que quiere cerrar"));
            if (inicialp < 1 || inicialp > 30) { //Valida que la posición exista
                JOptionPane.showMessageDialog(null, "Digite una posición válida válido");
            } else {
                inicial = inicialp; //Cambia el nodo inicial para el dijkstra
                String pantalla = String.valueOf(inicialp);
                labelPosicion.setText(pantalla); //Cambia en el label la posición en que está
            }
        } catch (Exception e) { //valida que el usuario digite números
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_botonPosicionActionPerformed

    //Botón para consultar personas en un nodo
    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        try {
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite la intersección a consultar"));
            if (pos < 1 || pos > 30) {//Valida que el nodo exista
                JOptionPane.showMessageDialog(null, "La intersección no existe");
            } else {
                grafo.buscar(pos); //Busca la persona en esa posición, el método se encarga de validar si hay o no
            }
        } catch (Exception e) { //valida que digite números
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_botonConsultarActionPerformed

    //Botón para agregar personas
    private void botonAgregarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPersonaActionPerformed
        try {
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite la intersección donde está la persona"));
            if (pos < 1 || pos > 30) { //Valida que el nodo exista
                JOptionPane.showMessageDialog(null, "La intersección no existe");
            } else {//Pide los datos de la persona
                String n = " --- ";
                n = JOptionPane.showInputDialog("Digite el nombre");
                int e = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad"));
                int t = Integer.parseInt(JOptionPane.showInputDialog("Digite el triage [de 1 a 5]"));
                if (t > 5 || t < 1) {
                    JOptionPane.showMessageDialog(null, "El triage debe ser de 1 a 5"); //Valida que el triage sea correcto
                } else {
                    Persona p = new Persona(t, e, n);
                    grafo.agregarPersona(pos, p); //Agrega la persona
                    JOptionPane.showMessageDialog(null, "Persona agregada");
                    botonEliminarPersona.setVisible(true);//Muestra el botón para permitir eliminarla
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_botonAgregarPersonaActionPerformed

    //Botón para abrir un camino
    private void botonCaminoAbiertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCaminoAbiertoActionPerformed
        try {
            int camino;
            camino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del camino abierto"));
            if (camino < 1 || camino > 41) { //Valida que el camino exista
                JOptionPane.showMessageDialog(null, "Digite un camino válido");
            } else {
                if (algoritmo.validaCamino[camino] == 0) { //Valida si ya estaba abierto o no
                    JOptionPane.showMessageDialog(null, "El camino ya estaba abierto");
                } else {
                    hayCerrado--;//Resta un camino de los cerrados
                    algoritmo.abrirCamino(camino); //Cierra el camino
                    JOptionPane.showMessageDialog(null, "Camino abierto");
                }
                if (hayCerrado <= 0) { //Si ya no hay caminos cerrados, oculta el botón para abrir un camino
                    botonCaminoAbierto.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_botonCaminoAbiertoActionPerformed

    //Botón para eliminar una persona
    private void botonEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPersonaActionPerformed
        try {
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite la intersección donde está la persona a eliminar"));
            if (pos < 1 || pos > 30) { //Valida que el nodo exista
                JOptionPane.showMessageDialog(null, "La intersección no existe");
            } else {
                grafo.buscarPersonaPorPosicion(pos);//Busca la persona en esa posición
                if (grafo.hayPersonaEnEsaPosicion == true) {//Si hay persona la elimina
                    grafo.eliminarPersona(pos);
                    JOptionPane.showMessageDialog(null, "Persona eliminada");
                } else {//Si no, muestra en pantalla que ya estaba vacía esa posición
                    JOptionPane.showMessageDialog(null, "La posición ya está vacía");
                }
                if (grafo.hayPersonas()) {
                } else {//Si ya no hay personas en el grafo oculta el botón para eliminarlas
                    botonEliminarPersona.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite un dato válido");
        }
    }//GEN-LAST:event_botonEliminarPersonaActionPerformed

    //Botón para indicar que se recogió una persona
    private void botonRecogioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecogioActionPerformed

        if (personas >= personasRecogidas) { //Valida que haya mayor o igual cantidad de personas totales a las recogidas
            inicial = posicion;
            grafo.eliminarPersona(posicion); //Como ya se recogió, se elimina esa persona de la posición
            personasRecogidas++;//Suma una persona recogida
            if (personasRecogidas != personas) { //Valida que no sea el mismo número de personas totales a las recogidas
                //Reemplaza los valores en los label
                muestraRecogidos.setText(String.valueOf(personasRecogidas));
                muestraDestino.setText(String.valueOf(posicion));
                muestraDistancia.setText("0");
                labelPosicion.setText(String.valueOf(inicial));
                //Hace o no visibles los botones necesarios en el instante
                botonSiguiente.setVisible(true);
                botonRecogio.setVisible(false);
            } else { //Como no es diferente quiere decir que es el mismo, puesto que en la condición de arriba
                // no se deja pasar si es mayor el número de personas recogidas
                //Se termina el recorrido, se reemplazan valores en los label y se ocultan/muestran
                // ciertos botones de acuerdo a su necesidad en el instante 
                botonAgregarPersona.setVisible(true);
                if (grafo.hayPersonas()) {//Valida si hay personas
                    botonEliminarPersona.setVisible(true);
                }
                if (hayCerrado <= 0) {//Valida si hay caminos cerrados
                    botonCaminoAbierto.setVisible(false);
                } else {
                    botonCaminoAbierto.setVisible(true);
                }
                jButton1.setVisible(true);
                btCalcular.setVisible(true);
                botonRecogio.setVisible(false);
                botonCancelar.setVisible(false);
                labelRecogidos.setVisible(false);
                labelDe.setVisible(false);
                muestraRecogidos.setVisible(false);
                muestraDe.setVisible(false);
                labelRuta.setVisible(false);
                muestraRuta.setVisible(false);
                grafo.cantidadPersonas = personas = personasRecogidas = 0; //Coloca en 0 todas las variables relacionadas solo
                // con el recorrido para que no generen conflicto con futuros recorridos
                muestraDestino.setText(String.valueOf(inicial));
                labelPosicion.setText(String.valueOf(inicial));
                muestraDistancia.setText("0");
                JOptionPane.showMessageDialog(null, "Recorrido terminado");
            }
        }
    }//GEN-LAST:event_botonRecogioActionPerformed

    //Botón para recoger a la siguiente persona
    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed

        try {
            grafo.triageMayor();
            posicion = grafo.idTriagreMax;
            grafo.mostrarTriage(posicion);
            algoritmo.algoritmoDijkstra(inicial, posicion); //Ejecuta el Dijkstra en la posición de la persona con
            // triage mayor, igual al botón de iniciar la ruta
            //Muestra el camino
            algoritmo.iniciarDijkstra(inicial - 1);
            algoritmo.caminoMinimo();
            algoritmo.recuperaCamino(posicion - 1);
            //------------------------------------------------
            //Oculta botones y reemplaza textos en los distintos label
            botonRecogio.setVisible(true);
            botonSiguiente.setVisible(false);;
            labelRuta.setVisible(true);
            muestraRuta.setVisible(true);
            muestraDistancia.setText(String.valueOf(algoritmo.distancia));
            muestraDestino.setText(String.valueOf(posicion));
            muestraRuta.setText(algoritmo.textoCamino);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    //Botón para cancelar el recorrido
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        //Similar a cuando el recorrido se termina
        //Reemplaza texto en los label, oculta/muestra botones de acuerdo a lo necesario
        botonAgregarPersona.setVisible(true);
        botonCaminoAbierto.setVisible(true);
        jButton1.setVisible(true);
        btCalcular.setVisible(true);
        botonRecogio.setVisible(false);
        botonSiguiente.setVisible(false);
        botonCancelar.setVisible(false);
        labelRecogidos.setVisible(false);
        labelDe.setVisible(false);
        labelRuta.setVisible(false);
        muestraRuta.setVisible(false);
        if (grafo.hayPersonas()) {//Valida si hay o no personas
            botonEliminarPersona.setVisible(true);//Si hay hace visible el botón para eliminar
        }
        if (hayCerrado <= 0) {//Valida si hay o no caminos cerrados para mostrar o no el botón de abrir camino
            botonCaminoAbierto.setVisible(false);
        } else {
            botonCaminoAbierto.setVisible(true);
        }
        muestraRecogidos.setVisible(false);
        muestraDe.setVisible(false);
        muestraDestino.setText(String.valueOf(inicial));
        muestraDistancia.setText("0");
        grafo.cantidadPersonas = personas = personasRecogidas = 0; //Todas las variables del recorrido se igualan a 
    }//GEN-LAST:event_botonCancelarActionPerformed

    //Main del formulario
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Home.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarPersona;
    private javax.swing.JButton botonCaminoAbierto;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonEliminarPersona;
    private javax.swing.JToggleButton botonPosicion;
    private javax.swing.JButton botonRecogio;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton btCalcular;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel colorFondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelBestRoute;
    private javax.swing.JLabel labelDe;
    private javax.swing.JLabel labelDestino;
    private javax.swing.JLabel labelDistancia;
    private javax.swing.JLabel labelGrafo;
    private javax.swing.JLabel labelPosicion;
    private javax.swing.JLabel labelRecogidos;
    private javax.swing.JLabel labelRuta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel muestraDe;
    private javax.swing.JLabel muestraDestino;
    private javax.swing.JLabel muestraDistancia;
    private javax.swing.JLabel muestraRecogidos;
    private javax.swing.JLabel muestraRuta;
    private javax.swing.JLabel unidadMetros;
    // End of variables declaration//GEN-END:variables
}
