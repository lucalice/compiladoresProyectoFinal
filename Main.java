public class Main{
	public static void main(String args[]){
		System.out.println("Hola brous.");
		System.out.println("No se como entre aqui XD.");
		System.out.println("Acaso neva en L.A? Acaso hay gabachos con placazo V.L? Nel, chale");
	try{
		File f = new File(args[0])
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		Yylex lexer = new Yylex(br);
		Parser parser = new Parser(lexer);
		parser.init();
		parser.programa();
		if(parser.currentToken.equals(0)){
			System.out.println("Cadena Aceptada");
		}else{
			System.out.println("Error sintactico");
		}
		br.close();

	}catch(IOException e){
		System.out.println("Error al abrir el archivo");
	}

		
  }
}
