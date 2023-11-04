
public class CalculadoraHashResto extends CalculadoraHash {

	public CalculadoraHashResto(int tamanhoArrayTabelaHash, String nomeCalculadora) {
		super(tamanhoArrayTabelaHash, nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		return registroChave.getCodigo() % tamanhoArrayTabelaHash;
	};

}
