import java.awt.Dimension;
/**
 * Escreva a descrição da classe Ponto aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ponto
{
    public Ponto(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public int getXRelativo(Dimension dim){     
        return (int)(x * dim.width);
    }
    
    public int getYRelativo(Dimension dim){
        return (int)(y * dim.height);
    }
    
    public float x;
    public float y;
}
