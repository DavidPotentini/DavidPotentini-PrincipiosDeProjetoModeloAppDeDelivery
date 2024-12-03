package org.example.ManipulacaoDeDados;

import org.example.ModuloRegistroDeLog.DadosParaRegistro;

import java.io.FileWriter;

public class GeradorDeXML implements IGeradorDeDocumentos {

    @Override
    public void gerar(DadosParaRegistro dados){
        StringBuilder xml = new StringBuilder();
        xml.append("<registro>\n");
        xml.append("    <nome>").append(dados.getNomeDoUsuario()).append("</nome>\n");
        xml.append("    <dataRegistro>").append(dados.getdataEHoraDeRegistro()).append("</dataRegistro>\n");
        xml.append("    <codigo>").append(dados.getCodigoDoPedido()).append("</codigo>\n");
        xml.append("    <operacao>").append(dados.getNomeOperacao()).append("</operacao>\n");
        xml.append("</registro>\n");

        try {
            FileWriter fileWriter = new FileWriter("log.xml");
            fileWriter.write(xml.toString());
            fileWriter.close();
        }catch(Exception e){
            System.out.println("Erro inesperado: "+e);
        }
    }
}
