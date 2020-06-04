package gestisimalFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gestisimal.Almacen;
import gestisimal.Articulo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VArticulosController implements Initializable {

  Almacen almacen;
  /*******************
   * VISTA ARTÍCULOS (TABLA)
   */
  @FXML
  private TableView<Articulo> tablaVA;
  @FXML
  private TableColumn<Articulo, Integer> codigoVA;
  @FXML
  private TableColumn<Articulo, String> descVA;
  @FXML
  private TableColumn<Articulo, Double> preComVA;
  @FXML
  private TableColumn<Articulo, Double> preVenVA;
  @FXML
  private TableColumn<Articulo, Integer> udsVA;
  @FXML
  private Button changeView;

  public void reloadTb() {
    codigoVA.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    descVA.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    preComVA.setCellValueFactory(new PropertyValueFactory<>("precioCompra"));
    preVenVA.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
    udsVA.setCellValueFactory(new PropertyValueFactory<>("unidades"));
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    almacen = GestisimalController.getAlmacen();

    reloadTb();
    for (Articulo art : almacen.almacen) {
      tablaVA.getItems().add(art);
    }
    
    changeView.setOnAction(e -> {
      try {
      // Cambio de vista
      GestisimalController.cambiarVista(false);
      // Cierro el stage actual
      Stage stage = (Stage) tablaVA.getScene().getWindow();
      stage.close();
      } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      }
     });

  }

}
