package org.example.ModuloDescontosTaxaDeEntrega;

import org.example.ModuloCupomDesconto.CupomDescontoEntrega;
import org.example.ModuloBase.*;
import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoEntregaTaxaPorBairro implements IFormaDescontoTaxaEntrega {
    private Map<String, Double> descontosPorBairroCliente = new HashMap<>();

    public MetodoDescontoEntregaTaxaPorBairro(){
        descontosPorBairroCliente.put("Centro", 0.2);
        descontosPorBairroCliente.put("Bela Vista", 0.3);
        descontosPorBairroCliente.put("Cidade Maravilhosa", 0.15);
    }
    @Override
    public void calcularPedido(Pedido pedido) {
        if(seAplica(pedido)){
            String bairro = pedido.getCliente().getBairro();
            Double porcentagem = descontosPorBairroCliente.get(bairro);

            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("DESCONTO POR BAIRRO", porcentagem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        String bairro = pedido.getCliente().getBairro();
        Double verificaExistencia = descontosPorBairroCliente.get(bairro);

        if(verificaExistencia != null){
            return true;
        }
        else{
            return false;
        }
    }
}
