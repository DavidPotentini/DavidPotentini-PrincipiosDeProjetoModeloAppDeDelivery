package org.example;

import org.example.ModuloBase.*;
import org.example.ModuloDescontosPedido.CalculadoraDeDescontoPedidosService;
import org.example.ModuloDescontosTaxaDeEntrega.CalculadoraDeDescontoEntregaService;
import org.example.ModuloRegistroDeLog.*;
import org.example.ModuloConexaoBancoDeDados.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente("Cidade Maravilhosa", null, "David", 2, "Rua Neves Armond", "Alegre");
        Item item1 = new Item("Hamburguer", 2, 20.00, "Alimentação");
        Item item2 = new Item("Caderno", 1, 100.00, "Educação");

        Pedido pedido = new Pedido(new Date(), cliente, 1);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        pedido.setCodigoCupom("DESC10");

        CalculadoraDeDescontoEntregaService serviceEntrega = new CalculadoraDeDescontoEntregaService();
        serviceEntrega.calcularDesconto(pedido);

        CalculadoraDeDescontoPedidosService servicePedido = new CalculadoraDeDescontoPedidosService();
        servicePedido.calcularDesconto(pedido);



        LogService logService1 = new LogService(new LogXML());
        //LogService logService2 = new LogService(new LogJSON());
        //LogService logService3 = new LogService(new LogDB(new ConexaoSQLite()));

        IPedido pedidoComLogDecorator = new PedidoComLogDecorator(pedido, logService1);

        System.out.println("Valor total do pedido: " + pedidoComLogDecorator.getValorPedido());

        System.out.println("Desconto concedido sobre o valor da entrega: "+ pedido.getDescontoConcedidoEntrega());

        System.out.println("Desconto concedido sobre o valor do pedido: " + pedido.getDescontoConcedidoPedido());


    }
}