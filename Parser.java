import java.util.Stack;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;

public class Parser{
	
	public final int VER = 1000;
	public final int FAL = 1001;
	public final int ELSE = 1002;
	public final int WHILE = 1003;
	public final int FUNC = 1004;
	public final int DO = 1005;
	public final int IF = 1006;
	public final int SWITCH = 1007;
	public final int CASE = 1008;
	public final int DEFAULT = 1009;
	public final int FOR = 1010;
	public final int RETURN = 1011;
	public final int BREAK = 1012;
	public final int CONTINUE = 1013;
	public final int ID = 1014;
	public final int INT = 1015;
	public final int FLOAT = 1016;
	public final int CHAR = 1017;
	public final int DOUBLE = 1018;
	public final int VOID = 1019;
    public final int PA = 1020;
    public final int PC = 1021;
	public final int IGUAL = 1022;
	public final int SUMA = 1023;
	public final int RESTA = 1024;
	public final int MULTI = 1025;
	public final int DIVI = 1026;
	public final int MOD = 1027;
	public final int INCREMENTO = 1028;
	public final int OR = 1029;
	public final int AND = 1030;
	public final int IGUALQ = 1031;
	public final int DIFEQ = 1032;
	public final int MENOR = 1033;
	public final int MAYOR = 1034;
	public final int MENORIGUAL = 1035;
	public final int MAYORIGUAL = 1036;
	public final int PCOMA = 1037;
	public final int DOSPU = 1038;
	public final int COMA = 1039;
	public final int CA = 1040;
	public final int CC = 1041;
	public final int NUMERO = 1042;
	public final int CADENA = 1043;
	public final int LLAVEI = 1044;
    public final int LLAVED = 1045;
    public final int DIFUNI = 1046;
    public final int PRINT = 1048;
    public final int SCAN = 1049;
    public final int DECIMAL = 1050;

    Stack<TablaSimbolos> pilaTS;
    Stack<TablaTipos> pilaTT;
    Stack<TablaSimbolos> pilaTS2;
    Stack<TablaTipos> pilaTT2;
    Stack<TablaSimbolos> aux;
    Stack<TablaTipos> aux1;
    Stack<Integer> tablaDirecciones;
    Stack<Integer> idTSLista;
    Stack<Integer> idTTLista;
    ArrayList<Integer> argumentosLista;
    ArrayList<Integer> argumentosListaP;
    ArrayList<Integer> listArgumentos;
    ArrayList<Integer> listArgumentosP;
    int dir = 0;
    int idTT = 5;
    int idTS = 0;


	private  Yylex lexer;
    Token currentToken;
    
    public  void init() throws IOException{
        currentToken = lexer.yylex();
	}
	
	public Parser(Yylex lexer){
        this.lexer = lexer;
        //Inicializamos las pilas en el contructor
        pilaTS = new Stack<TablaSimbolos>();
        pilaTT = new Stack<TablaTipos>();
        pilaTT2 = new Stack<TablaTipos>();
        tablaDirecciones = new Stack<Integer>();
        idTSLista = new Stack<Integer>();
        idTTLista = new Stack<Integer>();
        aux1 = new Stack<TablaTipos>();
        pilaTT.push(new TablaTipos(0,"int",4,0,-1));
        pilaTT.push(new TablaTipos(1,"float",4,0,-1));
        pilaTT.push(new TablaTipos(2,"char",1,0,-1));
        pilaTT.push(new TablaTipos(3,"double",8,0,-1));
        pilaTT.push(new TablaTipos(4,"void",0,0,-1));
    }
	
	public void error(String mensaje) {
		System.out.println(mensaje);
	}

	public  void error() {
        System.out.println("Error 2 de sintaxis en la línea: "+currentToken.line);
        currentToken.clase = -1;
        currentToken.valor = "EOF";
	}

	public  void eat(int value){
		try {
            if(currentToken.clase == value){
            //    System.out.println("Me comí "+currentToken.clase+" con valor: "+currentToken.valor);
                currentToken=lexer.yylex();
            }else{
                error("Error de sintaxis en la línea: "+currentToken.line);
                currentToken.clase = -1;
                currentToken.valor = "EOF";
            }
        } catch (IOException e) {
            System.out.println("Tipo no definido.");
        }
    }
    
    /*Inicio gramática*/

