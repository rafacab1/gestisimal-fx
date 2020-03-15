package utiles;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */

public class Menu {
  
  // Propiedades Menu //////
  String tituloMenu;
  String[] opciones;
  
  // Variables //////
  int eleccion;
  
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
  public int escoger() {
    muestraMenu();
    do {
      eleccion = Teclado.leerEntero("Escoge una opción: ");
    } while (!(eleccion >= 1 && eleccion <= opciones.length));
    return eleccion;
  }
  
}
