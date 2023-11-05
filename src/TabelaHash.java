
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
	public void inserir(Registro registro) {
		int posicao = calculadoraHash.calcularHash(registro);
		vetor[posicao].inserir(registro);
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
	
	public long obterQtdComparacoesInsercao() {
		long qtd = 0;
		for (int i = 0; i < tamanhoVetor; i++) {
			qtd += vetor[i].qtdComparacoesInsercao;
		}
		return qtd;
	}
	
	public long obterQtdColisoesInsercao() {
		long qtd = 0;
		for (int i = 0; i < tamanhoVetor; i++) {
			qtd += vetor[i].qtdColisoesInsercao;
		}
		return qtd;
	}
	
	public int buscarQtdRegistrosPilhaMaisVazia() {
		int qtdRegistrosPilhaMaisVazia = vetor[0].getTamanho();
		for (int i = 0; i < tamanhoVetor; i++) {
			if (vetor[i].getTamanho() < qtdRegistrosPilhaMaisVazia) {
				qtdRegistrosPilhaMaisVazia = vetor[i].getTamanho();
			}
		}
		return qtdRegistrosPilhaMaisVazia;
	}
	
	public int buscarQtdRegistrosPilhaMaisCheia() {
		int qtdRegistrosPilhaMaisCheia = vetor[0].getTamanho();
		for (int i = 0; i < tamanhoVetor; i++) {
			if (vetor[i].getTamanho() > qtdRegistrosPilhaMaisCheia) {
				qtdRegistrosPilhaMaisCheia = vetor[i].getTamanho();
			}
		}
		return qtdRegistrosPilhaMaisCheia;
	}
}