	public  void programa() throws IOException{
		declaraciones();
		funciones();
	}
	public  void declaraciones() throws IOException{
        int listaVarTipo;
        if(currentToken.clase == (INT)){
            listaVarTipo = tipo();
            lista_var(listaVarTipo);
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (FLOAT)){
			listaVarTipo = tipo();
            lista_var(listaVarTipo);
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (CHAR)){
			listaVarTipo = tipo();
            lista_var(listaVarTipo);
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (DOUBLE)){
			listaVarTipo = tipo();
            lista_var(listaVarTipo);
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (VOID)){
			listaVarTipo = tipo();
            lista_var(listaVarTipo);
		    eat(PCOMA);
		    declaraciones();
        }else if(currentToken.clase == (ID)){
            if(buscarTS(currentToken.valor)){
                error();
            }
        }
        
	}

	public int tipo() throws IOException {
        int compuestoBase = basico();
        return compuesto(compuestoBase);
	}

	public int basico() throws IOException {
		if(currentToken.clase == (INT)){
            eat(INT);
            return 0;
		}else if(currentToken.clase == (FLOAT)){
            eat(FLOAT);
            return 1;
		}else if(currentToken.clase == (CHAR)){
            eat(CHAR);
            return 2;
		}else if(currentToken.clase == (DOUBLE)){
            eat(DOUBLE);
            return 3;
		}else if(currentToken.clase == (VOID)){
            eat(VOID);
            return 4;
		}else{
			System.out.println("Error de sintaxis. Se esperaba un "+currentToken.clase+" tenemos :" +currentToken.valor);
        }
        return -1;
	}

	public int compuesto(int compuestoBase) throws IOException{
        int compuestoTipo;
        int compuestoBase1;
        int elementos = 0;
        int tamaño = 0;
        if(currentToken.clase == CA){
            eat(CA);
            if(currentToken.clase == NUMERO){
                elementos = Integer.parseInt(currentToken.valor);
                eat(NUMERO);
                if(currentToken.clase == CC){
                    eat(CC);
                    for (TablaTipos dato:pilaTT){
                        if(dato.id == compuestoBase){
                            tamaño = elementos*dato.tamaño;
                        } 
                    }
                    compuestoTipo = pilaTT.push(new TablaTipos(idTT,"array",tamaño,elementos,compuestoBase)).id;
                    compuestoBase1 = compuestoBase;
                    idTT += 1;
                    return compuesto(compuestoTipo);
                }
            }
        }
        /* compuestoTipo = compuestoBase;*/
        return compuestoBase;
	}

	public  void lista_var(int tipo) throws IOException{
        int lista_varPTipo = tipo;
        if(buscarTS(currentToken.valor)){
            pilaTS.push(new TablaSimbolos(idTS,currentToken.valor,tipo,dir,"var",null));
            idTS += 1;
            dir = dir + buscarTT(tipo);
        }else{
            System.out.println("El id ya está declarado.");
            error();
        }
        eat(ID);
        lista_varPrima(lista_varPTipo);
	}

	public  void lista_varPrima(int listaVarTipo) throws IOException{
        int lista_varPTipo1 = listaVarTipo;
        if(currentToken.clase == COMA){
            eat(COMA);
            if(buscarTS(currentToken.valor)){
                pilaTS.push(new TablaSimbolos(idTS,currentToken.valor,listaVarTipo,dir,"var",null));
                idTS += 1;
                dir = dir + buscarTT(listaVarTipo);
            }else{
                System.out.println("El id ya está declarado.");
            }
            eat(ID);
            lista_varPrima(lista_varPTipo1);
        }
	}

	public  void funciones() throws IOException {
        String idTemp;
        int tipoFuncion;
        ArrayList argumentos =  new ArrayList();
        if(currentToken.clase == FUNC){
            eat(FUNC);
            pilaTS2 =  new Stack<TablaSimbolos>();
            pilaTT2 =  new Stack<TablaTipos>();
            pilaTT2.push(new TablaTipos(0,"int",4,0,-1));
            pilaTT2.push(new TablaTipos(1,"float",4,0,-1));
            pilaTT2.push(new TablaTipos(2,"char",1,0,-1));
            pilaTT2.push(new TablaTipos(3,"double",8,0,-1));
            pilaTT2.push(new TablaTipos(4,"void",0,0,-1));
            tablaDirecciones.push(dir);
            idTSLista.push(idTS);
            idTTLista.push(idTT);
            dir = 0;
            idTS = 0;
            idTT = 5;
            tipoFuncion = tipo();
            idTemp = currentToken.valor;
            eat(ID);
            eat(PA);
            argumentos();
            eat(PC);
            bloque();
            if(buscarTS(idTemp)){
                aux = new Stack<TablaSimbolos>();
                for(int i = 1; i <= idTS; i++){
                    aux.push(pilaTS.pop());
                }
                for(int i = 1; i <= idTS; i++){
                    pilaTS2.push(aux.pop());
                }
                for(int i = 6; i <= idTT; i++){
                    aux1.push(pilaTT.pop());
                }
                for(int i = 6; i <= idTT; i++){
                    pilaTT2.push(aux1.pop());
                }

                getAyudaTS2();
                getAyudaTT2();
                idTS = idTSLista.pop().intValue();
                idTT = idTTLista.pop().intValue();
                dir = tablaDirecciones.pop().intValue();
                //int posicion, String id, int tipo, int direccion, String var, int args
                pilaTS.push(new TablaSimbolos(idTS,idTemp,tipoFuncion,-1,"func",listArgumentos));
                idTS += 1;
            }
            funciones();
        }
    }
    
