package br.unipar.webtrabalhosegundobimestre;


import br.unipar.webtrabalhosegundobimestre.domain.Paciente;
import br.unipar.webtrabalhosegundobimestre.dto.*;
import br.unipar.webtrabalhosegundobimestre.exceptions.BusinessException;
import br.unipar.webtrabalhosegundobimestre.services.PacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/pacientes")
public class PacienteController {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(PacienteInsertRequestDTO pacienteInsertRequestDTO) {
        try {
            PacienteService pacienteService = new PacienteService();
            Paciente paciente = new Paciente(pacienteInsertRequestDTO);

            paciente = pacienteService.inserir(paciente);

            return Response.
                    status(Response.Status.CREATED).
                    entity(paciente).
                    build();

        }catch (BusinessException businessException){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO(businessException.getMessage());

            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(exceptionResponseDTO).
                    build();

        } catch (Exception exception){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO("Ocorreu um erro interno.");

            return Response.
                    serverError().
                    entity(exceptionResponseDTO).
                    build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editar(@PathParam("id") Integer id, PacienteEditRequestDTO pacienteEditRequestDTO){

        try {
            PacienteService pacienteService = new PacienteService();
            Paciente paciente = new Paciente(id, pacienteEditRequestDTO);

            paciente = pacienteService.editar(paciente);


            return Response.
                    status(Response.Status.CREATED).
                    entity(paciente).
                    build();

        }catch (BusinessException businessException){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO(businessException.getMessage());

            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(exceptionResponseDTO).
                    build();

        } catch (Exception exception){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO("Ocorreu um erro interno.");

            return Response.
                    serverError().
                    entity(exceptionResponseDTO).
                    build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response desativar(@PathParam("id") Integer id) throws BusinessException {


        try {
            PacienteService pacienteService = new PacienteService();
            pacienteService.desativar(id);

            return Response.
                    status(Response.Status.CREATED).
                    build();


        }catch (BusinessException businessException){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO(businessException.getMessage());

            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(exceptionResponseDTO).
                    build();

        } catch (Exception exception){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO("Ocorreu um erro interno.");

            return Response.
                    serverError().
                    entity(exceptionResponseDTO).
                    build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodos(@QueryParam("nome") String nome) throws BusinessException {

        try {
            List<Paciente> listaPacientes = new ArrayList<Paciente>();

            PacienteService pacienteService = new PacienteService();
            listaPacientes = pacienteService.buscarTodos();

            return Response.
                    status(Response.Status.CREATED).
                    entity(listaPacientes).
                    build();

        }catch (BusinessException businessException){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO(businessException.getMessage());

            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(exceptionResponseDTO).
                    build();

        } catch (Exception exception){
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO("Ocorreu um erro interno.");

            return Response.
                    serverError().
                    entity(exceptionResponseDTO).
                    build();
        }

    }

}
