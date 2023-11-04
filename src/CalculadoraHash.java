
public abstract class CalculadoraHash {
	
	protected int tamanhoArrayTabelaHash;
	private String nomeCalculadora;

	public String getNomeCalculadora() {
		return nomeCalculadora;
	}

	public void setTamanhoArrayTabelaHash(int tamanhoArrayTabelaHash) {
		this.tamanhoArrayTabelaHash = tamanhoArrayTabelaHash;
	}

	public CalculadoraHash(int tamanhoArrayTabelaHash, String nomeCalculadora) {
		this.tamanhoArrayTabelaHash = tamanhoArrayTabelaHash;
		this.nomeCalculadora = nomeCalculadora;
	}
	
	public abstract int calcularHash(Registro registroChave);
	
}
