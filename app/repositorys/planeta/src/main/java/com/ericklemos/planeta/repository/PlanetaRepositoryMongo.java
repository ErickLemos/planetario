package com.ericklemos.planeta.repository;

import com.ericklemos.planetario.entitys.PlanetaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepositoryMongo extends MongoRepository<PlanetaEntity, String> {
}
