package org.example.ModuloDescontosPedido;

import org.example.ModuloBase.Pedido;
import org.example.ModuloDescontosTaxaDeEntrega.CalculadoraDeDescontoEntregaService;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeDescontoPedidosService {
    private List<IFormaDescontoPedido> metodosDeDesconto = new ArrayList<>();

    public CalculadoraDeDescontoPedidosService(){
        metodosDeDesconto.add(new MetodoDescontoPedidoTipoItem());
        metodosDeDesconto.add(new MetodoDescontoPedidoTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoPedidoCodigoCupom());
    }

    public void calcularDesconto(Pedido pedido){
        for(IFormaDescontoPedido metodo:metodosDeDesconto){
            metodo.calcularPedido(pedido);
        }
    }
}
