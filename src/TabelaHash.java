
public class TabelaHash {
	private ListaOrdenadaRegistro[] vetor;
	private CalculadoraHash calculadoraHash;
	private int tamanhoVetor;
	
	public TabelaHash(int tamanhoVetor, CalculadoraHash calculadoraHash) {
		vetor = new ListaOrdenadaRegistro[tamanhoVetor];
		this.calculadoraHash = calculadoraHash;
		this.tamanhoVetor = tamanhoVetor;
		popularVetorComListasVazias();
	}
	
	private void popularVetorComListasVazias() {
		for (int i = 0; i < tamanhoVetor; i++) {
			vetor[i] = new ListaOrdenadaRegistro();
		}
	}

	// Retorna o número de comparações na inserção
	public int inserir(Registro registro) {
		int posicao = calculadoraHash.calcularHash(registro);
		return vetor[posicao].inserir(registro);
	}
	
	// Retorna o número de comparações na busca
	public int buscar(Registro registro) {
		int posicao = calculadoraHash.calcularHash(registro);
		return vetor[posicao].buscar(registro);
	}
	
	public void imprimir() {
		for (int i = 0; i < tamanhoVetor; i++) {
			vetor[i].imprimir();
		}
	}
	
	public int getTamanhoVetor() {
		return tamanhoVetor;
	}
}
