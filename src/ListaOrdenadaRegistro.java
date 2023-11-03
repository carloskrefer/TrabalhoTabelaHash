public class ListaOrdenadaRegistro {
	No primeiroNo;
	int tamanho;
	
	public ListaOrdenadaRegistro() {
		tamanho = 0;
	}
	
	public void inserir(Registro registro) {
		tamanho++;
		if (listaEstaVazia()) {
			primeiroNo = new No(registro);
			return;
		} 
		inserir(primeiroNo, primeiroNo.getProximoNo(), registro);
	}
	
	private void inserir(No noAtual, No noAposAtual, Registro registroInserido) {			
		if ((noAtual == primeiroNo) && (registroInserido.getCodigo() <= noAtual.getRegistro().getCodigo())) {
			primeiroNo = new No(registroInserido);
			primeiroNo.setProximoNo(noAtual);
			return;
		} 

		if (noAposAtual == null) {
			noAtual.setProximoNo(new No(registroInserido));
		} else {
			if (registroInserido.getCodigo() <= noAposAtual.getRegistro().getCodigo()) {
				noAtual.setProximoNo(new No(registroInserido));
				noAtual.getProximoNo().setProximoNo(noAposAtual);
			} else {
				inserir(noAposAtual, noAposAtual.getProximoNo(), registroInserido);
			}
		}
	}
	
	public void imprimir() {
		if (listaEstaVazia()) {
			System.out.println("A estrutura está vazia.");
		} else {
			imprimir(primeiroNo);
		}
	}
	
	private No imprimir(No no) {
		System.out.print(no.getRegistro().getCodigo() + " -> ");
		if (no.getProximoNo() == null) {
			System.out.println("null");
			return no;
		} else {
			return imprimir(no.getProximoNo());
		}
	}
	
	public int informarNumeroComparacoesBusca(Registro registro) {
		return informarNumeroComparacoesBusca(primeiroNo, registro, 1);
	}
	
	private int informarNumeroComparacoesBusca(No noAtual, Registro registro, int numeroComparacoes) {
		if (noAtual == null) {
			return numeroComparacoes;
		}
		
		if (registro.getCodigo() == noAtual.getRegistro().getCodigo()) {
			return numeroComparacoes;
		} else {
			return informarNumeroComparacoesBusca(noAtual.getProximoNo(), registro, ++numeroComparacoes);
		}
	}
	
	public boolean listaEstaVazia() {
		return (primeiroNo == null);
	}
}
