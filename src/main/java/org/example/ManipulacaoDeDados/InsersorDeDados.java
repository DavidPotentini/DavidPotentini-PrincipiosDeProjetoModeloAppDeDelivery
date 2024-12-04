
package org.example.ManipulacaoDeDados;

import org.example.ModuloConexaoBancoDeDados.*;
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
            String dataFormatada = sdf.format(dados.getDataEHoraDeRegistro());
            
            stmt.setString(1, dados.getNomeDoUsuario());
            stmt.setString(2, dataFormatada);
            stmt.setInt(3, dados.getCodigoDoPedido());
            stmt.setString(4, dados.getNomeOperacao());

            stmt.executeUpdate();
        } 
        catch (Exception e) {
            System.err.println("Erro ao gravar log no banco de dados: " + e.getMessage());
        }
    }
}
