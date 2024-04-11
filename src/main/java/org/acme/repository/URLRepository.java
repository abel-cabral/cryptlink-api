package org.acme.repository;

import org.acme.Util.ShortIdGenerator;
import org.acme.model.URL;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class URLRepository implements PanacheMongoRepository<URL> {
    public URL persistURL(URL urlData) {
        /* Poderia ter uma consulta para ver se o ShortId gerado já esta em uso, mas por ter um numero na casa de bilhoes de combinacoes e 
            isso não gerar um grande impacto caso haja colisões, vou deixar sem um findAndUpdate */
        String customId = ShortIdGenerator.generateShortId();
        urlData.setId(customId);
        urlData.setLink_public("http://encutador.com/" + customId);
        persistOrUpdate(urlData);
        return urlData;
    }

    public URL findByEncriptedUrl(String url){
        URL urlData = find("url", url).firstResult();
        
        // Caso a pesquisa seja do tipo auto-delete, já deleta o registro após o resgate. 
        if (urlData.getAuto_delete()) {
            urlData.setNumero_exibicao(urlData.getNumero_exibicao() - 1);
            if (urlData.getNumero_exibicao() < 0) {
                delete("url", url);
            } else {
                update(urlData);
            }
        }
        return urlData; 
    }

    public List<URL> findOrderedByName(){
        return findAll().list();
      }
}
