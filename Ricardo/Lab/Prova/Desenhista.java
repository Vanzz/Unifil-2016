import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Desenhista extends JFrame {
    
    // Elementos (widgets) da nossa interface
    private Tela tela;
    private JButton btnDesenharArranjo;
    private JTextField txtEntradaArranjo;
    
    
    /**
     * O construtor do aplicativo Desenhista. É aqui que todos os elementos da interface gráfica são
     * construídos, configurados e posicionados. Por enquanto, aqui também é feito o tratamento de 
     * eventos (input de usuário através de mouse e teclado), utilizando classes anônimas.
     * Provavelmente vamos separar esta funcionalidade no futuro.
     * 
     * @see javax.swing.JFrame
     */
    public Desenhista() {
        
        // Cria e configura a tela do desenhista
        tela = new Tela();
        tela.setPreferredSize(new Dimension(800, 600));

        // Container que organiza o posicionamento dos botões e da tela
        Container organizacao = getContentPane();
        organizacao.setLayout(new BorderLayout());
        organizacao.add(tela, BorderLayout.CENTER);

        // Configurações de comportamento do aplicativo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Desenhista - Lab. Comp. II");
        pack();
        setVisible(true);
        requestFocus();
    }
    
    
    /**
     * Ponto de início do programa. Simplesmente informa que é um aplicativo gráfico e passa o controle
     * para o construtor do método. Utiliza uma segunda thread para isso.
     * 
     * @param args Argumentos recebidos da linha de comando.
     */
    public static void main(String[] args) {
        // Código que inicializa o aplicativo gráfico
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Desenhista();
            }
        }); 
    }
}