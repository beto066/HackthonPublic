package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.SuportResponseDTO;
import br.unitins.model.Suport;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SuportRepository implements PanacheRepository<Suport>  {
    public List<SuportResponseDTO> findAllSuports() {
        return listAll().stream()
            .map(suports -> new SuportResponseDTO(suports))
            .collect(Collectors.toList());
    }

    // public  List<EventoResponseDTO> findByNome(String nome) {
    //     return find("nome LIKE ?1", "%"+nome+"%").stream()
    //     .map(evento -> new EventoResponseDTO(evento))
    //     .collect(Collectors.toList());
    // }
}
