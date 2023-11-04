
public class TabelaHash {
	private ListaOrdenadaRegistro[] vetor;
	private FuncaoHash funcao;
	private int tamanhoVetor;
	
	public TabelaHash(int tamanhoVetor, FuncaoHash funcao) {
		vetor = new ListaOrdenadaRegistro[tamanhoVetor];
		this.funcao = funcao;
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
		int posicao = funcao.calcularHash(registro);
		return vetor[posicao].inserir(registro);
	}
	
	// Retorna o número de comparações na busca
	public int buscar(Registro registro) {
		int posicao = funcao.calcularHash(registro);
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
