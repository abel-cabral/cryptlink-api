package org.acme.repository;

import com.mongodb.client.MongoClient;
import org.acme.model.URL;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class URLRepository implements PanacheMongoRepository<URL> {
    private final MongoClient mongoClient;

    public URLRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    public URL persistURL(URL urlData) {
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
