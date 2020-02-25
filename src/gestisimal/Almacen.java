package gestisimal;
import java.util.ArrayList;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Almacen {
  // Creo un ArrayList de artículos (es decir, objetos de la clase Articulo)
  ArrayList<Articulo> atls = new ArrayList<Articulo>();
  
  public void addArt(String descripcion, double precioCompra, double precioVenta, int unidades) {
    atls.add(new Articulo(descripcion, precioCompra, precioVenta, unidades)); // Añado un nuevo artículo en el ArrayList de artículos.
    System.out.println(atls.get(atls.size()-1)); // Devuelvo el último objeto del ArrayList, que sería el último artículo.
  }
  
  public void remArt(int code) {
    atls.remove(code); // TODO: ¿Como referenciar al código?
  }
  
  public void modArt(int code, String descripcion, double precioCompra, double precioVenta, int unidades) {
    int sitio = atls.indexOf(code); // TODO: ¿Como referenciar al código?
    atls.remove(sitio);
    atls.add(sitio, new Articulo(descripcion, precioCompra, precioVenta, unidades));
  }
  
  public void iExistencias(int code, int cantidad) {
    int sitio = atls.indexOf(code); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = atls.get(code); // TODO: ¿Como referenciar al código?
    int uds = elemento.unidades + cantidad; // Sumo la cantidad
    // TODO: ¿Como digo que quiero cambiar las unidades del Articulo que hay en la posición "sitio"?
  }
  
  public void dExistencias(int code, int cantidad) {
    int sitio = atls.indexOf(code); // Guardo la posición para luego saber donde tengo que insertar la nueva cantidad
    Articulo elemento = atls.get(code); // TODO: ¿Como referenciar al código?
    if (cantidad>0) {
      int uds = elemento.unidades - cantidad; // Resto la cantidad
    }
    // TODO: ¿Como digo que quiero cambiar las unidades del Articulo que hay en la posición "sitio"?
  }
  
  public Articulo verArticulo(int code) {
    return atls.get(code); // TODO: ¿Como referenciar al código?
  }
  
  @Override
  public String toString() {
    String tmp = "";
    for (int i=0;i<=atls.size()-1;i++) {
      tmp = tmp + atls.get(i) + "\n"; // Voy concatenando todo en una variable 
    }
    return tmp;
  }
}
