package pkg2pp_bustamantemathias.Utilidades;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogOK {
    public static void mostrar(String titulo, String mensaje) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL); //Bloquear la ventana principal
        ventana.setTitle(titulo);
        ventana.setMinWidth(300);
        ventana.setMinHeight(150);

        Label etiqueta = new Label(mensaje);

        Button botonCerrar = new Button("Cerrar");

        botonCerrar.setOnAction(e -> {
            ventana.close();
        });

        HBox contenedorBotones = new HBox(10); 
        contenedorBotones.getChildren().addAll(botonCerrar);
        contenedorBotones.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(etiqueta, contenedorBotones);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout);
        ventana.setScene(escena);
        ventana.showAndWait(); //Espera hasta que el usuario cierre la ventana
    }
}

//boolean resp = ConfirmDialog.mostrar("Mi mensaje a mostrar");
//System.out.println("Boton: " + (resp ? "Aceptar" : "Cancelar"));