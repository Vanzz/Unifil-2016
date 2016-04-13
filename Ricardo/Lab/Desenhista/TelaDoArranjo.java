import javax.swing.*;
import java.awt.*;
import java.util.Random;

class TelaDoArranjo extends JPanel {
    // Escolha de cores
    Color a = getRandomColor();
    Color b = getRandomColor();

    // Constantes importantes
    final int TAMANHO_MARGEM_TXT = 10;
    final int TAMANHO_LINHA_TXT = 20;

    // Campos da classe
    private int[] arranjo = { 1 };

    /**
     * Construtor principal da Tela.
     * 
     * @param arranjo Arranjo de int a ser desenhado na tela.
     */
    public TelaDoArranjo(int[] arranjo) {
        this();

        this.arranjo = arranjo;
    }

    /**
     * Outro construtor para a Tela. Possui o mesmo comportamento que o construtor principal, porém
     * aceita receber número em uma String separados por ",".
     * 
     * @param arranjo String com números separados por vírgula.
     */
    public TelaDoArranjo(String arranjo) {
        this(textoParaArranjo(arranjo));
    }

    /**
     * Construtor padrão da classe, considera que deva um arranjo com apenas um elemento. Aqui se
     * configura alguns dos comportamentos dos objetos.
     */
    public TelaDoArranjo() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    /**
     * Define um novo arranjo para ser desenhado na tela.
     * 
     * @para novoArranjo Arranjo com quantos valores forem desejados a serem desenhados.
     */
    public void setArranjo(int[] novoArranjo) {
        this.arranjo = novoArranjo;
    }

    /**
     * Define um novo arranjo para ser desenhado na tela.
     * 
     * @para novoArranjo String com valores numéricos separados por ",".
     */
    public void setArranjo(String novoArranjo) {
        setArranjo(textoParaArranjo(novoArranjo));
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

        StringBuilder txtArranjo = new StringBuilder("Arranjo desenhado: ");
        for (int n : arranjo) {
            txtArranjo.append(n).append(",");
        }
        txtArranjo.deleteCharAt(txtArranjo.length() - 1);
        g2d.drawString(txtArranjo.toString(), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT * 2);

        StringBuilder txtDMC = new StringBuilder("Maior Elem: "+  maiorElem(arranjo));
        g2d.drawString(txtDMC.toString(), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT * 3);
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
        
        desenhaColunas(g2d, a, b, dim);
    }
    /******************************************
     * Todos os seus métodos auxiliares estão daqui para baixo. Lembre-se de sempre escrevre o
     * devido javadoc.
     */

    /**
     * Este método encontra o maior elemento de um arranjo de entrada.
     * 
     * @param arranjo Arranjo a ser procurado pelo seu maior elemento.
     * @return Valor do maior elemento.
     */
    private static int maiorElem(int[] arranjo) {
        int maiorElem = arranjo[0];

        for (int i = 0; i < arranjo.length; i++) {
            if (arranjo[i] > maiorElem) {
                maiorElem = arranjo[i];
            }
        }

        return maiorElem;
    }
    
    /**
     * Este método desenha os elementos do arranjo com cores aleatórias {@link getRandomColor()}
     * e redimensionável pela classe escala classe Escala.
     * @param g2d - usado para a pintura; a - cor random A; b - cor random B; dim - dimensionador
     * 
     */
    public void desenhaColunas (Graphics2D g2d, Color a, Color b, Dimension dim) {
        float espacamentoInicial = .05f;
        float espacamento = .6f;
        float altura = .85f;

        for (int i = 0; i < arranjo.length; i++) {
            float x = (float)(espacamentoInicial + (espacamento * i / arranjo.length) + ((espacamento/2) * i / arranjo.length));
            float y = (float)(altura - (espacamento * arranjo[i] / maiorElem(arranjo)));
            float w = (float)(espacamento / arranjo.length);
            float h = (float)(espacamento * arranjo[i] / maiorElem(arranjo));

            Escala e = new Escala(x, y, w, h);

            g2d.setColor(a);
            g2d.fillRect(e.getX(dim),e.getY(dim),e.getW(dim),e.getH(dim));

            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(b);
            
            g2d.drawRect(e.getX(dim),e.getY(dim),e.getW(dim),e.getH(dim));
            
            g2d.setColor(Color.BLACK);
            StringBuilder textoNumero = new StringBuilder("");            
            textoNumero.append(arranjo[i]);            
            g2d.drawString(textoNumero.toString(), (e.getX(dim)+(e.getX(dim) + e.getW(dim)))/2, e.getY(dim) + e.getH(dim) + TAMANHO_LINHA_TXT);
        }
    }
    
    /**
     * Metódo responsável por randomizar as cores
     * @return randomColor - cor randomizada;
     */
    public Color getRandomColor() {
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Color randomColor = new Color(r, g, b);

        return randomColor;
    }
}