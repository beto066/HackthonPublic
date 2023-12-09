package br.unitins.resources;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

import br.unitins.dto.DicionaryDTO;
import br.unitins.dto.DicionaryResponseDTO;
import br.unitins.dto.NoticeDTO;
import br.unitins.model.Dicionary;
import br.unitins.repository.DicionaryRepository;
import br.unitins.dto.NoticeResponseDTO;
import br.unitins.model.Dicionary;
import br.unitins.model.Notice;
import br.unitins.repository.NoticeRepository;
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

@Path("/dicionary")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DicionaryResource {
    @Inject
    private DicionaryRepository repository;

    @GET
    @Path("/{id}")
    public DicionaryResponseDTO get(@PathParam("id") Long id) {
        return new DicionaryResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response create(DicionaryDTO dto) {
       if (!DicionaryDTO.isValid(dto)){
           throw new BadRequestException();
       }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        // EnderecoRepository rEndereco = new EnderecoRepository();
        Dicionary entity = new Dicionary();
        NoticeRepository rNotice = new NoticeRepository();
        Notice notice = rNotice.findById(dto.getNoticeId());

        dto.toDicionary(entity,notice);

        this.repository.persist(entity);

        DicionaryResponseDTO responseDTO = new DicionaryResponseDTO(entity);
        return Response.created(URI.create("/dicionary/" + entity.id)).entity(responseDTO).build();
    }   
}
