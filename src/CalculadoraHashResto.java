
public class CalculadoraHashResto extends CalculadoraHash {

	public CalculadoraHashResto(String nomeCalculadora) {
		super(nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		return registroChave.getCodigo() % tamanhoArrayTabelaHash;
	};

}
