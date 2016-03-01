import java.awt.Dimension;
import java.awt.Graphics2D;


/**
 * Write a description of class Desenhos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desenhos
{
    public static void desenhoLivre(Graphics2D pincel, Dimension dim) {
        Retangulo retangulo = new Retangulo(new Ponto(.1f,.1f), .3f, .3f);
        
        pincel.drawRect(retangulo.p0.getXRelativo(dim),
                     retangulo.p0.getYRelativo(dim),
                     retangulo.getWRelativo(dim),
                     retangulo.getHRelativo(dim));
    }
    
    public static void desenharAsterisco(Graphics2D g2d, Dimension dim) {
        Linha linha1 = new Linha(new Ponto(.1f, .1f), new Ponto(.7f, .7f));
        Linha linha2 = new Linha(new Ponto(.1f, .7f), new Ponto(.7f, .1f));
        Linha linha3 = new Linha(new Ponto(.4f, .0f), new Ponto(.4f, .8f));
        Linha linha4 = new Linha(new Ponto(.0f, .4f), new Ponto(.8f, .4f));
        
        linha1.desenharRelativo(g2d, dim);
        linha2.desenharRelativo(g2d, dim);
        linha3.desenharRelativo(g2d, dim);
        linha4.desenharRelativo(g2d, dim);
    }
    
}
