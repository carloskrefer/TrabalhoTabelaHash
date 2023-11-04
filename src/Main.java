
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		long inicioCronometro = System.nanoTime();
		
		var x = 10;
		
		FuncaoHash funcao = (registroChave) -> {
			return (registroChave.getCodigo() % x);
		};
		
		var tabela = new TabelaHash(10, funcao);
		
		System.out.println(tabela.inserir(new Registro(13)));
		System.out.println(tabela.inserir(new Registro(23)));
		System.out.println(tabela.inserir(new Registro(43)));
		System.out.println(tabela.inserir(new Registro(13)));
		System.out.println(tabela.inserir(new Registro(53)));
		
		
		
		long fimCronometro = System.nanoTime();
		
		System.out.println(((fimCronometro - inicioCronometro) / 1000000000.0) + "s");
	}

}
