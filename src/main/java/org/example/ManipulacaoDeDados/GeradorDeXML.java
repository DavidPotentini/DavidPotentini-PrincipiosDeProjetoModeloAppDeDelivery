package org.example.ManipulacaoDeDados;

import org.example.ModuloRegistroDeLog.DadosParaRegistro;

import java.io.FileWriter;
import java.text.SimpleDateFormat;

public class GeradorDeXML implements IManipuladorDeDadosParaLog {

    @Override
    public void gerar(DadosParaRegistro dados){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = sdf.format(dados.getDataEHoraDeRegistro());

        StringBuilder xml = new StringBuilder();
        xml.append("<registro>\n");
        xml.append("    <nome>").append(dados.getNomeDoUsuario()).append("</nome>\n");
        xml.append("    <dataRegistro>").append(dataFormatada).append("</dataRegistro>\n");
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
