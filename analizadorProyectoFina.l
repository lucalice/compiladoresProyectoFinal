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
%type Integer
%{

	public static void main(String [] arg) throws FileNotFoundException, IOException{ 

	
        //Esto lo debemos poner en un archivo main.
        FileReader f = new FileReader(arg[0]);
        BufferedReader b = new BufferedReader(f);

        Yylex lexer = new Yylex(b);
      try{
          Integer lexema = lexer.yylex();
          System.out.println(lexema);
          while(lexema != null){
          
          lexema = lexer.yylex();
          System.out.println(lexema);
      }
          System.out.println();
      }catch(IOException e){
          System.out.println("Ocurrio un error al intentar acceder a la consola");
      }
 }

%}
letra = [a-zA-Z]
num =[0-9]
exp = (e|E)("+"|-)
sigEsp = ("+"| - | @ | # | \ | "/" | "*" | % | . | , | _ | # | "$" | &)
secEsc = ( \n | \b | \t | \v | \\ | \f | \’ | \” | \0 | \a | \r | \?)
espacio = [ \t\tn\n]
esps={espacio}+
id=({letra}|_)+({num}|{letra}|_)*
entero = ({num})+(_?({num})+)*
flotante = ( {entero} . {entero}? ({exp})? {entero}? ) | ( {entero}? . {entero}? ({exp})? {entero} )
numero = {entero}
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
int= int
float= float 
char= char
double= double
void= void
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

%%
{verdadero} {return 1;}
{falso} {return 2;}
{else}  {return 3;}
{while} {return 4;}
{func} {return 5;}
{do} {return 6;}
{if} { return 7;}
{switch} { return 8;}
{case} { return 9;}
{default} { return 10;}
{for} { return 11;}
{return} { return 12;}
{break} { return 13;}
{continue} { return 14;}
{id} {System.out.println("Hola bro"); return 15;}
{int} {return 16;}
{float} {return 17;}
{char} {return 18;}
{double} {return 19;}
{void} {return 20;}
{pa} {return 21;} 
{pc} {return 22;}
{igual} {return 23;}
{suma} {return 24;}
{resta} {return 25;}
{multi} {return 26;}
{divi} {return 27;}
{mod} {return 28;}
{incremento} {return 29;}
{or} {return 30;}
{and} {return 31;}
{igualque} {return 32;}
{diferenteque} {return 33;}
{menor} {return 34;}
{mayor} {return 35;}
{menorigual} {return 36;}
{mayorigual} {return 37;}
{puntocoma} {return 38;}
{dospuntos} {return 39;}
{coma} {return 40;}
{ca} {return 41;}
{cc} {return 42;}
{numero} {return 43;}
{cadena} {return 44;}

{esps} {/*El analizador ignora*/}
. { System.out.println("Error al identificar token");
	return -1;}


