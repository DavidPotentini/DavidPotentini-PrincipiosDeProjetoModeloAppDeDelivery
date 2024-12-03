package org.example.ModuloDescontosTaxaDeEntrega;

import org.example.ModuloCupomDesconto.CupomDescontoEntrega;
import org.example.ModuloBase.Pedido;

public class MetodoDescontoEntregaValorPedido implements IFormaDescontoTaxaEntrega{

    @Override
    public void calcularPedido(Pedido pedido) {
        if(seAplica(pedido)){
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("DESCONTO POR VALOR DO PEDIDO", 0.15));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido.getSomaItens()>2000){
            return true;
        }

        return false;
    }
}
