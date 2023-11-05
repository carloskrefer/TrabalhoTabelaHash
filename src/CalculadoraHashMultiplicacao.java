
public class CalculadoraHashMultiplicacao extends CalculadoraHash {
	public static int qtdRegistrosComPeloMenosUmNumeroZero = 0;
	
	public CalculadoraHashMultiplicacao(String nomeCalculadora) {
		super(nomeCalculadora);
	}
	
	public int calcularHash(Registro registroChave) {
		int produto = 1;
		int[] arrayDigitosSeparados = separarDigitos(registroChave.getCodigo(), Registro.QTD_DIGITOS);
		
		for (int i = 0; i < Registro.QTD_DIGITOS; i++) {
			produto *= arrayDigitosSeparados[i];
		}
		
		produto = aplicarCircularBufferParaQueResultadoEstejaNoLimiteDoTamanhoArrayTabelaHash(produto);
			
		if (produto == 0) {
			qtdRegistrosComPeloMenosUmNumeroZero++;
		}
		
//		System.out.println("Produto: " + produto);
		return produto;
	}

}
