package org.acme.model.dto;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EncryptDto {
    @NotBlank(message = "'url' não deve estar em branco.")
    @Schema(description = "URL a ser encurtada/criptografada", example = "https://www.exemplo.com", required = true)
    @BsonProperty("url")
    public String url;

    @NotBlank(message = "'senha' não deve estar em branco.")
    @Schema(description = "Senha para criptografia", example = "senha123", required = true)
    @BsonProperty("senha")
    public String senha;
   
    @NotNull(message = "'auto_delete' não deve estar em branco.")
    @Schema(description = "Boleano para indicar se o link tem numero x de exibições", example = "true")
    @BsonProperty("auto_delete")
    public Boolean auto_delete;
    
    @Min(value = 1, message = "'auto_delete' não deve estar em branco e o número deve ser maior do que 1.")
    @Schema(description = "Número de exibição", example = "0")
    @BsonProperty("numero_exibicao")
    public int numero_exibicao;

    public EncryptDto(String url, String senha) {
        this.url = url;
        this.senha = senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAuto_delete() {
        return auto_delete;
    }

    public void setAuto_delete(Boolean auto_delete) {
        this.auto_delete = auto_delete;
    }

    public int getNumero_exibicao() {
        return numero_exibicao;
    }

    public void setNumero_exibicao(int numero_exibicao) {
        this.numero_exibicao = numero_exibicao;
    }
}