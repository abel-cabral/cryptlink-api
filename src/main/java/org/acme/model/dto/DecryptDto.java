package org.acme.model.dto;

import org.bson.codecs.pojo.annotations.BsonProperty;

import jakarta.validation.constraints.NotBlank;

public class DecryptDto {
    @NotBlank(message = "'id' não deve estar em branco.")
    @BsonProperty("id")
    public String id;

    @NotBlank(message = "'id' não deve estar em branco.")
    @BsonProperty("senha")
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
