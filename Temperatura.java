/**
 * Clase Temperatura que representa una Temperatura real que
 * puede venir en kelvin (K), celsius (C) o farenheit (F) que 
 * ademas tiene cierta maginitud numerica
 * 
 * @author Felipe Pacheco
 * @author Kendall Tenorio
 */
public class Temperatura {
  double temperatura;
  char tipoGrado;
  
  /**
   * Constructor base de Temperatura que la inicializa en 0 y sin tipo 
   * de grado (representado como espacio)
   */
  public Temperatura () {
    temperatura = 0;
    tipoGrado = ' ';
  }
  
  public double getTemperatura() {
    toKelvin();
    return temperatura;
  }
  
  /**
   * Constructor de Temperatura cuando recibe la magnitud de la temperatura
   * y ademas el tipo de grado de esa temperatura
   * @param pTemperatura
   * @param pTipoGrado 
   */
  public Temperatura(double pTemperatura, char pTipoGrado) {
    temperatura = pTemperatura;
    tipoGrado = pTipoGrado;
  }
  
  /**
   * Si la temperatura es farenheit o kelvin la transforma
   * a celsisus con el uso de las  formulas
   * C = (F - 32) * 5/9
   * C = K - 273.15
   */
  public void toCelsius() {
    if (tipoGrado == 'F') {
      temperatura = (temperatura  - 32) * 5/9;
      tipoGrado = 'C';
    } else if (tipoGrado == 'K') {
      temperatura = temperatura - 273.15;
      tipoGrado = 'C';
    } 
  }
  
  /**
   * Si la temperatura es farenheit o celsius la transforma
   * a kelvin con el uso de las  formulas
   * K = (F - 32) * 5/9 + 273.15
   * K = C + 273.15
   */
  public void toKelvin() {
    if (tipoGrado == 'F') {
      temperatura = (temperatura  - 32) / 1.8 + 273.15;
      tipoGrado = 'K';
    } else if (tipoGrado == 'C') {
      temperatura = temperatura + 273.15;
      tipoGrado = 'K';
    } 
  }
  
  /**
   * Si la temperatura es celsius o kelvin la transforma
   * a farenheit con el uso de las  formulas
   * F = 1.8 * (K - 237.15) + 32
   * F = C * 1.8 + 32
   */
  public void toFarenheit() {
    if (tipoGrado == 'K') {
      temperatura = 1.8 * (temperatura - 273.15) + 32;
      tipoGrado = 'F';
    } else if (tipoGrado == 'C') {
      temperatura = temperatura * 1.8 + 32;
      tipoGrado = 'F';
    } 
  }
  
  /**
   * Retorna la temperatura de la forma magnitud con dos
   * decimales + el tipo de grado
   * @return un string con la temperatura 
   */
  @Override
  public String toString() {
    if (tipoGrado == ' ') {
      return "";
    }
    return String.format("%.2f", temperatura) + " " + tipoGrado + "°";
  }
  
}
