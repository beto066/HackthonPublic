package br.unitins.dto;

import br.unitins.model.Usuario;

public class UsuarioResponseDTO {
    private String nome; 
    private String email;
    private String cpf;
    private String rani;
    private String senha;
    private MessageResponseDTO message;

    public UsuarioResponseDTO(Usuario usuario){
        this.nome = usuario.nome;  
        this.email = usuario.email;
        this.cpf = usuario.cpf;
        this.rani = usuario.rani;
        this.senha = usuario.senha;
        this.message = new MessageResponseDTO(usuario.message);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRani() {
        return rani;
    }
    public void setRani(String rani) {
        this.rani = rani;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public MessageResponseDTO getMessage() {
        return message;
    }
    public void setMessage(MessageResponseDTO message) {
        this.message = message;
    }
    
}
