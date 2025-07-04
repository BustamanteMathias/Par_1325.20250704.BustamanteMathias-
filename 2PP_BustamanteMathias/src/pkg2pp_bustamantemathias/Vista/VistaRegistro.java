package pkg2pp_bustamantemathias.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import pkg2pp_bustamantemathias.Controlador.Constantes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pkg2pp_bustamantemathias.Modelo.Usuario;
import pkg2pp_bustamantemathias.Utilidades.*;

public class VistaRegistro {

    private final VentanaPrincipal controlador;
    private boolean registroExitoso = false;

    public VistaRegistro(VentanaPrincipal controlador) {
        this.controlador = controlador;
    }

    public Pane getVista() {
        // Componentes
        Label titulo = new Label("Crear Usuario");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextField inputUsuario = new TextField();
        inputUsuario.setPromptText("Usuario");

        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Contraseña");

        PasswordField inputConfirmar = new PasswordField();
        inputConfirmar.setPromptText("Confirmar contraseña");

        TextField inputEmail = new TextField();
        inputEmail.setPromptText("Correo electrónico");

        Label mensaje = new Label();
        mensaje.setStyle("-fx-text-fill: red;");

        Button botonRegistrar = new Button("Registrar");
        Button botonVolver = new Button("Volver");

        botonRegistrar.setOnAction(e -> {
            String usuario = inputUsuario.getText();
            String password = inputPassword.getText();
            String confirmacion = inputConfirmar.getText();
            String email = inputEmail.getText();

            if (usuario.isEmpty() || password.isEmpty() || confirmacion.isEmpty()) {
                mensaje.setText("Completa los campos obligatorios.");
                return;
            }

            if (!password.equals(confirmacion)) {
                mensaje.setText("Las contraseñas no coinciden.");
                return;
            }

            boolean resultado = registrarUsuario(usuario, password, email);

            if (resultado) {
                mensaje.setStyle("-fx-text-fill: green;");
                mensaje.setText("Usuario registrado correctamente.");
                registroExitoso = true;

                // Volver a login despues de registrar
                controlador.mostrarVista(new VistaLogin(controlador).getVista());
            } else {
                mensaje.setStyle("-fx-text-fill: red;");
                mensaje.setText("No se pudo registrar el usuario.");
            }
        });

        botonVolver.setOnAction(e -> {
            controlador.mostrarVista(new VistaLogin(controlador).getVista());
        });

        HBox botones = new HBox(15, botonRegistrar, botonVolver);
        botones.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                titulo,
                inputUsuario,
                inputPassword,
                inputConfirmar,
                inputEmail,
                botones,
                mensaje
        );
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        return layout;
    }

    private boolean registrarUsuario(String usuario, String password, String email) {
        File archivo = new File(Constantes.RUTA_ARCHIVO_USUARIOS);
        ArrayList<Usuario> listaDeUsuarios;
        
        if(ConfirmDialog.mostrar("Registro de Usuario", "Confirmar?")){
            if (archivo.exists()) {
                listaDeUsuarios = (ArrayList<Usuario>)Serializador.leer(Constantes.RUTA_ARCHIVO_USUARIOS);
                System.out.println("[TEST]: Archivo " +  Constantes.RUTA_ARCHIVO_USUARIOS+  " existe.");
                
                for (Usuario u : listaDeUsuarios) {
                    if(u.getEmail().equalsIgnoreCase(email)){
                        DialogOK.mostrar("Registro de Usuario", "El usuario ya existe.");
                        return false;
                    }
                }
            } else {
                listaDeUsuarios = new ArrayList();
                System.out.println("[TEST]: Archivo " +  Constantes.RUTA_ARCHIVO_USUARIOS  +" no existe.  [se procede a crearlo].");
            }
            listaDeUsuarios.add(new Usuario(usuario, email, password));
            Serializador.guardar(Constantes.RUTA_ARCHIVO_USUARIOS, listaDeUsuarios);
            
            DialogOK.mostrar("Registro de Usuario", "Se creo el usuario correctamente.");
        }else{
            return false;
        }
        
        return true;
    }

    public boolean fueRegistroExitoso() {
        return registroExitoso;
    }
}