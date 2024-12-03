package org.example.ModuloDescontosPedido;

import org.example.ModuloCupomDesconto.CupomDescontoPedido;
import org.example.ModuloBase.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoPedidoCodigoCupom implements IFormaDescontoPedido {
    private Map<String, Double> descontosPorCodigoCupom = new HashMap<>();

    public MetodoDescontoPedidoCodigoCupom(){
        descontosPorCodigoCupom.put("DESC10", 0.10);
        descontosPorCodigoCupom.put("DESC20", 0.20);
        descontosPorCodigoCupom.put("DESC30", 0.30);
    }

    @Override
    public void calcularPedido(Pedido pedido) {
        if(seAplica(pedido)){
            String codigoCupom = pedido.getCodigoCupom();
            Double porcentagem = descontosPorCodigoCupom.get(codigoCupom);

            pedido.aplicarDescontoPedido(new CupomDescontoPedido("DESCONTO POR CODIGO DO CUPOM", porcentagem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        String codigoCupom = pedido.getCodigoCupom();
        Double verificaExistencia = descontosPorCodigoCupom.get(codigoCupom);
        if(verificaExistencia != null){
            return true;
        }
        return false;
    }
}
