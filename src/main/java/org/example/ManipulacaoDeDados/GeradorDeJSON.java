package org.example.ManipulacaoDeDados;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.ModuloRegistroDeLog.DadosParaRegistro;

import java.io.FileWriter;


public class GeradorDeJSON implements IManipuladorDeDadosParaLog {
    private Gson gson;
    public GeradorDeJSON(){
        this.gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void gerar(DadosParaRegistro dados){
        try {
            FileWriter fileWriter = new FileWriter("log.json");
            fileWriter.write(gson.toJson(dados));
            fileWriter.close();
        }catch(Exception e){
            System.out.println("Erro inesperado: "+ e);
        }
    }
}
