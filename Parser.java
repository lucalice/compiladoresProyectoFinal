public static final int VER = 1000;
public static final int FAL = 1001;
public static final int ELSE = 1002;
public static final int WHILE = 1003;
public static final int FUNC = 1004;
public static final int DO = 1005;
public static final int IF = 1006;
public static final int SWITCH = 1007;
public static final int CASE = 1008;
public static final int DEFAULT = 1009;
public static final int FOR = 1010;
public static final int RETURN = 1011;
public static final int BREAK = 1012;
public static final int CONTINUE = 1013;
public static final int ID = 1014;
public static final int INT = 1015;
public static final int FLOAT = 1016;
public static final int CHAR = 1017;
public static final int DOUBLE = 1018;
public static final int VOID = 1019;
public static final int FUNC = 1020;
public static final int PA = 1021;
public static final int PI = 1022;
public static final int IGUAL = 1023;
public static final int SUMA = 1024;
public static final int RESTA = 1025;
public static final int MULTI = 1026;
public static final int DIVI = 1027;
public static final int MOD = 1028;
public static final int INCREMENTO = 1029;
public static final int OR = 1030;
public static final int AND = 1031;
public static final int IGUALQ = 1032;
public static final int DIFEQ = 1033;
public static final int MENOR = 1034;
public static final int MAYOR = 1035;
public static final int MENORIGUAL = 1036;
public static final int MAYORIGUAL = 1037;
public static final int PCOMA = 1038;
public static final int DOSPU = 1039;
public static final int COMA = 1040;
public static final int CA = 1041;
public static final int CC = 1042;
public static final int NUMERO = 1043;
public static final int CADENA = 1044;
public static final int LLAVED = 1045;
public static final int LLAVEI = 1046;
public class Parser{
	
	private Yylex lexer;
	Token currentToken;
	
	public Parser(Yylex lexer) throws IOException{
		this.lexer = lexer;
	}
	public void init(){
		this.currentToken = lexer.yylex()	
	}
	public Parser(Yylex lexer) throws IOException{
		this.lexer = lexer;
	}
	
	public void error(mensaje) throws IOException{
		System.out,println(mensaje);
	}

	public void eat(int value) throws IOException{
		if(currentToken.equals(value)){
			currentToken=lexer.yylex();
		}else{
			error("Error de sintaxis");
		}
	}
	public static void programa() throws IOException{
		declaraciones();
		funciones();
	}
	public static void declaraciones() throws IOException{
		tipo();
		lista_var();
		eat(PCOMA);
		declaraciones();
	}

	public static void tipo(){
		basico();
		compuesto();
	}

	public static void basico(){
		if(currentToken.equals(INT)){
			eat(INT);
		}else if(currentToken.equals(FLOAT)){
			eat(FLOAT);
		}else if(currentToken.equals(CHAR)){
			eat(CHAR);
		}else if(currentToken.equals(DOUBLE)){
			eat(DOUBLE);
		}else if(currentToken.equals(VOID)){
			eat(VOID);
		}else{
			System.out.println("Error de sintaxis");
		}
	}

	public static void compuesto(){
		eat(CA);
		eat(NUMERO);
		eat(CC);
		compuesto();
	}

	public static void lista_var(){
		eat(ID);
		lista_varPrima();
	}

	public static void lista_varPrima(){
		eat(COMA);
		eat(ID);
		lista_varPrima();
	}

	public static void funciones(){
		eat(FUNC);
		eat(ID);
		eat(CA);
		argumentos();
		eat(CC);
	}



  	public static void predeterminado()throws IOException{
  		
		eat(DEFAULT);
		eat(DOSPU);
  		instrucciones();
			
  	}

	public static void bool()throws IOException{
  		comp();
  		boolP();
    }
  	public static void boolP()throws IOException{
  		eat(OR)
	  	comb();
	  	boolP();
  		
  	}
  	public static void comb()throws IOException{
		igualdad();
		combP();
	}
	public static void combP()throws IOException{
			eat(AND);
	  		igualdad();
	  		combP();
  		
	}

	public static void igualdad() throws IOException{
		rel();
		igualdadPP();
	}

	public static void igualdadPP() throws IOException{
		igualdadP();
		igualdadPP();
	}

	public static void igualdadP() throws IOException{
		if(currentToken.equals(IGUALQ)){
	  		eat(IGUALQ);
	  		rel();
  		}else if (currentToken.equals(DIFEQ)) {
  			eat(DIFEQ);
  			rel();
  		}
	}

	public static void rel() throws IOException{
		exp();
		relP();
	}

	public static void relP() throws IOException{
		if(currentToken.equals(MENOR)){
	  		eat(MENOR);
	  		exp();
  		}else if (currentToken.equals(MENORIGUAL)) {
  			eat(MENORIGUAL);
  			exp();
  		}else if (currentToken.equals(MAYORIGUAL)) {
  			eat(MAYORIGUAL);
  			exp();
  		}else if (currentToken.equals(MAYOR)) {
  			eat(MAYOR);
  			exp();
  		}
 	 }
  	public static void exp() throws IOException{
  		term();
  		expPP();
  	}
  	public static void expPP() throws IOException{
  		expP();
  		expPP();
  	}
  	public static void expP() throws IOException{
  		if(currentToken.equals(SUMA)){
	  		eat(SUMA);
	  		term();
  		}else if (currentToken.equals(RESTA)) {
  			eat(RESTA)
  			term();
  		}
	}
	public static term() throws IOException{
        unario();
        ter();
    }
    public static ter() throws IOException{
        if(currentToken.equals(MULTI)){
            currentToken=lexer.yylex();
            unario();
            ter();
        } else if(currentToken.equals(DIVI)){
            currentToken=lexer.yylex();
            unario();
            ter();
        }else if(currentToken.equals(MOD)){
            currentToken=lexer.yylex();
            unario();
            ter();
        }
    }

