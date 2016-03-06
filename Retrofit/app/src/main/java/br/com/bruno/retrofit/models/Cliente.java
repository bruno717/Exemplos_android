package br.com.bruno.retrofit.models;

/**
 * Created by Bruno on 06/03/2016.
 */
public class Cliente {

    private Integer id;
    private PessoaFisica pessoaFisica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

}

