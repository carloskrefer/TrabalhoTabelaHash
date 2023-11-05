public class Registro {
	public static final int LIMITE_SUPERIOR = 999999999;
	public static final int QTD_DIGITOS = 9;
	
	private int codigo;
	
	public Registro(int codigo) {
//		System.out.println("Gerado um registro com o número aleatório: " + codigo);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
}