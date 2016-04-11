import javax.swing.*;
import java.awt.*;

class Tela extends JPanel {

    // Constantes importantes
    final int TAMANHO_MARGEM_TXT = 10;
    final int TAMANHO_LINHA_TXT = 15;

    
    /**
     * Construtor padrão da classe, considera que deva um arranjo com apenas um elemento. Aqui se
     * configura alguns dos comportamentos dos objetos.
     */
    public Tela() {

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }
    
    
    /**
     * Método auxiliar para a classe que converte para um arranjo de ints uma sequencia de valores em
     * String, separados por ",". Valores não numéricos são considerados como 0.
     * 
     * @param textoArranjo String com valores separados por ",".
     * @return Arranjo de inteiros de acordo com a String de entrada.
     */
    private static int[] textoParaArranjo(String textoArranjo) {
        String[] numeros = textoArranjo.split(",");
        int[] arranjo = new int[numeros.length];
        
        for (int i = 0; i < numeros.length; i++) {
            try {
                arranjo[i] = Integer.parseInt(numeros[i]);
            } catch (NumberFormatException nfe) {
                String entradaErrada = nfe.getMessage();
                int posIni = entradaErrada.indexOf("\"") + 1;
                int posFim = entradaErrada.lastIndexOf("\"");
                entradaErrada = entradaErrada.substring(posIni, posFim);
                
                System.out.println("Ignorando entrada '" + entradaErrada + "'. Utilizado valor 0.");
                arranjo[i] = 0;
            }
        }
        
        return arranjo;
    }
    
    /**
     * Método que escreve informações auxiliares úteis. Elas são:
     *  - Dimensões da tela
     *  - Arranjo desenhado
     * 
     * @param g2d Pincel utilizado para desenhar na tela.
     */
    private void exibirInfosUteis(Graphics2D g2d) {
        Dimension dim = getSize();
        StringBuilder txtDim = new StringBuilder("Dimensões da tela: ");
        txtDim.append(dim.width).append(" X ").append(dim.height);
        g2d.drawString(txtDim.toString(), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT);
    }
    
    
    /**
     * Método responsável por desenhar o arranjo, além de outros elementos gráficos secundários e
     * auxiliares. É aqui que os alunos deverão trabalhar. Porém devem evitar de fazerem um código
     * demasiadamente grande, devem separar em métodos auxiliares (subrotinas) sempre que possível.
     * 
     * @param g Pincel do desenhista.
     * @see java.awt.Graphics, java.swing.Graphics2D
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        exibirInfosUteis(g2d);
        
        // Seu código desenhista começa aqui!
        Dimension dim = getSize();
        desenharCongresso(g2d, dim);
    }
    
    public void desenharCongresso(Graphics2D g2d, Dimension dim) {
        float x,y,w,h;
        x = 0.3f; y = 0.2f; w = 0.21f; h = 0.4f;
        
        Escala e = new Escala(x, y, w, h);
        
        g2d.fillRect(e.getX(dim), e.getY(dim), e.getW(dim), e.getH(dim));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}