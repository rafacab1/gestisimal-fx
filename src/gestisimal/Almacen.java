package gestisimal;
import java.util.ArrayList;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Almacen {
  // Creo un ArrayList de artículos (es decir, objetos de la clase Articulo)
  private ArrayList<Articulo> atls = new ArrayList<Articulo>();
  
  /**
   * Método para añadir artículos al almacén.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   */
  public void addArt(String descripcion, double precioCompra, double precioVenta, int unidades) {
    atls.add(new Articulo(descripcion, precioCompra, precioVenta, unidades)); // Añado un nuevo artículo en el ArrayList de artículos.
    System.out.println(atls.get(atls.size()-1)); // Devuelvo el último objeto del ArrayList, que sería el último artículo.
  }
  
  /**
   * Método para eliminar artículos del almacén.
   * 
   * @param code
   * @return boolean
   * @throws ArticuloNoExisteException
   */
  public boolean remArt(int code) throws ArticuloNoExisteException {
    return atls.remove(new Articulo(code));
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
  public void modArt(int code, String descripcion, double precioCompra, double precioVenta, int unidades) {
    int sitio = atls.indexOf(new Articulo(code)); // Busco el artículo
    atls.remove(sitio); // Borro el artículo
    atls.add(sitio, new Articulo(code, descripcion, precioCompra, precioVenta, unidades)); // Creo de nuevo el artículo
  }
  
  /**
   * Método para incrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   */
  public void iExistencias(int code, int cantidad){
    int sitio = atls.indexOf(new Articulo(code)); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = atls.get(sitio); // Guardo en una variable el artículo para usarlo después
    atls.set(sitio, new Articulo(code, elemento.descripcion, elemento.precioCompra, elemento.precioVenta, elemento.unidades+cantidad)); // Cambio el articulo, aunque mantengo todo excepto las unidades.
  }
  
  /**
   * Método para decrementar las existencias de un artículo del almacén.
   * 
   * @param code
   * @param cantidad
   * @throws Exception
   */
  public void dExistencias(int code, int cantidad) throws Exception{
    int sitio = atls.indexOf(new Articulo(code)); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = atls.get(sitio); // Guardo en una variable el artículo para usarlo después
    if (elemento.unidades>cantidad) {
      atls.set(sitio, new Articulo(code, elemento.descripcion, elemento.precioCompra, elemento.precioVenta, elemento.unidades-cantidad)); // Cambio el articulo, aunque mantengo todo excepto las unidades.
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
  public Articulo verArticulo(int code) {
    return atls.get(atls.indexOf(new Articulo(code)));
  }
  
  @Override
  public String toString() {
    String tmp = "";
    for (int i=0;i<=atls.size()-1;i++) {
      tmp = tmp + atls.get(i) + "\n"; // Voy concatenando todo en una variable 
    }
    return "\n" + tmp;
  }
}
