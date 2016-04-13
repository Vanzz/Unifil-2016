/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.views.tablemodels;

import edu.unifil.javaconnection.misc.ReadJSONConfig;
import edu.unifil.javaconnection.models.Pessoa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mhadaniya
 */
public class PessoaTableModel extends AbstractTableModel {

    ReadJSONConfig readJSONConfig = new ReadJSONConfig();
    String colunas[] = {"#", "Nome", "E-mail", "Idade"};
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    String[] config;

    public PessoaTableModel() {
        try {
            config = readJSONConfig.getAllConfig();
        } catch (Exception ex) {
            Logger.getLogger(PessoaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return getListaPessoas().size();
    }

    @Override
    public int getColumnCount() {
        char[] mostrar = config[5].toCharArray();
        
        int columnIndex = 0;
        for (int i = 0; i < mostrar.length; i++) {
            if (mostrar[i] == '1') {
                columnIndex++;
            }
        }
        
        return columnIndex;
    }

    @Override
    public String getColumnName(int column) {
        char[] mostrar = config[5].toCharArray();
        
        int[] g = new int[getColumnCount()];
        int cont = 0;
        for (int i = 0; i < mostrar.length; i++) {
            if (mostrar[i] == '1') {
                g[cont++] = i;
            }
        }
        
        switch (g[column]) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
            case 3:
                return colunas[3];
        }

        return colunas[column];
    }

    public void addPessoa(Pessoa pP) {
        getListaPessoas().add(pP);
        fireTableDataChanged();
    }

    public void removePessoa(Pessoa pP) {
        getListaPessoas().remove(pP);
        fireTableDataChanged();
    }

    public Pessoa getPessoa(int pI) {
        return getListaPessoas().get(pI);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        char[] mostrar = config[5].toCharArray();
        
        int[] g = new int[getColumnCount()];
        int cont = 0;
        for (int i = 0; i < mostrar.length; i++) {
            if (mostrar[i] == '1') {
                g[cont++] = i;
            }
        }
        switch (g[columnIndex]) {
            case 0:
                return getListaPessoas().get(rowIndex).getId();
            case 1:
                return getListaPessoas().get(rowIndex).getNome();
            case 2:
                return getListaPessoas().get(rowIndex).getEmail();
            case 3:
                return getListaPessoas().get(rowIndex).getIdade();
            default:
                return getListaPessoas().get(rowIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        char[] editar = config[6].toCharArray();
        
        int[] g = new int[editar.length];
        int cont = 0;
        System.out.println(config[6]);
        for (int i = 0; i < editar.length; i++) {
            if (editar[i] == '1') {
                g[cont++] = i;
            } 
        }
        
       return (editar[g[columnIndex]] == '1');
    }

    /**
     * @return the listaPessoas
     */
    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    /**
     * @param listaPessoas the listaPessoas to set
     */
    public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
        this.fireTableDataChanged();
    }

}
