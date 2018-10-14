/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class Elemento {
    String nombre;
    int pesoAtomico;
    String simbolo;
    double masaAtomica;
    String color;
    String configuracionElectronica;
    double electronegatividad;
    int radioAtomico;
    String radioIonico;
    int radioVanDelWaals;
    int energiaIonizacion;
    int afinidadElectronica;
    int estadosOxidacion[];
    String estadoEstandar;
    String tipo;
    int puntoFusion;
    int puntoEbullicion;
    double densidad;
    String nombreBloque;
    int annoDescubrimiento;
    String historia;
    String[] links;
    
public Elemento(String pNombre, int pPesoAtomico, String pSimbolo, double pMasaAtomica, String pColor, String pConfiguracionElectronica, double pElectronegatividad, int pRadioAtomico, String pRadioIonico, int pRadioVanDelWaals, int pEnergiaIonizacion, int pAfinidadElectronica, int pEstadosOxidacion[], String pEstadoEstandar, String pTipo, int pPuntoFusion, int pPuntoEbullicion, double pDensidad, String pNombreBloque, int pAnnoDescubrimiento, String pHistoria, String[] pLinks) {
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
            estados += (i == estadosOxidacion.length -1) ? estadosOxidacion[i]: estadosOxidacion[i] + ", ";
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
    
    public void setEnergiaIonizacion (int pEnergiaIonizacion) {
        energiaIonizacion = pEnergiaIonizacion;
    }
    
    public int getEnergiaIonizacion() {
        return energiaIonizacion;
    }
    
    public void setAfinidadElectronica(int pAfinidadElectronica) {
        afinidadElectronica = pAfinidadElectronica;
    }
    
    public  int getAfinidadElectronica() {
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
    
    public void setPuntoFusion(int pPuntoFusion) {
        puntoFusion = pPuntoFusion;
    }
    
    public int getPuntoFusion() {
        return puntoFusion;
    }
    
    public void setPuntoEbullicion(int pPuntoEbullicion) {
        puntoEbullicion = pPuntoEbullicion;
    }
    
    public int getPuntoEbullicion() {
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


