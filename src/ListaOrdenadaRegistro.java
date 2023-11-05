public class ListaOrdenadaRegistro {
	private No primeiroNo;
	private int tamanho;
	public long qtdColisoesInsercao = 0;
	public long qtdComparacoesInsercao = 0;
	
	public int getTamanho() {
		return tamanho;
	}
	
	public ListaOrdenadaRegistro() {
		tamanho = 0;
	}
	
	public void inserir(Registro registro) {
		tamanho++;
		if (listaEstaVazia()) {
			primeiroNo = new No(registro);
//			System.out.println("0 operações");
			return;
		} 
		
		qtdColisoesInsercao++;
		inserir(primeiroNo, primeiroNo.getProximoNo(), registro);
	}
	
	private void inserir(No noAtual, No noAposAtual, Registro registroInserido) {			
		qtdComparacoesInsercao++;
		
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
	
	public int buscar(Registro registro) {
		return buscar(primeiroNo, registro, 1);
	}
	
	private int buscar(No noAtual, Registro registro, int numeroComparacoes) {
		if (noAtual == null) {
			return numeroComparacoes;
		}
		
		if (registro.getCodigo() == noAtual.getRegistro().getCodigo()) {
			return numeroComparacoes;
		} else {
			return buscar(noAtual.getProximoNo(), registro, ++numeroComparacoes);
		}
	}
	
	public boolean listaEstaVazia() {
		return (primeiroNo == null);
	}
}
