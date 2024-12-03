package org.example.ModuloDescontosTaxaDeEntrega;

import org.example.ModuloBase.Pedido;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeDescontoEntregaService {
    private List<IFormaDescontoTaxaEntrega> metodosDeDesconto = new ArrayList<>();

    public CalculadoraDeDescontoEntregaService(){
        metodosDeDesconto.add(new MetodoDescontoEntregaTaxaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoEntregaTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoEntregaTipoItem());
        metodosDeDesconto.add(new MetodoDescontoEntregaValorPedido());
    }

    public void calcularDesconto(Pedido pedido){
        for (IFormaDescontoTaxaEntrega metodo: metodosDeDesconto){
            metodo.calcularPedido(pedido);
        }
    }
}
