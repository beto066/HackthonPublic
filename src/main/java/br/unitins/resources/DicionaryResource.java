package br.unitins.resources;

import java.net.URI;
import java.util.ArrayList;

import br.unitins.dto.DicionaryDTO;
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
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

public class DicionaryResource {
    @Inject
    private DicionaryRepository repository;

    @POST
    @Transactional
    // @RolesAllowed({"Admin"})
    public Dicionary create(DicionaryDTO dto) {
       // if (!NoticeDTO.isValid(dto)){
          //  throw new BadRequestException();
       // }

        // EsporteRepository rEsporte = new EsporteRepository();
        // CidadeRepository rCidade = new CidadeRepository();
        // EnderecoRepository rEndereco = new EnderecoRepository();
        Dicionary entity = new Dicionary();
        NoticeRepository rNotice = new NoticeRepository();
        Notice notice = rNotice.findById(dto.getNoticeId());

        dto.toDicionary(entity,notice);

        this.repository.persist(entity);

        return entity;
    }   
}
