package gestisimal;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class Articulo{
  // Atributos ////////
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int unidades; // Unidades deben ser siempre positivas
  private static int contador = 1;
  
  // Constructor ////////
  Articulo (String descripcion, double precioCompra, double precioVenta, int unidades) throws UnidadesNegativasException {
    this.codigo = contador++;
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setUnidades(unidades);
  }
  
  // Para buscar Articulo
  Articulo(int code) {
    this.codigo = code;
  }

  // Getters & Setters ////////
  private int getCodigo() {
    return codigo;
  }

  private String getDescripcion() {
    return descripcion;
  }

  private void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  private double getPrecioCompra() {
    return precioCompra;
  }

  private void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  private double getPrecioVenta() {
    return precioVenta;
  }

  private void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  private int getUnidades() {
    return unidades;
  }

  private void setUnidades(int unidades) throws UnidadesNegativasException {
    if (unidades<0) {
      throw new UnidadesNegativasException("Las unidades no pueden ser negativas.");
    }
    this.unidades = unidades;
  }
  
  /**
   * Método modificar para modificar las propiedades de Articulo
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   * @return
   * @throws UnidadesNegativasException
   */
  Articulo modificar(String descripcion, double precioCompra, double precioVenta, int unidades) throws UnidadesNegativasException {
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setUnidades(unidades);
    return this;
  }
  
  /**
   * Método incrementarStock para incrementar el stock de Articulo
   * 
   * @param unidades
   * @return
   * @throws UnidadesNegativasException
   */
  Articulo incrementarStock(int unidades) throws UnidadesNegativasException {
    setUnidades(getUnidades() + unidades);
    return this;
  }
  
  /**
   * Método decrementarStock para decrementar el stock de Articulo
   * 
   * @param unidades
   * @return
   * @throws UnidadesNegativasException
   */
  Articulo decrementarStock(int unidades) throws UnidadesNegativasException {
    setUnidades(getUnidades() - unidades);
    return this;
  }
  
  @Override
  public String toString() {
    return "COD → " + getCodigo() + ".\n Descripción → " + getDescripcion() + "\n Precio de compra → " + getPrecioCompra() + "€\n Precio de venta → " + getPrecioVenta() + "€\n Unidades → " + getUnidades();
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
