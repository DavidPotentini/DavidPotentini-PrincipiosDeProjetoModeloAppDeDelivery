
package org.example.ManipulacaoDeDados;

import ModuloConexaoBancoDeDados.*;
import org.example.ModuloRegistroDeLog.DadosParaRegistro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

public class InsersorDeDados implements IManipuladorDeDadosParaLog{
    IConexaoDB conexaoDB;
    public InsersorDeDados(IConexaoDB conexaoDB){
        this.conexaoDB = conexaoDB;
    }
    @Override
    public void gerar(DadosParaRegistro dados){
        
         // SQL para inserir o registro
        String sql = "INSERT INTO logs (usuario, datahora, codigo_pedido, operacao) VALUES (?, ?, ?, ?)";
        try{
         Connection conn = conexaoDB.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
            
            
            // Formatar a data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = sdf.format(dados.getdataEHoraDeRegistro());
            
            stmt.setString(1, dados.getNomeDoUsuario());
            stmt.setString(2, formattedDate);
            stmt.setInt(3, dados.getCodigoDoPedido());
            stmt.setString(4, dados.getNomeOperacao());

            stmt.executeUpdate();
        } 
        catch (SQLException e) {
            System.err.println("Erro ao gravar log no banco de dados: " + e.getMessage());
        }
    }
}
