package gestisimal;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */

@SuppressWarnings("serial")
public class ArticuloNoExisteException extends Exception {
  public ArticuloNoExisteException(String msg) {
    super("Este artículo no existe.");
  }
}
