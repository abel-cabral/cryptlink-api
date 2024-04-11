package org.acme.Util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class IDSequence {
    private static final String SEQUENCE_COLLECTION = "sequence";
    private static final String SEQUENCE_FIELD = "url_id";
    
    public static int getNextSequence(MongoClient client, String dbName, String collectionName) {
        MongoDatabase database = client.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(SEQUENCE_COLLECTION);
        
        Document filter = new Document("_id", collectionName);
        Document update = new Document("$inc", new Document(SEQUENCE_FIELD, 1));
        
        Document result = collection.findOneAndUpdate(filter, update);
        
        if (result == null) {
            Document newDocument = new Document("_id", collectionName)
                                        .append(SEQUENCE_FIELD, 1);
            collection.insertOne(newDocument);
            return 1;
        } else {
            return result.getInteger(SEQUENCE_FIELD);
        }
    }
}
