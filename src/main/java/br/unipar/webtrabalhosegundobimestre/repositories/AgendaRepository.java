package br.unipar.webtrabalhosegundobimestre.repositories;

import br.unipar.webtrabalhosegundobimestre.domain.Agenda;
import br.unipar.webtrabalhosegundobimestre.infraestructure.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AgendaRepository {
    private static final String INSERT =
            "INSERT INTO agenda (id_medico, id_paciente, data_consulta, hora_inicio, hora_final) VALUES (?, ?, ?, ?, ?)";

    private static final String FIND_DATE =
            "SELECT id_medico, id_paciente, data_consulta, hora_inicio, hora_final FROM agenda WHERE cancelada = false AND data_consulta = ? and id_paciente = ?";


    private static final String CANCEL =
            "UPDATE agenda  set cancelada = ? WHERE data_consulta = ? and id_paciente = ?";


    public Agenda inserir(Agenda agenda) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, agenda.getIdMedico());
            pstmt.setInt(2, agenda.getIdPaciente());
            pstmt.setDate(3, java.sql.Date.valueOf(agenda.getDataAgendamento()));
            pstmt.setTime(4, java.sql.Time.valueOf(agenda.getHoraInicio()));
            pstmt.setTime(5, java.sql.Time.valueOf(agenda.getHoraFim()));
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            agenda.setId(rs.getInt(1));

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }

        return agenda;

    }



    public Agenda BuscarPorDataPaciente(Date data, int id_paciente) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        Agenda agendaResult = new Agenda();
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_DATE);
            pstmt.setDate(1, (java.sql.Date) data);
            pstmt.setInt(2, id_paciente);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                agendaResult.setIdMedico(rs.getInt("id_medico"));
                agendaResult.setIdPaciente(rs.getInt("id_paciente"));
                agendaResult.setDataAgendamento(rs.getString("data_consulta"));
                agendaResult.setHoraInicio(rs.getString("hora_inicio"));
                agendaResult.setHoraFim(rs.getString("hora_final"));

            } else {
                agendaResult = null;
            }

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return agendaResult;

    }


    public Agenda cancelar(Date data, int id_paciente) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        Agenda agendaResult = new Agenda();
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(CANCEL);
            pstmt.setDate(1, (java.sql.Date) data);
            pstmt.setInt(2, id_paciente);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                agendaResult.setIdMedico(rs.getInt("id_medico"));
                agendaResult.setIdPaciente(rs.getInt("id_paciente"));
                agendaResult.setDataAgendamento(rs.getString("data_consulta"));
                agendaResult.setHoraInicio(rs.getString("hora_inicio"));
                agendaResult.setHoraFim(rs.getString("hora_final"));

            } else {
                agendaResult = null;
            }

        } finally {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        }
        return agendaResult;

    }



}
