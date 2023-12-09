package br.unitins.resources;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.dto.MessageDTO;
import br.unitins.dto.MessageResponseDTO;
import br.unitins.dto.SuportDTO;
import br.unitins.model.Message;
import br.unitins.repository.MessageRepository;
import br.unitins.dto.SuportResponseDTO;
import br.unitins.model.Message;
import br.unitins.model.Suport;
import br.unitins.repository.SuportRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    @Inject
    private MessageRepository repository;

    @GET
    @PermitAll
    public List<MessageResponseDTO> getAll() {
        return repository.findAllMessages();
    }

    @GET
    @PermitAll
    @Path("/topic/{topic}")
    public List<MessageResponseDTO> getByTopic(@PathParam("topic") String topic) {
        return repository.findByTopic(topic);
    }

    @GET
    @PermitAll
    @Path("/topic/{topic}/unatribbuited")
    public List<MessageResponseDTO> findByTopicUnatribbuited(@PathParam("topic") String topic) {
        List<MessageResponseDTO> messages = repository.findByTopic(topic);
        List<MessageResponseDTO> messagesUnatribbuited = repository.findByTopic(topic);

        messages.forEach((MessageResponseDTO message) -> {
            if (message.suport == null) {
                messagesUnatribbuited.add(message);
            }
        });

        return messagesUnatribbuited.stream().filter(m -> m.suport == null).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public MessageResponseDTO get(@PathParam("id") Long id) {
        return new MessageResponseDTO(repository.findById(id));
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response applySuport(Long suportId, @PathParam("id") Long id) {
        Message entity = repository.findById(id);
        SuportRepository rSuport = new SuportRepository();
        entity.suport = rSuport.findById(suportId);

        MessageResponseDTO responseDTO = new MessageResponseDTO(entity);
        return Response.created(URI.create("/Message/" + entity.id)).entity(responseDTO).build();
    }

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response create(MessageDTO dto) {
       if (!MessageDTO.isValid(dto)){
           throw new BadRequestException();
       }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        // EnderecoRepository rEndereco = new EnderecoRepository();
        Message entity = new Message();
        dto.toMessage(entity);

        this.repository.persist(entity);
        System.out.println("hello");

        MessageResponseDTO responseDTO = new MessageResponseDTO(entity);
        return Response.created(URI.create("/Message/" + entity.id)).entity(responseDTO).build();
    }   
}
