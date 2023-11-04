public class ListaOrdenadaRegistro {
	No primeiroNo;
	int tamanho;
	
	public ListaOrdenadaRegistro() {
		tamanho = 0;
	}
	
	public int inserir(Registro registro) {
		tamanho++;
		if (listaEstaVazia()) {
			primeiroNo = new No(registro);
			return 0;
		} 
		return inserir(primeiroNo, primeiroNo.getProximoNo(), registro, 0);
	}
	
	private int inserir(No noAtual, No noAposAtual, Registro registroInserido, int numeroComparacoes) {			
		if ((noAtual == primeiroNo) && (registroInserido.getCodigo() <= noAtual.getRegistro().getCodigo())) {
			primeiroNo = new No(registroInserido);
			primeiroNo.setProximoNo(noAtual);
			return ++numeroComparacoes;
		}
		
		numeroComparacoes++;

		if (noAposAtual == null) {
			noAtual.setProximoNo(new No(registroInserido));
		} else {
			if (registroInserido.getCodigo() <= noAposAtual.getRegistro().getCodigo()) {
				noAtual.setProximoNo(new No(registroInserido));
				noAtual.getProximoNo().setProximoNo(noAposAtual);
			} else {
				numeroComparacoes = inserir(noAposAtual, noAposAtual.getProximoNo(), registroInserido, numeroComparacoes);
			}
		}
		return numeroComparacoes;
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
