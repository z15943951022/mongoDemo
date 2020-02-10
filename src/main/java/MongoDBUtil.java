import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    public static MongoDatabase getConnection(){
        MongoClient localhost = new MongoClient("localhost", 27017);
        MongoDatabase hello = localhost.getDatabase("hello");
        return hello;
    }
}
