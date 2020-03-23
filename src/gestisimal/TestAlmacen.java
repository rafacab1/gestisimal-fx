package gestisimal;
import utiles.Menu;
import utiles.Teclado;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class TestAlmacen {
  
  // Variables //////
  static Almacen a1 = new Almacen(); 
  
  // Métodos //////
  // Obtención de datos
  /**
   * Pide el código de un artículo.
   * @return int
   */
  private static int pedirCodigo() {
    return Teclado.leerEntero("Introduce el código del artículo: ");
  }
  
  /**
   * Pide la descripción de un artículo.
   * @return String
   */
  private static String pedirDescripcion() {
    return Teclado.leerCadena("Introduce la descripción: ");
  }
  
  /**
   * Pide el precio de compra de un artículo.
   * @return double
   */
  private static double pedirPrecioCompra() {
    return Teclado.leerDouble("Introduce el precio de compra: ");
  }
  
  /**
   * Pide el precio de venta de un artículo.
   * @return double
   */
  private static double pedirPrecioVenta() {
    return Teclado.leerDouble("Introduce el precio de venta: ");
  }
  
  /**
   * Pide las unidades de un artículo.
   * @return double
   */
  private static int pedirUnidades() {
    return Teclado.leerEntero("Introduce las unidades: ");
  }
  
  // Tareas
  /**
   * Da de alta un artículo.
   * @return Articulo
   */
  private static Articulo alta() {
    return a1.addArt(pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirUnidades());
  }
  
  /**
   * Da de baja un artículo.
   * @throws Exception
   */
  private static void baja() throws ArticuloNoExisteException {
    try {
      a1.remArt(pedirCodigo());
    } catch (ArticuloNoExisteException e) {
      System.err.println(e.getMessage()); // Hay que revisarlo, issue #11
    }
  }
  
  /**
   * Modifica un artículo
   */
  private static void modificacion() {
    a1.modArt(pedirCodigo(), pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirUnidades());
  }
  
  /**
   * Incrementa las existencias de un artículo
   */
  private static void incrementarExistencias() {
    a1.iExistencias(pedirCodigo(), Teclado.leerEntero("¿Cuántas existencias entran? "));
  }
  
  /**
   * Decrementa las existencias de un artículo
   * @throws Exception
   */
  private static void decrementarExistencias() throws Exception {
    try {
      a1.dExistencias(pedirCodigo(), Teclado.leerEntero("¿Cuántas existencias salen? "));
    } catch (UnidadesNegativasException e) {
      System.err.println(e.getMessage());          
    }
  }
  
  public static void main(String[] args) throws Exception {   
    // Crea un objeto de la clase Menu
    String[] opciones = new String[] {"1. Listado", "2. Alta", "3. Baja", "4. Modificación", "5. Entrada de mercancía", "6. Salida de Mercancia", "7. Salir"};
    Menu menu = new Menu("GESTISIMAL", opciones);
    
    do {
      switch (menu.gestiona()) {
      case 1:
        System.out.println(a1);
        break;
        
      case 2:
        System.out.println("\n" + alta());
        break;
        
      case 3:
        baja();
        break;
        
      case 4:
        modificacion();
        System.out.println("Artículo modificado.");
        break;
        
      case 5:
        incrementarExistencias();
        System.out.println("Existencias incrementadas.");
        break;
        
      case 6:
        decrementarExistencias();
        break;
        
      case 7:
        System.out.print("\nSaliendo...");
        System.exit(0);
        break;
      }
    } while (true);
  }

}
