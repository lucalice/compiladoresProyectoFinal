public class Semantico{

	public static String nuevaTemporal(){
		return "t"+numTemporal++;
	}

	public static boolean equivalentes (int tipo1, int tipo2){
		if(tipo1==tipo2)return true;
		if(tipo1 == 0 && tipo2 == 1) return true;
		if(tipo1 == 1 && tipo2 == 0) return true;
		return false;
	}

	public static int maximo(int tipo1, int tipo2){
		if(tipo1==tipo2)return tipo1;
		if(tipo1 == 0 && tipo2 == 1) return 1;
		if(tipo1 == 1 && tipo2 == 0) return 1;
		return -1;
	}


	public static String ampliar(String d, int menor, int mayor, CodigoIntermedio cod){
		if(menor == mayor) return d;
		String temp;
		if(menor == 0 && mayor == 1){
			temp == nuevaTemporal();
			cod.codigo.add(new Cuadrupla("=","(float) "+d, "", temp);
			return temp;
		}
		return null;
	}

	public static String reducir(String d, int mayor, int menor, CodigoIntermedio cod){
		if(menor == mayor) return d;
		String temp;
		if(menor == 0 && mayor == 1){
			temp == nuevaTemporal();
			cod.codigo.add(new Cuadrupla("=","(int) "+d, "", temp);
			return temp;
		}
		return null;
	}


}