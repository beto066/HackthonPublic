package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.NoticeResponseDTO;
import br.unitins.model.Notice;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NoticeRepository implements PanacheRepository<Notice>  {
    public List<NoticeResponseDTO> findAllNotices() {
        return listAll().stream()
            .map(notices -> new NoticeResponseDTO(notices))
            .collect(Collectors.toList());
    }

    // public  List<EventoResponseDTO> findByNome(String nome) {
    //     return find("nome LIKE ?1", "%"+nome+"%").stream()
    //     .map(evento -> new EventoResponseDTO(evento))
    //     .collect(Collectors.toList());
    // }
}
