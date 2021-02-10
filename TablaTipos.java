public class TablaTipos{

    int id; 
    String tipo;
    int tamaño;
    int numElementos;
    int tipoBase;

    public TablaTipos(){
        
    }
    public TablaTipos(int id,String tipo, int tamaño, int numElementos,int tipoBase){
        this.id = id;
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.numElementos = numElementos;
        this.tipoBase = tipoBase;
    }

    /*
    TT
    id   nombre    tamaño ele tipoBase
    0     "int"      4     0    ---
    1    "array"     16    4     0

    */
}