    public static unario() throws IOException{
        if(currentToken.equals(DIFUNI)){
            currentToken=lexer.yylex();
            unario();
        } else if(CurrentToken.equals(RESTA)){
            currentToken=lexer.yylex();
            unario();
        }else{
            factor();
        }
    }

    public static factor() throws IOException{
        if(currentToken.equals(CA)){
            CurrentToken=lexer.yylex();
            bool();
            if(currentToken.equals(CC)){
                currentToken=lexer.yylex();
            }else if(currentToken.equals(NUMERO)){
                currentToken=lexer.yylex();
            }else if(currentToken.equals(CADENA)){
                currentToken=lexer.yylex();
            }else if(currentToken.equals(VER)){
                currentToken=lexer.yylex();
            }else if(currentToken.equals(FAL)){
                currentToken=lexer.yylex();
            }else if(currentToken.equals(ID)){
                currentToken=lexer.yylex();
                if(currentToken.equals(CA)){
                    currentToken=lexer.yylex();
                    parametros();
                    if(currentToken.equals(CC)){
                        currentToken=lexer.yylex();
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
       if(currentToken.equals(COMA)){
            currentToken=lexer.yylex();
            bool();
            lispar();
        }
    }

    public static localizacion() throws IOException{
        if(currentToken.equals(ID)){
            currentToken=lexer.yylex();
            local();
        }
    }

    public static local() throws IOException{
        if(currentToken.equals(CA)){
            currentToken=lexer.yylex();
            bool();
            if(currentToken.equals(CC)){
                currentToken=lexer.yylex();
                local();
            }
    }  
	    
//8 - 14
	public void argumentos(Stack args)throws IOException{
		if(args != nule){
			list_args(args);
		}
	}
	
	public void list_args(Stack args) throws IOException{
		tipo();
		if(currentToken.equals(ID)){
			eat(currentToken);
			lista_argsP();
		}else{
			error();
		}
	}
	
	public void lista_argsP() throws IOException{
		if (currentToken.equals(COMA)){
			eat(CurrentToken);
			tipo();
			if(currentToken.equals(ID)){
				eat(CurrentToken);
				lista_argsP();
			}else{
				error();
			}
		}
	}
	
	public void bloque() throws IOException{
		declaraciones();
		instrucciones();
	}
	
	public void instrucciones() throws IOException{
		sentencia();
		if (currentToken == 1002){
			instruccionesP();
		}else{
			error();
		}
	}
	
	public void instruccionesP() throws IOException{		
		if(currentToken.equals(WHILE) || currentToken.equals(SWITCH) || currentToken.equals(IF) || currentToken.equals(CASE) || currentToken.equals(DO)){
			eat(currentToken)
			sentencia();
			instruccionesP();
		}
		if(currentToken.equals(ID) || currentToken.equals(PA)){
			eat(currentToken);
			sentencia();
			instruccionesP();
		}
		if(currentToken.equals(INT) || currentToken.equals(FLOAT) || currentToken.equals(CHAR) || currentToken.equals(DOUBLE) || currentToken.equals(VOID)){
			eat(currentToken);
			sentencia();
			instruccionesP();
		}
	}
	
	public void sentencia() throws IOException{
		if(currentToken.equals(ID) || currentToken.equals(PA)){
			localizacion();
			if (currentToken.equals(IGUAL)){
				eat(currentToken);
				if (currentToken.equals(LLAVED)){
					eat(currentToken);
					bool();
					if (currentToken.equals(LLAVEI)){
						eat(currentToken);
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
		if(currentToken.equals(INT) || currentToken.equals(FLOAT) || currentToken.equals(CHAR) || currentToken.equals(DOUBLE) || currentToken.equals(VOID)){
			bloque();
		}
		if(currentToken.equals(IF)){
			eat(currentToken);
			if(currentToken.equals(PA)){
				eat(currentToken);
				bool();
				if(currentToken.equals(PI)){
					eat(currentToken);
					sentencia();
					sentenciaP();
				}else{
					error();
				}
			}else{
				error();
			}
		}
		if(currentToken.equals(DO)){
			eat(currentToken);
			sentencia();
			if(correntToken.equals(WHILE)){
				eat(currentToken);
				if(correntToken.equals(PA)){
					eat(currentToken);
					bool();
					if(currentToken.equals(PI)){
						eat(currentToken);
						
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
		if(currentToken(BREAK)){
			eat(currentToken);
			if(currentToken.equals(PCOMA)){
				eat(currentToken);
			}else{
				error();
			}
		}
		if(currentToken.equals(SWITCH)){
			eat(currentToken);
			if(currentToken.equals(PA)){
				eat(currentToken);
				bool();
				if(currentToken.equals(PI)){
					eat(currentToken);
					if(currentToken.equals(LLAVED)){
						eat(currentToken);
						casos();
						if(currentToken.equals(LLAVEI)){
							eat(currentToken);
						}else{
							error();
						}
					}else(
						error();
					)
				}
			}else{
				error
			}
			
		}
		
	}
	public void sentenciaP() throws IOException{
		if(currentToken.equals(ELSE)){
			eat(currentToken);
			sentencia();
		}
	}
	public void casos() throws IOException{
		if(currentToken.equals(CASE)){
			caso();
			casos();
		}
		if(currentToken.equals(DEFAULT)){
			predeterminado();
		}
	}
	public void caso() throws IOException{
		if(currentToken.equals(CASE)){
			eat(currentToken);
			if(currentToken.equals(NUMERO)){
				eat(currentToken);
				if(currentToken.equals(DOSPU)){
					eat(currentToken);
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
