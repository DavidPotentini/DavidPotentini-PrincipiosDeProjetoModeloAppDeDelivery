package org.example.ModuloBase;

import org.example.ModuloCupomDesconto.CupomDescontoEntrega;
import org.example.ModuloCupomDesconto.CupomDescontoPedido;
import org.example.ModuloRegistroDeLog.DadosParaRegistro;
import org.example.ModuloRegistroDeLog.ILog;
import org.example.ModuloRegistroDeLog.LogService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private LocalDate data;
    private Cliente cliente;
    private List<CupomDescontoEntrega> cupomDescontoEntregaList = new ArrayList<>();
    private List<CupomDescontoPedido> cupomDescontoPedidoList = new ArrayList<>();
    private List<Item> itensList = new ArrayList<>();
    private String codigoCupom;
    private ILog iLog;
    private LogService logService;
    private int codigoPedido;

    public Pedido(LocalDate data, Cliente cliente, ILog iLog, int codigoPedido){
        this.data = data;
        this.cliente = cliente;
        this.iLog = iLog;
        this.codigoPedido = codigoPedido;

        logService = new LogService(iLog);

        taxaEntrega = 10;
    }

    public void setCodigoCupom(String codigoCupom){
        this.codigoCupom = codigoCupom;
    }

    public String getCodigoCupom(){
        return this.codigoCupom;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void aplicarDescontoTaxaEntrega(CupomDescontoEntrega desconto){
        cupomDescontoEntregaList.add(desconto);
    }
    public void aplicarDescontoPedido(CupomDescontoPedido desconto){
        cupomDescontoPedidoList.add(desconto);
    }

    public double getDescontoConcedidoPedido(){
        double descontoPorcentagemTotal = 0;
        for(CupomDescontoPedido desconto: cupomDescontoPedidoList){
            descontoPorcentagemTotal += desconto.getPorcentagemDesconto();
        }

        return (descontoPorcentagemTotal * getSomaItens());
    }

    public double getDescontoConcedidoEntrega(){
        double descontoPorcentagemTotal = 0;
        for(CupomDescontoEntrega desconto: cupomDescontoEntregaList){
            descontoPorcentagemTotal += desconto.getPorcentagemDesconto();
        }
        if(descontoPorcentagemTotal >= 1){
            return 10;
        }

        return (descontoPorcentagemTotal * taxaEntrega);
    }

    public List<CupomDescontoEntrega> getCupomDescontoEntrega() {
        return cupomDescontoEntregaList;
    }

    public void adicionarItem(Item item){
        itensList.add(item);
    }

    public List<Item> getItensList() {
        return itensList;
    }

    public double getSomaItens(){
        double valorTotal = 0;
        for(Item item : getItensList()){
            valorTotal += item.getValorTotal();
        }

        return  valorTotal;
    }

    public double getValorPedido(){
        logService.escrever(new DadosParaRegistro(new Date(), codigoPedido));

        double valorComDesconto = (getSomaItens() - getDescontoConcedidoPedido()) + (taxaEntrega - getDescontoConcedidoEntrega());
        return valorComDesconto;
    }

}
