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
	Token eof = new Token(0, "EOF");
	return eof;
%eofval}
%{

	Parser par;

	public Token nextToken(String lex, int num){
		return new Token(num, lex);
	}

	public Token nextToken(String lex, int num, int tipo){
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
entero=({num})+(_?({num})+)*
flotante = ( {entero} "." {entero}? ({exp})? {entero}? ) | ( {entero}? . {entero}? ({exp})? {entero} )
numero = {flotante} | {entero}
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

{verdadero} {return new Token(1000,"true");}
{falso} {return new Token(1001,"false");}
{else}  {return new Token(1002,"else");}
{while} {return new Token(1003,"while");}
{func} {return new Token(1004,"func");}
{do} {return new Token(1005,"do");}
{if} { return new Token(1006,"if");}
{switch} { return new Token(1007,"switch");}
{case} { return new Token(1008,"case");}
{default} { return new Token(1009,"default");}
{for} { return new Token(1010,"for");}
{return} { return new Token(1011,"return");}
{break} { return new Token(1012,"break");}
{continue} { return new Token(1013,"continue");}

{pa} {return new Token(1020, "(");}
{pc} {return new Token(1021, ")");}
{igual} {return new Token(1022, "=");} 
{suma} {return new Token(1023, "+");}
{resta} {return new Token(1024, "-");}
{multi} {return new Token(1025, "*");}
{divi} {return new Token(1026, "/");}
{mod} {return new Token(1027, "%");}
{incremento} {return new Token(1028,"incremento");}
{or} {return new Token(1029,"or");}
{and} {return new Token(1030,"and");}
{igualque} {return new Token(1031," == ");}
{diferenteque} {return new Token(1032," !=");}
{menor} {return new Token(1033," < ");}
{mayor} {return new Token(1034," > ");}
{menorigual} {return new Token(1035," <= ");}
{mayorigual} {return new Token(1036," >= ");}
{puntocoma} {return new Token(1037," ; ");}
{dospuntos} {return new Token(1038," : ");}
{coma} {return new Token(1039," , ");}
{ca} {return new Token(1040," [ ");}
{cc} {return new Token(1041," ] ");}
{numero} {return new Token(1042,"numero");}
{print} {return new Token(1048,"print");}
{cadena} {return new Token(1043,"cadena");}
{scan} {return new Token(1049,"scan");}
{llavei} {return new Token(1044,"{");}
{llaved} {return new Token(1045,"}");}
{diferenteuni} {return new Token(1046,"diferenteuni");}
{esps} {/*El analizador ignora*/}
{int} {return new Token(1015,"int");}
{float} {return new Token(1016,"float");}
{char} {return new Token(1017,"char");}
{double} {return new Token(1018,"double");}
{void} {return new Token(1019, "void");}
{id} { return new Token(1014,"id");}
{num} {return new Token(1047,"num");}

. { System.out.println("Error al identificar token");}
