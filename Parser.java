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

	
	public Parser() throws IOException{
		
	}
	
	public Parser(Yylex lexer) throws IOException{
		this.lexer = lexer;
	}
	
	public void error(mensaje) throws IOException{
		System.out,println(mensaje);
	}

	public void eat(int value) throws IOException{
		if(CurrentToken.equals(value)){
			CurrentToken=lexer.yylex();
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
		eat(INT);
		eat(FLOAT);
		eat(CHAR);
		eat(DOUBLE);
		eat(VOID);
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
  		if(CurrentToken.equals(DEFAULT)){
  			CurrentToken=lexer.yylex();
  			if(CurrentToken.equals(DOSPU)){
  				CurrentToken=lexer.yylex();
  				instrucciones();
			}
		}
  	}

	public static void bool()throws IOException{
  		comp();
  		boolP();
    }
  	public static void boolP()throws IOException{
  		if(CurrentToken.equals(OR)){
	  		CurrentToken=lexer.yylex();
	  		comb();
	  		boolP();
  		}
  	}
    public static void comb()throws IOException{
		igualdad();
		combP();
	}
	public static void combP()throws IOException{
		if(CurrentToken.equals(AND)){
	  		CurrentToken=lexer.yylex();
	  		igualdad();
	  		combP();
  		}
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
		if(CurrentToken.equals(IGUALQ)){
	  		CurrentToken=lexer.yylex();
	  		rel();
  		}else if (CurrentToken.equals(DIFEQ)) {
  			CurrentToken=lexer.yylex();
  			rel();
  		}
	}

	public static void rel() throws IOException{
		exp();
		relP();
	}

	public static void relP() throws IOException{
		if(CurrentToken.equals(MENOR)){
	  		CurrentToken=lexer.yylex();
	  		exp();
  		}else if (CurrentToken.equals(MENORIGUAL)) {
  			CurrentToken=lexer.yylex();
  			exp();
  		}else if (CurrentToken.equals(MAYORIGUAL)) {
  			CurrentToken=lexer.yylex();
  			exp();
  		}else if (CurrentToken.equals(MAYOR)) {
  			CurrentToken=lexer.yylex();
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
  		if(CurrentToken.equals(SUMA)){
	  		CurrentToken=lexer.yylex();
	  		term();
  		}else if (CurrentToken.equals(RESTA)) {
  			CurrentToken=lexer.yylex();
  			term();
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
	    
//8 - 14
	public void argumentos(Stack args)throws IOException{
		if(args != nule){
			list_args(args);
		}
	}
	
	public void list_args(Stack args) throws IOException{
		tipo();
		if(CurrentToken.equals(ID)){
			eat(CurrentToken);
			lista_argsP();
		}else{
			error();
		}
	}
	
	public void lista_argsP() throws IOException{
		if (CurrentToken.equals(COMA)){
			eat(CurrentToken);
			tipo();
			if(CurrentToken.equals(ID)){
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
		if (CurrentToken == 1002){
			instruccionesP();
		}else{
			error();
		}
	}
	
	public void instruccionesP() throws IOException{		
		if(CurrentToken.equals(WHILE) || CurrentToken.equals(SWITCH) || CurrentToken.equals(IF) || CurrentToken.equals(CASE) || CurrentToken.equals(DO)){
			eat(CurrentToken)
			sentencia();
			instruccionesP();
		}
		if(CurrentToken.equals(ID) || CurrentToken.equals(PA)){
			eat(CurrentToken);
			sentencia();
			instruccionesP();
		}
		if(CurrentToken.equals(INT) || CurrentToken.equals(FLOAT) || CurrentToken.equals(CHAR) || CurrentToken.equals(DOUBLE) || CurrentToken.equals(VOID)){
			eat(CurrentToken);
			sentencia();
			instruccionesP();
		}
	}
	
	public void sentencia() throws IOException{
		if(CurrentToken.equals(ID) || CurrentToken.equals(PA)){
			localizacion();
			if (CurrentToken.equals(IGUAL)){
				eat(CurrentToken);
				if (CurrentToken.equals(LLAVED)){
					eat(CurrentToken);
					bool();
					if (CurrentToken.equals(LLAVEI)){
						eat(CurrentToken);
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
		if(CurrentToken.equals(INT) || CurrentToken.equals(FLOAT) || CurrentToken.equals(CHAR) || CurrentToken.equals(DOUBLE) || CurrentToken.equals(VOID)){
			bloque();
		}
		if(CurrentToken.equals(IF)){
			eat(CurrentToken);
			if(CurrentToken.equals(PA)){
				eat(CurrentToken);
				bool();
				if(CurrentToken.equals(PI)){
					eat(CurrentToken);
					sentencia();
					sentenciaP();
				}else{
					error();
				}
			}else{
				error();
			}
		}
		if(CurrentToken.equals(DO)){
			eat(CurrentToken);
			sentencia();
			if(CorrentToken.equals(WHILE)){
				eat(CurrentToken);
				if(CorrentToken.equals(PA)){
					eat(CurrentToken);
					bool();
					if(CorrentToken.equals(PI)){
						eat(CurrentToken);
						
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
		if(CurrentToken(BREAK)){
			eat(CurrentToken);
			if(CurrentToken.equals(PCOMA)){
				eat(CurrentToken);
			}else{
				error();
			}
		}
		if(CurrentToken.equals(SWITCH)){
			eat(CurrentToken);
			if(CurrentToken.equals(PA)){
				eat(CurrentToken);
				bool();
				if(CurrentToken.equals(PI)){
					eat(CurrentToken);
					if(CurrentToken.equals(LLAVED)){
						eat(CurrentToken);
						casos();
						if(CurrentToken.equals(LLAVEI)){
							eat(CurrentToken);
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
		if(CurrentToken.equals(ELSE)){
			eat(CurrentToken);
			sentencia();
		}
	}
	public void casos() throws IOException{
		if(CurrentToken.equals(CASE)){
			caso();
			casos();
		}
		if(CurrentToken.equals(DEFAULT)){
			predeterminado();
		}
	}
	public void caso() throws IOException{
		if(CurrentToken.equals(CASE)){
			eat(CurrentToken);
			if(CurrentToken.equals(NUMERO)){
				eat(CurrentToken);
				if(CurrentToken.equals(DOSPU)){
					eat(CurrentToken);
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
