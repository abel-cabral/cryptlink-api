package org.acme.model.dto;

public class DecryptDto {
    public String id;
    public String senha;

    public DecryptDto(String id, String senha) {
        this.id = id;
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
