public class Registro {
	public static final int LIMITE_SUPERIOR_CODIGO = 999999999;
	
	private int codigo;
	
	public Registro(int codigo) {
//		System.out.println("Gerado um registro com o número aleatório: " + codigo);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
}