public class Token{
    int clase;
    String valor;
    int tipo;
    
    public Token(){
        
    }
    
    public Token(int clase, String valor){
      this.clase = clase;
      this.valor = valor;
    }

    public Token(int clase, String valor, int tipo){
      this.clase = clase;
      this.valor = valor;
      this.tipo = tipo;
    }
    
}
