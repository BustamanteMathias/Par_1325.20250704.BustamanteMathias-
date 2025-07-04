package pkg2pp_bustamantemathias.Vista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import pkg2pp_bustamantemathias.Controlador.Constantes;
import pkg2pp_bustamantemathias.Utilidades.ManejadorDeJavaFX;

public class VistaInicio {
    private final VentanaPrincipal controlador;

    public VistaInicio(VentanaPrincipal controlador) {
         this.controlador = controlador;
    }
    
    public Pane getVista() {
        // Título
        Label titulo = new Label("Menú Principal");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");

        // Botones
        Button btnPrueba = new Button("Ver Prueba");
        Button btnCerrarSesion = new Button("Cerrar Sesión");

        btnPrueba.setMaxWidth(Double.MAX_VALUE);
        btnCerrarSesion.setMaxWidth(Double.MAX_VALUE);

        btnPrueba.setOnAction(e -> {
            // controlador.mostrarVista(new VistaPerfil(controlador).getVista());
            controlador.mostrarVista(vistaBtnPrueba());
        });

        btnCerrarSesion.setOnAction(e -> {
            controlador.mostrarVista(new VistaLogin(controlador).getVista());
        });

        VBox contenedorBotones = new VBox(12,
                btnPrueba, btnCerrarSesion
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
    
    private Pane vistaBtnPrueba(){
        // Título
        Label titulo = new Label("Boton Prueba");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");
        
        // Botones
        Button volver = new Button("Volver");
        volver.setMaxWidth(Double.MAX_VALUE);
        volver.setOnAction(e -> {
            controlador.mostrarVista(this.getVista());
        });
        
        VBox contenedorBotones = new VBox(12,volver);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setFillWidth(true);
      
        //
        
        //
        
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
