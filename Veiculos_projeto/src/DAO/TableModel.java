/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.VeiculosDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModel extends AbstractTableModel{
    
    private List<VeiculosDTO> lista;
    
    private String[] colunns = {"Código","Marca","Modelo","Ano","Placa"};
    
    public TableModel(List<VeiculosDTO> lista ){
        this.lista = lista;
        
        
    }

    @Override
    public int getRowCount() {
       return colunns.length;
    }

    @Override
    public int getColumnCount() {
        return lista.size();
    }
    
    public String getColunmName(int columnIndex){
        return colunns[columnIndex];
    }
    
    public Class<?> getColunmClass(int columnIndex){
        return String.class;
    }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return null;
    }
}
