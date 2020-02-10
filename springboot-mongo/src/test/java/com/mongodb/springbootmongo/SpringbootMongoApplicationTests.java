package com.mongodb.springbootmongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class SpringbootMongoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("name").is("zhanshan");
        query.addCriteria(criteria);

        List<Peolep> peoleps = mongoTemplate.find(query, Peolep.class);
        for (Peolep peolep : peoleps) {
            System.out.println(peolep);
        }
    }

}
