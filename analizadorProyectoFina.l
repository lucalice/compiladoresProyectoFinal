//Nombre: Carranza Escobar Luis Enrique 315286513
//Nombre:
//Nombre:
//Nombre:

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;
import java.io.InputStreamReader;
import java.io.IOException;

%%
%line
%char
%column
%unicode
%type Token
%eofval{
	Token eof = new Token(0, "EOF",-1);
	return eof;
%eofval}
%{

	Parser par;

	public Token nextToken(String lex, int num,int line){
		return new Token(num, lex, line);
	}

	public Token nextToken(String lex, int num, int tipo, int line){
		return new Token(num, lex, tipo);
	}

	public void initPar(Parser par){
		this.par = par;
	}

%}
letra = [a-zA-Z]
num =[0-9]
exp = (e|E)("+"|-)
sigEsp = ("+"| - | @ | # | \ | "/" | "*" | % | . | , | _ | # | "$" | &)
secEsc = ( \n | \b | \t | \v | \\ | \f | \’ | \” | \0 | \a | \r | \?)
espacio = [ \t\r\n]
esps={espacio}+
comentarioLineas="*>"
comentLine= -- [ \t | \r | {letra} | {num} | . | [^\n]]*
comentLines= "<*" [^\"*>"] "*>"
entero=({num})+(_?({num})+)*
flotante = ( {entero} "." {entero}? ({exp})? {entero}? )
numero = {entero}
decimal = {flotante}
cadena = ( "\"" ({letra} | {num} | {secEsc} | {sigEsp})* "\"" | "\‘" ({letra} | {num} | {secEsc} | {sigEsp})*  "\‘"  )
verdadero = true
falso = false
if = if
else= else
while= while
func= func
do= do
switch = switch
case = case
default = default
for = for
return = return
break = break
continue = continue
int = int
float = float 
char = char
double = double
void = void
pa= "("
pc= ")"
igual= "="
suma= "+"
resta= "-"
multi= "*"
divi= "/"
mod= "%"
incremento= "++"
or= "||"
and= "&&"
igualque= "=="
diferenteque= "!="
menor= "<"
mayor= ">"
menorigual= "<="
mayorigual= ">="
puntocoma= ";"
dospuntos= ":"
coma= ","
ca= "["
cc= "]"
llavei = "{"
llaved = "}"
diferenteuni = "!"
id=({letra}|_)+({num}|{letra}|_)*
print = "print"
scan = "scan"

%%
{comentLine} {/*Ignorando*/}
{comentLines} {/*Ignorando*/}
{verdadero} {return new Token(1000,"true",yyline);}
{falso} {return new Token(1001,"false",yyline);}
{else}  {return new Token(1002,"else",yyline);}
{while} {return new Token(1003,"while",yyline);}
{func} {return new Token(1004,"func",yyline);}
{do} {return new Token(1005,"do",yyline);}
{if} { return new Token(1006,"if",yyline);}
{switch} { return new Token(1007,"switch",yyline);}
{case} { return new Token(1008,"case",yyline);}
{default} { return new Token(1009,"default",yyline);}
{for} { return new Token(1010,"for",yyline);}
{return} { return new Token(1011,"return",yyline);}
{break} { return new Token(1012,"break",yyline);}
{continue} { return new Token(1013,"continue",yyline);}
{numero} {return new Token(1042,yytext(),0,yyline);}
{decimal} {return new Token(1050,yytext(),1,yyline);}
{pa} {return new Token(1020, "(",yyline);}
{pc} {return new Token(1021, ")",yyline);}
{igual} {return new Token(1022, "=",yyline);} 
{suma} {return new Token(1023, "+",yyline);}
{resta} {return new Token(1024, "-",yyline);}
{multi} {return new Token(1025, "*",yyline);}
{divi} {return new Token(1026, "/",yyline);}
{mod} {return new Token(1027, "%",yyline);}
{incremento} {return new Token(1028,"incremento",yyline);}
{or} {return new Token(1029,"or",yyline);}
{and} {return new Token(1030,"and",yyline);}
{igualque} {return new Token(1031," == ",yyline);}
{diferenteque} {return new Token(1032," !=",yyline);}
{menor} {return new Token(1033," < ",yyline);}
{mayor} {return new Token(1034," > ",yyline);}
{menorigual} {return new Token(1035," <= ",yyline);}
{mayorigual} {return new Token(1036," >= ",yyline);}
{puntocoma} {return new Token(1037," ; ",yyline);}
{dospuntos} {return new Token(1038," : ",yyline);}
{coma} {return new Token(1039," , ",yyline);}
{ca} {return new Token(1040," [ ",yyline);}
{cc} {return new Token(1041," ] ",yyline);}
{print} {return new Token(1048,"print",yyline);}
{cadena} {return new Token(1043,"cadena",yyline);}
{scan} {return new Token(1049,"scan",yyline);}
{llavei} {return new Token(1044,"{",yyline);}
{llaved} {return new Token(1045,"}",yyline);}
{diferenteuni} {return new Token(1046,"diferenteuni",yyline);}
{esps} {/*El analizador ignora*/}
{int} {return new Token(1015,"int",yyline);}
{float} {return new Token(1016,"float",yyline);}
{char} {return new Token(1017,"char",yyline);}
{double} {return new Token(1018,"double",yyline);}
{void} {return new Token(1019, "void",yyline);}
{id} { return new Token(1014,yytext(),yyline);}

. { System.out.println("Error lexico. En la línea "+ yyline);}
