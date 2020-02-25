package gestisimal;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Articulo {
  // Atributos ////////
  int codigo;
  String descripcion;
  double precioCompra;
  double precioVenta;
  int unidades; // Unidades deben ser siempre positivas
  private static int contador = 0;
  
  // Constructor ////////
  public Articulo (String descripcion, double precioCompra, double precioVenta, int unidades) {
    this.codigo = contador++;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.precioVenta = precioVenta;
    this.unidades = unidades;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo++;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public int getUnidades() {
    return unidades;
  }

  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }
  
  @Override
  public String toString() {
    return "COD → " + this.codigo + ".\n Descripción → " + this.descripcion + ".\n Precio de compra → " + this.precioCompra + ".\n Precio de venta → " + this.precioVenta + ".\n Unidades → " + this.unidades;
  }
  
  
}
