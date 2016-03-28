/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.controllers;

import edu.unifil.javaconnection.db.ConexaoMySQL;
import edu.unifil.javaconnection.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhadaniya
 */
public class PessoaController {

    private Connection con;

    public PessoaController() {
        try {
            this.con = ConexaoMySQL.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insere(Pessoa p) {
        String query = "INSERT INTO PESSOA(Nome, Idade, Email) VALUES(?, ?, ?)";
        try {
            PreparedStatement pS = con.prepareStatement(query);
            pS.setString(1, p.getNome());
            pS.setString(2, String.valueOf(p.getIdade()));
            pS.setString(3, p.getEmail());

            pS.execute();
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(long id) {
        String query = "DELETE FROM PESSOA "
                        + "WHERE ID=?";
        try {
            PreparedStatement pS = con.prepareStatement(query);
            pS.setLong(1, id);
            pS.execute();
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void update(Pessoa p) {
        String query = "UPDATE PESSOA SET Nome=?, Idade=?, Email=? "
                + "WHERE ID=?";
        
        try {
            PreparedStatement pS = con.prepareStatement(query);
            pS.setString(1, p.getNome());
            pS.setString(2, String.valueOf(p.getIdade()));
            pS.setString(3, p.getEmail());
            pS.setLong(4, p.getId());
            pS.execute();
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que retorna todas as pessoas;
     * @return lista de pessoa
     */
    public List<Pessoa> getAll() {
        //Query é um comando do SQL
        String query = "SELECT * FROM PESSOA";
        List<Pessoa> listaPessoa = new ArrayList();
        try {
            //Preapara o statement da query de conexão
            PreparedStatement pS = con.prepareStatement(query);
            //Retorna da query executada
            ResultSet rS = pS.executeQuery();
            //Enquanto existir próximo na query executada (se quiser primeira linha rS.first();)
            while (rS.next()) {
                Pessoa p = new Pessoa();

                p.setId(rS.getLong("Id"));
                p.setNome(rS.getString("Nome"));
                p.setIdade(rS.getInt("Idade"));
                p.setEmail(rS.getString("Email"));

                listaPessoa.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPessoa;
    }

    public Pessoa[] list() throws Exception {

        String query = "SELECT count(*) FROM pessoa";
        Statement st = ConexaoMySQL.getConexao().createStatement();
        ResultSet rs = st.executeQuery(query);

        int numPessoas = 0;
        while (rs.next()) {
            numPessoas = rs.getInt(1);
        }
        Pessoa[] pessoas = new Pessoa[numPessoas];

        query = "SELECT * FROM pessoa";
        rs = st.executeQuery(query);

        int count = 0;
        while (rs.next()) {
            Pessoa p = new Pessoa();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setIdade(rs.getInt("idade"));
            p.setEmail(rs.getString("email"));
            pessoas[count] = p;
            count++;
        }

        st.close();

        return pessoas;
    }

}
