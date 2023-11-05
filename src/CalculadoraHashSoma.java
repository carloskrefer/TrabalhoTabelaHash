
public class CalculadoraHashSoma extends CalculadoraHash {
	public static int maiorSoma = 0;
	public static int[] arrayDigitosSeparadosMaiorSoma;
	
	public CalculadoraHashSoma(String nomeCalculadora) {
		super(nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		int soma = 0;
		int[] arrayDigitosSeparados = separarDigitos(registroChave.getCodigo(), Registro.QTD_DIGITOS);
		int excesso;
		
		for (int i = 0; i < Registro.QTD_DIGITOS; i++) {
			soma += arrayDigitosSeparados[i];
			if (soma > (tamanhoArrayTabelaHash - 1)) {
				excesso = soma - (tamanhoArrayTabelaHash - 1);
				while (excesso > (tamanhoArrayTabelaHash - 1)) {
					excesso -= tamanhoArrayTabelaHash;
				}
				soma = excesso;
				break;
			}
			
		}
		
//		System.out.println("Calculo hash soma: " + soma);
		if (soma > maiorSoma) {
			maiorSoma = soma;
			arrayDigitosSeparadosMaiorSoma = arrayDigitosSeparados;
		}
		return soma;
	};
                            
	// 4567 % 10 = 7             7 / 1 = 7
	// 4567 % 100 = 67          67 / 10 = 6
	// 4567 % 1000 = 567       567 / 100 = 5
	// 4567 % 10000 = 4567    4567 / 1000 = 4 
	//        ^ divisorModulo        ^ divisor
	public static int[] separarDigitos(int numero, int numeroDigitos) {
		int[] retorno = new int[numeroDigitos];
		for (int divisorDeModulo = 10, divisor = 1, i = (numeroDigitos - 1); i >= 0; divisorDeModulo *= 10, divisor *= 10, i--) {
			retorno[i] = (numero % divisorDeModulo) / divisor;
		}
		return retorno;
	}
	
}
