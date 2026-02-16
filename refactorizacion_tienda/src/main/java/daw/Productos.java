package daw;

public class Productos {
    private String nombre;
    private double precios;
    private int stock;
    public Productos (String nombre,double precios, int stock){
        this.nombre = nombre;
        this.precios = precios;
        this.stock = stock;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecios() {
        return precios;
    }
    public void setPrecios(double precios) {
        this.precios = precios;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
