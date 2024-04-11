package org.acme.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class URL extends PanacheMongoEntity {
	private String url;
	private Boolean auto_delete;
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
}
