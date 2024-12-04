package org.example.ModuloRegistroDeLog;

import org.example.ManipulacaoDeDados.ManipuladorDeDadosParaLogService;
import org.example.ManipulacaoDeDados.GeradorDeXML;

import java.io.FileWriter;

public class LogXML implements ILog{
    private ManipuladorDeDadosParaLogService geradorDeDocumentos;

    public LogXML(){
        geradorDeDocumentos = new ManipuladorDeDadosParaLogService(new GeradorDeXML());
    }

    @Override
    public void escrever(DadosParaRegistro dados) {
        geradorDeDocumentos.gerar(dados);
    }
}