    public void parteIzquierda() throws IOException{
        if(currentToken.clase == ID){
            eat(ID);
            parteIzquierdaP();
        }
    }

    public void parteIzquierdaP() throws IOException{
        if(currentToken.clase == CA){
            localizacion();
        }
    }

  	public  void predeterminado()throws IOException{
        if(currentToken.clase == DEFAULT){
           eat(DEFAULT);
		    eat(DOSPU);
  		    instrucciones();
        }	
  	}
	public  void bool()throws IOException{
  		comb();
  		boolP();
    }
  	public  void boolP()throws IOException{
  		if(currentToken.clase == OR){
            eat(OR);
            comb();
            boolP();
        }
  	}
  	public  void comb()throws IOException{
		igualdad();
		combP();
	}
	public  void combP()throws IOException{
		if(currentToken.clase == AND){
            eat(AND);
	    	igualdad();
	  	    combP();
        }
	}

	public  void igualdad() throws IOException{
		rel();
		igualdadP();
	}

	public  void igualdadP() throws IOException{
		if(currentToken.clase == (IGUALQ)){
	  		eat(IGUALQ);
            rel();
            igualdadP();  
  		}else if (currentToken.clase == (DIFEQ)) {
  			eat(DIFEQ);
            rel();
            igualdadP();  
  		}
	}

	public  void rel() throws IOException{
		exp();
		relP();
	}

	public  void relP() throws IOException{
		if(currentToken.clase == (MENOR)){
	  		eat(MENOR);
	  		exp();
  		}else if (currentToken.clase == (MENORIGUAL)) {
  			eat(MENORIGUAL);
  			exp();
  		}else if (currentToken.clase == (MAYORIGUAL)) {
  			eat(MAYORIGUAL);
  			exp();
  		}else if (currentToken.clase == (MAYOR)) {
  			eat(MAYOR);
  			exp();
  		}
 	 }
  	public  void exp() throws IOException{
  		term();
  		expP();
  	}
  	public  void expP() throws IOException{
  		if(currentToken.clase == (SUMA)){
	  		eat(SUMA);
            term();
            expP();  
  		}else if (currentToken.clase == (RESTA)) {
  			eat(RESTA);
            term();
            expP();
  		}
	}
	public  void term() throws IOException{
        unario();
        ter();
    }
    public  void ter() throws IOException{
        if(currentToken.clase == (MULTI)){
            eat(MULTI);
            unario();
            ter();
        } else if(currentToken.clase == (DIVI)){
            eat(DIVI);
            unario();
            ter();
        }else if(currentToken.clase == (MOD)){
            eat(MOD);
            unario();
            ter();
        }
    }

    public  void unario() throws IOException{
        if(currentToken.clase == (DIFUNI)){
            currentToken=lexer.yylex();
            unario();
        } else if(currentToken.clase == (RESTA)){
            currentToken=lexer.yylex();
            unario();
        }else{
            factor();
        }
    }

    public  void factor() throws IOException{
        if(currentToken.clase == (PA)){
            eat(PA);
            bool();
            eat(PC);
        }if(currentToken.clase == NUMERO){
            eat(NUMERO);
        }else if (currentToken.clase == DECIMAL){
            eat(DECIMAL);
        }else if(currentToken.clase == (CADENA)){
            eat(CADENA);
        }else if(currentToken.clase == (VER)){
            eat(VER);
        }else if(currentToken.clase == (FAL)){
            eat(FAL);
        }else if(currentToken.clase == (ID)){
            eat(ID);
            factorP();
        }else if(currentToken.clase == PRINT){
            exp();
        }else if(currentToken.clase == SCAN){
            parteIzquierda();
        }
    }

