package br.unitins.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.unitins.model.Message;
import br.unitins.model.Suport;
import br.unitins.model.Usuario;

public class UsuarioDTO {
    private String nome; 
    private String email;
    private String cpf;
    private String rani;
    private String senha;
    private MessageDTO message;

    public void toUsuario(Usuario usuario) {
        usuario.nome = this.nome; 
        usuario.email = this.email;
        usuario.cpf = this.cpf;
        usuario.rani = this.rani;
        usuario.senha = this.senha;
        Message message = new Message();
        this.message.toMessage(message);
        usuario.message = message;
    }

    public static boolean isValid(UsuarioDTO dto) {
        return (dto.nome != null && dto.nome.length() > 2 &&
            dto.email != null && isEmailValid(dto.email) &&
            dto.cpf != null && validarCPF(dto.cpf));
    }

    private static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarCPF(String cpf) {
        // // Remove caracteres não numéricos
        // cpf = cpf.replaceAll("[^0-9]", "");
    
        // // Verifica se o CPF tem 11 dígitos
        // if (cpf.length() != 11) {
        //     return false;
        // }
    
        // // Calcula o primeiro dígito verificador
        // int soma = 0;
        // for (int i = 0; i < 9; i++) {
        //     soma += (cpf.charAt(i) - '0') * (10 - i);
        // }
        // int primeiroDigito = 11 - (soma % 11);
        // if (primeiroDigito == 10 || primeiroDigito == 11) {
        //     primeiroDigito = 0;
        // }
        // if (primeiroDigito != (cpf.charAt(9) - '0')) {
        //     return false;
        // }
    
        // // Calcula o segundo dígito verificador
        // soma = 0;
        // for (int i = 0; i < 10; i++) {
        //     soma += (cpf.charAt(i) - '0') * (11 - i);
        // }
        // int segundoDigito = 11 - (soma % 11);
        // if (segundoDigito == 10 || segundoDigito == 11) {
        //     segundoDigito = 0;
        // }
        // if (segundoDigito != (cpf.charAt(10) - '0')) {
        //     return false;
        // }
    
        // Se passou por todas as verificações, o CPF é válido
        return true;
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
    public MessageDTO getMessage() {
        return message;
    }
    public void setMessage(MessageDTO message) {
        this.message = message;
    }
}
