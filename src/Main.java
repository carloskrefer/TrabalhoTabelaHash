
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		var x = 10;
		
		FuncaoHash funcao = (registroChave) -> {
			return (registroChave.getCodigo() % x);
		};
		
		var tabela = new TabelaHash(10, funcao);
		
		tabela.inserir(new Registro(1003));
		tabela.inserir(new Registro(1002));
		tabela.inserir(new Registro(1013));
		
		System.out.println(tabela.informarNumeroComparacoesBusca(new Registro(1013)));
		
		tabela.imprimir();
		

	}

}
