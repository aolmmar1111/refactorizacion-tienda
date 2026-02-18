package daw;

public class Venta {
    private static Venta instance = null;
    public Venta(){

    }
    public static Venta crearInstancia(){
        if (instance == null) {
            instance = new Venta();
        }
        return instance;
    }

    
}
