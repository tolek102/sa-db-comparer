package pl.springacademy.dbcomparer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pl.springacademy.dbcomparer.service.model.MongoUser;

@Repository
public interface MongoDbRepository extends MongoRepository<MongoUser, Integer> {

}
