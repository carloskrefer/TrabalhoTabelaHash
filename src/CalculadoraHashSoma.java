
public class CalculadoraHashSoma extends CalculadoraHash {
	public static int maiorSoma = 0;
	public static int[] arrayDigitosSeparadosMaiorSoma;
	
	public CalculadoraHashSoma(String nomeCalculadora) {
		super(nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		int soma = 0;
		int[] arrayDigitosSeparados = separarDigitos(registroChave.getCodigo(), Registro.QTD_DIGITOS);
		int excesso;
		
		for (int i = 0; i < Registro.QTD_DIGITOS; i++) {
			soma += arrayDigitosSeparados[i];		
		}
		
		soma = aplicarCircularBufferParaQueResultadoEstejaNoLimiteDoTamanhoArrayTabelaHash(soma);
		
		if (soma > maiorSoma) {
			maiorSoma = soma;
			arrayDigitosSeparadosMaiorSoma = arrayDigitosSeparados;
		}
		return soma;
	};                        
	
}
