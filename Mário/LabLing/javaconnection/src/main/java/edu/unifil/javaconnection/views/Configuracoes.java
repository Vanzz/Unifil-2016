/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.views;

import edu.unifil.javaconnection.db.ConexaoMySQL;
import edu.unifil.javaconnection.misc.ReadJSONConfig;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author mhadaniya
 */
public class Configuracoes extends javax.swing.JFrame {

    private Connection con;

    private String mo, ed, or;

    public Configuracoes() {
        initComponents();
    this.setLocationRelativeTo(null);
        try {
            carregarDadosArquivo();
        } catch (Exception ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarDadosArquivo() throws Exception {
        ReadJSONConfig readJSONConfig = new ReadJSONConfig();
        String[] config = readJSONConfig.getAllConfig();
        txtPassword.setText(config[0]);
        txtUsername.setText(config[1]);
        txtURL.setText(config[2]);
        txtPort.setText(config[3]);
        txtDatabase.setText(config[4]);
        
        char[] m = config[5].toCharArray();
        char[] e = config[6].toCharArray();
        char[] o = config[7].toCharArray();
        
        JCheckBox[] editar = {chckboxEditarId, chckboxEditarNome,
            chckboxEditarEmail, chckboxEditarIdade};
        JCheckBox[] mostrar = {chckboxMostrarId, chckboxMostrarNome,
            chckboxMostrarEmail, chckboxMostrarIdade};
        JCheckBox[] ordenar = {chckboxOrdenarId, chckboxOrdenarNome,
            chckboxOrdenarEmail, chckboxOrdenarIdade};

        for(int i = 0; i < 4; i++) {
            verify(mostrar[i], m[i]);
            verify(editar[i], e[i]);
            verify(ordenar[i], o[i]);
        }
    }

    public static boolean verify(JCheckBox check, char letter) {
        if (letter == '1') {
            check.setSelected(true);
            return true;
        } else {
            check.setSelected(false);
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        txtDatabase = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnTestarConexao = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        Tabela = new javax.swing.JPanel();
        chckboxMostrarId = new javax.swing.JCheckBox();
        chckboxMostrarNome = new javax.swing.JCheckBox();
        chckboxMostrarEmail = new javax.swing.JCheckBox();
        chckboxMostrarIdade = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chckboxEditarId = new javax.swing.JCheckBox();
        chckboxEditarNome = new javax.swing.JCheckBox();
        chckboxEditarEmail = new javax.swing.JCheckBox();
        chckboxEditarIdade = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        chckboxOrdenarId = new javax.swing.JCheckBox();
        chckboxOrdenarNome = new javax.swing.JCheckBox();
        chckboxOrdenarEmail = new javax.swing.JCheckBox();
        chckboxOrdenarIdade = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Banco de dados"));

        jLabel1.setText("url:");

        jLabel2.setText("database:");

        jLabel3.setText("port:");

        jLabel4.setText("username:");

        jLabel5.setText("password:");

        txtURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtURLActionPerformed(evt);
            }
        });

        btnTestarConexao.setText("Testar Conexão");
        btnTestarConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestarConexaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtPort)
                    .addComponent(txtDatabase)
                    .addComponent(txtURL)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTestarConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTestarConexao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        Tabela.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabela"));

        chckboxMostrarId.setText("#");

        chckboxMostrarNome.setText("Nome");

        chckboxMostrarEmail.setText("Email");

        chckboxMostrarIdade.setText("Idade");

        jLabel6.setText("Mostrar:");

        jLabel7.setText("Editar:");

        chckboxEditarId.setText("#");

        chckboxEditarNome.setText("Nome");

        chckboxEditarEmail.setText("Email");

        chckboxEditarIdade.setText("Idade");

        jLabel8.setText("Ordenar");

        chckboxOrdenarId.setText("#");

        chckboxOrdenarNome.setText("Nome");

        chckboxOrdenarEmail.setText("Email");

        chckboxOrdenarIdade.setText("Idade");

