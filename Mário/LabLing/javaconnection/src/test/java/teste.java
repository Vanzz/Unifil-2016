
import edu.unifil.javaconnection.db.ConexaoMySQL;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiagoketzer
 */
public class teste {
    @Test
    public void conectar(){
        try {
            Connection con = ConexaoMySQL.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
