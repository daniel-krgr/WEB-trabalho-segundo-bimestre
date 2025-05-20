package br.unipar.webtrabalhosegundobimestre.dto;

import br.unipar.webtrabalhosegundobimestre.domain.EnderecoPaciente;

public class PacienteEditRequestDTO {
    private String nome;
    private String telefone;
    private EnderecoPaciente enderecoPaciente;
    private boolean ativo;
    private String cpf;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoPaciente getEnderecoPaciente() {
        return enderecoPaciente;
    }
    public void setEnderecoPaciente(EnderecoPaciente enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
