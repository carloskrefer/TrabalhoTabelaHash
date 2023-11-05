
public abstract class CalculadoraHash {
	
	protected int tamanhoArrayTabelaHash;
	private String nomeCalculadora;

	public String getNomeCalculadora() {
		return nomeCalculadora;
	}

	public void setTamanhoArrayTabelaHash(int tamanhoArrayTabelaHash) {
		this.tamanhoArrayTabelaHash = tamanhoArrayTabelaHash;
	}

	public CalculadoraHash(String nomeCalculadora) {
		this.nomeCalculadora = nomeCalculadora;
	}
	
	public abstract int calcularHash(Registro registroChave);
	
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
	
	public static void imprimirNumeroDumArrayDeDigitosSemQuebrarLinha(int[] arrayDigitos, int qtdDigitos) {
		for (int i = 0; i < qtdDigitos; i++) {
			System.out.print(arrayDigitos[i]);
		}
	}
}
