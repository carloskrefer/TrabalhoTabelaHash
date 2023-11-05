
public class CalculadoraHashSoma extends CalculadoraHash {

	public CalculadoraHashSoma(int tamanhoArrayTabelaHash, String nomeCalculadora) {
		super(tamanhoArrayTabelaHash, nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		
//		int[] arrayDigitosSeparados = separarDigitos(registroChave.getCodigo());
		
		
		return registroChave.getCodigo() % tamanhoArrayTabelaHash;
	};
                            
	// 4567 % 10 = 7             7 / 1 = 7
	// 4567 % 100 = 67          67 / 10 = 6
	// 4567 % 1000 = 567       567 / 100 = 5
	// 4567 % 10000 = 4567    4567 / 1000 = 4 
	//        ^ divisorModulo        ^ divisor
	// Condição de parada: resultado do último módulo sem alteração.
	public static int[] separarDigitos(int numero, int numeroDigitos) {
		int[] retorno = new int[numeroDigitos];
		for (int divisorDeModulo = 10, divisor = 1, i = (numeroDigitos - 1); i >= 0; divisorDeModulo *= 10, divisor *= 10, i--) {
			retorno[i] = (numero % divisorDeModulo) / divisor;
		}
		return retorno;
	}
	
}
