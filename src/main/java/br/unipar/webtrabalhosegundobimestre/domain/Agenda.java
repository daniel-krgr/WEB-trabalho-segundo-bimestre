package br.unipar.webtrabalhosegundobimestre.domain;

import br.unipar.webtrabalhosegundobimestre.dto.AgendaCancelRequestDTO;
import br.unipar.webtrabalhosegundobimestre.dto.AgendaInsertRequestDTO;

public class Agenda {
    private int id;
    private int idMedico;
    private int idPaciente;
    private String dataAgendamento;
    private String  horaInicio;
    private String horaFim;
    private String crm;
    private String cpf;
    private String motivoCancelamento;

    public Agenda() {

    }

    public Agenda(Integer id, AgendaInsertRequestDTO agendaInsertRequestDTO) {
        this.id = id;
        this.dataAgendamento = agendaInsertRequestDTO.getDataAgendamento();
        this.horaInicio = agendaInsertRequestDTO.getHoraInicio();
        this.horaFim = agendaInsertRequestDTO.getHoraFim();
        this.crm = agendaInsertRequestDTO.getCrm();
        this.cpf = agendaInsertRequestDTO.getCpf();
    }

    public Agenda(AgendaInsertRequestDTO agendaDTO) {
        this.dataAgendamento = agendaDTO.getDataAgendamento();
        this.horaInicio = agendaDTO.getHoraInicio();
        this.horaFim = agendaDTO.getHoraFim();
        this.crm = agendaDTO.getCrm();
        this.cpf = agendaDTO.getCpf();

    }

    public Agenda(Integer id, AgendaCancelRequestDTO agendaCancelRequestDTO) {
        this.id = id;
        this.dataAgendamento = agendaCancelRequestDTO.getDataAgendamento();
        this.cpf = agendaCancelRequestDTO.getCpf();
        this.motivoCancelamento = agendaCancelRequestDTO.getMotivo();
    }

    public Agenda(AgendaCancelRequestDTO agendaDTO) {
        this.dataAgendamento = agendaDTO.getDataAgendamento();
        this.cpf = agendaDTO.getCpf();
        this.motivoCancelamento = agendaDTO.getMotivo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }
}
