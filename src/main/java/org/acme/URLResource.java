package org.acme;

import java.util.List;

import org.acme.Util.ResponseMessage;
import org.acme.Util.ShortIdGenerator;
import org.acme.Util.URLCrypto;
import org.acme.model.URL;
import org.acme.model.dto.DecryptDto;
import org.acme.model.dto.EncryptDto;
import org.acme.model.dto.URLDTO;
import org.acme.repository.URLRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class URLResource {
	private URLRepository urlRepository;

    @Inject
    public URLResource(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    };
    
    @POST
    @Path("/encrypt")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Encurta e/ou criptografa um link.")
    public Response create(@Valid EncryptDto decryptDto) {
        String url = decryptDto.getUrl();
        String senha = decryptDto.getSenha();
        Boolean auto_delete = decryptDto.getAuto_delete();
        int numero_exibicao = decryptDto.getNumero_exibicao();

        // Verifica se a URL é valida
        if (!ShortIdGenerator.isValidURL(url))
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("URL inválida").build();


        try {
            URL urlData = new URL(URLCrypto.encryptURL(url, senha), auto_delete, numero_exibicao);
            urlRepository.persistURL(urlData);
            
            return Response.status(Response.Status.CREATED).entity(urlData).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(new ResponseMessage(false, e.getMessage()))
                       .build();
        }
    }

    @POST
    @Path("/decrypt")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recebe um encurtado e/ou criptografado e retorna o link original.")
    public Response encript_link(@Valid DecryptDto decryptDto) {
        try {
            URL urlData = urlRepository.findByEncryptedUrl(decryptDto.getlink_publico());
            URLDTO url_dto = new URLDTO(urlData.getUrl());
            url_dto.setUrl(URLCrypto.decryptURL(urlData.getUrl(), decryptDto.getSenha()));
            return Response.status(Response.Status.FOUND).entity(url_dto)
            .build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                       .entity(new ResponseMessage(false, "Link não encontrado"))
                       .build();
        }
    }

    @GET
    @Path("/decrypt/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retorna uma lista com todos os links encurtados e/ou criptografados no BD.")
    public List<URL> decript_links() {
    	return urlRepository.listAll();
    }
}
