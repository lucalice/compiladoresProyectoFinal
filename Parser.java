package dds;

import java.io.IOException;
import java.util.ArrayList;

public class Parser{
    ArrayList<Symbol> tablaSimbolos;
    ArrayList<Type> tablaTipos;
    public static final int COMA = 1000;
    public static final int PYC = 1001;
    public static final int LCOR = 1002;
    public static final int RCOR = 1003;
    public static final int INT = 1004;
    public static final int FLOAT = 1005;
    public static final int NUM = 1006;
    public static final int ID = 1007;
    Yylex lexer;

    public Parser(Yylex lexer)throws IOException{
        this.lexer = lexer;
        actual = lexer.yylex();
        tablaSimbolos = new ArrayList<Symbol>();
        tablaTipos = new ArrayList<Type>();
        tablaTipos.add(new Type(0, "int", 4, -1, -1));
        tablaTipos.add(new Type(1, "float", 4, -1, -1));
    }

    Token actual;
    int dir = 0;

    void parse()throws IOException{
        D();
        printTS();
        printTT();
    }

    void eat(int i) throws IOException{
        if(actual.equals(i)){
            actual =lexer.yylex();
        }else{
            error("Error de sintaxis");
        }
    }

    void D()throws IOException{
        if(actual.equals(INT) || actual.equals(FLOAT) ){
            int tipo = T();
            L(tipo);
            eat(PYC);
            D();
        }
    }

    int T()throws IOException{
        int tipo;
        tipo = B();
        tipo = C(tipo);
        return tipo;
    }

    int B() throws IOException{
        if(actual.equals(INT)){
            eat(INT);
            return 0;
        }
        if(actual.equals(FLOAT)){
            eat(FLOAT);
            return 1;
        }
        error("error de sintaxis");
        return -1;
    }

    int C (int base)throws IOException{
        String valor;
        int tipo;
        int id;
        if(actual.equals(LCOR)){            
            eat(LCOR);
            valor = actual.valor;
            eat(NUM);
            eat(RCOR);
            tipo = C(base);            
            id = tablaTipos.size();
            int tam = Integer.parseInt(valor) * getTam(tipo);
            tablaTipos.add(new Type(id, "array", tam ,Integer.parseInt(valor),tipo));
            return id;
        }else{
            return base;
        }
    }

    void L(int tipo)throws IOException{
        if(actual.equals(ID)){
            if(!buscar(actual.valor)){
                tablaSimbolos.add(new Symbol(actual.valor,dir, tipo, 0, null ));
                dir += getTam(tipo);
            }else{
                error("Variable definida dos veces");
            }
            eat(ID);
            LP(tipo);
        }else{
            error("error de sintaxis");
        }
    }

    void LP(int tipo)throws IOException{
        if(actual.equals(COMA)){
            eat(COMA);
            if(!buscar(actual.valor)){
                tablaSimbolos.add(new Symbol(actual.valor,dir, tipo, 0, null ));
                dir += getTam(tipo);
            }else{
                error("Variable definida dos veces");
            }
            eat(ID);
            LP(tipo);
        }
    }

    void error(String msg){
        System.out.println(msg);
    }

    boolean buscar(String id){
        for(Symbol s: tablaSimbolos){
            if(s.id.equals(id)){
                return true;
            }
        }
        return false;
    }

    int getTam(int id){
        for(Type t : tablaTipos){
            if(id== t.id){
                return t.tam;
            }
        }
        return -1;
    }


    void printTT(){
        System.out.println("Tabla de tipos");
        for(Type t : tablaTipos){
            System.out.println(t.id+"\t"+t.type+"\t"+t.tam+"\t"+t.elem+"\t"+t.tipoBase);
        }    
    }

    void printTS(){
        System.out.println("Tabla de símbolos");
        int i=0;
        for(Symbol s : tablaSimbolos){
            System.out.println(""+i+"\t"+s.id+"\t"+s.dir+"\t"+s.type+"\t"+s.var);
            i++;
        }    
    }
    
    public static term() throws IOException{
        unario();
        ter();
    }
    public static ter() throws IOException{
        if(CurrentToken.equals(MULTI)){
            CurrentToken=lexer.yylex();
            unario();
            ter();
        } else if(CurrentToken.equals(DIVI)){
            CurrentToken=lexer.yylex();
            unario();
            ter();
        }else if(CurrentToken.equals(MOD)){
            CurrentToken=lexer.yylex();
            unario();
            ter();
        }
    }

    public static unario() throws IOException{
        if(CurrentToken.equals(DIFUNI)){
            CurrentToken=lexer.yylex();
            unario();
        } else if(CurrentToken.equals(RESTA)){
            CurrentToken=lexer.yylex();
            unario();
        }else{
            factor();
        }
    }

    public static factor() throws IOException{
        if(CurrentToken.equals(CA)){
            CurrentToken=lexer.yylex();
            bool();
            if(CurrentToken.equals(CC)){
                CurrentToken=lexer.yylex();
            }else if(CurrentToken.equals(NUMERO)){
                CurrentToken=lexer.yylex();
            }else if(CurrentToken.equals(CADENA)){
                CurrentToken=lexer.yylex();
            }else if(CurrentToken.equals(VER)){
                CurrentToken=lexer.yylex();
            }else if(CurrentToken.equals(FAL)){
                CurrentToken=lexer.yylex();
            }else if(CurrentToken.equals(ID)){
                CurrentToken=lexer.yylex();
                if(CurrentToken.equals(CA)){
                    CurrentToken=lexer.yylex();
                    parametros();
                    if(CurrentToken.equals(CC)){
                        CurrentToken=lexer.yylex();
                    }
                }
            } else{
                localizacion();
            }
        }
    }

    public static parametros() throws IOException{
        listparam();
    }

    public static listparam() throws IOException{
        bool();
        lispar();
    }

    public static lispar() throws IOException{
       if(CurrentToken.equals(COMA)){
            CurrentToken=lexer.yylex();
            bool();
            lispar();
        }
    }

    public static localizacion() throws IOException{
        if(CurrentToken.equals(ID)){
            CurrentToken=lexer.yylex();
            local();
        }
    }

    public static local() throws IOException{
        if(CurrentToken.equals(CA)){
            CurrentToken=lexer.yylex();
            bool();
            if(CurrentToken.equals(CC)){
                CurrentToken=lexer.yylex();
                local();
            }
    }

}