    public void factorP() throws IOException{
        if(currentToken.clase == CA){
            localizacion();
        }else if(currentToken.clase == PA){
            parametros();
        }
    }

    public  void parametros() throws IOException{
        listparam();
    }

    public  void listparam() throws IOException{
        bool();
        lispar();
    }

    public  void lispar() throws IOException{
       if(currentToken.clase == (COMA)){
            currentToken=lexer.yylex();
            bool();
            lispar();
        }
    }

    public  void localizacion() throws IOException{
        if(currentToken.clase == CA){
            eat(CA);
            bool();
            eat(CC);
            local();
        }
    }

    public  void local() throws IOException{
        if(currentToken.clase == (CA)){
            eat(CA);
            bool();
            if(currentToken.clase == (CC)){
                eat(CC);
                local();
            }
		}
	}  
	    

	public  void argumentos() throws IOException{
        if(currentToken.clase == (INT)){
            listArgumentos = lista_args();
		}else if(currentToken.clase == (FLOAT)){
			listArgumentos = lista_args();
		}else if(currentToken.clase == (CHAR)){
			listArgumentos = lista_args();
		}else if(currentToken.clase == (DOUBLE)){
			listArgumentos = lista_args();
		}else if(currentToken.clase == (VOID)){
			listArgumentos = lista_args();
		}else{
			listArgumentos = null;
		}
	}
	
	public ArrayList<Integer> lista_args() throws IOException{
		int tipoId = tipo();
        if(buscarTS(currentToken.valor)){
            //int posicion, String id, int tipo, int direccion, String var, ArrayList<Integer> args
            pilaTS.push(new TablaSimbolos(idTS,currentToken.valor,tipoId,dir,"var",null));
            idTS += 1;
            dir += buscarTT(tipoId);
        }else{
            error("El id ya existe.");
        }
        eat(ID);
        argumentosLista = new ArrayList<Integer>();
        argumentosLista.add(tipoId);
        return lista_argsP(argumentosLista);
	}
	
	public  ArrayList<Integer> lista_argsP(ArrayList<Integer> lista_argumentos) throws IOException {
        int tipoId;
        if (currentToken.clase == (COMA)){
			eat(COMA);
			tipoId = tipo();
            if(buscarTS(currentToken.valor)){
                //int posicion, String id, int tipo, int direccion, String var, ArrayList<Integer> args
                pilaTS.push(new TablaSimbolos(idTS,currentToken.valor,tipoId,dir,"var",null));
                idTS += 1;
                dir += buscarTT(tipoId);
            }else{
                error("El id ya existe.");
            }
            eat(ID);
            argumentosListaP = lista_argumentos;
            argumentosListaP.add(tipoId);
			lista_argsP(argumentosListaP);
        }
        return lista_argumentos;
	}
	
	public  void bloque() throws IOException{
		if(currentToken.clase == LLAVEI){
            eat(LLAVEI);
            declaraciones();
            instrucciones();
            eat(LLAVED);
        }
	}
	
	public  void instrucciones() throws IOException{
        sentencia();
		instruccionesP();
	}
	
	public  void instruccionesP() throws IOException{		
        if(currentToken.clase == IF || currentToken.clase == WHILE || currentToken.clase == DO || currentToken.clase == IF || currentToken.clase == BREAK || currentToken.clase == LLAVEI || currentToken.clase == RETURN || currentToken.clase == SWITCH || currentToken.clase == ID || currentToken.clase == PRINT || currentToken.clase == SCAN){
            sentencia();
            instruccionesP();
        }
	}
	
