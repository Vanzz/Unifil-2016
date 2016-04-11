import java.awt.Dimension;

public class Escala{
    public float x, y, w, h;

    /**
     * Construtor da classe Escala
     * @param x - x; y - y; w - width; h - height;
     */
    public Escala(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * Método getX redimensionável
     * @param dim - dimensionador;
     * @return o x redimensionado;
     */
    public int getX(Dimension dim) {
        return (int)(this.x * dim.width);
    }

    /**
     * Método getY redimensionável
     * @param dim - dimensionador;
     * @return o y redimensionado;
     */
    public int getY(Dimension dim) {
        return (int)(this.y * dim.height);
    }

    /**
     * Método getW redimensionável
     * @param dim - dimensionador;
     * @return o width redimensionado;
     */
    public int getW(Dimension dim) {
        return (int)(this.w * dim.width);
    }

    /**
     * Método getH redimensionável
     * @param dim - dimensionador;
     * @return o height redimensionado;
     */
    public int getH(Dimension dim) {
        return (int)(this.h * dim.height);
    }

    /**
     * Método toString da classe
     * @return suas propriedades: x,y,w,h;
     */
    public String toString() {
        return "X: "+x+" Y: "+y+" W: "+w+" H: "+h;
    }
}
