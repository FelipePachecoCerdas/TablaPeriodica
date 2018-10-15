/**
 * Clase Elemento que representa un elemento de la tabla periodica tal que almacena
 * ciertos datos importantes de este y los puede mostrar con la sobrecarga del metodo
 * toString()
 * 
 * @author Felipe Pacheco
 * @author Kendall Tenorio
 */
public class Elemento {

  private String nombre;
  private int pesoAtomico;
  private String simbolo;
  private double masaAtomica;
  private String color;
  private String configuracionElectronica;
  private double electronegatividad;
  private int radioAtomico;
  private String radioIonico;
  private int radioVanDelWaals;
  private int energiaIonizacion;
  private int afinidadElectronica;
  private int estadosOxidacion[];
  private String estadoEstandar;
  private String tipo;
  private Temperatura puntoFusion;
  private Temperatura puntoEbullicion;
  private double densidad;
  private String nombreBloque;
  private int annoDescubrimiento;
  private String historia;
  private String[] links;
  /**
   * Constructor de Elemento que asigna a cada atributo sus respectivos
   * valores con los parametros
   * @param pNombre
   * @param pPesoAtomico
   * @param pSimbolo
   * @param pMasaAtomica
   * @param pColor
   * @param pConfiguracionElectronica
   * @param pElectronegatividad
   * @param pRadioAtomico
   * @param pRadioIonico
   * @param pRadioVanDelWaals
   * @param pEnergiaIonizacion
   * @param pAfinidadElectronica
   * @param pEstadosOxidacion
   * @param pEstadoEstandar
   * @param pTipo
   * @param pPuntoFusion
   * @param pPuntoEbullicion
   * @param pDensidad
   * @param pNombreBloque
   * @param pAnnoDescubrimiento
   * @param pHistoria
   * @param pLinks 
   */
  public Elemento(String pNombre, int pPesoAtomico, String pSimbolo, double pMasaAtomica, String pColor, String pConfiguracionElectronica, double pElectronegatividad, int pRadioAtomico, String pRadioIonico, int pRadioVanDelWaals, int pEnergiaIonizacion, int pAfinidadElectronica, int pEstadosOxidacion[], String pEstadoEstandar, String pTipo, Temperatura pPuntoFusion, Temperatura pPuntoEbullicion, double pDensidad, String pNombreBloque, int pAnnoDescubrimiento, String pHistoria, String[] pLinks) {
    setNombre(pNombre);
    setPesoAtomico(pPesoAtomico);
    setSimbolo(pSimbolo);
    setMasaAtomica(pMasaAtomica);
    setColor(pColor);
    setConfiguracionElectronica(pConfiguracionElectronica);
    setElectronegatividad(pElectronegatividad);
    setRadioAtomico(pRadioAtomico);
    setRadioIonico(pRadioIonico);
    setRadioVanDelWaals(pRadioVanDelWaals);
    setEnergiaIonizacion(pEnergiaIonizacion);
    setAfinidadElectronica(pAfinidadElectronica);
    setEstadosOxidacion(pEstadosOxidacion);
    setEstadoEstandar(pEstadoEstandar);
    setTipo(pTipo);
    setPuntoFusion(pPuntoFusion);
    setPuntoEbullicion(pPuntoEbullicion);
    setDensidad(pDensidad);
    setNombreBloque(pNombreBloque);
    setAnnoDescubrimiento(pAnnoDescubrimiento);
    setHistoria(pHistoria);
    setLinks(pLinks);

  }

  public Elemento() {

  }
 /**
 *@return devuelve toda la informacion de un elemento en especifico, tal que 
 * por cada atributo se retorna su estado (si es un dato valido, sino se retorna 
 * unknown)
 */
  @Override
  public String toString() {
    String informacion = "Symbol: " + getSimbolo() + "\n";
    informacion += "Atomic Weight: " + getPesoAtomico() + " u\n";
    informacion += "Atomic Mass: " + getMasaAtomica() + " uma\n";
    informacion += "Electronic Configuration: " + getConfiguracionElectronica() + "\n";
    informacion += "Electronegativity: " + ((getElectronegatividad() == 0) ? "Unknown" : getElectronegatividad()) + "\n";
    informacion += "Atomic Radius: " + ((getRadioAtomico() == 0) ? "Unknown" : getRadioAtomico() + " pm") + "\n";
    informacion += "Ionic Radius: " + ((getRadioIonico().equals("")) ? "Unknown" : getRadioIonico() + " pm") + "\n";
    informacion += "Van Del Waals Radius: " + ((getRadioVanDelWaals() == 0) ? "Unknown" : getRadioVanDelWaals() + " pm") + "\n";
    informacion += "Ionization Energy: " + ((getEnergiaIonizacion() == 0) ? "Unknown" : getEnergiaIonizacion()) + "\n";
    informacion += "Electronic Affinity: " + ((getAfinidadElectronica() == 0) ? "Unknown" : getAfinidadElectronica()) + "\n";
    informacion += "Oxidation States: " + ((getEstadosOxidacionStr().equals("")) ? "Unknown" : getEstadosOxidacionStr()) + "\n";
    informacion += "Standard State: " + ((getEstadoEstandar().equals("")) ? "Unknown" : getEstadoEstandar()) + "\n";
    informacion += "Type: " + ((getTipo().equals("")) ? "Unknown" : getTipo()) + "\n";
    informacion += "Melting Point: " + ((getPuntoFusion().toString().equals("")) ? "Unknown" : getPuntoFusion().toString()) + "\n";
    informacion += "Melting Point: " + ((getPuntoEbullicion().toString().equals("")) ? "Unknown" : getPuntoEbullicion().toString()) + "\n";
    informacion += "Density: " + ((getDensidad() == 0) ? "Unknown" : getDensidad() + " g/cm3") + "\n";
    informacion += "Block Name: " + ((getNombreBloque().equals("")) ? "Unknown" : getNombreBloque()) + "\n";
    informacion += "Year of Discoverment: " + ((getAnnoDescubrimiento() == -1) ? "Ancient" : getAnnoDescubrimiento()) + "\n";
    return informacion;
  }

