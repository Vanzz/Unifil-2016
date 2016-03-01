import java.awt.Graphics2D;
import java.awt.Dimension;
/**
 * Escreva a descrição da classe Linha aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Linha
{
    public Linha(Ponto p0, Ponto p1){
        this.p0 = p0;
        this.p1 = p1;
    }
    
    public void desenharRelativo(Graphics2D g2d, Dimension dim){
        g2d.drawLine(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim));
    }
    
    public Ponto p0;
    public Ponto p1;
}
