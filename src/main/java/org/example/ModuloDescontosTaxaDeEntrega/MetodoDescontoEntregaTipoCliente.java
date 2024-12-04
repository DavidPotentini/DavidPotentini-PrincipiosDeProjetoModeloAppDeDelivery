package org.example.ModuloDescontosTaxaDeEntrega;

import org.example.ModuloCupomDesconto.CupomDescontoEntrega;
import org.example.ModuloBase.*;
import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoEntregaTipoCliente implements IFormaDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoCliente = new HashMap<>();

    public MetodoDescontoEntregaTipoCliente() {
        descontosPorTipoCliente.put("Ouro", 0.3);
        descontosPorTipoCliente.put("Prata", 0.2);
        descontosPorTipoCliente.put("Bronze", 0.1);
    }

    @Override
    public void calcularPedido(Pedido pedido) {
        if(seAplica(pedido)){
            String tipo = pedido.getCliente().getTipo();
            Double porcentagem = descontosPorTipoCliente.get(tipo);

            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("DESCONTO POR TIPO DE CLIENTE", porcentagem));
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
