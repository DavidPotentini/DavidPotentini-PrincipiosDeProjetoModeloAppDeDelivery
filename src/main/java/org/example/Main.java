package org.example;

import com.google.gson.JsonObject;
import org.example.ModuloBase.*;
import org.example.ModuloDescontosPedido.CalculadoraDeDescontoPedidosService;
import org.example.ModuloDescontosTaxaDeEntrega.CalculadoraDeDescontoEntregaService;
import org.example.ModuloRegistroDeLog.*;
import ModuloConexaoBancoDeDados.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
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


        LogService logService = new LogService(new LogDB(new ConexaoSQLite()));
        IPedido pedidoComLogDecorator = new PedidoComLogDecorator(pedido, logService);

        System.out.println(pedidoComLogDecorator.getValorPedido());

        System.out.println(pedido.getDescontoConcedidoEntrega());

        System.out.println(pedido.getDescontoConcedidoPedido());

        System.out.println(pedido.getValorPedido());


        //ILog log1 = new LogJSON();
        //log1.escrever(new DadosParaRegistro(new Date(), 2));


        //ILog log2 = new LogXML();
        //log2.escrever(new DadosParaRegistro("Jose", "24/01/2002", "15 horas", 5, "Calculando Pedido"));
    }
}