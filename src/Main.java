
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ListaOrdenadaRegistro lista = new ListaOrdenadaRegistro();
		
		lista.inserir(new Registro(5));
		lista.inserir(new Registro(10));
		lista.inserir(new Registro(1));
		lista.inserir(new Registro(0));
		lista.inserir(new Registro(1));
		lista.inserir(new Registro(4));
		lista.inserir(new Registro(9));
		lista.inserir(new Registro(15));
		
		lista.imprimir();

	}

}
