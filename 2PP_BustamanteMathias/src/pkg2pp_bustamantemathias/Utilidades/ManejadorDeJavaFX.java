package pkg2pp_bustamantemathias.Utilidades;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author mathi
 */
public class ManejadorDeJavaFX {
    public static GridPane crearGridDesdeMatrizString(String[][] matrizString) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);

        for (int fila = 0; fila < matrizString.length; fila++) {
            for (int col = 0; col < matrizString[fila].length; col++) {
                String dato = matrizString[fila][col];
                Label celda = new Label(dato);
                celda.setStyle("-fx-border-color: black; -fx-padding: 5;");
                grid.add(celda, col, fila);
            }
        }

        return grid;
    }
    
    public static GridPane crearGridDeImagenes(boolean[][] matriz, String rutaTrue, String rutaFalse) {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);

        Image imgTrue = new Image(rutaTrue);
        Image imgFalse = new Image(rutaFalse);

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                boolean valor = matriz[fila][col];
                ImageView imgView = new ImageView(valor ? imgTrue : imgFalse);
                imgView.setFitWidth(40);
                imgView.setFitHeight(40);
                grid.add(imgView, col, fila);
            }
        }

        return grid;
    }
}

//String[][] datos = {
//    {"A1", "A2", "A3"},
//    {"B1", "B2", "B3"},
//    {"C1", "C2", "C3"}
//};
//
//boolean[][] mapa = {
//    {true, false, true},
//    {false, true, false},
//    {true, true, false}
//};