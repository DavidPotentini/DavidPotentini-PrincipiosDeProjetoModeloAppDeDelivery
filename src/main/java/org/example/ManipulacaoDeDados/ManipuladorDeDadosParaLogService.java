package org.example.ManipulacaoDeDados;

import org.example.ModuloRegistroDeLog.DadosParaRegistro;

public class ManipuladorDeDadosParaLogService {
    private IManipuladorDeDadosParaLog geradorDeDocumentos;

    public ManipuladorDeDadosParaLogService(IManipuladorDeDadosParaLog geradorDeDocumentos){
        if(geradorDeDocumentos == null){
            throw new IllegalArgumentException("Valor Inválido para Dispositivo");
        }

        setGeradorDeDocumentos(geradorDeDocumentos);
    }

    public void gerar(DadosParaRegistro dados){
        geradorDeDocumentos.gerar(dados);
    }

    private void setGeradorDeDocumentos(IManipuladorDeDadosParaLog geradorDeDocumentos) {
        this.geradorDeDocumentos = geradorDeDocumentos;
    }
}
