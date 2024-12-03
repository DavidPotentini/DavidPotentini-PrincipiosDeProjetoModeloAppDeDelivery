package org.example.ModuloDescontosTaxaDeEntrega;

import org.example.ModuloCupomDesconto.CupomDescontoEntrega;
import org.example.ModuloBase.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetodoDescontoEntregaTipoItem implements IFormaDescontoTaxaEntrega {
    Map<String, Double> descontosPorItem = new HashMap<>();

    public MetodoDescontoEntregaTipoItem(){
        descontosPorItem.put("Alimentação", 0.05);
        descontosPorItem.put("Educação", 0.2);
        descontosPorItem.put("Lazer", 0.15);
    }


    @Override
    public void calcularPedido(Pedido pedido) {
        List<Item> listaDeItensCopia = pedido.getItensList();
        double somaDescontosItem = 0;
        if (seAplica(pedido)){
            for(Item item: listaDeItensCopia){
                Double porcentagem = descontosPorItem.get(item.getTipo());
                somaDescontosItem += porcentagem;
            }

            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("DESCONTO POR TIPO DE ITEM", somaDescontosItem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {

        for(Item item: pedido.getItensList()) {
            Double verificaExistencia = descontosPorItem.get(item.getTipo());
            if (verificaExistencia != null) {
                return true;
            }
        }
        return false;
    }
}
