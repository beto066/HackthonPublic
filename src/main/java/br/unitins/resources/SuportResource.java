package br.unitins.resources;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.unitins.dto.SuportDTO;
import br.unitins.dto.SuportResponseDTO;
import br.unitins.model.Suport;
import br.unitins.repository.SuportRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/suport")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuportResource {
    @Inject
    private SuportRepository repository;
    
    // @GET
    // @Produces(MediaType.TEXT_PLAIN)
    // public String hello() {
    //     return "sfgfjd";
    // }

    @GET
    @PermitAll
    public List<SuportResponseDTO> getAll() {
        return repository.findAllSuports();
    }

    @GET
    @Path("/{id}")
    public SuportResponseDTO get(@PathParam("id") Long id) {
        return new SuportResponseDTO(repository.findById(id));
    }

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response create(SuportDTO dto) {
        if (!SuportDTO.isValid(dto)){
            throw new BadRequestException();
        }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        // EnderecoRepository rEndereco = new EnderecoRepository();
        Suport entity = new Suport();

        dto.toSuport(entity);

        entity.messages = new ArrayList<>();

        this.repository.persist(entity);

        SuportResponseDTO responseDTO = new SuportResponseDTO(entity);
        return Response.created(URI.create("/suport/" + entity.id)).entity(responseDTO).build();
    }
}
