
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

	public void inserir(Registro registro) {
		int posicao = funcao.calcularHash(registro);
		vetor[posicao].inserir(registro);
	}
	
	public int informarNumeroComparacoesBusca(Registro registro) {
		int posicao = funcao.calcularHash(registro);
		return vetor[posicao].informarNumeroComparacoesBusca(registro);
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
