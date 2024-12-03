package org.example.ManipulacaoDeDados;

import org.example.ModuloRegistroDeLog.DadosParaRegistro;

public class GeradorDeDocumentosService {
    private IGeradorDeDocumentos geradorDeDocumentos;

    public GeradorDeDocumentosService(IGeradorDeDocumentos geradorDeDocumentos){
        if(geradorDeDocumentos == null){
            throw new IllegalArgumentException("Valor Inválido para Dispositivo");
        }

        setGeradorDeDocumentos(geradorDeDocumentos);
    }

    public void gerar(DadosParaRegistro dados){
        geradorDeDocumentos.gerar(dados);
    }

    private void setGeradorDeDocumentos(IGeradorDeDocumentos geradorDeDocumentos) {
        this.geradorDeDocumentos = geradorDeDocumentos;
    }
}
