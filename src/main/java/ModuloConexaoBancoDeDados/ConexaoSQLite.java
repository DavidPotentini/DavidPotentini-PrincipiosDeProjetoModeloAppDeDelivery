
package ModuloConexaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite implements IConexaoDB {
    // Caminho para o arquivo do banco SQLite
    String url = "jdbc:sqlite:C:/Users/layon/Desktop/logs.db";
    @Override
    public Connection conectar(){
        try{
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(SQLException e) {
            System.err.println("Erro ao gravar log no banco de dados: " + e.getMessage());
        }
        return null;
    }
}