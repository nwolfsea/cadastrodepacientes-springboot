package br.com.zup.cadastro.exceptions;


import java.util.List;

public class RespostaDeErro {
    private String tipoDeErro;
    private int codigo;
    private String status;
    private List<ObjetoDeErro> objetoDeErro;

    public RespostaDeErro() {
    }

    public RespostaDeErro(String tipoDeErro, int codigo, String status, List<ObjetoDeErro> objetoDeErro) {
        this.tipoDeErro = tipoDeErro;
        this.codigo = codigo;
        this.status = status;
        this.objetoDeErro = objetoDeErro;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ObjetoDeErro> getObjetoDeErro() {
        return objetoDeErro;
    }

    public void setObjetoDeErro(List<ObjetoDeErro> objetoDeErro) {
        this.objetoDeErro = objetoDeErro;
    }
}
