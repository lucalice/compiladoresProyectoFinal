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
public class Parser{

	public void Parser(){
		
	}

	public void eat(int value){
		if(CurrentToken.equals(value)){
			CurrentToken=lexer.yylex();
		}else{
			System.out.println("Erroe de sintaxis");
		}
	}
	public static void programa() throws IOException{
		declaraciones();
		funciones();
	}
	public static void declaraciones() throws IOException{
		tipo();
		lista_var();
		if(CurrentToken.equals(PCOMA)){
			CurrentToken=lexer.yylex();
			declaraciones();
		}
	}

	public static void tipo(){
		basico();
		compuesto();
	}

	public static void basico(){
		if(CurrentToken.equals(INT)){
			CurrentToken=lexer.yylex();
		}
		if(CurrentToken.equals(FLOAT)){
			CurrentToken=lexer.yylex();
		}
		if(CurrentToken.equals(CHAR)){
			CurrentToken=lexer.yylex();
		}
		if(CurrentToken.equals(DOUBLE)){
			CurrentToken=lexer.yylex();
		}
		if(CurrentToken.equals(VOID)){
			CurrentToken=lexer.yylex();
		}
	}

	public static void compuesto(){
		if(CurrentToken.equals(CA)){
			CurrentToken=lexer.yylex();
			if(CurrentToken.equals(NUMERO)){
				CurrentToken=lexer.yylex();
				if(CurrentToken.equals(CC)){
					CurrentToken=lexer.yylex();
					compuesto();
				}
			}
		}
	}

	public static void lista_var(){
		if(CurrentToken.equals(ID)){
			CurrentToken=lexer.yylex();
			lista_varPrima();
		}
	}

	public static void lista_varPrima(){
		if(CurrentToken.equals(COMA)){
			CurrentToken=lexer.yylex();
			if(CurrentToken.equals(ID)){
				CurrentToken=lexer.yylex();
				lista_varPrima();
			}
		}
	}

	public static void funciones(){
		if(CurrentToken.equals(FUNC)){
			CurrentToken=lexer.yylex();
			if(CurrentToken.equals(ID)){
				CurrentToken=lexer.yylex();
				if(CurrentToken.equals(CA)){
					CurrentToken=lexer.yylex();
					argumentos();
					if(CurrentToken.equals(CC)){
						CurrentToken=lexer.yylex();
					}
				}
			}
		}
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

}
