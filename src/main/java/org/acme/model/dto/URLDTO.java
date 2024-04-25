package org.acme.model.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class URLDTO {
    @Schema(description = "URL a ser encurtada/criptografada", example = "https://www.exemplo.com")
    private String url;

    public URLDTO() {}

    public URLDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

