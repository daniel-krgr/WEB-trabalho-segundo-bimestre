package br.unipar.webtrabalhosegundobimestre.repositories;

import br.unipar.webtrabalhosegundobimestre.Enums.EspecialidadeMedicoEnum;
import br.unipar.webtrabalhosegundobimestre.domain.EnderecoMedico;
import br.unipar.webtrabalhosegundobimestre.domain.Medico;
import br.unipar.webtrabalhosegundobimestre.infraestructure.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {

    private static final String INSERT =
            "INSERT INTO medicos (nome, crm, email, telefone, especialidade, id_endereco) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String INSERT_END =
            "INSERT INTO endereco_medico (logradouro, numero, complemento, bairro) VALUES (?, ?, ?, ?)";

    private static final String UPDATE =
            "UPDATE medicos SET nome = ?, telefone = ?, endereco = ?, WHERE id = ?";

    private static final String DEACTIVATE_BY_ID =
            "update medicos set ativo = false where id = ?";

    private static final String FIND_ALL =
            "select nome, email, crm, especialidade from medicos where ativo = true order by nome asc";

    private static final String FIND_CRM =
            "select id, nome, email, crm, especialidade from medicos where ativo = true and crm = ?";


    public int inserirEndereco(EnderecoMedico endereco) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int id;
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT_END, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setString(2, endereco.getNumero());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(3, endereco.getBairro());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            rs.next();

            id = rs.getInt(1);

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

        return id;
    }


    public Medico inserir(Medico medico) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            conn = new ConnectionFactory().getConnection();
            // Inserir o endereço
            // e retornar o ID gerado
            int id_endereco = inserirEndereco(medico.getEndereco());
            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getCrm());
            pstmt.setString(3, medico.getEmail());
            pstmt.setString(4, medico.getTelefone());
            pstmt.setString(5, "CARDIOLOGIA");
            pstmt.setInt(6, id_endereco);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            medico.setId(rs.getInt(1));

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

        return medico;

    }

    public Medico editar(Medico medico) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getTelefone());
            pstmt.setString(3, medico.getEndereco().toString());
            pstmt.setInt(4, medico.getId());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        return medico;
    }

    public void desativar(Integer id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DEACTIVATE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    public List<Medico> buscarTodos() throws SQLException, NamingException {
        List<Medico> medicos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setNome(rs.getString("nome"));
                medico.setEmail(rs.getString("email"));
                medico.setCrm(rs.getString("crm"));
                medico.setEspecialidade(EspecialidadeMedicoEnum.valueOf(rs.getString("especialidade")));
                medicos.add(medico);
            }
        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return medicos;
    }

    public Medico BuscarPorCrm(String crm) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        Medico medicoResult = new Medico();
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_CRM);
            pstmt.setString(1, crm);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                medicoResult.setNome(rs.getString("nome"));
                medicoResult.setEmail(rs.getString("email"));
                medicoResult.setCrm(rs.getString("crm"));
                medicoResult.setEspecialidade(EspecialidadeMedicoEnum.valueOf(rs.getString("especialidade")));
                medicoResult.setId(rs.getInt("id"));
            } else {
                medicoResult = null;
            }

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return medicoResult;

    }


}
