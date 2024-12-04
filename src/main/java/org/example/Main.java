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


        //LogService logService = new LogService(new LogDB(new ConexaoSQLite()));
        LogService logService = new LogService(new LogJSON());
        //LogService logService = new LogService(new LogXML());
        IPedido pedidoComLogDecorator = new PedidoComLogDecorator(pedido, logService);

        System.out.println(pedidoComLogDecorator.getValorPedido());

        System.out.println(pedido.getDescontoConcedidoEntrega());

        System.out.println(pedido.getDescontoConcedidoPedido());


    }
}