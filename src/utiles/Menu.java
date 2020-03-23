package utiles;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */

public class Menu {
  
  // Propiedades Menu //////
  private String tituloMenu;
  private String[] opciones;
  
  // Variables //////
  private int eleccion;
  
  // Constructor //////
  public Menu(String tituloMenu, String[] opciones) {
    this.tituloMenu = tituloMenu;
    this.opciones = opciones;
  }

  // Getters & Setters //////
  public String getTituloMenu() {
    return tituloMenu;
  }

  public void setTituloMenu(String tituloMenu) {
    this.tituloMenu = tituloMenu;
  }

  public String[] getOpciones() {
    return opciones;
  }

  public void setOpciones(String[] opciones) {
    this.opciones = opciones;
  }
  
  // Métodos //////
  
  /**
   * Método que muestra el menú y pide la opción
   * 
   * @return opción, llamando al método escoger
   */
  public int gestiona() {
    muestraMenu();
    return escoger();
  }
  
  
  /**
   * Muestra el menú por pantalla
   */
  private void muestraMenu() {
    System.out.println("\n" + tituloMenu + "\n");
    for (int i=0;i<opciones.length;i++) {
      System.out.println(opciones[i]);
    }
  }
  
  /**
   * Escoge una opción del menú
   * @return
   */
  private int escoger() {
    do {
      eleccion = Teclado.leerEntero("Escoge una opción: ");
    } while (!(eleccion >= 1 && eleccion <= opciones.length));
    return eleccion;
  }
  
}
