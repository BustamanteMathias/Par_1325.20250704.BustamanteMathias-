package pkg2pp_bustamantemathias.Vista;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VentanaPrincipal {
    private BorderPane rootLayout;

    public void mostrar(Stage stage) {
        rootLayout = new BorderPane();

        mostrarVista(new VistaLogin(this).getVista());

        Scene scene = new Scene(rootLayout, 400, 500);
        stage.setTitle("2PP - Bustamante  Mathias");
        stage.setScene(scene);
        stage.show();
    }

    public void mostrarVista(Pane vista) {
        rootLayout.setCenter(vista);
    }
}