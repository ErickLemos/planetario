package com.ericklemos.planetario.repository;

import com.ericklemos.planetario.entitys.GeografiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeografiaMongoRepository extends MongoRepository<GeografiaEntity, String> {
}
