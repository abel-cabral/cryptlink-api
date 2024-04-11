package org.acme.model.dto;

public class DecryptDto {
    public String url;
    public String senha;

    public DecryptDto(String url, String senha) {
        this.url = url;
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
