package org.acme.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class URL extends PanacheMongoEntity {
	private String id;
	
	private String url;
	private String link_public;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLink_public() {
		return link_public;
	}

	public void setLink_public(String link_public) {
		this.link_public = link_public;
	}
}
