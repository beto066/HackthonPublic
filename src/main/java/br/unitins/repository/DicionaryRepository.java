package br.unitins.repository;

import java.util.List;

import br.unitins.model.Dicionary;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DicionaryRepository implements PanacheRepository<Dicionary>  {
    // public List<EventoResponseDTO> findAllEventos() {
    //     return listAll().stream()
    //         .map(evento -> new EventoResponseDTO(evento))
    //         .collect(Collectors.toList());
    // }

    // public  List<EventoResponseDTO> findByNome(String nome) {
    //     return find("nome LIKE ?1", "%"+nome+"%").stream()
    //     .map(evento -> new EventoResponseDTO(evento))
    //     .collect(Collectors.toList());
    // }
}
