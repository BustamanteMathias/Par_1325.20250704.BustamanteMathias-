package pkg2pp_bustamantemathias.Utilidades;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmDialog {
    private static boolean respuesta;

    public static boolean mostrar(String titulo, String mensaje) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL); //Bloquear la ventana principal
        ventana.setTitle(titulo);
        ventana.setMinWidth(300);
        ventana.setMinHeight(150);

        Label etiqueta = new Label(mensaje);

        Button botonAceptar = new Button("Aceptar");
        Button botonCancelar = new Button("Cancelar");

        botonAceptar.setOnAction(e -> {
            respuesta = true;
            ventana.close();
        });

        botonCancelar.setOnAction(e -> {
            respuesta = false;
            ventana.close();
        });

        HBox contenedorBotones = new HBox(10); 
        contenedorBotones.getChildren().addAll(botonAceptar, botonCancelar);
        contenedorBotones.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(etiqueta, contenedorBotones);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout);
        ventana.setScene(escena);
        ventana.showAndWait(); //Espera hasta que el usuario cierre la ventana

        return respuesta;
    }
}

//boolean resp = ConfirmDialog.mostrar("Mi mensaje a mostrar");
//System.out.println("Boton: " + (resp ? "Aceptar" : "Cancelar"));