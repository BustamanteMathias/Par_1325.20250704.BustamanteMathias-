package pkg2pp_bustamantemathias.Modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Cine implements Serializable{ //lista de salas y entradas
    private final ArrayList<Sala> salas;
    private final ArrayList<Entrada> entradas;
    
    public Cine(){
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
    }
    
    // Getters
    public ArrayList<Sala> getSalas() {
        return salas;
    }
    
    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }
    
    public Sala getSala(int index) {
        if(this.salas == null) return null;
        return salas.get(index);
    }
    
    public Entrada getEntrada(int index) {
        if(this.entradas == null) return null;
        return entradas.get(index);
    }
    
    // Agregar a listas
    public boolean addSala(Sala sala){
        if(this.salas == null) return false;
        this.salas.add(sala);
        return true;
    }
    
    public boolean addEntrada(Entrada entrada){
        if(this.entradas == null) return false;
        this.entradas.add(entrada);
        return true;
    }
}
