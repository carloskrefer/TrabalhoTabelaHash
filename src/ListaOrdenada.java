public class ListaOrdenada {
	No primeiroNo;
	
	public ListaOrdenada() {
	
	}
	
	public void inserir(int valor) {
		if (primeiroNo == null) {
			primeiroNo = new No(valor);
			return;
		} 
		
		inserir(primeiroNo, primeiroNo.getProximoNo(), valor);
	}
	
	private void inserir(No noAtual, No noAposAtual, int valorInserir) {		
		if ((noAtual == primeiroNo) && (valorInserir <= noAtual.getValor())) {
			primeiroNo = new No(valorInserir);
			primeiroNo.setProximoNo(noAtual);
			return;
		} 

		if (noAposAtual == null) {
			noAtual.setProximoNo(new No(valorInserir));
		} else {
			if (valorInserir <= noAposAtual.getValor()) {
				noAtual.setProximoNo(new No(valorInserir));
				noAtual.getProximoNo().setProximoNo(noAposAtual);
			} else {
				inserir(noAposAtual, noAposAtual.getProximoNo(), valorInserir);
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
		System.out.print(no.getValor() + " -> ");
		if (no.getProximoNo() == null) {
			System.out.println("null");
			return no;
		} else {
			return imprimir(no.getProximoNo());
		}
	}
	
	public boolean listaEstaVazia() {
		return (primeiroNo == null);
	}
	
	
	

}
