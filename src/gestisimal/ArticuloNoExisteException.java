package gestisimal;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */

@SuppressWarnings("serial")
public class ArticuloNoExisteException extends Exception {
  public ArticuloNoExisteException() {
    super("Este artículo no existe");
  }
  public ArticuloNoExisteException(String msg) {
    super(msg);
  }
}
