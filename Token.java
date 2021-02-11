public class Token{
    int clase;
    String valor;
    int tipo;
    int line;
    
    public Token(){
        
    }
    
    public Token(int clase, String valor,int line){
      this.clase = clase;
      this.valor = valor;
      this.line = line;
    }

    public Token(int clase, String valor, int tipo,int line){
      this.clase = clase;
      this.valor = valor;
      this.tipo = tipo;
      this.line = line;
    }
    
}
