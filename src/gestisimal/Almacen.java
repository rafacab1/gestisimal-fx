package gestisimal;
import java.util.ArrayList;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Almacen {
  /**
   * ArrayList de objetos de la clase Articulo
   */
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  /**
   * Método para añadir artículos al almacén.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   * @throws UnidadesNegativasException 
   */
  Articulo anadir(String descripcion, double precioCompra, double precioVenta, int unidades) throws UnidadesNegativasException {
    almacen.add(new Articulo(descripcion, precioCompra, precioVenta, unidades)); // Añade un nuevo artículo en el ArrayList de artículos.
    return almacen.get(almacen.size()-1); // Devuelve el último objeto del ArrayList, que sería el último artículo.
  }
  
  /**
   * Método para eliminar artículos del almacén.
   * 
   * @param code
   * @return boolean
   * @throws ArticuloNoExisteException
   */
  boolean eliminar(int code) throws ArticuloNoExisteException {
    return almacen.remove(new Articulo(code));
  }
  
  /**
   * Método para modificar un artículo del almacén.
   * 
   * @param code
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   * @return 
   * @throws UnidadesNegativasException 
   */
  Articulo modificar(int code, String descripcion, double precioCompra, double precioVenta, int unidades) throws UnidadesNegativasException {
    return getArticulo(code).modificar(descripcion, precioCompra, precioVenta, unidades);
  }
  
  /**
   * Método para incrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   * @throws UnidadesNegativasException 
   * @throws ArticuloNoExisteException 
   */
  Articulo incrementarStock(int code, int cantidad) throws UnidadesNegativasException, ArticuloNoExisteException{
    try {
      return getArticulo(code).incrementarStock(cantidad);
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El artículo con código " + code + " no existe.");
    }
  }
  
  /**
   * Método para decrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   * @throws UnidadesNegativasException 
   * @throws ArticuloNoExisteException 
   */
  Articulo decrementarStock(int code, int cantidad) throws UnidadesNegativasException, ArticuloNoExisteException{
    try {
      return getArticulo(code).decrementarStock(cantidad);
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El artículo con código " + code + " no existe.");
    }
  }
  
  /**
   * Método para ver un artículo en concreto del almacén.
   * 
   * @param code
   * @return
   */
  Articulo getArticulo(int code) {
    try {
      return almacen.get(almacen.indexOf(new Articulo(code)));
    } catch (IndexOutOfBoundsException e) {
      System.err.print("Error al encontrar el artículo.");
      return null;
    }
    
  }
  
  @Override
  public String toString() {
    StringBuilder txtBuilder = new StringBuilder();
    for (int i=0;i<=almacen.size()-1;i++) {
      txtBuilder.append(almacen.get(i) + "\n"); // Voy concatena todo en una variable 
    }
    return "\n" + (txtBuilder.toString());
  }
}
