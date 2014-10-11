/* @fabioluizmagri 
   fabioluizmagri@gmail.com */

public class Extenso {
	static String[] dezenas = new String[] {"", "um", "dois", "três", "quatro", "cinco", 
			"seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", 
			"quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};	
	
	static String[] dezenas2 = new String[] {"", "", "vinte", "trinta", "quarenta", 
		"cinquenta", "sessenta", "setenta", "oitenta", "noventa", "cem"};

	static String[] centenas = new String[] {"", "cento", "duzentos", "trezentos", 
		"quatrocentos","quinhetos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
	
	static String[] milharSingular = new String[] {"", "mil", "milhão", "bilhão", "trilhão"};
	static String[] milharPlural = new String[] {"", "mil", "milhões", "bilhões", "trilhões"};
	
	static String[][] numeral = new String[][] {dezenas, dezenas2, centenas};
	static String[][] milhar = new String[][] {milharSingular, milharPlural};
	
	public static void main(String[] args) {
		int numero = 1101019;
		System.out.println(imprime(numero));
	}
	
	private static String imprime(int numero) {
		String n = "";
		int p = numero;
		int i = 0;

		while (numero > 0) {
			p = numero % 1000;
			numero = numero / 1000;
			if (p != 0) 
				n = extenso(p).concat(" ").concat(milhar[p>1?1:0][i].concat(" ").concat(n));
			i++;
		}
		
		return n;
	}

	private static String extenso(int numero) {
		String extenso = "";
		int casa = 0;
		int resto = 0;
		
		if (numero == 0) 
			extenso = "zero";
		else if (numero ==100)
			extenso = "cem";
		else
			while (numero > 0) {			
				if (casa == 1 && numero % 10 == 1) 
					extenso = numeral[0][10 + resto];
					
				extenso = numeral[casa++][numero % 10].concat(" ").concat(extenso);
				resto  = numero % 10;
				numero = numero / 10;
			}
		
		return extenso;
	}
}