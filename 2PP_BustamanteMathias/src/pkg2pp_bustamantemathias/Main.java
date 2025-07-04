package pkg2pp_bustamantemathias;
import javafx.application.Application;
import javafx.stage.Stage;
import pkg2pp_bustamantemathias.Vista.VentanaPrincipal;

public class Main extends Application{
    @Override
    public void start(Stage stage) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}