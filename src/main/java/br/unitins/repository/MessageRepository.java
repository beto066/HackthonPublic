package br.unitins.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.MessageResponseDTO;
import br.unitins.model.Message;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageRepository implements PanacheRepository<Message>  {
    public List<MessageResponseDTO> findAllMessages() {
        return listAll().stream()
            .map(messages -> new MessageResponseDTO(messages))
            .collect(Collectors.toList());
    }

    public  List<MessageResponseDTO> findByTopic(String topic) {
        System.out.println("topic");
        return find("topic LIKE ?1", topic).stream()
        .map(messages -> new MessageResponseDTO(messages))
        .collect(Collectors.toList());
    }
}
