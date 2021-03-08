package br.com.zup.cadastro.DTO;

import br.com.zup.cadastro.models.Cadastro;

public class CadastroDTO {

    private String nome;
    private int idade;
    private String cpf;

    public CadastroDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Cadastro converterDTOParaCadastro(CadastroDTO cadastroDTO){
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(cadastroDTO.getNome());
        cadastro.setCpf(cadastroDTO.getCpf());
        cadastro.setIdade(cadastroDTO.getIdade());

        return cadastro;
    }
}
