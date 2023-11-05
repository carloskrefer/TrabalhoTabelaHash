
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
			if (soma > (tamanhoArrayTabelaHash - 1)) {
				excesso = soma - (tamanhoArrayTabelaHash - 1);
				while (excesso > (tamanhoArrayTabelaHash - 1)) {
					excesso -= tamanhoArrayTabelaHash;
				}
				soma = excesso;
				break;
			}
			
		}
		
//		System.out.println("Calculo hash soma: " + soma);
		if (soma > maiorSoma) {
			maiorSoma = soma;
			arrayDigitosSeparadosMaiorSoma = arrayDigitosSeparados;
		}
		return soma;
	};                        
	
}
