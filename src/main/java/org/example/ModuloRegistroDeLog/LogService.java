package org.example.ModuloRegistroDeLog;

public class LogService {
    private ILog log;

    public LogService(ILog log) {
        if(log == null){
            throw new IllegalArgumentException("Valor Inválido para Dispositivo");
        }

        setiLog(log);
    }

    public void escrever(DadosParaRegistro dados){
        log.escrever(dados);
    }

    public void setiLog(ILog log) {
        this.log = log;
    }
}
