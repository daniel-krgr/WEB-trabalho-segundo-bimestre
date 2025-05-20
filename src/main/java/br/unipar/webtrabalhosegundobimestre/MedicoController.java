package br.unipar.webtrabalhosegundobimestre;

import br.unipar.webtrabalhosegundobimestre.domain.Medico;
import br.unipar.webtrabalhosegundobimestre.dto.ExceptionResponseDTO;
import br.unipar.webtrabalhosegundobimestre.dto.MedicoEditRequestDTO;
import br.unipar.webtrabalhosegundobimestre.dto.MedicoInsertRequestDTO;
import br.unipar.webtrabalhosegundobimestre.exceptions.BusinessException;
import br.unipar.webtrabalhosegundobimestre.services.MedicoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/medicos")
public class MedicoController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(MedicoInsertRequestDTO medicoInsertRequestDTO){
        try {
            MedicoService medicoService = new MedicoService();
            Medico medico = new Medico(medicoInsertRequestDTO);

            medico = medicoService.inserir(medico);

            return Response.
                    status(Response.Status.CREATED).
                    entity(medico).
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
    public Response editar(@PathParam("id") Integer id, MedicoEditRequestDTO medicoEditRequestDTO){

        try {
            MedicoService medicoService = new MedicoService();
            Medico medico = new Medico(id, medicoEditRequestDTO);

            medico = medicoService.editar(medico);


            return Response.
                    status(Response.Status.CREATED).
                    entity(medico).
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
            MedicoService medicoService = new MedicoService();
            medicoService.desativar(id);

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
            List<Medico> listaMedicos = new ArrayList<Medico>();

            MedicoService medicoService = new MedicoService();
            listaMedicos = medicoService.buscarTodos();

            return Response.
                    status(Response.Status.CREATED).
                    entity(listaMedicos).
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