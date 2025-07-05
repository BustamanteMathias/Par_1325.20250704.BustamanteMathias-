package pkg2pp_bustamantemathias.Modelo;
import java.io.Serializable;
import pkg2pp_bustamantemathias.Controlador.Constantes;

public class Sala implements Serializable{
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;
    
    public Sala(int numero, String pelicula){
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[Constantes.BUTACAS_FILAS][Constantes.BUTACAS_COLUMNAS];
        
        for(int i = 0; i<Constantes.BUTACAS_FILAS; i++){
            for(int j = 0; j<Constantes.BUTACAS_COLUMNAS; j++){
                this.butacas[i][j] = new Butaca(j+1, i+1, false);
            }
        }
    }
    
    // Getters
    public int getNumero() {
        return numero;
    }

    public String getPeliculal() {
        return pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPeliculal(String pelicula) {
        this.pelicula = pelicula;
    }

    public void setButaca(Butaca[][] butacas) {
        this.butacas = butacas;
    }
    
    public void setButacaCompra(Butaca[][] butaca, int fila, int columna, boolean estado) {
        butaca[fila][columna].setOcupado(estado);
    }
}
