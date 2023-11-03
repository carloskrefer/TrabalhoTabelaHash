
public class TabelaHash {
	ListaOrdenadaRegistro[] vetor;
	FuncaoHash funcao;
	int tamanhoVetor;
	
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
		int posicao = funcao.calcularHash(registro.getCodigo());
		vetor[posicao].inserir(registro);
	}
	
	public int informarNumeroComparacoesBusca(Registro registro) {
		int posicao = funcao.calcularHash(registro.getCodigo());
		return vetor[posicao].informarNumeroComparacoesBusca(registro);
	}
	
//	public Registro buscar(Registro registro) {
//		int posicao = funcao.calcularHash(registro.getCodigo());
//		
//	}
}
