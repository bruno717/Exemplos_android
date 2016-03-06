package br.com.bruno.retrofit.models;

/**
 * Created by Bruno on 06/03/2016.
 */
public class PessoaFisica {

    private Long cpf;
    private Pessoa pessoa = new Pessoa();

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
