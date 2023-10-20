/*
 * ID 
 * nome 
 * 
 */
package br.unitins.model;


import io.vertx.mutiny.core.eventbus.Message;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import java.util.List;

@Entity 
public class User extends DefaultEntity  {
    public String nome;
    public String email;
    public String senha;
    public String cpf;
    // public Suport suporte;
    
}