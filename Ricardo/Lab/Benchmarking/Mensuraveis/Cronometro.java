package Mensuraveis;

/**
 * Write a description of class Cronometro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cronometro
{
    /**
     * Construtor padrão da classe.
     */
    public Cronometro() {
        initialTime = 0;
        finalTime = 0;
    }
    
    /**
     * Inicia ou reinicia a contagem de tempo. Nunca zera o último estado do contador. Se o tempo já
     * estiver correndo, não faz nada.
     */
    public void iniciar() {
        if(initialTime == 0){
            initialTime = System.currentTimeMillis();
        }
    }
    
    /**
     * Para a contagem de tempo e retorna uma leitura do tempo decorrido.
     * 
     * @return Tempo decorrido até o momento da parada.
     */
    public double parar() {
        double currentTime = System.currentTimeMillis() - initialTime;
        return currentTime;
    }
    
    /**
     * Retorna o tempo decorrido contado até então, independente se está parado ou correndo. Não
     * altera o estado de contagem (parado/correndo).
     * 
     * return Tempo decorrido contado pelo cronômetro.
     */
    public double lerTempoEmMilissegundos() {
        finalTime = System.currentTimeMillis() - initialTime;
        return finalTime;
    }
    
    /**
     * Zera o contador de tempo do cronômetro. Se o cronômetro estava em estado de contagem, ele é
     * parado.
     */
    public void zerar() {
        if(finalTime > 0){
            initialTime = 0;
            finalTime = 0;
        }
    }
    
    // Atributos da classe são declarados aqui
    double initialTime;
    double finalTime;
}
