package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>  {
    public List<UsuarioResponseDTO> findAllUsuarios() {
        return listAll().stream()
            .map(usuarios -> new UsuarioResponseDTO(usuarios))
            .collect(Collectors.toList());
    }

    // public  List<EventoResponseDTO> findByNome(String nome) {
    //     return find("nome LIKE ?1", "%"+nome+"%").stream()
    //     .map(evento -> new EventoResponseDTO(evento))
    //     .collect(Collectors.toList());
    // }
}
