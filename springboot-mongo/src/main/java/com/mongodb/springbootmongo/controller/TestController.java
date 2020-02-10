package com.mongodb.springbootmongo.controller;

import com.mongodb.springbootmongo.Peolep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/HELLO")
    public Object getMessage(){
        Criteria criteria = new Criteria();

        Aggregation aggregation  = Aggregation.newAggregation(
                Aggregation.project("_id", "age", "sumage","name"),
                Aggregation.group("age").sum("age").as("sumage")
                        .last("_id").as("id")
                        .last("age").as("age"));
        AggregationResults<Peolep> people = mongoTemplate.aggregate(aggregation, "people", Peolep.class);
        return people.getMappedResults();

    }
}
