package org.example.ModuloDescontosPedido;

import org.example.ModuloBase.Pedido;

public interface IFormaDescontoPedido {
    public void calcularPedido(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
