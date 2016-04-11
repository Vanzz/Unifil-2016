/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.views.tablemodels;

import edu.unifil.javaconnection.models.Pessoa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mhadaniya
 */
public class PessoaTableModel extends AbstractTableModel {
    
    String colunas[] = {"Id", "Nome","Idade","E-mail"};
    private ArrayList <Pessoa> listaPessoas = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return getListaPessoas().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void addPessoa (Pessoa pP) {
        getListaPessoas().add(pP);
        fireTableDataChanged();
    }
    
    public void removePessoa (Pessoa pP) {
        getListaPessoas().remove(pP);
        fireTableDataChanged();
    }
    
    public Pessoa getPessoa (int pI) {
        return getListaPessoas().get(pI);
    }
    
    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return getListaPessoas().get(rowIndex).getId();
            case 1:
                return getListaPessoas().get(rowIndex).getNome();
            case 2:
                return getListaPessoas().get(rowIndex).getIdade();
            case 3:
                return getListaPessoas().get(rowIndex).getEmail();
            default:
                return getListaPessoas().get(rowIndex);
        }
    }

    /**
     * @return the listaPessoas
     */
    public ArrayList <Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    /**
     * @param listaPessoas the listaPessoas to set
     */
    public void setListaPessoas(ArrayList <Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
        this.fireTableDataChanged();
    }
    
}
