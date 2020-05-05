package gestisimal;
import utiles.Menu;
import utiles.Teclado;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class TestAlmacen {
  
  // Variables //////
  static Almacen almacen = new Almacen(); 
  
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
   * @throws UnidadesNegativasException 
   */
  private static Articulo alta() throws UnidadesNegativasException {
    return almacen.anadir(pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirUnidades());
  }
  
  /**
   * Da de baja un artículo.
   */
  private static void baja() {
      if (almacen.eliminar(pedirCodigo())) {
        System.out.println("Artículo eliminado.");
      } else {
        System.err.println("Artículo no encontrado.");
      }
    
  }
  
  /**
   * Modifica un artículo
   * @throws UnidadesNegativasException 
   * @throws ArticuloNoExisteException 
   */
  private static void modificacion() throws UnidadesNegativasException, ArticuloNoExisteException {
    try {
      almacen.modificar(pedirCodigo(), pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirUnidades());
      System.out.println("Artículo modificado.");
    } catch (UnidadesNegativasException e) {
      System.err.println(e.getMessage());
    } catch (ArticuloNoExisteException e) {
      System.err.println(e.getMessage());
    }
  }
  
  /**
   * Incrementa las existencias de un artículo
   * @throws ArticuloNoExisteException 
   * @throws UnidadesNegativasException 
   */
  private static void incrementarStock() throws UnidadesNegativasException, ArticuloNoExisteException {
    try {
      almacen.incrementarStock(pedirCodigo(), Teclado.leerEntero("¿Cuántas existencias entran? "));
      System.out.println("Unidades incrementadas.");
    } catch (UnidadesNegativasException e) {
      System.err.println(e.getMessage());
    } catch (ArticuloNoExisteException e) {
      System.err.println(e.getMessage());
    }
  }
  
  /**
   * Decrementa las existencias de un artículo
   * @throws ArticuloNoExisteException 
   * @throws UnidadesNegativasException 
   */
  private static void decrementarStock() throws UnidadesNegativasException, ArticuloNoExisteException {
    try {
      almacen.decrementarStock(pedirCodigo(), Teclado.leerEntero("¿Cuántas existencias salen? "));
      System.out.println("Unidades decrementadas.");
    } catch (UnidadesNegativasException e) {
      System.err.println(e.getMessage());          
    } catch (ArticuloNoExisteException e) {
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
        System.out.println(almacen);
        break;
        
      case 2:
        System.out.println("\n" + alta());
        break;
        
      case 3:
        baja();
        break;
        
      case 4:
        modificacion();
        break;
        
      case 5:
        incrementarStock();
        break;
        
      case 6:
        decrementarStock();
        break;
        
      case 7:
        System.out.print("\nSaliendo...");
        System.exit(0);
        break;
      }
    } while (true);
  }

}
