package gestisimal;
import java.util.ArrayList;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Almacen {
  // Creo un ArrayList de artículos (es decir, objetos de la clase Articulo)
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  /**
   * Método para añadir artículos al almacén.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   */
  Articulo addArt(String descripcion, double precioCompra, double precioVenta, int unidades) {
    almacen.add(new Articulo(descripcion, precioCompra, precioVenta, unidades)); // Añado un nuevo artículo en el ArrayList de artículos.
    return almacen.get(almacen.size()-1); // Devuelvo el último objeto del ArrayList, que sería el último artículo.
  }
  
  /**
   * Método para eliminar artículos del almacén.
   * 
   * @param code
   * @return boolean
   * @throws ArticuloNoExisteException
   */
  boolean remArt(int code) throws ArticuloNoExisteException {
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
   */
  void modArt(int code, String descripcion, double precioCompra, double precioVenta, int unidades) {
    int sitio = almacen.indexOf(new Articulo(code)); // Busco el artículo
    almacen.remove(sitio); // Borro el artículo
    almacen.add(sitio, new Articulo(code, descripcion, precioCompra, precioVenta, unidades)); // Creo de nuevo el artículo
  }
  
  /**
   * Método para incrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   */
  void iExistencias(int code, int cantidad){
    int sitio = almacen.indexOf(new Articulo(code)); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = almacen.get(sitio); // Guardo en una variable el artículo para usarlo después
    almacen.set(sitio, new Articulo(code, elemento.descripcion, elemento.precioCompra, elemento.precioVenta, elemento.unidades+cantidad)); // Cambio el articulo, aunque mantengo todo excepto las unidades.
  }
  
  /**
   * Método para decrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   * @throws Exception
   */
  void dExistencias(int code, int cantidad) throws Exception{
    int sitio = almacen.indexOf(new Articulo(code)); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = almacen.get(sitio); // Guardo en una variable el artículo para usarlo después
    if (elemento.unidades>cantidad) {
      almacen.set(sitio, new Articulo(code, elemento.descripcion, elemento.precioCompra, elemento.precioVenta, elemento.unidades-cantidad)); // Cambio el articulo, aunque mantengo todo excepto las unidades.
    } else {
      throw new UnidadesNegativasException("Las unidades no pueden ser negativas.");
    }
  }
  
  /**
   * Método para ver un artículo en concreto del almacén.
   * 
   * @param code
   * @return
   */
  Articulo verArticulo(int code) {
    return almacen.get(almacen.indexOf(new Articulo(code)));
  }
  
  @Override
  public String toString() {
    StringBuilder txtBuilder = new StringBuilder();
    for (int i=0;i<=almacen.size()-1;i++) {
      txtBuilder.append(almacen.get(i) + "\n"); // Voy concatenando todo en una variable 
    }
    return "\n" + (txtBuilder.toString());
  }
}
