/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class Temperatura {
  double temperatura;
  char tipoGrado;
  
  public Temperatura () {
    temperatura = 0;
    tipoGrado = ' ';
  }
  
  public double getTemperatura() {
    toKelvin();
    return temperatura;
  }
  
  public Temperatura(double pTemperatura, char pTipoGrado) {
    temperatura = pTemperatura;
    tipoGrado = pTipoGrado;
  }
  
  public void toCelsius() {
    if (tipoGrado == 'F') {
      temperatura = (temperatura  - 32) * 5/9;
      tipoGrado = 'C';
    } else if (tipoGrado == 'K') {
      temperatura = temperatura - 273.15;
      tipoGrado = 'C';
    } 
  }
  
  public void toKelvin() {
    if (tipoGrado == 'F') {
      temperatura = (temperatura  - 32) / 1.8 + 273.15;
      tipoGrado = 'K';
    } else if (tipoGrado == 'C') {
      temperatura = temperatura + 273.15;
      tipoGrado = 'K';
    } 
  }
  
  public void toFarenheit() {
    if (tipoGrado == 'K') {
      temperatura = 1.8 * (temperatura - 273.15) + 32;
      tipoGrado = 'F';
    } else if (tipoGrado == 'C') {
      temperatura = temperatura * 1.8 + 32;
      tipoGrado = 'F';
    } 
  }
  
  @Override
  public String toString() {
    if (tipoGrado == ' ') {
      return "";
    }
    return String.format("%.2f", temperatura) + " " + tipoGrado + "°";
  }
  
}
