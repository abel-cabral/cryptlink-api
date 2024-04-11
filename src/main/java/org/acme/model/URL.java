package org.acme.model;

import org.bson.types.ObjectId;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class URL extends PanacheMongoEntity {
	private ObjectId id;
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

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método para converter int para ObjectId
    public ObjectId getObjectId() {
        // Aqui você precisa de uma lógica para converter o int em ObjectId
        // Por exemplo, você pode criar um ObjectId com o int como um byte array
        byte[] bytes = new byte[12];
        bytes[0] = (byte) (id >>> 24);
        bytes[1] = (byte) (id >> 16 & 0xFF);
        bytes[2] = (byte) (id >> 8 & 0xFF);
        bytes[3] = (byte) (id & 0xFF);
        return new ObjectId(bytes);
    }

    // Método para converter ObjectId para int
    public void setObjectId(ObjectId objectId) {
        // Aqui você precisa de uma lógica para converter ObjectId para int
        // Por exemplo, você pode converter o byte array de ObjectId de volta para um int
        byte[] bytes = objectId.toByteArray();
        id = ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
    }
		this.id = id;
	}
}
