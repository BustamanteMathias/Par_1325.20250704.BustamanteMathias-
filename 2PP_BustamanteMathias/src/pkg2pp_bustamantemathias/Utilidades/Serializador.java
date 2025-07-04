package pkg2pp_bustamantemathias.Utilidades;
import java.io.*;

public class Serializador {
    public static <T extends Serializable> boolean guardar(String path, T obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public static <T extends Serializable> T leer(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            @SuppressWarnings("unchecked")  //Quita los warnning por advertencias de cast con generica  T
            T obj = (T) ois.readObject();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}

//Extender de Serializable
//Usuario u = new Usuario("pepe", "1234");
//Serializador.guardar("usuario.dat", u);
//Usuario u = Serializador.leer("usuario.dat");
//System.out.println("Usuario: " + u.getNombre());

//List<Usuario> usuarios = Serializador.leer("usuarios.dat");
//if (usuarios != null) {
//    for (Usuario u : usuarios) {
//        System.out.println("Nombre: " + u.getNombre());
//    }
//}
