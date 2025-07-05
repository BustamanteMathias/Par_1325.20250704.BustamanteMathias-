package pkg2pp_bustamantemathias.Vista;

import java.io.File;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import pkg2pp_bustamantemathias.Controlador.Constantes;
import pkg2pp_bustamantemathias.Modelo.Cliente;
import pkg2pp_bustamantemathias.Modelo.Sesion;
import pkg2pp_bustamantemathias.Utilidades.Serializador;

public class VistaLogin {
    private final VentanaPrincipal controlador;

    public VistaLogin(VentanaPrincipal controlador) {
        this.controlador = controlador;
    }

    public Pane getVista() {
        // Título
        Label titulo = new Label("Inicio de Sesión");
        titulo.setFont(new Font(20));
        titulo.setStyle("-fx-font-weight: bold;");

        // Inputs usuario
        Label labelEmail = new Label("Email:");
        TextField inputEmail = new TextField();
        inputEmail.setPromptText("Ingrese su email");

        VBox grupoUsuario = new VBox(5, labelEmail, inputEmail);

        // Inputs contraseña
        Label labelPassword = new Label("Contraseña:");
        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Ingrese su contraseña");

        VBox grupoPassword = new VBox(5, labelPassword, inputPassword);

        // Mensaje de validación
        Label mensaje = new Label();
        mensaje.setStyle("-fx-text-fill: red;");

        // Botones
        Button botonLogin = new Button("Ingresar");
        Button botonRegistro = new Button("Registrarse");

        botonLogin.setMaxWidth(Double.MAX_VALUE);
        botonRegistro.setMaxWidth(Double.MAX_VALUE);

        botonLogin.setOnAction(e -> {
            String usuario = inputEmail.getText();
            String password = inputPassword.getText();

            if (validarPassword(usuario, password)) {
                mensaje.setStyle("-fx-text-fill: green;");
                mensaje.setText("Acceso concedido");
                controlador.mostrarVista(new VistaInicio(controlador).getVista());
            } else {
                mensaje.setStyle("-fx-text-fill: red;");
                mensaje.setText("Credenciales incorrectas.");
            }
        });

        botonRegistro.setOnAction(e -> {
            controlador.mostrarVista(new VistaRegistro(controlador).getVista());
        });

        VBox botones = new VBox(10, botonLogin, botonRegistro);
        botones.setAlignment(Pos.CENTER);
        botones.setFillWidth(true);

        // Layout general
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setMaxWidth(300);
        layout.getChildren().addAll(titulo, grupoUsuario, grupoPassword, mensaje, botones);

        // Envolver en otro contenedor para centrar en pantalla
        StackPane contenedorCentral = new StackPane(layout);
        contenedorCentral.setPadding(new Insets(30));
        StackPane.setAlignment(layout, Pos.CENTER);

        return contenedorCentral;
    }

    private boolean validarPassword(String email, String password) {
        File archivo = new File(Constantes.RUTA_ARCHIVO_CLIENTES);
         if (!archivo.exists()) return false;
         
         ArrayList<Cliente> listaDeUsuarios = (ArrayList<Cliente>)Serializador.leer(Constantes.RUTA_ARCHIVO_CLIENTES);
          for (Cliente u : listaDeUsuarios) {
              if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)){
                  Sesion.getInstancia().setCliente(u);
                  return true;
              }
          }
          
          return false;
    }
}