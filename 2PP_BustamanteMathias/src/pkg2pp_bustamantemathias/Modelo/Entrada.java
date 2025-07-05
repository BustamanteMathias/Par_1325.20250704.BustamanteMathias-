package pkg2pp_bustamantemathias.Modelo;

import java.io.Serializable;

public class Entrada implements Serializable{ 
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;
    
    public Entrada(Cliente cliente, Sala sala, Butaca butaca){
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }
    
    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public Butaca getButaca() {
        return butaca;
    }

    // Setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }
}
