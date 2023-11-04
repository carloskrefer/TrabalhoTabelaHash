import java.util.Random;

public class Main {	
//	private static final int[] TAMANHOS_VETOR_TABELA_HASH = {10, 100, 1_000, 10_000, 100_000};
	private static final int[] TAMANHOS_VETOR_TABELA_HASH = {10};
//	private static final int[] TAMANHOS_CONJUNTO_DADOS = {20_000, 100_000, 500_000, 1_000_000, 5_000_000};
	private static final int[] TAMANHOS_CONJUNTO_DADOS = {20};
	
	public static void main(String[] args) {	

		realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(new CalculadoraHashResto(0, "Função Hash de Resto"));
		
	}
	
	private static void realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(CalculadoraHash calculadoraHash) {
		TabelaHash tabelaHash;
		int qtdOperacoesInsercao;
		long inicioCronometro;
		long fimCronometro;
		
		System.out.println("Início dos testes com " + calculadoraHash.getNomeCalculadora() + ".");
		
		for (int i = 0; i < obterTamanhoVetor(TAMANHOS_VETOR_TABELA_HASH); i++) {
			
			System.out.println("Tamanho do vetor da tabela: " + TAMANHOS_CONJUNTO_DADOS[i]);
			
			calculadoraHash.setTamanhoArrayTabelaHash(TAMANHOS_VETOR_TABELA_HASH[i]);
			
			for (int j = 0; j < obterTamanhoVetor(TAMANHOS_CONJUNTO_DADOS); j++) {
				tabelaHash = new TabelaHash(TAMANHOS_VETOR_TABELA_HASH[i], calculadoraHash);
				
				inicioCronometro = System.nanoTime();
				qtdOperacoesInsercao = 
						inserirEmLoteNaTabelaHashRetornandoQtdComparacoes(tabelaHash, TAMANHOS_CONJUNTO_DADOS[j]);
				fimCronometro = System.nanoTime();
				
				System.out.println("Tempo para inserção de " + TAMANHOS_CONJUNTO_DADOS[j] + " dados: " + 
						obterDiferencaTempoSegundos(inicioCronometro, fimCronometro) + " s");
				System.out.println("Quantidade de operações para inserção de " + TAMANHOS_CONJUNTO_DADOS[j] + 
						" dados: " + qtdOperacoesInsercao);
				
			}
			
		}
		
		System.out.println("Fim dos testes.");
	}
	
	private static double obterDiferencaTempoSegundos(long inicioNanossegundos, long fimNanossegundos) {
		return (fimNanossegundos - inicioNanossegundos) / 1_000_000_000.00d;
	}
	
	private static int inserirEmLoteNaTabelaHashRetornandoQtdComparacoes(TabelaHash tabela, int qtdInsercoes) {
		int qtdComparacoes = 0;
		Random random = new Random(1L);
		for (int i = 0; i < qtdInsercoes; i++) {
			qtdComparacoes += tabela.inserir(new Registro(random.nextInt(Registro.LIMITE_SUPERIOR_CODIGO + 1)));
		}
		return qtdComparacoes;
	}
	
	private static int obterTamanhoVetor(int[] vetor) {	
		for (int i = 0, aux; ; i++) {
			try {
				aux = vetor[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				return i;
			}
		}
	}

}
