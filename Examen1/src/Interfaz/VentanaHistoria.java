package Interfaz;

import Logica.Elemento;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class VentanaHistoria extends javax.swing.JFrame {

  JFrame ventanaPrincipal;
  Elemento elemento;
  /**
   * Creates new form VentanaHistoria
   * @param ventanaPrincipal
   * @param elemento
   */
  public VentanaHistoria(JFrame ventanaPrincipal, Elemento elemento) {
    this.ventanaPrincipal = ventanaPrincipal;
    this.elemento = elemento;
    
    initComponents();
    
    getContentPane().setBackground(Color.BLACK);
    this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    
    ImageIcon imagen;
    File f = new File(elemento.getNombre() + ".gif");
    if (f.exists() && !f.isDirectory()) {
      imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".gif").getImage().getScaledInstance(278, 210, Image.SCALE_DEFAULT));
    } else {
      imagen = new ImageIcon(new ImageIcon(elemento.getNombre() + ".jpg").getImage().getScaledInstance(278, 210, Image.SCALE_DEFAULT));
    }
    this.imagen.setIcon(imagen);
    this.jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
    this.informacionTexto.setText(elemento.getHistoria());
    this.informacionTexto.setLineWrap(true);
    this.informacionTexto.setWrapStyleWord(true);
    this.nombreEtiqueta.setText(elemento.getNombre());
    this.setVisible(true);
    
    String linksInformacion = "Links with more information about the element: \n\n";
    for (String link: elemento.getLinks()) {
      linksInformacion += link + "\n";
    }
    this.links.setText(linksInformacion);
    this.videosLinks.setBorder(BorderFactory.createEmptyBorder());
    this.links.setLineWrap(true);
    this.links.setWrapStyleWord(true);
    this.links.setEnabled(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    informacionTexto = new javax.swing.JTextArea();
    imagen = new javax.swing.JLabel();
    botonCerrar = new javax.swing.JButton();
    nombreEtiqueta = new javax.swing.JLabel();
    videosLinks = new javax.swing.JScrollPane();
    links = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setUndecorated(true);

    informacionTexto.setEditable(false);
    informacionTexto.setBackground(new java.awt.Color(0, 0, 0));
    informacionTexto.setColumns(20);
    informacionTexto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    informacionTexto.setRows(5);
    informacionTexto.setBorder(null);
    informacionTexto.setCaretColor(new java.awt.Color(0, 0, 0));
    informacionTexto.setDisabledTextColor(new java.awt.Color(153, 153, 153));
    informacionTexto.setEnabled(false);
    jScrollPane1.setViewportView(informacionTexto);

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

    nombreEtiqueta.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
    nombreEtiqueta.setForeground(new java.awt.Color(204, 204, 204));
    nombreEtiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nombreEtiqueta.setText("nombreElem");

    links.setEditable(false);
    links.setBackground(new java.awt.Color(0, 0, 0));
    links.setColumns(20);
    links.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
    links.setRows(5);
    links.setBorder(null);
    links.setCaretColor(new java.awt.Color(0, 0, 0));
    links.setDisabledTextColor(new java.awt.Color(153, 153, 153));
    links.setEnabled(false);
    videosLinks.setViewportView(links);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(28, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(videosLinks, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(57, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nombreEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(143, 143, 143))))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(botonCerrar)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(47, 47, 47)
            .addComponent(videosLinks, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(nombreEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(39, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
    this.dispose();
    this.ventanaPrincipal.setVisible(true);
  }//GEN-LAST:event_botonCerrarActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botonCerrar;
  private javax.swing.JLabel imagen;
  private javax.swing.JTextArea informacionTexto;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea links;
  private javax.swing.JLabel nombreEtiqueta;
  private javax.swing.JScrollPane videosLinks;
  // End of variables declaration//GEN-END:variables
}
