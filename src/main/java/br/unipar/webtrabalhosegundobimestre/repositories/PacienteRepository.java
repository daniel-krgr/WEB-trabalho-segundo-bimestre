package br.unipar.webtrabalhosegundobimestre.repositories;

import br.unipar.webtrabalhosegundobimestre.domain.EnderecoPaciente;
import br.unipar.webtrabalhosegundobimestre.domain.Paciente;
import br.unipar.webtrabalhosegundobimestre.infraestructure.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    //nome, cpf, email, telefone, id_endereco, ativo
    //logradouro, número, complemento, bairro, cidade, UF e CEP

    private static final String INSERT =
            "insert into pacientes (nome, cpf, email, telefone, id_endereco) values (?, ?, ?, ?, ?)";


    private static final String INSERT_END =
            "insert into endereco_paciente (logradouro, numero, complemento, bairro, cidade, uf, cep) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE =
            "update pacientes set nome = ?, telefone = ?, id_endereco = ? where id = ?";

    private static final String DEACTIVATE_BY_ID =
            "update pacientes set ativo = false where id = ?";

    private static final String FIND_ALL =
            "select nome, email, cpf from pacientes where ativo = true order by nome asc";

    private static final String FIND_CPF =
            "select id, nome, email, cpf, telefone from pacientes where ativo = true and cpf = ?";




    public int inserirEndereco(EnderecoPaciente endereco) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int id;
        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(INSERT_END, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setString(2, endereco.getNumero());
            pstmt.setString(3, endereco.getComplemento());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getUf());
            pstmt.setString(7, endereco.getCep());
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

    public Paciente inserir (Paciente paciente) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();

            int id_endereco = inserirEndereco(paciente.getEndereco());
            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getCpf());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getTelefone());
            pstmt.setInt(5, id_endereco);
            //pstmt.setBoolean(6, true);

            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            paciente.setId(rs.getInt(1));

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return paciente;
    }

    public Paciente editar(Paciente paciente) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();

            int id_endereco = inserirEndereco(paciente.getEndereco());
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getTelefone());
            pstmt.setInt(3, id_endereco);
            pstmt.setInt(4, paciente.getId());
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        return paciente;
    }


    public void desativar (Integer id) throws SQLException, NamingException {
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

    public List<Paciente> buscarTodos() throws SQLException, NamingException {
        List<Paciente> pacientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setNome(rs.getString("nome"));
                paciente.setEmail(rs.getString("email"));
                paciente.setCpf(rs.getString("cpf"));
                pacientes.add(paciente);
            }

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return pacientes;
    }

    public Paciente BuscarPorCpf(String cpf) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        Paciente pacienteResult = new Paciente();
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_CPF);
            pstmt.setString(1, cpf);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pacienteResult.setId(rs.getInt("id"));
                pacienteResult.setNome(rs.getString("nome"));
                pacienteResult.setEmail(rs.getString("email"));
                pacienteResult.setCpf(rs.getString("cpf"));
                pacienteResult.setTelefone(rs.getString("telefone"));
            } else {
                pacienteResult = null;
            }

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return pacienteResult;
    }

}
