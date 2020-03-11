package gestisimal;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Articulo{
  // Atributos ////////
  private int codigo;
  String descripcion;
  double precioCompra;
  double precioVenta;
  int unidades; // Unidades deben ser siempre positivas
  private static int contador = 1;
  
  // Constructores ////////
  public Articulo (String descripcion, double precioCompra, double precioVenta, int unidades) {
    this.codigo = contador++;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.precioVenta = precioVenta;
    this.unidades = unidades;
  }
  
  public Articulo (int code, String descripcion, double precioCompra, double precioVenta, int unidades) {
    this.codigo = code;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.precioVenta = precioVenta;
    this.unidades = unidades;
  }
  
  public Articulo(int code) {
    this.codigo = code;
  }

  // Getters & Setters ////////
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

  public void setUnidades(int unidades) throws UnidadesNegativasException {
    if (unidades<0) {
      throw new UnidadesNegativasException("Las unidades no pueden ser negativas.");
    }
    this.unidades = unidades;
  }
  
  @Override
  public String toString() {
    return "COD → " + this.codigo + ".\n Descripción → " + this.descripcion + "\n Precio de compra → " + this.precioCompra + "€\n Precio de venta → " + this.precioVenta + "€\n Unidades → " + this.unidades;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }
  
}
