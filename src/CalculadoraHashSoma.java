
public class CalculadoraHashSoma extends CalculadoraHash {

	public CalculadoraHashSoma(String nomeCalculadora) {
		super(nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		int soma = 0;
		int[] arrayDigitosSeparados = separarDigitos(registroChave.getCodigo(), Registro.QTD_DIGITOS);
		
		for (int i = 0; i < Registro.QTD_DIGITOS; i++) {
			// tamanhoArrayTabelaHash - 1 pois se o tamanho é 8 o array da tabela hash só vai de 0 a 7
			if ((soma + arrayDigitosSeparados[i]) > (tamanhoArrayTabelaHash - 1)) {
				break;
			} else {
				soma += arrayDigitosSeparados[i];
			}
		}
		
		System.out.println("Calculo hash soma: " + soma);
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
