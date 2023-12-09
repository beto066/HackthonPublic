package br.unitins.resources;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.dto.MessageDTO;
import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;
import br.unitins.dto.MessageResponseDTO;
import br.unitins.model.Usuario;
import br.unitins.model.Message;
import br.unitins.model.Suport;
import br.unitins.repository.MessageRepository;
import br.unitins.repository.NoticeRepository;
import br.unitins.repository.SuportRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    private UsuarioRepository repository;

    @GET
    @Path("/{id}")
    public UsuarioResponseDTO get(@PathParam("id") Long id) {
        return new UsuarioResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response create(UsuarioDTO dto) {
       if (!UsuarioDTO.isValid(dto)){
           throw new BadRequestException();
       }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        SuportRepository rSuport = new SuportRepository();
        Usuario entity = new Usuario();

        dto.toUsuario(entity);

        this.repository.persist(entity);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(entity);
        return Response.created(URI.create("/usuario/" + entity.id)).entity(responseDTO).build();
    }   
}
