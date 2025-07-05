package pkg2pp_bustamantemathias.Vista;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import pkg2pp_bustamantemathias.Controlador.Constantes;
import pkg2pp_bustamantemathias.Controlador.Controller;
import pkg2pp_bustamantemathias.Modelo.Butaca;
import pkg2pp_bustamantemathias.Modelo.Cine;
import pkg2pp_bustamantemathias.Modelo.Cliente;
import pkg2pp_bustamantemathias.Modelo.Entrada;
import pkg2pp_bustamantemathias.Modelo.Sala;
import pkg2pp_bustamantemathias.Modelo.Sesion;
import pkg2pp_bustamantemathias.Utilidades.DialogOK;
import pkg2pp_bustamantemathias.Utilidades.ManejadorDeJavaFX;
import pkg2pp_bustamantemathias.Utilidades.Serializador;

public class VistaInicio {
    private final VentanaPrincipal controlador;
    private final Cine cine = Controller.getCine();
    private final int indexSala  = 0;
    private final int fila = 0;
    private int columna = 0;
   
    public VistaInicio(VentanaPrincipal controlador) {
         this.controlador = controlador;
    }
    
    private Pane vistaBtnSalasDisponibles(){
        // Título
        Label titulo = new Label("Salas Disponibles");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");
        
        // Botones
        Button btnSala1 = new Button("SALA 1 - "+cine.getSala(0).getPeliculal());
        btnSala1.setMaxWidth(Double.MAX_VALUE);
        btnSala1.setOnAction(e -> {
            controlador.mostrarVista(this.getVista1());
        });
        
        Button btnSala2 = new Button("SALA 2 - "+cine.getSala(1).getPeliculal());
        btnSala2.setMaxWidth(Double.MAX_VALUE);
        btnSala2.setOnAction(e -> {
            controlador.mostrarVista(this.getVista2());
        });
        
        Button btnSala3 = new Button("SALA 3 - "+cine.getSala(2).getPeliculal());
        btnSala3.setMaxWidth(Double.MAX_VALUE);
        btnSala3.setOnAction(e -> {
            controlador.mostrarVista(this.getVista3());
        });
        
        Button volver = new Button("Volver");
        volver.setMaxWidth(Double.MAX_VALUE);
        volver.setOnAction(e -> {
            controlador.mostrarVista(this.getVista());
        });
        
        VBox contenedorBotones = new VBox(12, btnSala1, btnSala2, btnSala3, volver);
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
    
    private Pane vistaBtnComprarEntrada(){
        // Título
        Label titulo = new Label("Comprar Entrada ["+Sesion.getInstancia().getCliente().getNombre()+"]");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");
        
        ComboBox<String> comboSalas = new ComboBox<>();
        for(int  i=0; i<cine.getSalas().size(); i++){
            comboSalas.getItems().addAll("Sala ["+cine.getSala(i).getNumero()+"] - "+cine.getSala(i).getPeliculal());
        }
        comboSalas.setPromptText("Seleccionar una sala");
        
        ComboBox<String> comboFila = new ComboBox<>();
        for(int  i=0; i<Constantes.BUTACAS_FILAS; i++){
            comboFila.getItems().addAll(Integer.toString(i+1));
        }
        comboFila.setPromptText("Seleccionar una fila");

         ComboBox<String> comboColumna = new ComboBox<>();
        for(int  i=0; i<Constantes.BUTACAS_COLUMNAS; i++){
            comboColumna.getItems().addAll(Integer.toString(i+1));
        }
        comboColumna.setPromptText("Seleccionar una columna");
        
        // Botones
        Button comprar = new Button("Comprar");
        comprar.setMaxWidth(Double.MAX_VALUE);
        comprar.setOnAction(e -> {
            String  salaSeleccionada = comboSalas.getValue();
            //VALIDAR DISPONIBILIDAD DE LA SALA
             Entrada entrada;
             
            if(salaSeleccionada.contains("Sala [1]")){
                cine.getSala(0).setButacaCompra(cine.getSala(0).getButacas(), Integer.parseInt(comboFila.getValue())-1, Integer.parseInt(comboColumna.getValue())-1, true);
                entrada = new Entrada(Sesion.getInstancia().getCliente(),
                cine.getSala(0),
                cine.getSala(0).getButacas()[Integer.parseInt(comboFila.getValue())-1][Integer.parseInt(comboColumna.getValue())-1]);
                cine.addEntrada(entrada);
            }else if(salaSeleccionada.contains("Sala [2]")){
                cine.getSala(1).setButacaCompra(cine.getSala(1).getButacas(), Integer.parseInt(comboFila.getValue())-1, Integer.parseInt(comboColumna.getValue())-1, true);
                entrada = new Entrada(Sesion.getInstancia().getCliente(),
                cine.getSala(1),
                cine.getSala(1).getButacas()[Integer.parseInt(comboFila.getValue())-1][Integer.parseInt(comboColumna.getValue())-1]);
                cine.addEntrada(entrada);
            }else{
                cine.getSala(2).setButacaCompra(cine.getSala(2).getButacas(), Integer.parseInt(comboFila.getValue())-1, Integer.parseInt(comboColumna.getValue())-1, true);
                entrada = new Entrada(Sesion.getInstancia().getCliente(),
                cine.getSala(2),
                cine.getSala(2).getButacas()[Integer.parseInt(comboFila.getValue())-1][Integer.parseInt(comboColumna.getValue())-1]);
                cine.addEntrada(entrada);
            }
            DialogOK.mostrar("Compra de entrada EXITOSA", "No se esta validando si ya esta comprada!\nFunciona y persiste en archivo.\nVolver a la vista de las salas.");
            
            
            
            Serializador.guardar(Constantes.RUTA_ARCHIVO_CINE, cine);
        });
        
        Button volver = new Button("Volver");
        volver.setMaxWidth(Double.MAX_VALUE);
        volver.setOnAction(e -> {
            controlador.mostrarVista(this.getVista());
        });
        
        VBox contenedorBotones = new VBox(12, comboSalas, comboFila, comboColumna, comprar, volver);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setFillWidth(true);
      
        //
        Cliente c = Sesion.getInstancia().getCliente();
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
    
    public Pane getVista() {
        // Título
        Label titulo = new Label("Menú Principal");
        titulo.setFont(new Font(22));
        titulo.setStyle("-fx-font-weight: bold;");

        // Botones
        Button btnVerSalasDisponibles = new Button("Ver Salas Disponibles");
        Button btnComprarEntrada = new Button("Comprar Entrada");
        Button btnCerrarSesion = new Button("Cerrar Sesión");

        btnVerSalasDisponibles.setMaxWidth(Double.MAX_VALUE);
        btnComprarEntrada.setMaxWidth(Double.MAX_VALUE);
        btnCerrarSesion.setMaxWidth(Double.MAX_VALUE);

        btnVerSalasDisponibles.setOnAction(e -> {
            // controlador.mostrarVista(new VistaPerfil(controlador).getVista());
            controlador.mostrarVista(vistaBtnSalasDisponibles());
        });

        btnComprarEntrada.setOnAction(e -> {
            //controlador.mostrarVista(new VistaLogin(controlador).getVista());
            controlador.mostrarVista(vistaBtnComprarEntrada());
        });
        
        btnCerrarSesion.setOnAction(e -> {
            controlador.mostrarVista(new VistaLogin(controlador).getVista());
        });

        VBox contenedorBotones = new VBox(12,
                btnVerSalasDisponibles, btnComprarEntrada, btnCerrarSesion
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
    
    public Pane getVista1() {
    // Título
    Label titulo = new Label("Sala 1 [ "+cine.getSala(0).getPeliculal()+" ]");
    titulo.setFont(new Font(22));
    titulo.setStyle("-fx-font-weight: bold;");

    // Botones
    Button btnVolver = new Button("Volver");
    btnVolver.setMaxWidth(Double.MAX_VALUE);
    btnVolver.setOnAction(e -> {
        controlador.mostrarVista(vistaBtnSalasDisponibles());
    });

    VBox contenedorBotones = new VBox(12,
            btnVolver
    );
    contenedorBotones.setAlignment(Pos.CENTER);
    contenedorBotones.setFillWidth(true);

    GridPane vistaDeSalas = ManejadorDeJavaFX.crearGridDesdeMatrizButaca(cine.getSala(0).getButacas());

    VBox layout = new VBox(20, titulo, vistaDeSalas, contenedorBotones);
    layout.setPadding(new Insets(30));
    layout.setAlignment(Pos.CENTER);
    layout.setMaxWidth(300);

    StackPane contenedorCentral = new StackPane(layout);
    contenedorCentral.setPadding(new Insets(40));
    StackPane.setAlignment(layout, Pos.CENTER);

    return contenedorCentral;
}

    public Pane getVista2() {
    // Título
    Label titulo = new Label("Sala 2 [ "+cine.getSala(1).getPeliculal()+" ]");
    titulo.setFont(new Font(22));
    titulo.setStyle("-fx-font-weight: bold;");

    // Botones
    Button btnVolver = new Button("Volver");
    btnVolver.setMaxWidth(Double.MAX_VALUE);
    btnVolver.setOnAction(e -> {
        controlador.mostrarVista(vistaBtnSalasDisponibles());
    });

    VBox contenedorBotones = new VBox(12,
            btnVolver
    );
    contenedorBotones.setAlignment(Pos.CENTER);
    contenedorBotones.setFillWidth(true);

    GridPane vistaDeSalas = ManejadorDeJavaFX.crearGridDesdeMatrizButaca(cine.getSala(1).getButacas());

    VBox layout = new VBox(20, titulo, vistaDeSalas, contenedorBotones);
    layout.setPadding(new Insets(30));
    layout.setAlignment(Pos.CENTER);
    layout.setMaxWidth(300);

    StackPane contenedorCentral = new StackPane(layout);
    contenedorCentral.setPadding(new Insets(40));
    StackPane.setAlignment(layout, Pos.CENTER);

    return contenedorCentral;
}

    public Pane getVista3() {
    // Título
    Label titulo = new Label("Sala 3 [ "+cine.getSala(2).getPeliculal()+" ]");
    titulo.setFont(new Font(22));
    titulo.setStyle("-fx-font-weight: bold;");

    // Botones
    Button btnVolver = new Button("Volver");
    btnVolver.setMaxWidth(Double.MAX_VALUE);
    btnVolver.setOnAction(e -> {
        controlador.mostrarVista(vistaBtnSalasDisponibles());
    });

    VBox contenedorBotones = new VBox(12,
            btnVolver
    );
    contenedorBotones.setAlignment(Pos.CENTER);
    contenedorBotones.setFillWidth(true);

    GridPane vistaDeSalas = ManejadorDeJavaFX.crearGridDesdeMatrizButaca(cine.getSala(2).getButacas());

    VBox layout = new VBox(20, titulo, vistaDeSalas, contenedorBotones);
    layout.setPadding(new Insets(30));
    layout.setAlignment(Pos.CENTER);
    layout.setMaxWidth(300);

    StackPane contenedorCentral = new StackPane(layout);
    contenedorCentral.setPadding(new Insets(40));
    StackPane.setAlignment(layout, Pos.CENTER);

    return contenedorCentral;
}
}
