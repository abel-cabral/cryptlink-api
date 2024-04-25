package org.acme.model.dto;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;

public class DecryptDto {
    @NotBlank(message = "'link_publico' não deve estar em branco.")
    @Schema(description = "string do link para descriptografar", example = "y54SkO", required = true)
    @BsonProperty("link_publico")
	private String link_publico;

    @NotBlank(message = "'senha' não deve estar em branco.")
    @Schema(description = "Senha para criptografia", example = "senha123", required = true)
    @BsonProperty("senha")
    public String senha;

    public DecryptDto(String link_publico, String senha) {
        this.link_publico = link_publico;
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getlink_publico() {
        return link_publico;
    }
    public void setlink_publico(String link_publico) {
        this.link_publico = link_publico;
    }
}
