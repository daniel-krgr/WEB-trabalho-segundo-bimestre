package br.unipar.webtrabalhosegundobimestre.domain;

public class EnderecoMedico {

    //logradouro, número, complemento, bairro

    private int id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    public EnderecoMedico() {
    }

    public EnderecoMedico(String logradouro, String numero, String complemento, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    @Override
    public String toString() {
        return "EnderecoMedico{" +
                "logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
