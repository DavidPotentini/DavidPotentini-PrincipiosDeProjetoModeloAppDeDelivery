package org.example.ModuloRegistroDeLog;
import java.util.Date;

public class DadosParaRegistro {
    private String nomeDoUsuario;
    private Date dataEHoraDeRegistro; //Utilizei data e hora juntos pois a bliblioteca do Gson aceita somente
                                      //tipos de tempo com data e hora conjuntas como timestamp e sql.date
                                      //A alternativa de colocar mais dependencias para adapatdores ou utilizar valueof por exemplo
                                      //Nao me pareceram melhores do que essa
    private Integer codigoDoPedido;
    private String nomeOperacao;


    public DadosParaRegistro(Date dataEHoraDeRegistro, int codigoDoPedido) {
        this.nomeDoUsuario = UsuarioLogadoService.getNomeUsuario();
        this.dataEHoraDeRegistro = dataEHoraDeRegistro;
        this.codigoDoPedido = codigoDoPedido;
        this.nomeOperacao = "Calculo do valor total do pedido (getValorPedido())";
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public Integer getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public Date getdataEHoraDeRegistro() {
        return dataEHoraDeRegistro;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }
}
