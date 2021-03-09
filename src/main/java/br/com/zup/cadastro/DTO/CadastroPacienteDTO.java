package br.com.zup.cadastro.DTO;

import br.com.zup.cadastro.models.Cadastro;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class CadastroPacienteDTO {

    @Email(message = "email inválido")
    private String email;
    private String nome;
    @Min(message = "Idade mínima 18 anos", value = 18)
    private int idade;
    @CPF(message = "CPF inválido")
    private String cpf;

    public CadastroPacienteDTO() {
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

    public Cadastro converterDTOParaCadastro(){
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(this.nome);
        cadastro.setCpf(this.cpf);
        cadastro.setIdade(this.idade);

        return cadastro;
    }
}
