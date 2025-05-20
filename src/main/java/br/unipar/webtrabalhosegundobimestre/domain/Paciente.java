package br.unipar.webtrabalhosegundobimestre.domain;

import br.unipar.webtrabalhosegundobimestre.dto.PacienteEditRequestDTO;
import br.unipar.webtrabalhosegundobimestre.dto.PacienteInsertRequestDTO;

public class Paciente {

    //Nome E-mail Telefone CPF Endereço completo (logradouro, número, complemento, bairro, cidade, UF e CEP)

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private EnderecoPaciente endereco;
    private boolean ativo;

    public Paciente() { }

    public Paciente(Integer id, PacienteInsertRequestDTO pacienteInsertRequestDTO) {
        this.id = id;
        this.nome = pacienteInsertRequestDTO.getNome();
        this.cpf = pacienteInsertRequestDTO.getCpf();
        this.telefone = pacienteInsertRequestDTO.getTelefone();
        this.email = pacienteInsertRequestDTO.getEmail();
        this.endereco = pacienteInsertRequestDTO.getEndereco();
        this.ativo = pacienteInsertRequestDTO.isAtivo();
    }

    public Paciente(PacienteInsertRequestDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.cpf = pacienteDTO.getCpf();
        this.telefone = pacienteDTO.getTelefone();
        this.email = pacienteDTO.getEmail();
        this.endereco = pacienteDTO.getEndereco();
        this.ativo = pacienteDTO.isAtivo();
    }

    public Paciente(Integer id, PacienteEditRequestDTO pacienteEditRequestDTO) {
        this.id = id;
        this.nome = pacienteEditRequestDTO.getNome();
        this.telefone = pacienteEditRequestDTO.getTelefone();
        this.endereco = pacienteEditRequestDTO.getEnderecoPaciente();
        this.ativo = pacienteEditRequestDTO.isAtivo();
        this.cpf = pacienteEditRequestDTO.getCpf();
    }

    public Paciente(PacienteEditRequestDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.telefone = pacienteDTO.getTelefone();
        this.endereco = pacienteDTO.getEnderecoPaciente();
        this.ativo = pacienteDTO.isAtivo();
        this.cpf = pacienteDTO.getCpf();
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

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", ativo=" + ativo +
                '}';
    }
}
