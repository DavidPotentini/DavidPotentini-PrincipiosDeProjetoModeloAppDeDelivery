package org.example.ModuloDescontosPedido;

import org.example.ModuloCupomDesconto.CupomDescontoPedido;
import org.example.ModuloBase.Item;
import org.example.ModuloBase.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetodoDescontoPedidoTipoItem implements IFormaDescontoPedido{
    private Map<String, Double> descontosPorItem = new HashMap<>();
    private List<IFormaDescontoPedido> metodosDeDesconto = new ArrayList<>();

    public MetodoDescontoPedidoTipoItem(){
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

            pedido.aplicarDescontoPedido(new CupomDescontoPedido("DESCONTO POR TIPO DE ITEM", somaDescontosItem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        metodosDeDesconto.add(new MetodoDescontoPedidoTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoPedidoCodigoCupom());

        for(IFormaDescontoPedido metodo: metodosDeDesconto){
            if(metodo.seAplica(pedido)){
                return false;
            }
        }

        for(Item item: pedido.getItensList()) {
            Double verificaExistencia = descontosPorItem.get(item.getTipo());
            if (verificaExistencia != null) {
                return true;
            }
        }
        return false;
    }
}