  public void setLinks(String[] pLinks) {
    links = pLinks;
  }

  public String[] getLinks() {
    return links;
  }

  public void setHistoria(String pHistoria) {
    historia = pHistoria;
  }

  public String getHistoria() {
    return historia;
  }

  public String getEstadosOxidacionStr() {
    String estados = "";
    for (int i = 0; i < estadosOxidacion.length; i++) {
      estados += (i == estadosOxidacion.length - 1) ? estadosOxidacion[i] : estadosOxidacion[i] + ", ";
    }
    return estados;
  }

  public void setNombre(String pNombre) {
    nombre = pNombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setPesoAtomico(int pPesoAtomico) {
    pesoAtomico = pPesoAtomico;
  }

  public int getPesoAtomico() {
    return pesoAtomico;
  }

  public void setSimbolo(String pSimbolo) {
    simbolo = pSimbolo;
  }

  public String getSimbolo() {
    return simbolo;
  }

  public void setMasaAtomica(double pMasaAtomica) {
    masaAtomica = pMasaAtomica;
  }

  public double getMasaAtomica() {
    return masaAtomica;
  }

  public void setColor(String pColor) {
    color = pColor;
  }

  public String getColor() {
    return color;
  }

  public void setConfiguracionElectronica(String pConfiguracionElectronica) {
    configuracionElectronica = pConfiguracionElectronica;
  }

  public String getConfiguracionElectronica() {
    return configuracionElectronica;
  }

  public void setElectronegatividad(double pElectronegatividad) {
    electronegatividad = pElectronegatividad;
  }

  public double getElectronegatividad() {
    return electronegatividad;
  }

  public void setRadioAtomico(int pRadioAtomico) {
    radioAtomico = pRadioAtomico;
  }

  public int getRadioAtomico() {
    return radioAtomico;
  }

  public void setRadioIonico(String pRadioIonico) {
    radioIonico = pRadioIonico;
  }

  public String getRadioIonico() {
    return radioIonico;
  }

  public void setRadioVanDelWaals(int pRadioVanDelWaals) {
    radioVanDelWaals = pRadioVanDelWaals;
  }

  public int getRadioVanDelWaals() {
    return radioVanDelWaals;
  }

  public void setEnergiaIonizacion(int pEnergiaIonizacion) {
    energiaIonizacion = pEnergiaIonizacion;
  }

  public int getEnergiaIonizacion() {
    return energiaIonizacion;
  }

  public void setAfinidadElectronica(int pAfinidadElectronica) {
    afinidadElectronica = pAfinidadElectronica;
  }

  public int getAfinidadElectronica() {
    return afinidadElectronica;
  }

  public void setEstadosOxidacion(int[] pEstadosOxidacion) {
    estadosOxidacion = pEstadosOxidacion;
  }

  public int[] getEstadosOxidacion() {
    return estadosOxidacion;
  }

  public void setEstadoEstandar(String pEstadoEstandar) {
    estadoEstandar = pEstadoEstandar;
  }

  public String getEstadoEstandar() {
    return estadoEstandar;
  }

  public void setTipo(String pTipo) {
    tipo = pTipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setPuntoFusion(Temperatura pPuntoFusion) {
    puntoFusion = pPuntoFusion;
  }

  public Temperatura getPuntoFusion() {
    return puntoFusion;
  }

  public void setPuntoEbullicion(Temperatura pPuntoEbullicion) {
    puntoEbullicion = pPuntoEbullicion;
  }

  public Temperatura getPuntoEbullicion() {
    return puntoEbullicion;
  }

  public void setDensidad(double pDensidad) {
    densidad = pDensidad;
  }

  public double getDensidad() {
    return densidad;
  }

  public void setNombreBloque(String pNombreBloque) {
    nombreBloque = pNombreBloque;
  }

  public String getNombreBloque() {
    return nombreBloque;
  }

  public void setAnnoDescubrimiento(int pAnnoDescubrimiento) {
    annoDescubrimiento = pAnnoDescubrimiento;
  }

  public int getAnnoDescubrimiento() {
    return annoDescubrimiento;
  }
}
