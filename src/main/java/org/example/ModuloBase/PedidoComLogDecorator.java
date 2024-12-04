package org.example.ModuloBase;

import org.example.ModuloRegistroDeLog.DadosParaRegistro;
import org.example.ModuloRegistroDeLog.LogService;

import java.util.Date;

public class PedidoComLogDecorator implements IPedido{
    private IPedido pedido;
    private LogService logService;

    public PedidoComLogDecorator(IPedido pedido, LogService logService){
        if(pedido == null || logService == null){
            throw new IllegalArgumentException("Valor inválido para pedido e/ou log");
        }
        this.pedido = pedido;
        this.logService = logService;
    }


    @Override
    public double getValorPedido() {
        escrever();
        return pedido.getValorPedido();
    }

    @Override
    public int getCodigoPedido(){
     return pedido.getCodigoPedido();
    }

    public void escrever(){
        logService.escrever(new DadosParaRegistro(new Date(), getCodigoPedido()));
    }
}
