package org.example.ModuloRegistroDeLog;

import org.example.ManipulacaoDeDados.GeradorDeDocumentosService;
import org.example.ManipulacaoDeDados.GeradorDeJSON;

public class LogJSON implements ILog{
    private GeradorDeDocumentosService geradorDeDocumentos;

    public LogJSON(){
        geradorDeDocumentos = new GeradorDeDocumentosService(new GeradorDeJSON());
    }

    @Override
    public void escrever(DadosParaRegistro dados){
        geradorDeDocumentos.gerar(dados);
    }
}
