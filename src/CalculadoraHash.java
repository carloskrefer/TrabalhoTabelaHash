
public abstract class CalculadoraHash {
	
	protected int tamanhoArrayTabelaHash;
	private String nomeCalculadora;

	public String getNomeCalculadora() {
		return nomeCalculadora;
	}

	public void setTamanhoArrayTabelaHash(int tamanhoArrayTabelaHash) {
		this.tamanhoArrayTabelaHash = tamanhoArrayTabelaHash;
	}

	public CalculadoraHash(String nomeCalculadora) {
		this.nomeCalculadora = nomeCalculadora;
	}
	
	public abstract int calcularHash(Registro registroChave);
	
}
