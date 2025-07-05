package pkg2pp_bustamantemathias.Modelo;

public class Sesion {
    private static Sesion instancia;
    private Cliente clienteActual;

    private Sesion() {}

    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    public void setCliente(Cliente cliente) {
        this.clienteActual = cliente;
    }

    public Cliente getCliente() {
        return this.clienteActual;
    }
}