	public  void sentencia() throws IOException{
        if(currentToken.clase == IF){
            eat(IF);
            if(currentToken.clase == PA){
                eat(PA);
                bool();
                if(currentToken.clase == PC){
                    eat(PC);
                    sentencia();
                    sentenciaP();
                }
            }
        }else if(currentToken.clase == WHILE){
            eat(WHILE);
            if(currentToken.clase == PA){
                eat(PA);
                bool();
                if(currentToken.clase == PC){
                    eat(PC);
                    sentencia();
                }
            }
        }else if(currentToken.clase == DO){
            eat(DO);
            sentencia();
            if(currentToken.clase == WHILE){
                eat(WHILE);
                if(currentToken.clase == PA){
                    eat(PA);
                    bool();
                    if(currentToken.clase == PC){
                        eat(PC);
                    } 
                }
            }
        }else if(currentToken.clase == BREAK){
            eat(BREAK);
            eat(PCOMA);
            
        }else if(currentToken.clase == LLAVEI){
            bloque();
        }else if(currentToken.clase == RETURN){
            eat(RETURN);
            sentenciaPP();
            eat(PC);
        }else if(currentToken.clase == SWITCH){
            eat(SWITCH);
            if(currentToken.clase == PA){
                eat(PA);
                bool();
                if(currentToken.clase == PC){
                    eat(PC);
                    if(currentToken.clase == LLAVEI){
                        eat(LLAVEI);
                        casos();
                        eat(LLAVED);
                    } 
                }   
            }
        }else if(currentToken.clase == ID){
            parteIzquierda();
            if(currentToken.clase == IGUAL){
                eat(IGUAL);
                bool();
                eat(PCOMA);
            }
        }else if(currentToken.clase == PRINT){
            eat(PRINT);
            exp();
            eat(PCOMA);
        }else if(currentToken.clase == SCAN){
            eat(SCAN);
            parteIzquierda();
            eat(PCOMA);
        }


    }
	
	public  void sentenciaP() throws IOException{
		if(currentToken.clase == ELSE){
            eat(ELSE);
            sentencia();
		}
    }

	public  void sentenciaPP() throws IOException{
		if(currentToken.clase == (DIFUNI) || currentToken.clase == (RESTA) || currentToken.clase == (PA) || currentToken.clase == (NUMERO) || currentToken.clase == DECIMAL || currentToken.clase == (VER) || currentToken.clase == (FAL) || currentToken.clase == (ID) || currentToken.clase == (PRINT) || currentToken.clase == (SCAN)){
            exp();
            eat(PCOMA);
		}else{
            eat(PCOMA);
        }
	}
	public  void casos() throws IOException{
		if(currentToken.clase == (CASE)){
			caso();
			casos();
		}else if(currentToken.clase == (DEFAULT)){
			predeterminado();
		}
	}
	public  void caso() throws IOException{
		if(currentToken.clase == (CASE)){
			eat(currentToken.clase);
			if(currentToken.clase == (NUMERO)){
				eat(NUMERO);
				if(currentToken.clase == (DOSPU)){
					eat(currentToken.clase);
					instrucciones();
				}else{
					error();
				}
            }else if (currentToken.clase == DECIMAL){
                eat(DECIMAL);
				if(currentToken.clase == (DOSPU)){
					eat(currentToken.clase);
					instrucciones();
				}else{
					error();
				}
            }else{
				error();
			}
		}
    }
    
    public void getAyuda(){
        System.out.println("\nTabla de tipos global \n");
        System.out.println("id\tnom\ttam\tnumEle\ttipoBase");
        for (TablaTipos dato:pilaTT){
            System.out.println(dato.id+"\t"+dato.tipo+"\t"+dato.tamaño+"\t"+dato.numElementos+"\t"+dato.tipoBase);
        }
    }

    public void getAyudaTT2(){
        if(pilaTT2.size() > 5){
            System.out.println("\nTabla de tipos 2 \n");
            System.out.println("id\tnom\ttam\tnumEle\ttipoBase");
            for (TablaTipos dato:pilaTT2){
                System.out.println(dato.id+"\t"+dato.tipo+"\t"+dato.tamaño+"\t"+dato.numElementos+"\t"+dato.tipoBase);
            }
        }
    }

    public void getAyudaTS2(){
        System.out.println("\nTabla de Simbolos 2 \n");
        System.out.println("Pos\tid\ttipo\tdir\tvar\tparams");
        for (TablaSimbolos dato:pilaTS2){
            System.out.println(dato.posicion+"\t"+dato.id+"\t"+dato.tipo+"\t"+dato.direccion+"\t"+dato.var+"\t"+dato.args);
        }
    }

    public void getTS(){
        System.out.println("\nTabla de Simbolos global \n");
        System.out.println("Pos\tid\ttipo\tdir\tvar\tparams");
        for (TablaSimbolos dato:pilaTS){
            System.out.println(dato.posicion+"\t"+dato.id+"\t"+dato.tipo+"\t"+dato.direccion+"\t"+dato.var+"\t"+dato.args);
        }
    }

    public boolean buscarTS(String id){
        for (TablaSimbolos dato:pilaTS){
            if(dato.id.equals(id)){
                return false;
            }
        }
        return true;
    }

    public int buscarTT(int tipo){
        for (TablaTipos dato:pilaTT){
            if(dato.id == tipo){
                return dato.tamaño;
            }
        }
        return 1;
    }
	    
//-------------------

}
 
