package br.unipar.webtrabalhosegundobimestre.dto;

import br.unipar.webtrabalhosegundobimestre.domain.EnderecoMedico;

public class MedicoEditRequestDTO {


    private String nome;
    private String telefone;
    private EnderecoMedico enderecoMedico;
    private boolean ativo;
    private String crm;

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

    public EnderecoMedico getEnderecoMedico() {
        return enderecoMedico;
    }
    public void setEnderecoMedico(EnderecoMedico enderecoMedico) {
        this.enderecoMedico = enderecoMedico;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

}
