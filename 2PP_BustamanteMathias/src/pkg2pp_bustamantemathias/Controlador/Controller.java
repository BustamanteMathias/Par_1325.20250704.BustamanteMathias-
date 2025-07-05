package pkg2pp_bustamantemathias.Controlador;
import java.io.File;
import pkg2pp_bustamantemathias.Modelo.*;
import pkg2pp_bustamantemathias.Utilidades.Serializador;

public class Controller {
    private Controller(){
        //No instanciable
    }
    
    public static Cine getCine(){
        File archivo = new File(Constantes.RUTA_ARCHIVO_CINE);
        Cine cine;
        
        if(archivo.exists()){
            cine = Serializador.leer(Constantes.RUTA_ARCHIVO_CINE);
        }else{
            cine = new  Cine();
            Sala s1 = new Sala(1, "Pelicula 1");
            Sala s2 = new Sala(2, "Pelicula 2");
            Sala s3 = new Sala(3, "Pelicula 3");
            
            cine.addSala(s1);
            cine.addSala(s2);
            cine.addSala(s3);
        }
        return cine;
    }
    
    public boolean setButacaDisponible(Sala sala){
        Butaca[][] butacas = sala.getButacas();
        
        for(int i = 0; i<Constantes.BUTACAS_FILAS; i++){
            for(int j = 0; j<Constantes.BUTACAS_COLUMNAS; j++){
                if(butacas[i][j].getOcupado() == false){
                    butacas[i][j].setOcupado(true);
                    return true;
                }
            }
        }
        
        return false;
    }
}
