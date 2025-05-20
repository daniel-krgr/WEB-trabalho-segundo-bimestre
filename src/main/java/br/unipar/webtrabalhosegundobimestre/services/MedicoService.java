package br.unipar.webtrabalhosegundobimestre.services;

import br.unipar.webtrabalhosegundobimestre.domain.Medico;
import br.unipar.webtrabalhosegundobimestre.exceptions.BusinessException;
import br.unipar.webtrabalhosegundobimestre.repositories.MedicoRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class MedicoService {

    private MedicoRepository medicoRepository;

    public MedicoService() {
        medicoRepository = new MedicoRepository();
    }

    public Medico inserir(Medico medico) throws BusinessException, SQLException, NamingException {

        if (medico.getNome() == null || medico.getNome().isEmpty()) {
            throw new BusinessException("Nome do medico é obrigatório");
        }
        if (medico.getNome().length() > 100) {
            throw new BusinessException("Nome do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getNome().length() < 3) {
            throw new BusinessException("Nome do medico deve ter no mínimo 3 caracteres");
        }

        if (medico.getCrm() == null || medico.getCrm().isEmpty()) {
            throw new BusinessException("CRM do medico é obrigatório");
        }
        if (medico.getCrm().length() > 9 || medico.getCrm().length() < 9) {
            throw new BusinessException("CRM do medico deve ter 9 caracteres");
        }

        if (medico.getTelefone() == null || medico.getTelefone().isEmpty()) {
            throw new BusinessException("Telefone do medico é obrigatório");
        }
        if (medico.getTelefone().length() > 15 || medico.getTelefone().length() < 10) {
            throw new BusinessException("Telefone do medico deve ter entre 10 e 15 caracteres");
        }

        if (medico.getEmail() == null || medico.getEmail().isEmpty()) {
            throw new BusinessException("E-mail do medico é obrigatório");
        }
        if (medico.getEmail().length() > 100) {
            throw new BusinessException("E-mail do medico deve ter no máximo 100 caracteres");
        }
//        if (medico.getEmail().contains("@") == false) {
//            throw new BusinessException("E-mail inválido");
//        }

        //logradouro, número, complemento, bairro

        if (medico.getEndereco() == null) {
            throw new BusinessException("Endereço do medico é obrigatório");
        }
        if (medico.getEndereco().getLogradouro() == null || medico.getEndereco().getLogradouro().isEmpty()) {
            throw new BusinessException("Logradouro do medico é obrigatório");
        }
        if (medico.getEndereco().getLogradouro().length() > 100) {
            throw new BusinessException("Logradouro do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getEndereco().getBairro() == null || medico.getEndereco().getBairro().isEmpty()) {
            throw new BusinessException("Bairro do medico é obrigatório");
        }
        if (medico.getEndereco().getBairro().length() > 100) {
            throw new BusinessException("Bairro do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getEndereco().getNumero() != null && medico.getEndereco().getNumero().length() > 10) {
            throw new BusinessException("Número do medico deve ter no máximo 10 caracteres");
        }
        if (medico.getEndereco().getComplemento() != null && medico.getEndereco().getComplemento().length() > 100) {
            throw new BusinessException("Complemento do medico deve ter no máximo 100 caracteres");
        }


        return medicoRepository.inserir(medico);

    }

    public Medico editar(Medico medico) throws BusinessException, SQLException, NamingException {


        if (medico.getNome() == null || medico.getNome().isEmpty()) {
            throw new BusinessException("Nome do medico é obrigatório");
        }
        if (medico.getNome().length() > 100) {
            throw new BusinessException("Nome do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getNome().length() < 3) {
            throw new BusinessException("Nome do medico deve ter no mínimo 3 caracteres");
        }


        if (medico.getTelefone() == null || medico.getTelefone().isEmpty()) {
            throw new BusinessException("Telefone do medico é obrigatório");
        }
        if (medico.getTelefone().length() > 15 || medico.getTelefone().length() < 10) {
            throw new BusinessException("Telefone do medico deve ter entre 10 e 15 caracteres");
        }


        if (medico.getEndereco() == null) {
            throw new BusinessException("Endereço do medico é obrigatório");
        }
        if (medico.getEndereco().getLogradouro() == null || medico.getEndereco().getLogradouro().isEmpty()) {
            throw new BusinessException("Logradouro do medico é obrigatório");
        }
        if (medico.getEndereco().getLogradouro().length() > 100) {
            throw new BusinessException("Logradouro do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getEndereco().getBairro() == null || medico.getEndereco().getBairro().isEmpty()) {
            throw new BusinessException("Bairro do medico é obrigatório");
        }
        if (medico.getEndereco().getBairro().length() > 100) {
            throw new BusinessException("Bairro do medico deve ter no máximo 100 caracteres");
        }
        if (medico.getEndereco().getNumero() != null && medico.getEndereco().getNumero().length() > 10) {
            throw new BusinessException("Número do medico deve ter no máximo 10 caracteres");
        }
        if (medico.getEndereco().getComplemento() != null && medico.getEndereco().getComplemento().length() > 100) {
            throw new BusinessException("Complemento do medico deve ter no máximo 100 caracteres");
        }
        // convete CRM do medico no id do medico
        Medico medicoid = medicoRepository.BuscarPorCrm(medico.getCrm());
        if (medicoid== null) {
            throw new BusinessException("CPF não encontrado");
        } else {
            medico.setId(medicoid.getId());
        }

        return medicoRepository.editar(medico);
    }

    public void desativar(Integer id) throws BusinessException, SQLException, NamingException {
        if (id == null) {
            throw new BusinessException("Id do medico é obrigatório para exclusão");
        }

        medicoRepository.desativar(id);

    }

    public List<Medico> buscarTodos() throws BusinessException, SQLException, NamingException {
        return medicoRepository.buscarTodos();

    }

    public Medico buscarPorCrm(String crm) throws BusinessException, SQLException, NamingException {
        if (crm == null || crm.isEmpty()) {
            throw new BusinessException("CRM do medico é obrigatório");
        }
        if (crm.length() > 9 || crm.length() < 9) {
            throw new BusinessException("CRM do medico deve ter 9 caracteres");
        }
        return medicoRepository.BuscarPorCrm(crm);

    }

}
