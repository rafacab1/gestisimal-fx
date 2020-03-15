package utiles;

import java.util.Scanner;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */

public class Teclado {
  private static Scanner s = new Scanner(System.in);
/////////////////////////////////
// LECTOR DE CARACTERES ////////
///////////////////////////////
  
  /**
   * Lee un caracter
   * 
   * Si se le pasa un mensaje como parámetro, lo muestra (por ejemplo, "Introduce una letra: ")
   * y llama al mismo método pero sin parámetro.
   * El método empieza leyendo como si fuese una cadena, pero luego extrae como carácter 
   * la posición 0 de la cadena, y eso es lo que devuelve.
   * 
   * @param Mensaje para mostrar
   * @return
   */
  
  public static char leerCaracter(String msg) {
    System.out.print(msg);
    return leerCaracter();
  }
  public static char leerCaracter() {
    char caracter;
    try {
      caracter = leerCadena().charAt(0);
    } catch (Exception e) {
      caracter = 0;
    }
    return caracter;
  }
  
//////////////////////////////
// LECTOR DE CADENAS ////////
////////////////////////////
  
  /**
   * Lee una cadena
   * 
   * Si se le pasa un mensaje como parámetro, lo muestra (por ejemplo, "Introduce una cadena: ")
   * y llama al mismo método pero sin parámetro.
   * El método usa scanner para obtener la cadena.
   * 
   * @param Mensaje para mostrar
   * @return
   */
  
  public static String leerCadena(String msg) {
    System.out.print(msg);
    return leerCadena();
  }
  
  public static String leerCadena() {
    String tmp;
    try {
      tmp = s.nextLine();
    } catch (Exception e) {
      tmp = "";
    }
    return tmp;
  }
  
//////////////////////////////
// LECTOR DE ENTEROS ////////
////////////////////////////
  
  /**
   * Lee un entero.
   * 
   * Si se le pasa un mensaje como parámetro, lo muestra (por ejemplo, "Introduce un número: ")
   * y llama al mismo método pero sin parámetro.
   * El método usa el método leerCadena y lo convierte a entero.
   * 
   * @param Mensaje para mostrar
   * @return
   */
  
  public static int leerEntero(String msg) {
    System.out.print(msg);
    return leerEntero();
  }
  
  public static int leerEntero() {
    int entero;
    try {
      entero = Integer.parseInt(leerCadena());
    } catch (NumberFormatException e) {
      entero = 0;
    }
    return entero;
  }
  
//////////////////////////////
// LECTOR DE DOUBLE(s) //////
////////////////////////////
  
  /**
   * Lee un decimal (double).
   * 
   * Si se le pasa un mensaje como parámetro, lo muestra (por ejemplo, "Introduce un número: ")
   * y llama al mismo método pero sin parámetro.
   * El método usa el método leerCadena y lo convierte a decimal.
   * 
   * @param Mensaje para mostrar
   * @return
   */
  
  public static double leerDouble(String msg) {
    System.out.print(msg);
    return leerDouble();
  }
  
  public static double leerDouble() {
    double decimal;
    try {
      decimal = Double.parseDouble(leerCadena());
    } catch (NumberFormatException e) {
      decimal = 0;
    }
    return decimal;
  }
}
