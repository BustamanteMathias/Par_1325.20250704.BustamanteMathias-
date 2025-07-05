package pkg2pp_bustamantemathias.Modelo;
import java.io.Serializable;

public class Butaca implements Serializable{
    private int numero;
    private int fila;
    private boolean ocupado;
    
    public Butaca(int numero, int fila, boolean ocupado){
        this.numero = numero;
        this.fila = fila;
        this.ocupado = ocupado;
    }
    
    // Getters
    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    // Setters
    public void setNombre(int numero) {
        this.numero = numero;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
