
package org.example.ModuloRegistroDeLog;

import org.example.ManipulacaoDeDados.ManipuladorDeDadosParaLogService;
import org.example.ManipulacaoDeDados.InsersorDeDados;
import org.example.ModuloConexaoBancoDeDados.*;

public class LogDB implements ILog {
    
    private ManipuladorDeDadosParaLogService geradorDeDocumentos;

    public LogDB(IConexaoDB conexaoDB){
        geradorDeDocumentos = new ManipuladorDeDadosParaLogService(new InsersorDeDados(conexaoDB));
    }

    @Override
    public void escrever(DadosParaRegistro dados) {
        geradorDeDocumentos.gerar(dados);
    }
}
