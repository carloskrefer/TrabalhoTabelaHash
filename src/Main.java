import java.util.Random;

public class Main {	
//	private static final int[] TAMANHOS_VETOR_TABELA_HASH = {10, 100, 1_000, 10_000, 100_000};
	private static final int[] TAMANHOS_VETOR_TABELA_HASH = {100};
//	private static final int[] TAMANHOS_CONJUNTO_DADOS = {20_000, 100_000, 500_000, 1_000_000, 5_000_000};
	private static final int[] TAMANHOS_CONJUNTO_DADOS = {10000};
	
	public static void main(String[] args) {		
		realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(new CalculadoraHashResto("Função Hash de Resto"));
		System.out.println();
		
		realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(new CalculadoraHashSoma("Função Hash de Soma"));
		System.out.print("\t\t\tInserção - Maior soma obtida pela Função Hash de Soma durante os testes: " + CalculadoraHashSoma.maiorSoma + ". " +
				"Soma calculada a partir do número aleatório "); 
		CalculadoraHashSoma.imprimirNumeroDumArrayDeDigitosSemQuebrarLinha(CalculadoraHashSoma.arrayDigitosSeparadosMaiorSoma, Registro.QTD_DIGITOS);
		System.out.println(".");
		System.out.println();
		
		
		realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(new CalculadoraHashMultiplicacao("Função Hash de Multiplicação"));
		System.out.print("\t\t\tInserção - Quantidade de registros com pelo um dígito sendo zero: " + 
				CalculadoraHashMultiplicacao.qtdRegistrosComPeloMenosUmNumeroZero + ".");
		System.out.println();
	}
	
	private static void realizarTestesEmTabelasHashPorCalculadoraHashEspecifica(CalculadoraHash calculadoraHash) {
		TabelaHash tabelaHash;
		long inicioCronometro;
		long fimCronometro;
		
		System.out.println(calculadoraHash.getNomeCalculadora());
		
		for (int i = 0; i < obterTamanhoVetor(TAMANHOS_VETOR_TABELA_HASH); i++) {
			System.out.println("\tTamanho do vetor da tabela: " + TAMANHOS_VETOR_TABELA_HASH[i]);
			
			calculadoraHash.setTamanhoArrayTabelaHash(TAMANHOS_VETOR_TABELA_HASH[i]);
			
			for (int j = 0; j < obterTamanhoVetor(TAMANHOS_CONJUNTO_DADOS); j++) {
				tabelaHash = new TabelaHash(TAMANHOS_VETOR_TABELA_HASH[i], calculadoraHash);
				
				inicioCronometro = System.nanoTime();
				inserirEmLoteNaTabelaHash(tabelaHash, TAMANHOS_CONJUNTO_DADOS[j]);
				fimCronometro = System.nanoTime();
				
				System.out.println("\t\tResultados referentes a " + TAMANHOS_CONJUNTO_DADOS[j] + " dados:");
				System.out.println("\t\t\tInserção - Tempo: "+ 
						obterDiferencaTempoSegundos(inicioCronometro, fimCronometro) + " s");
				System.out.println("\t\t\tInserção - Quantidade de colisões: " + 
						tabelaHash.obterQtdColisoesInsercao());
				System.out.println("\t\t\tInserção - Quantidade de operações de comparação na lista após colisão: " + 
						tabelaHash.obterQtdComparacoesInsercao());
				System.out.println("\t\t\tInserção - Quantidade de elementos da pilha mais cheia: " + 
						tabelaHash.buscarQtdRegistrosPilhaMaisCheia());
				System.out.println("\t\t\tInserção - Quantidade de elementos da pilha mais vazia: " + 
						tabelaHash.buscarQtdRegistrosPilhaMaisVazia());
				
				long qtdComparacoesBusca;
				
				inicioCronometro = System.nanoTime();
				qtdComparacoesBusca = buscarCincoPrimeirosDadosAleatoriosRetornandoTotalComparacoes(tabelaHash);
				fimCronometro = System.nanoTime();
				
				System.out.println("\t\t\tBusca    - Tempo decorrido na localizar 5 elementos aleatórios já inseridos: " + 
						obterDiferencaTempoSegundos(inicioCronometro, fimCronometro) + "s");
			}
		}
	}
	
	private static long buscarCincoPrimeirosDadosAleatoriosRetornandoTotalComparacoes(TabelaHash tabela) {
		Random random = new Random(1L);
		long comparacoes = 0;
		
		for (int i = 0; i < 5; i++) {
			comparacoes += tabela.buscar(new Registro(random.nextInt(Registro.LIMITE_SUPERIOR + 1)));
		}
		
		return comparacoes;
	}
	
	private static double obterDiferencaTempoSegundos(long inicioNanossegundos, long fimNanossegundos) {
		return (fimNanossegundos - inicioNanossegundos) / 1_000_000_000.00d;
	}
	
	private static void inserirEmLoteNaTabelaHash(TabelaHash tabela, int qtdInsercoes) {
		Random random = new Random(1L);
		for (int i = 0; i < qtdInsercoes; i++) {
			tabela.inserir(new Registro(random.nextInt(Registro.LIMITE_SUPERIOR + 1)));
		}
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
