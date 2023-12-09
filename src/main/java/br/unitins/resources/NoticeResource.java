package br.unitins.resources;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.unitins.dto.NoticeDTO;
import br.unitins.dto.NoticeResponseDTO;
import br.unitins.model.Notice;
import br.unitins.repository.NoticeRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/notice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoticeResource {
    @Inject
    private NoticeRepository repository;
    
    // @GET
    // @Produces(MediaType.TEXT_PLAIN)
    // public String hello() {
    //     return "sfgfjd";
    // }

    @GET
    @PermitAll
    public List<NoticeResponseDTO> getAll() {
        return repository.findAllNotices();
    }

    @GET
    @Path("/{id}")
    public NoticeResponseDTO get(@PathParam("id") Long id) {
        return new NoticeResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response create(NoticeDTO dto) {
        if (!NoticeDTO.isValid(dto)){
            throw new BadRequestException();
        }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        // EnderecoRepository rEndereco = new EnderecoRepository();
        Notice entity = new Notice();

        dto.toNotice(entity);

        entity.dicionaries = new ArrayList<>();

        this.repository.persist(entity);

        NoticeResponseDTO responseDTO = new NoticeResponseDTO(entity);
        return Response.created(URI.create("/notice/" + entity.id)).entity(responseDTO).build();
    }
}
