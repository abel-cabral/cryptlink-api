package org.acme.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class URL extends PanacheMongoEntity {
	@Schema(description = "Id do registro", example = "VvCZyb")
	private String id;

	@Schema(description = "Link a ser encurtada/criptografada", example = "EwW1kx9Rvlj8fKzqR3FTsQ==")
	private String url;

	@Schema(description = "Boleano para indicar se o link tem numero x de exibições")
	private Boolean auto_delete;

	@Schema(description = "Número de exibição", example = "0")
	private int numero_exibicao;

	public URL() {}

	public URL(String url) {
		this.url = url;
	}

	public URL(String url, Boolean auto_delete, int numero_exibicao) {
		this.url = url;
		this.auto_delete = auto_delete;
		this.numero_exibicao = numero_exibicao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
