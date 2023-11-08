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
		
		No noAtual = primeiroNo;
		No noAposAtual = primeiroNo.getProximoNo();
		
		if ((noAtual == primeiroNo) && (registro.getCodigo() <= noAtual.getRegistro().getCodigo())) {
			primeiroNo = new No(registro);
			primeiroNo.setProximoNo(noAtual);
			return;
		}	
		
		for (int i = 0; i < tamanho; i++) {
			qtdComparacoesInsercao++;
			
			if (noAposAtual == null) {
				noAtual.setProximoNo(new No(registro));
				return;
				
			} else {
				if (registro.getCodigo() <= noAposAtual.getRegistro().getCodigo()) {
					noAtual.setProximoNo(new No(registro));
					noAtual.getProximoNo().setProximoNo(noAposAtual);
					return;
				} else {
					noAtual = noAposAtual;
					noAposAtual = noAposAtual.getProximoNo();
				}
			}
		}
	}
	
//	private void inserir(No noAtual, No noAposAtual, Registro registroInserido) {			
//		qtdComparacoesInsercao++;
//		
//		if ((noAtual == primeiroNo) && (registroInserido.getCodigo() <= noAtual.getRegistro().getCodigo())) {
//			primeiroNo = new No(registroInserido);
//			primeiroNo.setProximoNo(noAtual);
//			return;
//		}	
//		
//		if (noAposAtual == null) {
//			noAtual.setProximoNo(new No(registroInserido));
//		} else {
//			if (registroInserido.getCodigo() <= noAposAtual.getRegistro().getCodigo()) {
//				noAtual.setProximoNo(new No(registroInserido));
//				noAtual.getProximoNo().setProximoNo(noAposAtual);
//			} else {
//				inserir(noAposAtual, noAposAtual.getProximoNo(), registroInserido);
//			}
//		}
//	}
	
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
		No noAtual = primeiroNo;
		int numeroComparacoes = 1;
		
		for (int i = 0; i < tamanho; i++) {
			if (noAtual == null) {
				return numeroComparacoes;
			}
			
			if (registro.getCodigo() == noAtual.getRegistro().getCodigo()) {
				return numeroComparacoes;
			} else {
				noAtual = noAtual.getProximoNo();
				numeroComparacoes++;
			}
		}
		
		return numeroComparacoes;
	}
	
//	private int buscar(No noAtual, Registro registro, int numeroComparacoes) {
//		if (noAtual == null) {
//			return numeroComparacoes;
//		}
//		
//		if (registro.getCodigo() == noAtual.getRegistro().getCodigo()) {
//			return numeroComparacoes;
//		} else {
//			return buscar(noAtual.getProximoNo(), registro, ++numeroComparacoes);
//		}
//	}
	
	public boolean listaEstaVazia() {
		return (primeiroNo == null);
	}
}
