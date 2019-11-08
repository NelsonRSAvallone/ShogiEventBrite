
package shogieb;

public abstract class Cuadro {
    
    protected String simbolo;
    public String color; //blanca, negra o null, para espacios vacios
    public String tipo;
    
    public Cuadro (String tipoIn)
    {
    tipo = tipoIn;
    }
    
    String getSimbolo ()
    {
    return simbolo;
    }
    
    public String getTipo ()
    {
    return tipo;
    }

    public String getColor() {
        return color;
    }
    
    public abstract boolean checkMovimiento (int [] moverDesde, int[]moverHasta, String jugadorColor, boolean testRey);
}

