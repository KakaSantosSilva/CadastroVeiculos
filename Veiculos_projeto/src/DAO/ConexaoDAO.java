
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 16127512022.2
 */
public class ConexaoDAO {
    
    public Connection ConectaBD(){
        
        Connection conn = null;
        
        try {
           String sql = "jdbc:mysql://localhost:3306/veiculo?user=root&password=?";
           conn = DriverManager.getConnection(sql);
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CONEXAOBD DAO"+erro);
            
        }
        
        return conn;
    }
    
}

    
    
    

