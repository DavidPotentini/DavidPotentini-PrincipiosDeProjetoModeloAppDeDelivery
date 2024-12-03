package org.example.ModuloRegistroDeLog;

import org.example.ManipulacaoDeDados.GeradorDeDocumentosService;
import org.example.ManipulacaoDeDados.GeradorDeXML;

import java.io.FileWriter;

public class LogXML implements ILog{
    GeradorDeDocumentosService geradorDeDocumentos;

    public LogXML(){
        geradorDeDocumentos = new GeradorDeDocumentosService(new GeradorDeXML());
    }

    @Override
    public void escrever(DadosParaRegistro dados) {
        geradorDeDocumentos.gerar(dados);
    }
}
