import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.lang.*;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String args[]) throws IOException{

	try{
		File f = new File(args[0]);
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		Yylex lexer = new Yylex(bf);
		Parser parser = new Parser(lexer);
		parser.init();
		parser.programa();
		if(parser.currentToken.clase == 0){
			System.out.println("Cadena Aceptada");
		}else if (parser.currentToken.clase == -1){
			System.out.println("Error sintactico");
		}
		bf.close();
		parser.getTS();
		parser.getAyuda();
	}catch(IOException e){
		System.out.println("Error al abrir el archivo");
	}	
  }
}
