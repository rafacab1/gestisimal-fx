package gestisimalFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gestisimal.Almacen;
import gestisimal.Articulo;
import gestisimal.ArticuloNoExisteException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VArticulosIndividual implements Initializable {

  Almacen almacen;
  Articulo artListado;
  int articuloActual = 1;
  
  /*******************
   * VISTA INDIVIDUAL
   */
  @FXML
  private TextField codigoVI;
  @FXML
  private TextArea descVI;
  @FXML
  private TextField precioCompraVI;
  @FXML
  private TextField precioVentaVI;
  @FXML
  private TextField udsVI;
  @FXML
  private ScrollBar scroll;
  @FXML
  private Button changeView;
  
  public void recarga() throws ArticuloNoExisteException {
    artListado = almacen.getArticulo(articuloActual);
    System.out.println("DELETE: Comprobación" + artListado.getCodigo());    
    codigoVI.setText(Integer.toString(articuloActual));
    descVI.setText(artListado.getDescripcion());
    precioCompraVI.setText(Double.toString(artListado.getPrecioCompra()));
    precioVentaVI.setText(Double.toString(artListado.getPrecioVenta()));
    udsVI.setText(Integer.toString(artListado.getUnidades()));
  }
  
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    almacen = GestisimalController.getAlmacen();
    scroll.setMin(1);
    scroll.setMax(almacen.almacen.size());
    scroll.setValue(1);
    scroll.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov,
          Number old_val, Number new_val) {
              articuloActual = new_val.intValue();
              try {
                recarga();
              } catch (ArticuloNoExisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
          }
      });
    try {
      recarga();
    } catch (ArticuloNoExisteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    changeView.setOnAction(e -> {
      try {
      // Cambio de vista
      GestisimalController.cambiarVista(true);
      // Cierro el stage actual
      Stage stage = (Stage) scroll.getScene().getWindow();
      stage.close();
      } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      }
     });
  }

}
