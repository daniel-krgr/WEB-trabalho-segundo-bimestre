package br.unipar.webtrabalhosegundobimestre.dto;

import br.unipar.webtrabalhosegundobimestre.domain.EnderecoPaciente;

public class PacienteInsertRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private EnderecoPaciente endereco;
    private boolean ativo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoPaciente getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoPaciente endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
