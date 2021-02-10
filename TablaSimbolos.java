public class TablaSimbolos{
    
    int posicion;
    String id;
    int tipo;
    int direccion;
    String var;
    int args;

    public TablaSimbolos(){

    }

    public TablaSimbolos(int posicion, String id, int tipo, int direccion, String var, int args){
        this.posicion = posicion;
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.var = var;
        this.args = args;
    }
}
