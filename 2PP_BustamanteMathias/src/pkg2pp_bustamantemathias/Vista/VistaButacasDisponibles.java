package pkg2pp_bustamantemathias.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaButacasDisponibles {
     private final VentanaPrincipal controlador;
    
    public VistaButacasDisponibles(VentanaPrincipal controlador) {
        this.controlador = controlador;
    }
    
     public Pane getVista() {
        // Título
        Label titulo = new Label("Butacas Disponibles");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");

        // Botones
        Button btnVolver= new Button("Volver");
        btnVolver.setMaxWidth(Double.MAX_VALUE);
        btnVolver.setOnAction(e -> {
            controlador.mostrarVista(new VistaInicio(controlador).getVista());
        });

        VBox contenedorBotones = new VBox(12,
                btnVolver
        );
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setFillWidth(true);

        VBox layout = new VBox(20, titulo, contenedorBotones);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setMaxWidth(300);

        StackPane contenedorCentral = new StackPane(layout);
        contenedorCentral.setPadding(new Insets(40));
        StackPane.setAlignment(layout, Pos.CENTER);

        return contenedorCentral;
    }
}
