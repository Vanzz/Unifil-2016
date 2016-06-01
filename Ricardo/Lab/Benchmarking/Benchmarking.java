import java.util.Random;

import Mensuraveis.Ordenacao.*;

/**
 * Write a description of class Benchmarking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Benchmarking
{
    /**
     * Início do programa, define os parâmetros de benchmarking, executa e exibe os resultados em
     * forma de gráfico.
     * 
     * 
     */
    public static void main(String args[]) {
        int nMin = 500;
        int nMax = 3000;
        int passo = 50;
        int repeticoes = 50;        
        
        TabelaTempos graficoOrdenacao = tomaTemposOrdenacoes(nMin, nMax, passo, repeticoes);
        graficoOrdenacao.exibirGraficoXY();
    }
    
    /**
     * Realiza o benchmarking de diversas implementações de ordenacao em arranjos e anota os resultados
     * em uma tabela de tempos.
     * 
     * @param
     */
    public static TabelaTempos tomaTemposOrdenacoes(int nMin, int nMax, int passo, int repeticoes) {
        SelecaoMensuravel selecao = new SelecaoMensuravel();
        BolhaMensuravel bolha = new BolhaMensuravel();
        InsercaoMensuravel insercao = new InsercaoMensuravel();
        MergesortMensuravel mergesort = new MergesortMensuravel();
        QuicksortMensuravel quicksort = new QuicksortMensuravel();
        
        TabelaTempos dadosDesempenho = new TabelaTempos();
        
        long seed = 0;
        Random gerador = new Random(seed);
        for (int n = nMin; n < nMax; n += passo) {
            // Inicializar estruturas de dados e parâmetros
            int[] lista = new int[n];
            for (int i = 0; i < lista.length; i++) {
                lista[i] = gerador.nextInt(nMax - nMin);
            }
            
            double tempoSelecao = (selecao.benchmarkOrdenacao(lista, repeticoes) / 1000) / repeticoes;
            double tempoBolha = (bolha.benchmarkOrdenacao(lista, repeticoes) / 1000) / repeticoes;
            double tempoInsercao = (insercao.benchmarkOrdenacao(lista, repeticoes) / 1000) / repeticoes;
            double tempoMergesort = (mergesort.benchmarkOrdenacao(lista, repeticoes) / 1000) / repeticoes;
            double tempoQuicksort = (quicksort.benchmarkOrdenacao(lista, repeticoes) / 1000) / repeticoes;
            
            // Assim que tiver a implementação das outras buscas prontas, vá adicionando os parâmetros
            // abaixo à chamada do método anotarAmostra()
            dadosDesempenho.anotarAmostra(n, tempoSelecao, tempoBolha, tempoInsercao, tempoMergesort, tempoQuicksort);//, tempoBolha, tempoInsercao, tempoMergesort);
            dadosDesempenho.setLegendas("Seleção", "Bolha", "Inserção", "Mergesort", "Quicksort");//, "Bolha", "Inserção", "Mergesort");
            
            
            dadosDesempenho.setTitulo("Ordenacao com tamanhos de " + nMin + " a " + nMax );
            dadosDesempenho.setEtiquetaX("Tamanho do Arranjo");
            dadosDesempenho.setEtiquetaY("Tempo (s)");
        }
        
        return dadosDesempenho;
    }
}
