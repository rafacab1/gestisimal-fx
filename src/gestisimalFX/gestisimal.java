package gestisimalFX;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class gestisimal extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	  primaryStage.setTitle("Gestisimal"); // Título
    primaryStage.setResizable(false); // Bloque el redimensionamiento
    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("Gestisimal.fxml"));
    GridPane root = fxml.<GridPane>load(); // Creo el GridPane
    primaryStage.setScene(new Scene(root)); // Crea la escena
    primaryStage.show(); // Muestra la escena
	}

	public static void main(String[] args) {
		launch(args);
	}
}
