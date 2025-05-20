package br.unipar.webtrabalhosegundobimestre.services;

import br.unipar.webtrabalhosegundobimestre.domain.Agenda;
import br.unipar.webtrabalhosegundobimestre.domain.Medico;
import br.unipar.webtrabalhosegundobimestre.domain.Paciente;
import br.unipar.webtrabalhosegundobimestre.exceptions.BusinessException;
import br.unipar.webtrabalhosegundobimestre.repositories.AgendaRepository;
import br.unipar.webtrabalhosegundobimestre.repositories.MedicoRepository;
import br.unipar.webtrabalhosegundobimestre.repositories.PacienteRepository;

import java.time.LocalTime;

public class AgendaService {

    private AgendaRepository agendaRepository;
    private MedicoRepository medicoRepository;
    private PacienteRepository pacienteRepository;

    public AgendaService() {
        agendaRepository = new AgendaRepository();
        medicoRepository = new MedicoRepository();
        pacienteRepository = new PacienteRepository();
    }

    public Agenda inserir(Agenda agenda) throws BusinessException, Exception {

        // verifica se esta no horario de funcionamento de das 07:00 às 19:00;
        LocalTime horaInicio = LocalTime.parse(agenda.getHoraInicio());
        if (horaInicio.isBefore(LocalTime.of(7, 0)) || horaInicio.isAfter(LocalTime.of(19, 0))) {
            throw new BusinessException("A consulta deve ser agendada dentro do horário de funcionamento (07:00 às 19:00).");
        }

        // verifica se o prozo do horario inicial e horario final e de 1 hora
        LocalTime horaFim = LocalTime.parse(agenda.getHoraFim());
        if (horaFim.isBefore(horaInicio.plusHours(1))) {
            throw new BusinessException("O horário final deve ser pelo menos 1 hora após o horário inicial.");
        }

        //verifica se o horario inicial esta 30 minutos antes do horario atual
        if (horaInicio.isBefore(LocalTime.now().plusMinutes(30))) {
            throw new BusinessException("A consulta deve ser agendada com antecedência mínima de 30 minutos.");
        }


        //verifica se ja tem um agendamento para esta data
        Agenda agendaDate = new Agenda();
        agendaDate = agendaRepository.BuscarPorDataPaciente(java.sql.Date.valueOf(agenda.getDataAgendamento()), agenda.getIdPaciente());
        if (agendaDate != null) {
            throw new BusinessException("Já existe um agendamento para esta data.");
        }

        // converte o crm no id do medico
        //verifica se o medico esta ativo no sistema
        Medico medico = medicoRepository.BuscarPorCrm(agenda.getCrm());
        if (medico == null) {
            throw new BusinessException("CRM não encontrado ou medico inativo no sistema");
        }else{
            agenda.setIdMedico(medico.getId());
        }


        // convete cpf do paciente no id do paciente
        // tambem ja verifica se encontra o paciente ativo no banco de dados
        Paciente paciente = pacienteRepository.BuscarPorCpf(agenda.getCpf());
        if (paciente == null) {
            throw new BusinessException("CPF não encontrado ou paciente inativo");
        }else{
            agenda.setIdPaciente(paciente.getId());
        }

        return agendaRepository.inserir(agenda);
    }

    public Agenda cancelar(Agenda agenda) throws BusinessException, Exception {

        // convete cpf do paciente no id do paciente
        Paciente paciente = pacienteRepository.BuscarPorCpf(agenda.getCpf());
        if (paciente == null) {
            throw new BusinessException("CPF não encontrado ou paciente inativo");
        }else{
            agenda.setIdPaciente(paciente.getId());
        }

        return agendaRepository.cancelar(java.sql.Date.valueOf(agenda.getDataAgendamento()), agenda.getIdPaciente());

    }

}
