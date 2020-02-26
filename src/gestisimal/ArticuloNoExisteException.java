package gestisimal;

@SuppressWarnings("serial")
public class ArticuloNoExisteException extends Exception {
  public ArticuloNoExisteException() {
    super("Este artículo no existe.");
  }
}
