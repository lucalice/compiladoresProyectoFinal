import java.util.Stack;
import java.io.IOException;

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
	public final int AND = 1039;
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

	private  Yylex lexer;
    Token currentToken;
    
    public  void init() throws IOException{
        currentToken = lexer.yylex();
	}
	
	public Parser(Yylex lexer){
		this.lexer = lexer;
    }
	
	public  void error(String mensaje) {
		System.out.println(mensaje);
	}

	public  void error() {
		System.out.println("Error de sintaxis 2");
	}

	public  void eat(int value){
		try {
            if(currentToken.clase == value){
                currentToken=lexer.yylex();
            }else{
                error("Error de sintaxis 1 "+currentToken.valor);
            }
        } catch (IOException e) {
            System.out.println("Tipo no definido.");
        }
    }
    
    /*public  void eat(Token currentToken) throws IOException{
		if(currentToken.clase.equals(currentToken)){
			currentToken=lexer.yylex();
		}else{
			error("Error de sintaxis");
		}
    }*/
    
    /*Inicio gramática*/

	public  void programa() throws IOException{
		declaraciones();
		funciones();
	}
	public  void declaraciones() throws IOException{
        if(currentToken.clase == (INT)){
            tipo();
            lista_var();
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (FLOAT)){
			tipo();
            lista_var();
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (CHAR)){
			tipo();
            lista_var();
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (DOUBLE)){
			tipo();
            lista_var();
		    eat(PCOMA);
		    declaraciones();
		}else if(currentToken.clase == (VOID)){
			tipo();
            lista_var();
		    eat(PCOMA);
		    declaraciones();
		}
	}

	public  void tipo(){
		basico();
		compuesto();
	}

	public  void basico(){
		if(currentToken.clase == (INT)){
            eat(INT);
		}else if(currentToken.clase == (FLOAT)){
			eat(FLOAT);
		}else if(currentToken.clase == (CHAR)){
			eat(CHAR);
		}else if(currentToken.clase == (DOUBLE)){
			eat(DOUBLE);
		}else if(currentToken.clase == (VOID)){
			eat(VOID);
		}else{
			System.out.println("Error de sintaxis. Se esperaba un "+currentToken.clase+" tenemos :" +currentToken.valor);
		}
	}

	public  void compuesto(){
        if(currentToken.clase == CA){
            eat(CA);
            if(currentToken.clase == NUMERO){
                eat(NUMERO);
                if(currentToken.clase == CA){
                    eat(CC);
                    compuesto();
                }
            }
        }
	}

	public  void lista_var(){
        eat(ID);
        lista_varPrima();
	}

	public  void lista_varPrima(){
		if(currentToken.clase == COMA){
            eat(COMA);
            eat(ID);
            lista_varPrima();
        }
	}

	public  void funciones() throws IOException {
        if(currentToken.clase == FUNC){
            eat(FUNC);
            tipo();
            eat(ID);
            eat(PA);
            argumentos();
            eat(PC);
            bloque();
            funciones();
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
        }else if(currentToken.clase == (NUMERO)){
            eat(NUMERO);
        }else if(currentToken.clase == (CADENA)){
            eat(CADENA);
        }else if(currentToken.clase == (VER)){
            eat(VER);
        }else if(currentToken.clase == (FAL)){
            eat(FAL);
        }else if(currentToken.clase == (ID)){
            eat(ID);
            if(currentToken.clase == PA){
                eat(PA);
                parametros();
                if(currentToken.clase == (PC)){
                    eat(PC);
                }
            }else{
                localizacion();
            }
            
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
        if(currentToken.clase == (ID)){
            eat(ID);
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
	    
//8 - 14
	public  void argumentos(){
    //public  void argumentos(Stack args)throws IOException{
		/*if(args != null){
			list_args(args);
        }*/
        if(currentToken.clase == (INT)){
            lista_args();
		}else if(currentToken.clase == (FLOAT)){
			lista_args();
		}else if(currentToken.clase == (CHAR)){
			lista_args();
		}else if(currentToken.clase == (DOUBLE)){
			lista_args();
		}else if(currentToken.clase == (VOID)){
			lista_args();
		}else{
			
		}
	}
	
	public  void lista_args(){
    //public  void list_args(Stack args) throws IOException{
		tipo();
        eat(ID);
        lista_argsP();
	}
	
	public  void lista_argsP() {
		if (currentToken.clase == (COMA)){
			eat(COMA);
			tipo();
		    eat(ID);
			lista_argsP();
		}
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
        System.out.println("Si jalé.");
		instruccionesP();
	}
	
	public  void instruccionesP() throws IOException{		
		if(currentToken.clase == (IF) || currentToken.clase == (WHILE) || currentToken.clase == (SWITCH) || currentToken.clase == (DO) || currentToken.clase == (RETURN) || currentToken.clase == (BREAK)){
            System.out.println("Primero.");
            eat(currentToken.clase);
			sentencia();
			instruccionesP();
		}else if(currentToken.clase == (ID) || currentToken.clase == (CA)){
            System.out.println("Primero 2.");
            eat(currentToken.clase);
			sentencia();
			instruccionesP();
		}else if(currentToken.clase == LLAVEI){
            System.out.println("Primero 3.");
			eat(currentToken.clase);
			sentencia();
			instruccionesP();
        }
	}
	
	public  void sentencia() throws IOException{
        if(currentToken.clase == (ID) || currentToken.clase == (PA)){
            localizacion();
			if (currentToken.clase == IGUAL){
                eat(IGUAL);
                bool();
                System.out.println(currentToken.clase);
                if(currentToken.clase == PCOMA){
                    eat(PCOMA);
                }else{
                    error();
                }
			}else{
				error();
			}
		}
		
		if(currentToken.clase == (INT) || currentToken.clase == (FLOAT) || currentToken.clase == (CHAR) || currentToken.clase == (DOUBLE) || currentToken.clase == (VOID)){
			bloque();
		}
		
		if(currentToken.clase == (IF)){
			eat(currentToken.clase);
			if(currentToken.clase == (PA)){
				eat(currentToken.clase);
				bool();
				if(currentToken.clase == (PC)){
					eat(currentToken.clase);
					sentencia();
					sentenciaPP();
				}else{
					error();
				}
			}else{
				error();
			}
		}
		
		if(currentToken.clase == (DO)){
			eat(currentToken.clase);
			sentencia();
			if(currentToken.clase == (WHILE)){
				eat(currentToken.clase);
				if(currentToken.clase == (PA)){
					eat(currentToken.clase);
					bool();
					if(currentToken.clase == (PC)){
						eat(currentToken.clase);
					}else{
						error();
					}
				}else{
					error();
				}	
			}else{
				error();
			}			
		}
		
		if(currentToken.clase == BREAK){
			eat(currentToken.clase);
			if(currentToken.clase  == PCOMA){
				eat(currentToken.clase);
			}else{
				error();
			}
		}
		
		if(currentToken.clase == SWITCH){
			eat(currentToken.clase);
			if(currentToken.clase == (PA)){
				eat(currentToken.clase);
				bool();
				if(currentToken.clase == (PC)){
					eat(currentToken.clase);
					if(currentToken.clase == (LLAVED)){
						eat(currentToken.clase);
						casos();
						if(currentToken.clase == (LLAVEI)){
							eat(currentToken.clase);
						}else{
							error();
						}
					}else{
						error();
					}
				}
			}else{
				error();
			}	
		}

		if(currentToken.clase == RETURN){
			eat(currentToken.clase);
			sentenciaP();
		}
	}
	
	public  void sentenciaP() throws IOException{
		if(currentToken.clase == (PCOMA)){
			eat(currentToken.clase);
		}else{
			exp();
			if(currentToken.clase == (PCOMA)){
				eat(currentToken.clase);
			}else{
				error();
			}
		}
	}
	public  void sentenciaPP() throws IOException{
		if(currentToken.clase == (ELSE)){
			eat(currentToken.clase);
			sentencia();
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
				eat(currentToken.clase);
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
	    
//-------------------

}
