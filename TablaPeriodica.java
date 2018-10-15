
import java.io.*; 
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 * Clase VentanaInformacion que muestra toda la informacion de
 * un elemento junto con su imagen, su espectro y su informacion, 
 * ademas se tiene un boton que lleva a una nueva ventana que muestra
 * la historia de ese elemento
 * 
 * @author Felipe Pacheco
 * @author Kendall Tenorio
 */
public class TablaPeriodica {
    Elemento[] elementos;
    /**
    * El constructor de la tabla, abre el archivo Tabla.json y recopila toda la informacion
    * de los elementos tal que rellena el arreglo de elementos con los 118 elementos de la
    * tabla, cada uno con respectiva informacion del json, la cual si es nula es guardada como
    * 0 o string vacio
    */
    public TablaPeriodica() {
        JSONParser parser = new JSONParser();
        elementos = new Elemento[118];
        try {
            JSONArray arregloElementosJson = (JSONArray) parser.parse(new FileReader("Tabla.json"));
            for (int i = 0; i < arregloElementosJson.size(); i++) {
                JSONObject elemento = (JSONObject) arregloElementosJson.get(i);
                
                int pesoAtomico = Integer.parseInt(elemento.get("atomicNumber").toString());
                
                String simbolo = elemento.get("symbol").toString();
                
                String nombre = elemento.get("name").toString();
                
                double masaAtomica = Double.parseDouble(elemento.get("atomicMass").toString());
                
                String color = elemento.get("cpkHexColor").toString();
                String configuracionElectronica = elemento.get("electronicConfiguration").toString();
                
                String electronegatividadStr = elemento.get("electronegativity").toString();
                double electronegatividad = (electronegatividadStr.equals("")) ? 0: Double.parseDouble(electronegatividadStr);
                
                String radioAtomicoStr = elemento.get("atomicRadius").toString();
                int radioAtomico = (radioAtomicoStr.equals("")) ? 0: Integer.parseInt(radioAtomicoStr);
                
                String radioIonico = elemento.get("ionRadius").toString();
                
                String radioVanDelWaalsStr = elemento.get("vanDelWaalsRadius").toString();
                int radioVanDelWaals = (radioVanDelWaalsStr.equals("")) ? 0: Integer.parseInt(radioVanDelWaalsStr);
                
                String energiaIonizacionStr = elemento.get("ionizationEnergy").toString();
                int energiaIonizacion = (energiaIonizacionStr.equals("")) ? 0: Integer.parseInt(energiaIonizacionStr); 
                
                String afinidadElectronicaStr = elemento.get("electronAffinity").toString();
                int afinidadElectronica = (afinidadElectronicaStr.equals("")) ? 0: Integer.parseInt(afinidadElectronicaStr); 
                
                String estadosOxidacionStr = elemento.get("oxidationStates").toString();
                int[] estadosOxidacion;
                if (!estadosOxidacionStr.equals("")) {
                    String[] estadosStr = estadosOxidacionStr.split(",");
                    estadosOxidacion = new int[estadosStr.length];
                    int j = 0;
                    while (j < estadosStr.length) {
                        estadosOxidacion[j] = Integer.parseInt(estadosStr[j].replace(" ", ""));
                        j++;
                    }
                } else {
                    estadosOxidacion = new int [0];
                }

                String estadoEstandar = elemento.get("standardState").toString();
                
                String tipo = elemento.get("bondingType").toString();
                
                String puntoFusionStr = elemento.get("meltingPoint").toString();
                int puntoFusionInt = (puntoFusionStr.equals("")) ? 0: Integer.parseInt(puntoFusionStr); 
                Temperatura puntoFusion = (puntoFusionInt == 0) ? new Temperatura(): new Temperatura(puntoFusionInt, 'K');
                
                String puntoEbullicionStr = elemento.get("boilingPoint").toString();
                int puntoEbullicionInt = (puntoEbullicionStr.equals("")) ? 0: Integer.parseInt(puntoEbullicionStr); 
                Temperatura puntoEbullicion = (puntoFusionInt == 0) ? new Temperatura(): new Temperatura(puntoEbullicionInt, 'K');
                
                String densidadStr = elemento.get("density").toString();
                double densidad = (densidadStr.equals("")) ? 0: Double.parseDouble(densidadStr);
                
                String nombreBloque = elemento.get("groupBlock").toString();
              
                String annoDescubrimientoStr = elemento.get("yearDiscovered").toString();
                int annoDescubrimiento = (annoDescubrimientoStr.equals("Ancient")) ? -1: Integer.parseInt(annoDescubrimientoStr); 
                
                String historia = elemento.get("history").toString();
                
                JSONArray arrayLinks = (JSONArray) elemento.get("links");
                String[] linksInfo = new String[arrayLinks.size()];
                for (int j = 0; j < arrayLinks.size(); j++) {
                  String link = arrayLinks.get(j).toString();
                  linksInfo[j] = link;
                }
                
                elementos[i] = new Elemento( nombre, pesoAtomico, simbolo, masaAtomica, color, configuracionElectronica, electronegatividad, radioAtomico, radioIonico, radioVanDelWaals, energiaIonizacion, afinidadElectronica, estadosOxidacion, estadoEstandar, tipo, puntoFusion, puntoEbullicion, densidad, nombreBloque, annoDescubrimiento, historia, linksInfo);
                
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace(); 
        } catch (Exception e) { 
            //e.printStackTrace(); 
        }
    }
    /**
    *Obtiene todos los elementos que esten en el archivo tabla.json en un arreglo de Elementos
    */
    public Elemento[] getElementos() {
        return elementos;
    }
}
