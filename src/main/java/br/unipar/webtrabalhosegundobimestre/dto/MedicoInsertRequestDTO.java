package br.unipar.webtrabalhosegundobimestre.dto;

import br.unipar.webtrabalhosegundobimestre.Enums.EspecialidadeMedicoEnum;
import br.unipar.webtrabalhosegundobimestre.domain.EnderecoMedico;

public class MedicoInsertRequestDTO {

    private String nome;
    private String telefone;
    private String email;
    private EspecialidadeMedicoEnum especialidade;
    private String crm;
    private EnderecoMedico endereco;
    private boolean ativo;

    public String getNome() { return nome; }
    public void setNome(String nome) {this.nome = nome;}

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email;}

    public EspecialidadeMedicoEnum getEspecialidade() { return especialidade; }
    public void setEspecialidade(EspecialidadeMedicoEnum especialidade) {this.especialidade = especialidade;}

    public String getCrm() { return crm; }
    public void setCrm(String crm) {this.crm = crm;}

    public EnderecoMedico getEndereco() { return endereco; }
    public void setEndereco(EnderecoMedico endereco) {this.endereco = endereco;}

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) {this.ativo = ativo;}

}
