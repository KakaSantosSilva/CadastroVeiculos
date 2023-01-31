package DAO;

import DTO.VeiculosDTO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;


public class VeiculosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    ArrayList<VeiculosDTO> lista = new ArrayList<>();
    
    public void CadastrarVeiculo(VeiculosDTO objcadastrarveiculo){
       
        String sql = "insert into dados_veiculos(modelo,marca,ano,placa,imagem)values(?,?,?,?,?)";
        
        conn = new ConexaoDAO().ConectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadastrarveiculo.getMarca());
            pstm.setString(2, objcadastrarveiculo.getModelo());
            pstm.setInt(3, objcadastrarveiculo.getAno());
            pstm.setString(4, objcadastrarveiculo.getPlaca());
            pstm.setBytes(5, objcadastrarveiculo.getImagem());
            
            pstm.execute();
            
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CADASTRAR VEICULO"+erro);
        }
    
    
    
    }
    public void ExcluirVeiculos(VeiculosDTO objexcluirdto) {
	String sql  = "delete from dados_veiculos where id_veiculo = ?";
    
	try {
		
     pstm =  conn.prepareStatement(sql);
     
     pstm.setInt(1, objexcluirdto.getId_veiculo());
     
     pstm.execute();
     
		
	} catch (SQLException e) {
		
		
	}
	
    }
  public void AlterarVeiculos(VeiculosDTO objexcluirdto) {
	String sql = "Update set dados_veiculos modelo = ?, marca = ?, ano = ?, placa = ?, imagem = ? where id_veiculo = ?";
	
	try {
		
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, objexcluirdto.getModelo());
		pstm.setString(2, objexcluirdto.getMarca());
		pstm.setInt(3, objexcluirdto.getAno());
		pstm.setString(4, objexcluirdto.getPlaca());
		pstm.setBytes(5, objexcluirdto.getImagem());
        
		pstm.execute();
		
		pstm.close();
		
		
	} catch (SQLException e) {
	
		
	}
	
}
  public  List<VeiculosDTO> listar(){
	String sql = "select * from veiculos";
	
	try {
	 pstm = conn.prepareStatement(sql);
	 rs = pstm.executeQuery();
	 
	 while(rs.next()) {
		VeiculosDTO objlista = new VeiculosDTO();
		objlista.setId_veiculo(rs.getInt("id_veiculo"));
		objlista.setModelo(rs.getString("modelo"));
		objlista.setMarca(rs.getNString("marca"));
		objlista.setAno(rs.getInt("ano"));
		objlista.setPlaca(rs.getNString("placa"));
		objlista.setImagem(rs.getBytes("imagem"));
		 
	    lista.add(objlista);    
	   
	 }
	 
	} catch (SQLException e) {
		
		
	}
  return lista;

  
}
        
}

