import java.awt.Graphics2D;
import java.awt.Dimension;
/**
 * Escreva a descrição da classe Retangulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Retangulo
{
    public Retangulo(Ponto p0, float w, float h){
        this.p0 = p0;
        this.w = w;
        this.h = h;
    }
    
    public void desenharRelativo(Graphics2D g2d, Dimension dim) {
        
    }
    
    public int getWRelativo(Dimension dim){     
        return (int)(w * dim.width);
    }
    
    public int getHRelativo(Dimension dim){
        return (int)(h * dim.height);
    }
    
    public Ponto p0;
    public float w;
    public float h;
}
