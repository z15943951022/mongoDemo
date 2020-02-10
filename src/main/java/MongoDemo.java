import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDemo {
    public static void main(String[] args) {
        MongoDatabase connection = MongoDBUtil.getConnection();
        MongoCollection<Document> cc = connection.getCollection("people");
        Bson bson = Filters.or(
                Filters.gt("age", 49),
                Filters.eq("name","zhanshan"));
        FindIterable<Document> documents = cc.find(bson);
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