        javax.swing.GroupLayout TabelaLayout = new javax.swing.GroupLayout(Tabela);
        Tabela.setLayout(TabelaLayout);
        TabelaLayout.setHorizontalGroup(
            TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabelaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(chckboxMostrarId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxMostrarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxMostrarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxMostrarIdade))
                    .addGroup(TabelaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chckboxEditarId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxEditarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxEditarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxEditarIdade))
                    .addGroup(TabelaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chckboxOrdenarId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxOrdenarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxOrdenarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chckboxOrdenarIdade)))
                .addGap(14, 14, 14))
        );
        TabelaLayout.setVerticalGroup(
            TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chckboxMostrarId)
                    .addComponent(chckboxMostrarNome)
                    .addComponent(chckboxMostrarEmail)
                    .addComponent(chckboxMostrarIdade)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chckboxEditarId)
                    .addComponent(chckboxEditarNome)
                    .addComponent(chckboxEditarEmail)
                    .addComponent(chckboxEditarIdade)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chckboxOrdenarId)
                    .addComponent(chckboxOrdenarNome)
                    .addComponent(chckboxOrdenarEmail)
                    .addComponent(chckboxOrdenarIdade)
                    .addComponent(jLabel8))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Tabela, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtURLActionPerformed

    }//GEN-LAST:event_txtURLActionPerformed

    private void btnTestarConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestarConexaoActionPerformed

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String url = txtURL.getText();
        String database = txtDatabase.getText();
        String port = txtPort.getText();

        JSONObject jSON = new JSONObject();

        jSON.put("username", username);
        jSON.put("password", password);
        jSON.put("url", url);
        jSON.put("database", database);
        jSON.put("port", port);
        System.out.println(jSON.toJSONString());

        try (FileWriter fw = new FileWriter("config/configTest.json")) {
            fw.write(jSON.toJSONString());
        } catch (IOException ex) {

        }
        testarConexao();
    }//GEN-LAST:event_btnTestarConexaoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        Main.main(null);
        this.dispose();
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Salvar conexão se o teste for true
        if (testarConexao()) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String url = txtURL.getText();
            String database = txtDatabase.getText();
            String port = txtPort.getText();

            JSONObject jSON = new JSONObject();

            jSON.put("username", username);
            jSON.put("password", password);
            jSON.put("url", url);
            jSON.put("database", database);
            jSON.put("port", port);
            
            JCheckBox[] editar = {chckboxEditarId, chckboxEditarNome,
                chckboxEditarEmail, chckboxEditarIdade};
            JCheckBox[] mostrar = {chckboxMostrarId, chckboxMostrarNome,
                chckboxMostrarEmail, chckboxMostrarIdade};
            JCheckBox[] ordenar = {chckboxOrdenarId, chckboxOrdenarNome,
                chckboxOrdenarEmail, chckboxOrdenarIdade};
            mo = arruma(mostrar);
            ed = arruma(editar);
            or = arruma(ordenar);
            jSON.put("mostrar", mo);
            jSON.put("editar", ed);
            jSON.put("ordenar", or);

            try (FileWriter fw = new FileWriter("config/config.json")) {
                fw.write(jSON.toJSONString());
            } catch (IOException ex) {

            }
        }
        Main.main(null);
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    public String arruma(JCheckBox []check) {
        String rs = "";
        for (JCheckBox jCheckBox : check) {
            if(jCheckBox.isSelected()){
                rs+= ""+1;
            } else {
                rs+= ""+0;
            }
        }
        return rs;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tabela;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTestarConexao;
    private javax.swing.JCheckBox chckboxEditarEmail;
    private javax.swing.JCheckBox chckboxEditarId;
    private javax.swing.JCheckBox chckboxEditarIdade;
    private javax.swing.JCheckBox chckboxEditarNome;
    private javax.swing.JCheckBox chckboxMostrarEmail;
    private javax.swing.JCheckBox chckboxMostrarId;
    private javax.swing.JCheckBox chckboxMostrarIdade;
    private javax.swing.JCheckBox chckboxMostrarNome;
    private javax.swing.JCheckBox chckboxOrdenarEmail;
    private javax.swing.JCheckBox chckboxOrdenarId;
    private javax.swing.JCheckBox chckboxOrdenarIdade;
    private javax.swing.JCheckBox chckboxOrdenarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtURL;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private boolean testarConexao() {
        try {
            con = ConexaoMySQL.testConexao();
            JOptionPane.showMessageDialog(null, "Conexão bem sucedida!");
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Conexão mal sucedida!");
            return false;
        }
    }
}
