/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.abs;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRootPane;

/**
 *
 * @author felip
 */
public class InterfazGrafica extends javax.swing.JFrame {

  TablaPeriodica tablaPeriodica;
  private final javax.swing.JButton[] botones;
  private final ImageIcon[] imagenes;
  Elemento[] losElementos;
  
  //private javax.swing.JButton button_array[];
  /**
   * Creates new form InterfazGrafica
   */
  public InterfazGrafica() {

    
    this.setUndecorated(true);
    this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    imagenes = new ImageIcon[118];
    //this.setLocation(200, 150);
    initComponents();
    getContentPane().setBackground(Color.BLACK);
    tablaPeriodica = new TablaPeriodica();
    botones = new javax.swing.JButton[]{hidrogeno, helio, litio, berilio, boro, carbono, nitrogeno, oxigeno, fluor, neon, sodio, magnesio, aluminio, silicio, fosforo, azufre, cloro, argon, potasio, calcio, escandio, titanio, vanadio, cromo, manganeso, hierro, cobalto, niquel, cobre, zinc, galio, germanio, arsenico, selenio, bromo, krypton, rubidio, estroncio, itrio, circonio, niobio, molibdeno, tecnecio, rutenio, rodio, paladio, plata, cadmio, indio, estanno, antimonio, telurio, yodo, xenon, cesio, bario, lantano, cerio, praseodimio, neodimio, prometio, samario, europio, gadolinio, terbio, disprosio, holmio, erbio, tulio, iterbio, lutecio, hafnio, tantalio, wolframio, renio, osmio, iridio, platino, oro, mercurio, talio, plomo, bismuto, polonio, astato, radon, francio, radio, actinio, torio, protactinio, uranio, neptunio, plutonio, americio, curio, berkelio, californio, einstenio, fermio, mendelevio, nobelio, lawrencio, rutherfordio, dubnio, seaborgio, bohrio, hassio, meitnerio, darmstadio, roentgenio, copernicio, nihonium, flerovio, moscovium, livermorio, tennessine, oganesson};
    this.lantano_salto.setBackground(Color.BLACK);
    this.actinio_salto.setBackground(Color.BLACK);
    //hidrogeno.addActionListener(boro.getActionListeners()[0]);
    //botones[0].setBackground(Color.decode("0xA3FFC7"));
    losElementos = tablaPeriodica.getElementos();

    for (int i = 0; i < 118; i++) {
      Elemento elemento = tablaPeriodica.getElementos()[i];
      ImageIcon imagen;
      File f = new File(elemento.getNombre() + ".gif");
      if (f.exists() && !f.isDirectory()) {
        imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".gif").getImage().getScaledInstance(48, 36, Image.SCALE_DEFAULT));
      } else {
        imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".jpg").getImage().getScaledInstance(48, 36, Image.SCALE_DEFAULT));
      }
      botones[i].setIcon(imagen);
      imagenes[i] = imagen;
      botones[i].setName(elemento.getSimbolo());
      String espacios = "";
      for (int j = 0; j < (10 + abs((String.valueOf(elemento.getPesoAtomico()) + elemento.getSimbolo()).length() - 5)); j++) {
        espacios += "&nbsp;";
      }

      botones[i].setText("<html><left><p>" + elemento.getSimbolo() + espacios + elemento.getPesoAtomico() + "</p><br>"
              + "<left><p>" + elemento.getMasaAtomica() + "</p></html>");

      //botones[i].setText(elemento.getSimbolo() + "\n" + elemento.getPesoAtomico() + elemento.)getMasaAtomica());
      //String color = elemento.getColor();
      //if (!color.equals("")) botones[i].setBackground(Color.decode("0x"+color));
      botones[i].setToolTipText(elemento.getNombre());
      botones[i].addActionListener(boro.getActionListeners()[0]);
    }

    this.cbbOrdenarM.setBackground(Color.BLACK);
    this.cbbOrdenarT.setBackground(Color.BLACK);
    this.icons.setSelected(true);
  }

  public void reordenar() {
    System.out.println("REORDENAR");
    
    for (JButton boton: botones) {
      System.out.println(boton.getText());
      Elemento elementoBoton = new Elemento();
      int indice = 0;
      for (Elemento elemento: tablaPeriodica.getElementos()) {
        //System.out.println("SIMMM    " + elemento.getSimbolo());
        if (elemento.getSimbolo().equals(boton.getText())) {
          elementoBoton = elemento;
          break;
        }
        indice++;
      }
      String espacios = "";
      for (int j = 0; j < (10 + abs((String.valueOf(elementoBoton.getPesoAtomico()) + elementoBoton.getSimbolo()).length() - 5)); j++) {
        espacios += "&nbsp;";
      }
      ///////////////////boton.setIcon(imagenes[indice]);
      boton.setName(elementoBoton.getSimbolo());
      boton.setText("<html><left><p>" + elementoBoton.getSimbolo() + espacios + elementoBoton.getPesoAtomico() + "</p><br>"
              + "<left><p>" + elementoBoton.getMasaAtomica() + "</p></html>");
      boton.setToolTipText(elementoBoton.getNombre());
    }
    if (this.icons.isSelected()) {
      this.icons.doClick();
    } else if (this.cpkColoring.isSelected()) {
      this.cpkColoring.doClick();
    } else {
      this.temperature.doClick();
    }
  
  }
    /*
    *ordena los botones de acuerdo al nombre que tiene ya sea ascendente o descendente
    *@param modo(Ascendente o descendente)
    */
    public void ordenarNombre(String modo){
        if(modo.equals("Ascendente")){
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getNombre().compareToIgnoreCase(losElementos[j].getNombre())<0){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }else{
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getNombre().compareToIgnoreCase(losElementos[j].getNombre())>0){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }
    }
    /*
    *ordena los botones de acuerdo al Simbolo del elemento que tiene ya sea ascendente o descendente
    *@param modo(Ascendente o Descendente)
    */
    public void ordenarSimbolo(String modo){
        if(modo.equals("Ascendente")){
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getSimbolo().compareToIgnoreCase(losElementos[j].getSimbolo())<0){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }else{
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getSimbolo().compareToIgnoreCase(losElementos[j].getSimbolo())>0){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }
    }
    /*
    *ordena los botones de acuerdo al numero atomico del elemento que tiene ya sea ascendente o descendente
    *@param modo(Ascendente o Descendente)
    */
    public void ordenarNumeroAtomico(String modo){ 
        if(modo.equals("Ascendente")){
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPesoAtomico()<losElementos[j].getPesoAtomico()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }else{
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPesoAtomico()>losElementos[j].getPesoAtomico()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }
    }
    /*
    *ordena los botones de acuerdo al punto de Fusion del elemento que tiene ya sea ascendente o descendente
    *@param modo(Ascendente o Descendente)
    */
    public void ordenarPuntoFusion(String modo){
        if(modo.equals("Ascendente")){
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPuntoFusion().getTemperatura()<losElementos[j].getPuntoFusion().getTemperatura()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }else{
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPuntoFusion().getTemperatura()>losElementos[j].getPuntoFusion().getTemperatura()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }
    }
    /*
    *ordena los botones de acuerdo al punto de Embullicion del elemento que tiene ya sea ascendente o descendente
    *@param modo(Ascendente o Descendente)
    */
    public void ordenarPuntoEmbullicion(String modo){
        if(modo.equals("Ascendente")){
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPuntoEbullicion().getTemperatura()<losElementos[j].getPuntoEbullicion().getTemperatura()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }else{
            for(int i=0;i<losElementos.length;i++){
                for(int j=0;j<losElementos.length && i!=j;j++){
                    if(losElementos[i].getPuntoEbullicion().getTemperatura()>losElementos[j].getPuntoEbullicion().getTemperatura()){
                        Elemento aux=losElementos[i];
                        losElementos[i]=losElementos[j];
                        losElementos[j]=aux;
                    }
                }
            }
            for(int i=0;i<botones.length;i++){
                botones[i].setText(losElementos[i].getSimbolo());
            }
        }
    }
      
  
  
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButton69 = new javax.swing.JButton();
    jButton70 = new javax.swing.JButton();
    jButton71 = new javax.swing.JButton();
    jButton72 = new javax.swing.JButton();
    jButton73 = new javax.swing.JButton();
    jButton74 = new javax.swing.JButton();
    jButton75 = new javax.swing.JButton();
    jButton76 = new javax.swing.JButton();
    jFrame1 = new javax.swing.JFrame();
    jFrame2 = new javax.swing.JFrame();
    jFrame3 = new javax.swing.JFrame();
    jFrame4 = new javax.swing.JFrame();
    jFrame5 = new javax.swing.JFrame();
    jSeparator1 = new javax.swing.JSeparator();
    jFrame6 = new javax.swing.JFrame();
    hidrogeno = new javax.swing.JButton();
    helio = new javax.swing.JButton();
    cobre = new javax.swing.JButton();
    antimonio = new javax.swing.JButton();
    arsenico = new javax.swing.JButton();
    molibdeno = new javax.swing.JButton();
    tecnecio = new javax.swing.JButton();
    rutenio = new javax.swing.JButton();
    niobio = new javax.swing.JButton();
    rodio = new javax.swing.JButton();
    rubidio = new javax.swing.JButton();
    plata = new javax.swing.JButton();
    estroncio = new javax.swing.JButton();
    potasio = new javax.swing.JButton();
    itrio = new javax.swing.JButton();
    calcio = new javax.swing.JButton();
    escandio = new javax.swing.JButton();
    yodo = new javax.swing.JButton();
    bromo = new javax.swing.JButton();
    litio = new javax.swing.JButton();
    berilio = new javax.swing.JButton();
    oxigeno = new javax.swing.JButton();
    boro = new javax.swing.JButton();
    azufre = new javax.swing.JButton();
    aluminio = new javax.swing.JButton();
    carbono = new javax.swing.JButton();
    silicio = new javax.swing.JButton();
    fosforo = new javax.swing.JButton();
    nitrogeno = new javax.swing.JButton();
    sodio = new javax.swing.JButton();
    argon = new javax.swing.JButton();
    magnesio = new javax.swing.JButton();
    titanio = new javax.swing.JButton();
    niquel = new javax.swing.JButton();
    cromo = new javax.swing.JButton();
    manganeso = new javax.swing.JButton();
    hierro = new javax.swing.JButton();
    neon = new javax.swing.JButton();
    vanadio = new javax.swing.JButton();
    cobalto = new javax.swing.JButton();
    selenio = new javax.swing.JButton();
    zinc = new javax.swing.JButton();
    galio = new javax.swing.JButton();
    circonio = new javax.swing.JButton();
    paladio = new javax.swing.JButton();
    telurio = new javax.swing.JButton();
    cadmio = new javax.swing.JButton();
    indio = new javax.swing.JButton();
    germanio = new javax.swing.JButton();
    estanno = new javax.swing.JButton();
    fluor = new javax.swing.JButton();
    cloro = new javax.swing.JButton();
    xenon = new javax.swing.JButton();
    krypton = new javax.swing.JButton();
    berkelio = new javax.swing.JButton();
    bismuto = new javax.swing.JButton();
    wolframio = new javax.swing.JButton();
    renio = new javax.swing.JButton();
    osmio = new javax.swing.JButton();
    actinio = new javax.swing.JButton();
    tantalio = new javax.swing.JButton();
    iridio = new javax.swing.JButton();
    lantano = new javax.swing.JButton();
    lawrencio = new javax.swing.JButton();
    cesio = new javax.swing.JButton();
    lutecio = new javax.swing.JButton();
    oro = new javax.swing.JButton();
    radon = new javax.swing.JButton();
    bario = new javax.swing.JButton();
    francio = new javax.swing.JButton();
    radio = new javax.swing.JButton();
    actinio_salto = new javax.swing.JButton();
    rutherfordio = new javax.swing.JButton();
    darmstadio = new javax.swing.JButton();
    seaborgio = new javax.swing.JButton();
    bohrio = new javax.swing.JButton();
    lantano_salto = new javax.swing.JButton();
    hassio = new javax.swing.JButton();
    dubnio = new javax.swing.JButton();
    meitnerio = new javax.swing.JButton();
    astato = new javax.swing.JButton();
    livermorio = new javax.swing.JButton();
    copernicio = new javax.swing.JButton();
    nihonium = new javax.swing.JButton();
    flerovio = new javax.swing.JButton();
    roentgenio = new javax.swing.JButton();
    moscovium = new javax.swing.JButton();
    cerio = new javax.swing.JButton();
    gadolinio = new javax.swing.JButton();
    neodimio = new javax.swing.JButton();
    prometio = new javax.swing.JButton();
    samario = new javax.swing.JButton();
    oganesson = new javax.swing.JButton();
    praseodimio = new javax.swing.JButton();
    europio = new javax.swing.JButton();
    iterbio = new javax.swing.JButton();
    disprosio = new javax.swing.JButton();
    holmio = new javax.swing.JButton();
    torio = new javax.swing.JButton();
    curio = new javax.swing.JButton();
    nobelio = new javax.swing.JButton();
    californio = new javax.swing.JButton();
    einstenio = new javax.swing.JButton();
    erbio = new javax.swing.JButton();
    fermio = new javax.swing.JButton();
    tennessine = new javax.swing.JButton();
    terbio = new javax.swing.JButton();
    mendelevio = new javax.swing.JButton();
    tulio = new javax.swing.JButton();
    uranio = new javax.swing.JButton();
    hafnio = new javax.swing.JButton();
    neptunio = new javax.swing.JButton();
    platino = new javax.swing.JButton();
    plutonio = new javax.swing.JButton();
    polonio = new javax.swing.JButton();
    protactinio = new javax.swing.JButton();
    mercurio = new javax.swing.JButton();
    americio = new javax.swing.JButton();
    talio = new javax.swing.JButton();
    plomo = new javax.swing.JButton();
    botonCerrar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jLabel20 = new javax.swing.JLabel();
    jLabel21 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    jLabel28 = new javax.swing.JLabel();
    jLabel29 = new javax.swing.JLabel();
    icons = new javax.swing.JRadioButton();
    cpkColoring = new javax.swing.JRadioButton();
    temperature = new javax.swing.JRadioButton();
    cbbOrdenarT = new javax.swing.JComboBox<>();
    jLabel31 = new javax.swing.JLabel();
    cbbOrdenarM = new javax.swing.JComboBox<>();
    jLabel30 = new javax.swing.JLabel();

    jButton69.setText("jButton14");

    jButton70.setText("jButton14");

    jButton71.setText("jButton14");

    jButton72.setText("jButton14");

    jButton73.setText("jButton14");

    jButton74.setText("jButton14");

    jButton75.setText("jButton14");

    jButton76.setText("jButton14");

    javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame1Layout.setVerticalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
    jFrame2.getContentPane().setLayout(jFrame2Layout);
    jFrame2Layout.setHorizontalGroup(
      jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame2Layout.setVerticalGroup(
      jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
    jFrame3.getContentPane().setLayout(jFrame3Layout);
    jFrame3Layout.setHorizontalGroup(
      jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame3Layout.setVerticalGroup(
      jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
    jFrame4.getContentPane().setLayout(jFrame4Layout);
    jFrame4Layout.setHorizontalGroup(
      jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame4Layout.setVerticalGroup(
      jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
    jFrame5.getContentPane().setLayout(jFrame5Layout);
    jFrame5Layout.setHorizontalGroup(
      jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame5Layout.setVerticalGroup(
      jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame6Layout = new javax.swing.GroupLayout(jFrame6.getContentPane());
    jFrame6.getContentPane().setLayout(jFrame6Layout);
    jFrame6Layout.setHorizontalGroup(
      jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame6Layout.setVerticalGroup(
      jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 153, 51));

    hidrogeno.setBackground(new java.awt.Color(153, 255, 255));
    hidrogeno.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    hidrogeno.setForeground(new java.awt.Color(204, 204, 204));
    hidrogeno.setText("H");
    hidrogeno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    hidrogeno.setMargin(new java.awt.Insets(0, 0, 0, 0));
    hidrogeno.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        hidrogenoActionPerformed(evt);
      }
    });

    helio.setBackground(new java.awt.Color(153, 255, 255));
    helio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    helio.setForeground(new java.awt.Color(204, 204, 204));
    helio.setText("He");
    helio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    helio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    helio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        helioActionPerformed(evt);
      }
    });

    cobre.setBackground(new java.awt.Color(153, 255, 255));
    cobre.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cobre.setForeground(new java.awt.Color(204, 204, 204));
    cobre.setText("Cu");
    cobre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cobre.setMargin(new java.awt.Insets(0, 0, 0, 0));

    antimonio.setBackground(new java.awt.Color(153, 255, 255));
    antimonio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    antimonio.setForeground(new java.awt.Color(204, 204, 204));
    antimonio.setText("Sb");
    antimonio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    antimonio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    arsenico.setBackground(new java.awt.Color(153, 255, 255));
    arsenico.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    arsenico.setForeground(new java.awt.Color(204, 204, 204));
    arsenico.setText("As");
    arsenico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    arsenico.setMargin(new java.awt.Insets(0, 0, 0, 0));

    molibdeno.setBackground(new java.awt.Color(153, 255, 255));
    molibdeno.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    molibdeno.setForeground(new java.awt.Color(204, 204, 204));
    molibdeno.setText("Mo");
    molibdeno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    molibdeno.setMargin(new java.awt.Insets(0, 0, 0, 0));
    molibdeno.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        molibdenoActionPerformed(evt);
      }
    });

    tecnecio.setBackground(new java.awt.Color(153, 255, 255));
    tecnecio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    tecnecio.setForeground(new java.awt.Color(204, 204, 204));
    tecnecio.setText("Tc");
    tecnecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    tecnecio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    rutenio.setBackground(new java.awt.Color(153, 255, 255));
    rutenio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    rutenio.setForeground(new java.awt.Color(204, 204, 204));
    rutenio.setText("Ru");
    rutenio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    rutenio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    niobio.setBackground(new java.awt.Color(153, 255, 255));
    niobio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    niobio.setForeground(new java.awt.Color(204, 204, 204));
    niobio.setText("Nb");
    niobio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    niobio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    rodio.setBackground(new java.awt.Color(153, 255, 255));
    rodio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    rodio.setForeground(new java.awt.Color(204, 204, 204));
    rodio.setText("Rh");
    rodio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    rodio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    rubidio.setBackground(new java.awt.Color(153, 255, 255));
    rubidio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    rubidio.setForeground(new java.awt.Color(204, 204, 204));
    rubidio.setText("Rb");
    rubidio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    rubidio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    plata.setBackground(new java.awt.Color(153, 255, 255));
    plata.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    plata.setForeground(new java.awt.Color(204, 204, 204));
    plata.setText("Ag");
    plata.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    plata.setMargin(new java.awt.Insets(0, 0, 0, 0));

    estroncio.setBackground(new java.awt.Color(153, 255, 255));
    estroncio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    estroncio.setForeground(new java.awt.Color(204, 204, 204));
    estroncio.setText("Sr");
    estroncio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    estroncio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    potasio.setBackground(new java.awt.Color(153, 255, 255));
    potasio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    potasio.setForeground(new java.awt.Color(204, 204, 204));
    potasio.setText("K");
    potasio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    potasio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    itrio.setBackground(new java.awt.Color(153, 255, 255));
    itrio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    itrio.setForeground(new java.awt.Color(204, 204, 204));
    itrio.setText("Y");
    itrio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    itrio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    calcio.setBackground(new java.awt.Color(153, 255, 255));
    calcio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    calcio.setForeground(new java.awt.Color(204, 204, 204));
    calcio.setText("Ca");
    calcio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    calcio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    escandio.setBackground(new java.awt.Color(153, 255, 255));
    escandio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    escandio.setForeground(new java.awt.Color(204, 204, 204));
    escandio.setText("Sc");
    escandio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    escandio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    yodo.setBackground(new java.awt.Color(153, 255, 255));
    yodo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    yodo.setForeground(new java.awt.Color(204, 204, 204));
    yodo.setText("I");
    yodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    yodo.setMargin(new java.awt.Insets(0, 0, 0, 0));

    bromo.setBackground(new java.awt.Color(153, 255, 255));
    bromo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    bromo.setForeground(new java.awt.Color(204, 204, 204));
    bromo.setText("Br");
    bromo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bromo.setMargin(new java.awt.Insets(0, 0, 0, 0));

    litio.setBackground(new java.awt.Color(153, 255, 255));
    litio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    litio.setForeground(new java.awt.Color(204, 204, 204));
    litio.setText("Li");
    litio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    litio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    litio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        litioActionPerformed(evt);
      }
    });

    berilio.setBackground(new java.awt.Color(153, 255, 255));
    berilio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    berilio.setForeground(new java.awt.Color(204, 204, 204));
    berilio.setText("Be");
    berilio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    berilio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    berilio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        berilioActionPerformed(evt);
      }
    });

    oxigeno.setBackground(new java.awt.Color(153, 255, 255));
    oxigeno.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    oxigeno.setForeground(new java.awt.Color(204, 204, 204));
    oxigeno.setText("O");
    oxigeno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    oxigeno.setMargin(new java.awt.Insets(0, 0, 0, 0));

    boro.setBackground(new java.awt.Color(153, 255, 255));
    boro.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    boro.setForeground(new java.awt.Color(204, 204, 204));
    boro.setText("B");
    boro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    boro.setMargin(new java.awt.Insets(0, 0, 0, 0));
    boro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        boroActionPerformed(evt);
      }
    });

    azufre.setBackground(new java.awt.Color(153, 255, 255));
    azufre.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    azufre.setForeground(new java.awt.Color(204, 204, 204));
    azufre.setText("S");
    azufre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    azufre.setMargin(new java.awt.Insets(0, 0, 0, 0));

    aluminio.setBackground(new java.awt.Color(153, 255, 255));
    aluminio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    aluminio.setForeground(new java.awt.Color(204, 204, 204));
    aluminio.setText("Al");
    aluminio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    aluminio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    aluminio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aluminioActionPerformed(evt);
      }
    });

    carbono.setBackground(new java.awt.Color(153, 255, 255));
    carbono.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    carbono.setForeground(new java.awt.Color(204, 204, 204));
    carbono.setText("C");
    carbono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    carbono.setMargin(new java.awt.Insets(0, 0, 0, 0));
    carbono.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        carbonoActionPerformed(evt);
      }
    });

    silicio.setBackground(new java.awt.Color(153, 255, 255));
    silicio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    silicio.setForeground(new java.awt.Color(204, 204, 204));
    silicio.setText("Si");
    silicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    silicio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    fosforo.setBackground(new java.awt.Color(153, 255, 255));
    fosforo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    fosforo.setForeground(new java.awt.Color(204, 204, 204));
    fosforo.setText("P");
    fosforo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    fosforo.setMargin(new java.awt.Insets(0, 0, 0, 0));

    nitrogeno.setBackground(new java.awt.Color(153, 255, 255));
    nitrogeno.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    nitrogeno.setForeground(new java.awt.Color(204, 204, 204));
    nitrogeno.setText("N");
    nitrogeno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    nitrogeno.setMargin(new java.awt.Insets(0, 0, 0, 0));

    sodio.setBackground(new java.awt.Color(153, 255, 255));
    sodio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    sodio.setForeground(new java.awt.Color(204, 204, 204));
    sodio.setText("Na");
    sodio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    sodio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    argon.setBackground(new java.awt.Color(153, 255, 255));
    argon.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    argon.setForeground(new java.awt.Color(204, 204, 204));
    argon.setText("Ar");
    argon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    argon.setMargin(new java.awt.Insets(0, 0, 0, 0));

    magnesio.setBackground(new java.awt.Color(153, 255, 255));
    magnesio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    magnesio.setForeground(new java.awt.Color(204, 204, 204));
    magnesio.setText("Mg");
    magnesio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    magnesio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    titanio.setBackground(new java.awt.Color(153, 255, 255));
    titanio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    titanio.setForeground(new java.awt.Color(204, 204, 204));
    titanio.setText("Ti");
    titanio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    titanio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    niquel.setBackground(new java.awt.Color(153, 255, 255));
    niquel.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    niquel.setForeground(new java.awt.Color(204, 204, 204));
    niquel.setText("Ni");
    niquel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    niquel.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cromo.setBackground(new java.awt.Color(153, 255, 255));
    cromo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cromo.setForeground(new java.awt.Color(204, 204, 204));
    cromo.setText("Cr");
    cromo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cromo.setMargin(new java.awt.Insets(0, 0, 0, 0));

    manganeso.setBackground(new java.awt.Color(153, 255, 255));
    manganeso.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    manganeso.setForeground(new java.awt.Color(204, 204, 204));
    manganeso.setText("Mn");
    manganeso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    manganeso.setMargin(new java.awt.Insets(0, 0, 0, 0));

    hierro.setBackground(new java.awt.Color(153, 255, 255));
    hierro.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    hierro.setForeground(new java.awt.Color(204, 204, 204));
    hierro.setText("Fe");
    hierro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    hierro.setMargin(new java.awt.Insets(0, 0, 0, 0));
    hierro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        hierroActionPerformed(evt);
      }
    });

    neon.setBackground(new java.awt.Color(153, 255, 255));
    neon.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    neon.setForeground(new java.awt.Color(204, 204, 204));
    neon.setText("Ne");
    neon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    neon.setMargin(new java.awt.Insets(0, 0, 0, 0));
    neon.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        neonActionPerformed(evt);
      }
    });

    vanadio.setBackground(new java.awt.Color(153, 255, 255));
    vanadio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    vanadio.setForeground(new java.awt.Color(204, 204, 204));
    vanadio.setText("V");
    vanadio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    vanadio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cobalto.setBackground(new java.awt.Color(153, 255, 255));
    cobalto.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cobalto.setForeground(new java.awt.Color(204, 204, 204));
    cobalto.setText("Co");
    cobalto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cobalto.setMargin(new java.awt.Insets(0, 0, 0, 0));

    selenio.setBackground(new java.awt.Color(153, 255, 255));
    selenio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    selenio.setForeground(new java.awt.Color(204, 204, 204));
    selenio.setText("Se");
    selenio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    selenio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    zinc.setBackground(new java.awt.Color(153, 255, 255));
    zinc.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    zinc.setForeground(new java.awt.Color(204, 204, 204));
    zinc.setText("Zn");
    zinc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    zinc.setMargin(new java.awt.Insets(0, 0, 0, 0));

    galio.setBackground(new java.awt.Color(153, 255, 255));
    galio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    galio.setForeground(new java.awt.Color(204, 204, 204));
    galio.setText("Ga");
    galio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    galio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    circonio.setBackground(new java.awt.Color(153, 255, 255));
    circonio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    circonio.setForeground(new java.awt.Color(204, 204, 204));
    circonio.setText("Zr");
    circonio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    circonio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    paladio.setBackground(new java.awt.Color(153, 255, 255));
    paladio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    paladio.setForeground(new java.awt.Color(204, 204, 204));
    paladio.setText("Pd");
    paladio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    paladio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    paladio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        paladioActionPerformed(evt);
      }
    });

    telurio.setBackground(new java.awt.Color(153, 255, 255));
    telurio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    telurio.setForeground(new java.awt.Color(204, 204, 204));
    telurio.setText("Te");
    telurio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    telurio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cadmio.setBackground(new java.awt.Color(153, 255, 255));
    cadmio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cadmio.setForeground(new java.awt.Color(204, 204, 204));
    cadmio.setText("Cd");
    cadmio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cadmio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    cadmio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cadmioActionPerformed(evt);
      }
    });

    indio.setBackground(new java.awt.Color(153, 255, 255));
    indio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    indio.setForeground(new java.awt.Color(204, 204, 204));
    indio.setText("In");
    indio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    indio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    germanio.setBackground(new java.awt.Color(153, 255, 255));
    germanio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    germanio.setForeground(new java.awt.Color(204, 204, 204));
    germanio.setText("Ge");
    germanio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    germanio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    estanno.setBackground(new java.awt.Color(153, 255, 255));
    estanno.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    estanno.setForeground(new java.awt.Color(204, 204, 204));
    estanno.setText("Sn");
    estanno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    estanno.setMargin(new java.awt.Insets(0, 0, 0, 0));

    fluor.setBackground(new java.awt.Color(153, 255, 255));
    fluor.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    fluor.setForeground(new java.awt.Color(204, 204, 204));
    fluor.setText("F");
    fluor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    fluor.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cloro.setBackground(new java.awt.Color(153, 255, 255));
    cloro.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cloro.setForeground(new java.awt.Color(204, 204, 204));
    cloro.setText("Cl");
    cloro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cloro.setMargin(new java.awt.Insets(0, 0, 0, 0));

    xenon.setBackground(new java.awt.Color(153, 255, 255));
    xenon.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    xenon.setForeground(new java.awt.Color(204, 204, 204));
    xenon.setText("Xe");
    xenon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    xenon.setMargin(new java.awt.Insets(0, 0, 0, 0));

    krypton.setBackground(new java.awt.Color(153, 255, 255));
    krypton.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    krypton.setForeground(new java.awt.Color(204, 204, 204));
    krypton.setText("Kr");
    krypton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    krypton.setMargin(new java.awt.Insets(0, 0, 0, 0));
    krypton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        kryptonActionPerformed(evt);
      }
    });

    berkelio.setBackground(new java.awt.Color(153, 255, 255));
    berkelio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    berkelio.setForeground(new java.awt.Color(204, 204, 204));
    berkelio.setText("Bk");
    berkelio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    berkelio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    bismuto.setBackground(new java.awt.Color(153, 255, 255));
    bismuto.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    bismuto.setForeground(new java.awt.Color(204, 204, 204));
    bismuto.setText("Bi");
    bismuto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bismuto.setMargin(new java.awt.Insets(0, 0, 0, 0));

    wolframio.setBackground(new java.awt.Color(153, 255, 255));
    wolframio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    wolframio.setForeground(new java.awt.Color(204, 204, 204));
    wolframio.setText("W");
    wolframio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    wolframio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    renio.setBackground(new java.awt.Color(153, 255, 255));
    renio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    renio.setForeground(new java.awt.Color(204, 204, 204));
    renio.setText("Re");
    renio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    renio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    osmio.setBackground(new java.awt.Color(153, 255, 255));
    osmio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    osmio.setForeground(new java.awt.Color(204, 204, 204));
    osmio.setText("Os");
    osmio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    osmio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    osmio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        osmioActionPerformed(evt);
      }
    });

    actinio.setBackground(new java.awt.Color(153, 255, 255));
    actinio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    actinio.setForeground(new java.awt.Color(204, 204, 204));
    actinio.setText("Ac");
    actinio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    actinio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    actinio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        actinioActionPerformed(evt);
      }
    });

    tantalio.setBackground(new java.awt.Color(153, 255, 255));
    tantalio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    tantalio.setForeground(new java.awt.Color(204, 204, 204));
    tantalio.setText("Ta");
    tantalio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    tantalio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    tantalio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tantalioActionPerformed(evt);
      }
    });

    iridio.setBackground(new java.awt.Color(153, 255, 255));
    iridio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    iridio.setForeground(new java.awt.Color(204, 204, 204));
    iridio.setText("Ir");
    iridio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    iridio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    lantano.setBackground(new java.awt.Color(153, 255, 255));
    lantano.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    lantano.setForeground(new java.awt.Color(204, 204, 204));
    lantano.setText("La");
    lantano.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lantano.setMargin(new java.awt.Insets(0, 0, 0, 0));

    lawrencio.setBackground(new java.awt.Color(153, 255, 255));
    lawrencio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    lawrencio.setForeground(new java.awt.Color(204, 204, 204));
    lawrencio.setText("Lr");
    lawrencio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lawrencio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cesio.setBackground(new java.awt.Color(153, 255, 255));
    cesio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cesio.setForeground(new java.awt.Color(204, 204, 204));
    cesio.setText("Cs");
    cesio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cesio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    lutecio.setBackground(new java.awt.Color(153, 255, 255));
    lutecio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    lutecio.setForeground(new java.awt.Color(204, 204, 204));
    lutecio.setText("Lu");
    lutecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lutecio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    oro.setBackground(new java.awt.Color(153, 255, 255));
    oro.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    oro.setForeground(new java.awt.Color(204, 204, 204));
    oro.setText("Au");
    oro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    oro.setMargin(new java.awt.Insets(0, 0, 0, 0));
    oro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oroActionPerformed(evt);
      }
    });

    radon.setBackground(new java.awt.Color(153, 255, 255));
    radon.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    radon.setForeground(new java.awt.Color(204, 204, 204));
    radon.setText("Rn");
    radon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    radon.setMargin(new java.awt.Insets(0, 0, 0, 0));

    bario.setBackground(new java.awt.Color(153, 255, 255));
    bario.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    bario.setForeground(new java.awt.Color(204, 204, 204));
    bario.setText("Ba");
    bario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bario.setMargin(new java.awt.Insets(0, 0, 0, 0));

    francio.setBackground(new java.awt.Color(153, 255, 255));
    francio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    francio.setForeground(new java.awt.Color(204, 204, 204));
    francio.setText("Fr");
    francio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    francio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    francio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        francioActionPerformed(evt);
      }
    });

    radio.setBackground(new java.awt.Color(153, 255, 255));
    radio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    radio.setForeground(new java.awt.Color(204, 204, 204));
    radio.setText("Ra");
    radio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    radio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    actinio_salto.setBackground(new java.awt.Color(153, 255, 255));
    actinio_salto.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    actinio_salto.setForeground(new java.awt.Color(204, 204, 204));
    actinio_salto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    actinio_salto.setMargin(new java.awt.Insets(0, 0, 0, 0));

    rutherfordio.setBackground(new java.awt.Color(153, 255, 255));
    rutherfordio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    rutherfordio.setForeground(new java.awt.Color(204, 204, 204));
    rutherfordio.setText("Rf");
    rutherfordio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    rutherfordio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    darmstadio.setBackground(new java.awt.Color(153, 255, 255));
    darmstadio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    darmstadio.setForeground(new java.awt.Color(204, 204, 204));
    darmstadio.setText("Ds");
    darmstadio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    darmstadio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    seaborgio.setBackground(new java.awt.Color(153, 255, 255));
    seaborgio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    seaborgio.setForeground(new java.awt.Color(204, 204, 204));
    seaborgio.setText("Sg");
    seaborgio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    seaborgio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    bohrio.setBackground(new java.awt.Color(153, 255, 255));
    bohrio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    bohrio.setForeground(new java.awt.Color(204, 204, 204));
    bohrio.setText("Bh");
    bohrio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bohrio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    bohrio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bohrioActionPerformed(evt);
      }
    });

    lantano_salto.setBackground(new java.awt.Color(153, 255, 255));
    lantano_salto.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    lantano_salto.setForeground(new java.awt.Color(204, 204, 204));
    lantano_salto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lantano_salto.setMargin(new java.awt.Insets(0, 0, 0, 0));

    hassio.setBackground(new java.awt.Color(153, 255, 255));
    hassio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    hassio.setForeground(new java.awt.Color(204, 204, 204));
    hassio.setText("Hs");
    hassio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    hassio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    hassio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        hassioActionPerformed(evt);
      }
    });

    dubnio.setBackground(new java.awt.Color(153, 255, 255));
    dubnio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    dubnio.setForeground(new java.awt.Color(204, 204, 204));
    dubnio.setText("Db");
    dubnio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    dubnio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    meitnerio.setBackground(new java.awt.Color(153, 255, 255));
    meitnerio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    meitnerio.setForeground(new java.awt.Color(204, 204, 204));
    meitnerio.setText("Mt");
    meitnerio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    meitnerio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    meitnerio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        meitnerioActionPerformed(evt);
      }
    });

    astato.setBackground(new java.awt.Color(153, 255, 255));
    astato.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    astato.setForeground(new java.awt.Color(204, 204, 204));
    astato.setText("At");
    astato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    astato.setMargin(new java.awt.Insets(0, 0, 0, 0));

    livermorio.setBackground(new java.awt.Color(153, 255, 255));
    livermorio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    livermorio.setForeground(new java.awt.Color(204, 204, 204));
    livermorio.setText("Lv");
    livermorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    livermorio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    copernicio.setBackground(new java.awt.Color(153, 255, 255));
    copernicio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    copernicio.setForeground(new java.awt.Color(204, 204, 204));
    copernicio.setText("Cn");
    copernicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    copernicio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    nihonium.setBackground(new java.awt.Color(153, 255, 255));
    nihonium.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    nihonium.setForeground(new java.awt.Color(204, 204, 204));
    nihonium.setText("Nh");
    nihonium.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    nihonium.setMargin(new java.awt.Insets(0, 0, 0, 0));

    flerovio.setBackground(new java.awt.Color(153, 255, 255));
    flerovio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    flerovio.setForeground(new java.awt.Color(204, 204, 204));
    flerovio.setText("Fl");
    flerovio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    flerovio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    roentgenio.setBackground(new java.awt.Color(153, 255, 255));
    roentgenio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    roentgenio.setForeground(new java.awt.Color(204, 204, 204));
    roentgenio.setText("Rg");
    roentgenio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    roentgenio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    moscovium.setBackground(new java.awt.Color(153, 255, 255));
    moscovium.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    moscovium.setForeground(new java.awt.Color(204, 204, 204));
    moscovium.setText("Mc");
    moscovium.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    moscovium.setMargin(new java.awt.Insets(0, 0, 0, 0));

    cerio.setBackground(new java.awt.Color(153, 255, 255));
    cerio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    cerio.setForeground(new java.awt.Color(204, 204, 204));
    cerio.setText("Ce");
    cerio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    cerio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    gadolinio.setBackground(new java.awt.Color(153, 255, 255));
    gadolinio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    gadolinio.setForeground(new java.awt.Color(204, 204, 204));
    gadolinio.setText("Gd");
    gadolinio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    gadolinio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    neodimio.setBackground(new java.awt.Color(153, 255, 255));
    neodimio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    neodimio.setForeground(new java.awt.Color(204, 204, 204));
    neodimio.setText("Nd");
    neodimio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    neodimio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    prometio.setBackground(new java.awt.Color(153, 255, 255));
    prometio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    prometio.setForeground(new java.awt.Color(204, 204, 204));
    prometio.setText("Pm");
    prometio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    prometio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    samario.setBackground(new java.awt.Color(153, 255, 255));
    samario.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    samario.setForeground(new java.awt.Color(204, 204, 204));
    samario.setText("Sm");
    samario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    samario.setMargin(new java.awt.Insets(0, 0, 0, 0));

    oganesson.setBackground(new java.awt.Color(153, 255, 255));
    oganesson.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    oganesson.setForeground(new java.awt.Color(204, 204, 204));
    oganesson.setText("Og");
    oganesson.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    oganesson.setMargin(new java.awt.Insets(0, 0, 0, 0));
    oganesson.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oganessonActionPerformed(evt);
      }
    });

    praseodimio.setBackground(new java.awt.Color(153, 255, 255));
    praseodimio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    praseodimio.setForeground(new java.awt.Color(204, 204, 204));
    praseodimio.setText("Pr");
    praseodimio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    praseodimio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    europio.setBackground(new java.awt.Color(153, 255, 255));
    europio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    europio.setForeground(new java.awt.Color(204, 204, 204));
    europio.setText("Eu");
    europio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    europio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    iterbio.setBackground(new java.awt.Color(153, 255, 255));
    iterbio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    iterbio.setForeground(new java.awt.Color(204, 204, 204));
    iterbio.setText("Yb");
    iterbio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    iterbio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    disprosio.setBackground(new java.awt.Color(153, 255, 255));
    disprosio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    disprosio.setForeground(new java.awt.Color(204, 204, 204));
    disprosio.setText("Dy");
    disprosio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    disprosio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    holmio.setBackground(new java.awt.Color(153, 255, 255));
    holmio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    holmio.setForeground(new java.awt.Color(204, 204, 204));
    holmio.setText("Ho");
    holmio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    holmio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    torio.setBackground(new java.awt.Color(153, 255, 255));
    torio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    torio.setForeground(new java.awt.Color(204, 204, 204));
    torio.setText("Th");
    torio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    torio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    curio.setBackground(new java.awt.Color(153, 255, 255));
    curio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    curio.setForeground(new java.awt.Color(204, 204, 204));
    curio.setText("Cm");
    curio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    curio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    nobelio.setBackground(new java.awt.Color(153, 255, 255));
    nobelio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    nobelio.setForeground(new java.awt.Color(204, 204, 204));
    nobelio.setText("No");
    nobelio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    nobelio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    californio.setBackground(new java.awt.Color(153, 255, 255));
    californio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    californio.setForeground(new java.awt.Color(204, 204, 204));
    californio.setText("Cf");
    californio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    californio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    einstenio.setBackground(new java.awt.Color(153, 255, 255));
    einstenio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    einstenio.setForeground(new java.awt.Color(204, 204, 204));
    einstenio.setText("Es");
    einstenio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    einstenio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    erbio.setBackground(new java.awt.Color(153, 255, 255));
    erbio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    erbio.setForeground(new java.awt.Color(204, 204, 204));
    erbio.setText("Er");
    erbio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    erbio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    erbio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        erbioActionPerformed(evt);
      }
    });

    fermio.setBackground(new java.awt.Color(153, 255, 255));
    fermio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    fermio.setForeground(new java.awt.Color(204, 204, 204));
    fermio.setText("Fm");
    fermio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    fermio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    tennessine.setBackground(new java.awt.Color(153, 255, 255));
    tennessine.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    tennessine.setForeground(new java.awt.Color(204, 204, 204));
    tennessine.setText("Ts");
    tennessine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    tennessine.setMargin(new java.awt.Insets(0, 0, 0, 0));

    terbio.setBackground(new java.awt.Color(153, 255, 255));
    terbio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    terbio.setForeground(new java.awt.Color(204, 204, 204));
    terbio.setText("Tb");
    terbio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    terbio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    mendelevio.setBackground(new java.awt.Color(153, 255, 255));
    mendelevio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    mendelevio.setForeground(new java.awt.Color(204, 204, 204));
    mendelevio.setText("Md");
    mendelevio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    mendelevio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    tulio.setBackground(new java.awt.Color(153, 255, 255));
    tulio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    tulio.setForeground(new java.awt.Color(204, 204, 204));
    tulio.setText("Tm");
    tulio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    tulio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    uranio.setBackground(new java.awt.Color(153, 255, 255));
    uranio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    uranio.setForeground(new java.awt.Color(204, 204, 204));
    uranio.setText("U");
    uranio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    uranio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    hafnio.setBackground(new java.awt.Color(153, 255, 255));
    hafnio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    hafnio.setForeground(new java.awt.Color(204, 204, 204));
    hafnio.setText("Hf");
    hafnio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    hafnio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    neptunio.setBackground(new java.awt.Color(153, 255, 255));
    neptunio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    neptunio.setForeground(new java.awt.Color(204, 204, 204));
    neptunio.setText("Np");
    neptunio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    neptunio.setMargin(new java.awt.Insets(0, 0, 0, 0));
    neptunio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        neptunioActionPerformed(evt);
      }
    });

    platino.setBackground(new java.awt.Color(153, 255, 255));
    platino.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    platino.setForeground(new java.awt.Color(204, 204, 204));
    platino.setText("Pt");
    platino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    platino.setMargin(new java.awt.Insets(0, 0, 0, 0));
    platino.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        platinoActionPerformed(evt);
      }
    });

    plutonio.setBackground(new java.awt.Color(153, 255, 255));
    plutonio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    plutonio.setForeground(new java.awt.Color(204, 204, 204));
    plutonio.setText("Pu");
    plutonio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    plutonio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    polonio.setBackground(new java.awt.Color(153, 255, 255));
    polonio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    polonio.setForeground(new java.awt.Color(204, 204, 204));
    polonio.setText("Po");
    polonio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    polonio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    protactinio.setBackground(new java.awt.Color(153, 255, 255));
    protactinio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    protactinio.setForeground(new java.awt.Color(204, 204, 204));
    protactinio.setText("Pa");
    protactinio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    protactinio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    mercurio.setBackground(new java.awt.Color(153, 255, 255));
    mercurio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    mercurio.setForeground(new java.awt.Color(204, 204, 204));
    mercurio.setText("Hg");
    mercurio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    mercurio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    americio.setBackground(new java.awt.Color(153, 255, 255));
    americio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    americio.setForeground(new java.awt.Color(204, 204, 204));
    americio.setText("Am");
    americio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    americio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    talio.setBackground(new java.awt.Color(153, 255, 255));
    talio.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    talio.setForeground(new java.awt.Color(204, 204, 204));
    talio.setText("Tl");
    talio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    talio.setMargin(new java.awt.Insets(0, 0, 0, 0));

    plomo.setBackground(new java.awt.Color(153, 255, 255));
    plomo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
    plomo.setForeground(new java.awt.Color(204, 204, 204));
    plomo.setText("Pb");
    plomo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    plomo.setMargin(new java.awt.Insets(0, 0, 0, 0));

    botonCerrar.setBackground(new java.awt.Color(153, 0, 0));
    botonCerrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    botonCerrar.setForeground(new java.awt.Color(0, 0, 0));
    botonCerrar.setLabel("X");
    botonCerrar.setMargin(new java.awt.Insets(0, 0, 0, 0));
    botonCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonCerrarActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel1.setText("1");

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel2.setText("3");

    jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel3.setText("2");

    jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel4.setText("4");

    jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel5.setText("6");

    jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel6.setText("5");

    jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel7.setText("7");

    jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel8.setText("9");

    jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel9.setText("8");

    jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel10.setText("11");

    jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel11.setText("10");

    jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel12.setText("13");

    jLabel13.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel13.setText("12");

    jLabel14.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel14.setText("14");

    jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel15.setText("17");

    jLabel16.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel16.setText("15");

    jLabel17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel17.setText("16");

    jLabel18.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel18.setText("18");

    jLabel19.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel19.setText("1");

    jLabel20.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel20.setText("2");

    jLabel21.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel21.setText("3");

    jLabel22.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel22.setText("4");

    jLabel23.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel23.setText("5");

    jLabel24.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel24.setText("7");

    jLabel25.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    jLabel25.setText("6");

    jLabel26.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel26.setText("Lantanides");

    jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel28.setText("Actinides");

    jLabel29.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
    jLabel29.setForeground(new java.awt.Color(204, 204, 204));
    jLabel29.setText("Periodic Table of the Elements");

    icons.setBackground(new java.awt.Color(0, 0, 0));
    icons.setText("Icons");
    icons.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        iconsActionPerformed(evt);
      }
    });

    cpkColoring.setBackground(new java.awt.Color(0, 0, 0));
    cpkColoring.setText("CPK Coloring");
    cpkColoring.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cpkColoringActionPerformed(evt);
      }
    });

    temperature.setBackground(new java.awt.Color(0, 0, 0));
    temperature.setText("Temperature");
    temperature.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        temperatureActionPerformed(evt);
      }
    });

    cbbOrdenarT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número Atómico", "Nombre", "Simbolo", "Punto de Fúsion", "Punto de embullición" }));
    cbbOrdenarT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbbOrdenarTActionPerformed(evt);
      }
    });

    jLabel31.setText("En");

    cbbOrdenarM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
    cbbOrdenarM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbbOrdenarMActionPerformed(evt);
      }
    });

    jLabel30.setText("Ordenar por:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(botonCerrar)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(91, 91, 91)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lantano, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(cerio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(praseodimio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(neodimio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(prometio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(samario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(europio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(gadolinio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(terbio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(disprosio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(holmio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(erbio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(tulio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(iterbio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(actinio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(torio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(protactinio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(uranio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(neptunio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(plutonio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(americio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(curio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(berkelio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(californio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(einstenio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(fermio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(mendelevio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(nobelio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lutecio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lawrencio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addGap(71, 71, 71)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel31)
                .addGap(22, 22, 22)
                .addComponent(cbbOrdenarM, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(cbbOrdenarT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(rubidio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(estroncio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(itrio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(circonio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(niobio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(molibdeno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(tecnecio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(rutenio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(rodio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(paladio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(plata, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(cadmio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(indio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(estanno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(antimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(telurio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(potasio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(calcio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(escandio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17))
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(titanio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(vanadio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cromo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(manganeso, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hierro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cobalto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(niquel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cobre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(zinc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(galio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(germanio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(arsenico, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(selenio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                  .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(cpkColoring)
                      .addComponent(temperature)
                      .addComponent(icons))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(bromo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(yodo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel15))))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cesio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lantano_salto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hafnio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tantalio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(wolframio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(renio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(osmio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(iridio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(platino, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(oro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mercurio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(talio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(plomo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bismuto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(polonio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(astato, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(francio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(actinio_salto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rutherfordio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dubnio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(seaborgio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bohrio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hassio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(meitnerio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(darmstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roentgenio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(copernicio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nihonium, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(flerovio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(moscovium, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(livermorio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tennessine, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hidrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addGroup(layout.createSequentialGroup()
                            .addComponent(litio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(berilio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addGroup(layout.createSequentialGroup()
                            .addComponent(sodio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(magnesio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(aluminio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(silicio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(fosforo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(azufre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(boro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(carbono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nitrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(oxigeno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(fluor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(cloro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(helio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(neon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(argon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oganesson, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(krypton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(xenon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)))
            .addGap(48, 48, 48))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(hidrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(fluor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(boro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(carbono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(nitrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(oxigeno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(cloro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(litio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(berilio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sodio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magnesio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aluminio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(silicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fosforo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(azufre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(icons)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpkColoring)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temperature)
                .addGap(18, 18, 18)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potasio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escandio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titanio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vanadio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cromo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manganeso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hierro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cobalto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niquel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cobre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zinc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(galio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(germanio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arsenico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selenio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rubidio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estroncio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itrio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circonio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niobio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(molibdeno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tecnecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutenio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rodio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paladio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plata, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadmio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estanno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(antimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telurio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
              .addGroup(layout.createSequentialGroup()
                .addComponent(bromo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(yodo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cesio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lantano_salto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hafnio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tantalio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wolframio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(renio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osmio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iridio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platino, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mercurio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(talio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plomo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bismuto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(polonio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(astato, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(francio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actinio_salto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutherfordio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dubnio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seaborgio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bohrio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hassio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meitnerio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darmstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roentgenio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copernicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nihonium, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flerovio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moscovium, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livermorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(tennessine, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addComponent(helio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(neon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(argon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(xenon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(krypton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(radon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(oganesson, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(36, 36, 36)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel26))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lantano, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cerio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(praseodimio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(neodimio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(prometio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(samario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(europio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(gadolinio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(terbio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(disprosio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(holmio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(erbio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tulio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(iterbio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(actinio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(torio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(protactinio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(uranio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(neptunio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(plutonio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(americio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(curio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(berkelio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(californio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(einstenio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(fermio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(mendelevio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nobelio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28))))
          .addGroup(layout.createSequentialGroup()
            .addComponent(lutecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(lawrencio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel30)
          .addComponent(cbbOrdenarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel31)
          .addComponent(cbbOrdenarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(7, 7, 7))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

    private void kryptonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kryptonActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_kryptonActionPerformed

    private void hidrogenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidrogenoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_hidrogenoActionPerformed

    private void helioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_helioActionPerformed

    private void litioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_litioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_litioActionPerformed

    private void neonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neonActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_neonActionPerformed

    private void francioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_francioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_francioActionPerformed

    private void tantalioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tantalioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_tantalioActionPerformed

    private void molibdenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_molibdenoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_molibdenoActionPerformed

    private void bohrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bohrioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_bohrioActionPerformed

    private void hierroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hierroActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_hierroActionPerformed

    private void osmioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osmioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_osmioActionPerformed

    private void hassioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hassioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_hassioActionPerformed

    private void meitnerioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meitnerioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_meitnerioActionPerformed

    private void paladioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paladioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_paladioActionPerformed

    private void platinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platinoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_platinoActionPerformed

    private void oroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oroActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_oroActionPerformed

    private void cadmioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadmioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_cadmioActionPerformed

    private void carbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carbonoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_carbonoActionPerformed

    private void oganessonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oganessonActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_oganessonActionPerformed

    private void actinioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actinioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_actinioActionPerformed

    private void berilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berilioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_berilioActionPerformed

    private void aluminioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aluminioActionPerformed
      // TODO add your handling code here: 
      int papita = 0;
    }//GEN-LAST:event_aluminioActionPerformed

    private void boroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boroActionPerformed
      Elemento elementoBoton = new Elemento();
      for (Elemento elemento : tablaPeriodica.getElementos()) {
        if (elemento.getSimbolo().equals(((JButton) evt.getSource()).getName())) {
          elementoBoton = elemento;
          System.out.println(elementoBoton.getNombre());
          break;
        }
      }
      try {
        VentanaInformacion frame = new VentanaInformacion(this, elementoBoton);
        this.setVisible(false);
      } catch (IOException ex) {
        Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_boroActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
      System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void erbioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_erbioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_erbioActionPerformed

  private void neptunioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neptunioActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_neptunioActionPerformed

  private void temperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperatureActionPerformed
    this.cpkColoring.setSelected(false);
    this.icons.setSelected(false);
    for (JButton boton : botones) {
      boton.setForeground(Color.BLACK);
      System.out.println(boton.getName());
      boton.setIcon(null);
      double temperatura = 0;   
      for (Elemento elementoTabla : tablaPeriodica.getElementos()) {
        if (elementoTabla.getSimbolo().equals(boton.getName())) {
          temperatura = (elementoTabla.getPuntoFusion().getTemperatura() + elementoTabla.getPuntoEbullicion().getTemperatura()) / 2;
          break;
        }
      }
      temperatura = temperatura/6000 * (16711680 - 255) + 255;
      String hexa = Integer.toHexString((int) temperatura);
      boton.setBackground(Color.decode("0x" + hexa));
      }
  }//GEN-LAST:event_temperatureActionPerformed

  private void cpkColoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpkColoringActionPerformed
    this.icons.setSelected(false);
    this.temperature.setSelected(false);
    for (JButton boton : botones) {
      boton.setForeground(Color.BLACK);
      System.out.println(boton.getName());
      boton.setIcon(null);
      Elemento elemento = new Elemento();
      for (Elemento elementoTabla : tablaPeriodica.getElementos()) {
        if (elementoTabla.getSimbolo().equals(boton.getName())) {
          elemento = elementoTabla;
          break;
        }
      }
      if (!elemento.getColor().equals("")) {
        boton.setBackground(Color.decode("0x" + elemento.getColor()));
      } else {
        boton.setBackground(Color.WHITE);
      }
    }
  }//GEN-LAST:event_cpkColoringActionPerformed

  private void iconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconsActionPerformed
    this.cpkColoring.setSelected(false);
    this.temperature.setSelected(false);
    for (JButton boton : botones) {
      boton.setForeground(Color.WHITE);
      //System.out.println(boton.getName());
      Elemento elemento = new Elemento();
      for (Elemento elementoTabla : tablaPeriodica.getElementos()) {
        if (elementoTabla.getSimbolo().equals(boton.getName())) {
          elemento = elementoTabla;
          break;
        }
      }
      ImageIcon imagen;
      File f = new File(elemento.getNombre() + ".gif");
      if (f.exists() && !f.isDirectory()) {
        imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".gif").getImage().getScaledInstance(48, 36, Image.SCALE_DEFAULT));
      } else {
        imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".jpg").getImage().getScaledInstance(48, 36, Image.SCALE_DEFAULT));
      }
      boton.setIcon(imagen);
    }
  }//GEN-LAST:event_iconsActionPerformed

  private void cbbOrdenarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbOrdenarTActionPerformed
    Object obj = evt.getSource();
    Object obj2 = evt.getSource();
    if (obj == cbbOrdenarM || obj2 == cbbOrdenarT) {
      String mod = (String) cbbOrdenarM.getSelectedItem();
      if (cbbOrdenarT.getSelectedItem().equals("Número Atómico")) {
        this.ordenarNumeroAtomico(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Simbolo")) {
        this.ordenarSimbolo(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Nombre")) {
        this.ordenarNombre(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Punto de Fúsion")) {
        this.ordenarPuntoFusion(mod);
      } else {
        this.ordenarPuntoEmbullicion(mod);
      }
      this.reordenar();
    }
  }//GEN-LAST:event_cbbOrdenarTActionPerformed

  private void cbbOrdenarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbOrdenarMActionPerformed
    Object obj = evt.getSource();
    Object obj2 = evt.getSource();
    if (obj == cbbOrdenarM || obj2 == cbbOrdenarT) {
      String mod = (String) cbbOrdenarM.getSelectedItem();
      if (cbbOrdenarT.getSelectedItem().equals("Número Atómico")) {
        this.ordenarNumeroAtomico(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Simbolo")) {
        this.ordenarSimbolo(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Nombre")) {
        this.ordenarNombre(mod);
      } else if (cbbOrdenarT.getSelectedItem().equals("Punto de Fúsion")) {
        this.ordenarPuntoFusion(mod);
      } else {
        this.ordenarPuntoEmbullicion(mod);
      }
      this.reordenar();
    }
  }//GEN-LAST:event_cbbOrdenarMActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */

    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new InterfazGrafica().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton actinio;
  private javax.swing.JButton actinio_salto;
  private javax.swing.JButton aluminio;
  private javax.swing.JButton americio;
  private javax.swing.JButton antimonio;
  private javax.swing.JButton argon;
  private javax.swing.JButton arsenico;
  private javax.swing.JButton astato;
  private javax.swing.JButton azufre;
  private javax.swing.JButton bario;
  private javax.swing.JButton berilio;
  private javax.swing.JButton berkelio;
  private javax.swing.JButton bismuto;
  private javax.swing.JButton bohrio;
  private javax.swing.JButton boro;
  private javax.swing.JButton botonCerrar;
  private javax.swing.JButton bromo;
  private javax.swing.JButton cadmio;
  private javax.swing.JButton calcio;
  private javax.swing.JButton californio;
  private javax.swing.JButton carbono;
  private javax.swing.JComboBox<String> cbbOrdenarM;
  private javax.swing.JComboBox<String> cbbOrdenarT;
  private javax.swing.JButton cerio;
  private javax.swing.JButton cesio;
  private javax.swing.JButton circonio;
  private javax.swing.JButton cloro;
  private javax.swing.JButton cobalto;
  private javax.swing.JButton cobre;
  private javax.swing.JButton copernicio;
  private javax.swing.JRadioButton cpkColoring;
  private javax.swing.JButton cromo;
  private javax.swing.JButton curio;
  private javax.swing.JButton darmstadio;
  private javax.swing.JButton disprosio;
  private javax.swing.JButton dubnio;
  private javax.swing.JButton einstenio;
  private javax.swing.JButton erbio;
  private javax.swing.JButton escandio;
  private javax.swing.JButton estanno;
  private javax.swing.JButton estroncio;
  private javax.swing.JButton europio;
  private javax.swing.JButton fermio;
  private javax.swing.JButton flerovio;
  private javax.swing.JButton fluor;
  private javax.swing.JButton fosforo;
  private javax.swing.JButton francio;
  private javax.swing.JButton gadolinio;
  private javax.swing.JButton galio;
  private javax.swing.JButton germanio;
  private javax.swing.JButton hafnio;
  private javax.swing.JButton hassio;
  private javax.swing.JButton helio;
  private javax.swing.JButton hidrogeno;
  private javax.swing.JButton hierro;
  private javax.swing.JButton holmio;
  private javax.swing.JRadioButton icons;
  private javax.swing.JButton indio;
  private javax.swing.JButton iridio;
  private javax.swing.JButton iterbio;
  private javax.swing.JButton itrio;
  private javax.swing.JButton jButton69;
  private javax.swing.JButton jButton70;
  private javax.swing.JButton jButton71;
  private javax.swing.JButton jButton72;
  private javax.swing.JButton jButton73;
  private javax.swing.JButton jButton74;
  private javax.swing.JButton jButton75;
  private javax.swing.JButton jButton76;
  private javax.swing.JFrame jFrame1;
  private javax.swing.JFrame jFrame2;
  private javax.swing.JFrame jFrame3;
  private javax.swing.JFrame jFrame4;
  private javax.swing.JFrame jFrame5;
  private javax.swing.JFrame jFrame6;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel23;
  private javax.swing.JLabel jLabel24;
  private javax.swing.JLabel jLabel25;
  private javax.swing.JLabel jLabel26;
  private javax.swing.JLabel jLabel28;
  private javax.swing.JLabel jLabel29;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel30;
  private javax.swing.JLabel jLabel31;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JButton krypton;
  private javax.swing.JButton lantano;
  private javax.swing.JButton lantano_salto;
  private javax.swing.JButton lawrencio;
  private javax.swing.JButton litio;
  private javax.swing.JButton livermorio;
  private javax.swing.JButton lutecio;
  private javax.swing.JButton magnesio;
  private javax.swing.JButton manganeso;
  private javax.swing.JButton meitnerio;
  private javax.swing.JButton mendelevio;
  private javax.swing.JButton mercurio;
  private javax.swing.JButton molibdeno;
  private javax.swing.JButton moscovium;
  private javax.swing.JButton neodimio;
  private javax.swing.JButton neon;
  private javax.swing.JButton neptunio;
  private javax.swing.JButton nihonium;
  private javax.swing.JButton niobio;
  private javax.swing.JButton niquel;
  private javax.swing.JButton nitrogeno;
  private javax.swing.JButton nobelio;
  private javax.swing.JButton oganesson;
  private javax.swing.JButton oro;
  private javax.swing.JButton osmio;
  private javax.swing.JButton oxigeno;
  private javax.swing.JButton paladio;
  private javax.swing.JButton plata;
  private javax.swing.JButton platino;
  private javax.swing.JButton plomo;
  private javax.swing.JButton plutonio;
  private javax.swing.JButton polonio;
  private javax.swing.JButton potasio;
  private javax.swing.JButton praseodimio;
  private javax.swing.JButton prometio;
  private javax.swing.JButton protactinio;
  private javax.swing.JButton radio;
  private javax.swing.JButton radon;
  private javax.swing.JButton renio;
  private javax.swing.JButton rodio;
  private javax.swing.JButton roentgenio;
  private javax.swing.JButton rubidio;
  private javax.swing.JButton rutenio;
  private javax.swing.JButton rutherfordio;
  private javax.swing.JButton samario;
  private javax.swing.JButton seaborgio;
  private javax.swing.JButton selenio;
  private javax.swing.JButton silicio;
  private javax.swing.JButton sodio;
  private javax.swing.JButton talio;
  private javax.swing.JButton tantalio;
  private javax.swing.JButton tecnecio;
  private javax.swing.JButton telurio;
  private javax.swing.JRadioButton temperature;
  private javax.swing.JButton tennessine;
  private javax.swing.JButton terbio;
  private javax.swing.JButton titanio;
  private javax.swing.JButton torio;
  private javax.swing.JButton tulio;
  private javax.swing.JButton uranio;
  private javax.swing.JButton vanadio;
  private javax.swing.JButton wolframio;
  private javax.swing.JButton xenon;
  private javax.swing.JButton yodo;
  private javax.swing.JButton zinc;
  // End of variables declaration//GEN-END:variables

}
