package br.unipar.webtrabalhosegundobimestre.domain;

import br.unipar.webtrabalhosegundobimestre.Enums.EspecialidadeMedicoEnum;
import br.unipar.webtrabalhosegundobimestre.dto.MedicoEditRequestDTO;
import br.unipar.webtrabalhosegundobimestre.dto.MedicoInsertRequestDTO;

public class Medico {

    //Nome E-mail Telefone CRM Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia) Endereço completo

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private EspecialidadeMedicoEnum especialidade;
    private String crm;
    private EnderecoMedico endereco;
    private boolean ativo;

    public Medico() { }

    public Medico(Integer id, MedicoInsertRequestDTO medicoInsertRequestDTO) {
        this.id = id;
        this.nome = medicoInsertRequestDTO.getNome();
        this.telefone = medicoInsertRequestDTO.getTelefone();
        this.email = medicoInsertRequestDTO.getEmail();
        this.especialidade = medicoInsertRequestDTO.getEspecialidade();
        this.crm = medicoInsertRequestDTO.getCrm();
        this.endereco = medicoInsertRequestDTO.getEndereco();
        this.ativo = true;
    }

    public Medico(MedicoInsertRequestDTO medicoDTO) {;
        this.nome = medicoDTO.getNome();
        this.telefone = medicoDTO.getTelefone();
        this.email = medicoDTO.getEmail();
        this.especialidade = medicoDTO.getEspecialidade();
        this.crm = medicoDTO.getCrm();
        this.endereco = medicoDTO.getEndereco();
        this.ativo = true;
    }

    public Medico(Integer id, MedicoEditRequestDTO medicoEditRequestDTO) {
        this.id = id;
        this.nome = medicoEditRequestDTO.getNome();
        this.telefone = medicoEditRequestDTO.getTelefone();
        this.crm = medicoEditRequestDTO.getCrm();
        this.ativo = medicoEditRequestDTO.isAtivo();
        this.endereco = medicoEditRequestDTO.getEnderecoMedico();
    }

    public Medico(MedicoEditRequestDTO medicoDTO) {
        this.nome = medicoDTO.getNome();
        this.telefone = medicoDTO.getTelefone();
        this.crm = medicoDTO.getCrm();
        this.ativo = medicoDTO.isAtivo();
        this.endereco = medicoDTO.getEnderecoMedico();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public EspecialidadeMedicoEnum getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(EspecialidadeMedicoEnum especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EnderecoMedico getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoMedico endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", especialidade=" + especialidade +
                ", crm='" + crm + '\'' +
                ", endereco=" + endereco +
                ", ativo=" + ativo +
                '}';
    }
}
