package org.example.ModuloDescontosTaxaDeEntrega;
import org.example.ModuloBase.Pedido;

public interface IFormaDescontoTaxaEntrega {
    public void calcularPedido(Pedido pedido);
    public boolean seAplica(Pedido pedido);

}
