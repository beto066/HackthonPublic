package br.unitins.repository;

import br.unitins.model.Suport;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SuportRepository implements PanacheRepository<Suport>  {
    // public List<NoticeResponseDTO> findAllNotices() {
    //     return listAll().stream()
    //         .map(notices -> new NoticeResponseDTO(notices))
    //         .collect(Collectors.toList());
    // }

    // public  List<EventoResponseDTO> findByNome(String nome) {
    //     return find("nome LIKE ?1", "%"+nome+"%").stream()
    //     .map(evento -> new EventoResponseDTO(evento))
    //     .collect(Collectors.toList());
    // }
}
