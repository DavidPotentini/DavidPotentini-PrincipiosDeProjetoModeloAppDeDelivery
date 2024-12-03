package org.example.ModuloDescontosPedido;

import org.example.ModuloCupomDesconto.CupomDescontoPedido;
import org.example.ModuloBase.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoPedidoTipoCliente implements IFormaDescontoPedido{
    Map<String, Double> descontosPorTipoCliente = new HashMap<>();

    public MetodoDescontoPedidoTipoCliente() {
        descontosPorTipoCliente.put("Ouro", 0.3);
        descontosPorTipoCliente.put("Prata", 0.2);
        descontosPorTipoCliente.put("Bronze", 0.1);
    }

    @Override
    public void calcularPedido(Pedido pedido) {
        if(seAplica(pedido)){
            String tipo = pedido.getCliente().getTipo();
            Double porcentagem = descontosPorTipoCliente.get(tipo);

            pedido.aplicarDescontoPedido(new CupomDescontoPedido("DESCONTO POR TIPO DE CLIENTE", porcentagem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        String tipo = pedido.getCliente().getTipo();
        Double verificaExistencia = descontosPorTipoCliente.get(tipo);

        if(verificaExistencia != null){
            return true;
        }
        else{
            return false;
        }
    }
}
