package org.example.ModuloRegistroDeLog;

import org.example.ManipulacaoDeDados.ManipuladorDeDadosParaLogService;
import org.example.ManipulacaoDeDados.GeradorDeJSON;

public class LogJSON implements ILog{
    private ManipuladorDeDadosParaLogService geradorDeDocumentos;

    public LogJSON(){
        geradorDeDocumentos = new ManipuladorDeDadosParaLogService(new GeradorDeJSON());
    }

    @Override
    public void escrever(DadosParaRegistro dados){
        geradorDeDocumentos.gerar(dados);
    }
}
