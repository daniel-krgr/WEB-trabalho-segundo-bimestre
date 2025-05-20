package br.unipar.webtrabalhosegundobimestre.services;

import br.unipar.webtrabalhosegundobimestre.domain.Paciente;
import br.unipar.webtrabalhosegundobimestre.exceptions.BusinessException;
import br.unipar.webtrabalhosegundobimestre.repositories.PacienteRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService() {
        pacienteRepository = new PacienteRepository();
    }

    public Paciente inserir(Paciente paciente) throws BusinessException, SQLException, NamingException {

        //Nome E-mail Telefone CPF Endereço completo (logradouro, número, complemento, bairro, cidade, UF e CEP)



        if (paciente.getNome() == null || paciente.getNome().isEmpty()) {
            throw new BusinessException("Nome do paciente é obrigatório");
        }
        if (paciente.getNome().length() > 100) {
            throw new BusinessException("Nome do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getNome().length() < 3) {
            throw new BusinessException("Nome do paciente deve ter no mínimo 3 caracteres");
        }

        if (paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
            throw new BusinessException("CPF do paciente é obrigatório");
        }
        if (paciente.getCpf().length() > 11 || paciente.getCpf().length() < 11) {
            throw new BusinessException("CPF do paciente deve ter 11 caracteres");
        }

        if (paciente.getTelefone() == null || paciente.getTelefone().isEmpty()) {
            throw new BusinessException("Telefone do paciente é obrigatório");
        }
        if (paciente.getTelefone().length() > 15 || paciente.getTelefone().length() < 10) {
            throw new BusinessException("Telefone do paciente deve ter entre 10 e 15 caracteres");
        }

        if (paciente.getEmail() == null || paciente.getEmail().isEmpty()) {
            throw new BusinessException("E-mail do paciente é obrigatório");
        }
        if (paciente.getEmail().length() > 100) {
            throw new BusinessException("E-mail do paciente deve ter no máximo 100 caracteres");
        }
//        if (paciente.getEmail().contains("@") == false) {
//            throw new BusinessException("E-mail inválido");
//        }



        if (paciente.getEndereco() == null) {
            throw new BusinessException("Endereço do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro() == null || paciente.getEndereco().getLogradouro().isEmpty()) {
            throw new BusinessException("Logradouro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro().length() > 100) {
            throw new BusinessException("Logradouro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getBairro() == null || paciente.getEndereco().getBairro().isEmpty()) {
            throw new BusinessException("Bairro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getBairro().length() > 100) {
            throw new BusinessException("Bairro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getCidade() == null || paciente.getEndereco().getCidade().isEmpty()) {
            throw new BusinessException("Cidade do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCidade().length() > 100) {
            throw new BusinessException("Cidade do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getUf() == null || paciente.getEndereco().getUf().isEmpty()) {
            throw new BusinessException("UF do paciente é obrigatório");
        }
        if (paciente.getEndereco().getUf().length() > 2 || paciente.getEndereco().getUf().length() < 2) {
            throw new BusinessException("UF do paciente deve ter 2 caracteres");
        }
        if (paciente.getEndereco().getCep() == null || paciente.getEndereco().getCep().isEmpty()) {
            throw new BusinessException("CEP do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCep().length() > 8 || paciente.getEndereco().getCep().length() < 8) {
            throw new BusinessException("CEP do paciente deve ter 8 caracteres");
        }
        if (paciente.getEndereco().getNumero() != null && paciente.getEndereco().getNumero().length() > 10) {
            throw new BusinessException("Número do paciente deve ter no máximo 10 caracteres");
        }
        if (paciente.getEndereco().getComplemento() != null && paciente.getEndereco().getComplemento().length() > 100) {
            throw new BusinessException("Complemento do paciente deve ter no máximo 100 caracteres");
        }

        return pacienteRepository.inserir(paciente);



    }

    public Paciente editar(Paciente paciente) throws BusinessException, SQLException, NamingException {


        if (paciente.getNome() == null || paciente.getNome().isEmpty()) {
            throw new BusinessException("Nome do paciente é obrigatório");
        }
        if (paciente.getNome().length() > 100) {
            throw new BusinessException("Nome do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getNome().length() < 3) {
            throw new BusinessException("Nome do paciente deve ter no mínimo 3 caracteres");
        }

        if (paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
            throw new BusinessException("CPF do paciente é obrigatório");
        }
        if (paciente.getCpf().length() > 11 || paciente.getCpf().length() < 11) {
            throw new BusinessException("CPF do paciente deve ter 11 caracteres");
        }

        if (paciente.getTelefone() == null || paciente.getTelefone().isEmpty()) {
            throw new BusinessException("Telefone do paciente é obrigatório");
        }
        if (paciente.getTelefone().length() > 15 || paciente.getTelefone().length() < 10) {
            throw new BusinessException("Telefone do paciente deve ter entre 10 e 15 caracteres");
        }


        if (paciente.getEndereco() == null) {
            throw new BusinessException("Endereço do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro() == null || paciente.getEndereco().getLogradouro().isEmpty()) {
            throw new BusinessException("Logradouro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro().length() > 100) {
            throw new BusinessException("Logradouro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getBairro() == null || paciente.getEndereco().getBairro().isEmpty()) {
            throw new BusinessException("Bairro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getBairro().length() > 100) {
            throw new BusinessException("Bairro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getCidade() == null || paciente.getEndereco().getCidade().isEmpty()) {
            throw new BusinessException("Cidade do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCidade().length() > 100) {
            throw new BusinessException("Cidade do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getUf() == null || paciente.getEndereco().getUf().isEmpty()) {
            throw new BusinessException("UF do paciente é obrigatório");
        }
        if (paciente.getEndereco().getUf().length() > 2 || paciente.getEndereco().getUf().length() < 2) {
            throw new BusinessException("UF do paciente deve ter 2 caracteres");
        }
        if (paciente.getEndereco().getCep() == null || paciente.getEndereco().getCep().isEmpty()) {
            throw new BusinessException("CEP do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCep().length() > 8 || paciente.getEndereco().getCep().length() < 8) {
            throw new BusinessException("CEP do paciente deve ter 8 caracteres");
        }
        if (paciente.getEndereco().getNumero() != null && paciente.getEndereco().getNumero().length() > 10) {
            throw new BusinessException("Número do paciente deve ter no máximo 10 caracteres");
        }
        if (paciente.getEndereco().getComplemento() != null && paciente.getEndereco().getComplemento().length() > 100) {
            throw new BusinessException("Complemento do paciente deve ter no máximo 100 caracteres");
        }

        if (paciente.getEndereco() == null) {
            throw new BusinessException("Endereço do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro() == null || paciente.getEndereco().getLogradouro().isEmpty()) {
            throw new BusinessException("Logradouro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getLogradouro().length() > 100) {
            throw new BusinessException("Logradouro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getBairro() == null || paciente.getEndereco().getBairro().isEmpty()) {
            throw new BusinessException("Bairro do paciente é obrigatório");
        }
        if (paciente.getEndereco().getBairro().length() > 100) {
            throw new BusinessException("Bairro do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getCidade() == null || paciente.getEndereco().getCidade().isEmpty()) {
            throw new BusinessException("Cidade do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCidade().length() > 100) {
            throw new BusinessException("Cidade do paciente deve ter no máximo 100 caracteres");
        }
        if (paciente.getEndereco().getUf() == null || paciente.getEndereco().getUf().isEmpty()) {
            throw new BusinessException("UF do paciente é obrigatório");
        }
        if (paciente.getEndereco().getUf().length() > 2 || paciente.getEndereco().getUf().length() < 2) {
            throw new BusinessException("UF do paciente deve ter 2 caracteres");
        }
        if (paciente.getEndereco().getCep() == null || paciente.getEndereco().getCep().isEmpty()) {
            throw new BusinessException("CEP do paciente é obrigatório");
        }
        if (paciente.getEndereco().getCep().length() > 8 || paciente.getEndereco().getCep().length() < 8) {
            throw new BusinessException("CEP do paciente deve ter 8 caracteres");
        }
        if (paciente.getEndereco().getNumero() != null && paciente.getEndereco().getNumero().length() > 10) {
            throw new BusinessException("Número do paciente deve ter no máximo 10 caracteres");
        }
        if (paciente.getEndereco().getComplemento() != null && paciente.getEndereco().getComplemento().length() > 100) {
            throw new BusinessException("Complemento do paciente deve ter no máximo 100 caracteres");
        }

        // convete cpf do paciente no id do paciente
        Paciente pacienteid = pacienteRepository.BuscarPorCpf(paciente.getCpf());
        if (pacienteid == null) {
            throw new BusinessException("CPF não encontrado");
        } else {
            paciente.setId(pacienteid.getId());
        }

        return pacienteRepository.editar(paciente);
    }

    public void desativar(Integer id) throws BusinessException, SQLException, NamingException {
        if (id == null) {
            throw new BusinessException("Id do paciente é obrigatório para exclusão");
        }

        pacienteRepository.desativar(id);

    }

    public List<Paciente> buscarTodos() throws BusinessException, SQLException, NamingException {
        return pacienteRepository.buscarTodos();

    }

    public Paciente buscarPorCpf(String cpf) throws BusinessException, SQLException, NamingException {
        if (cpf == null || cpf.isEmpty()) {
            throw new BusinessException("CPF do paciente é obrigatório");
        }
        if (cpf.length() > 11 || cpf.length() < 11) {
            throw new BusinessException("CPF do paciente deve ter 11 caracteres");
        }

        return pacienteRepository.BuscarPorCpf(cpf);

    }


}
