package pl.springacademy.dbcomparer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.springacademy.dbcomparer.aspect.Timed;
import pl.springacademy.dbcomparer.model.User;
import pl.springacademy.dbcomparer.repository.MongoDbRepository;
import pl.springacademy.dbcomparer.service.model.MongoUser;

@Slf4j
@Service
@Qualifier("mongo_db")
@RequiredArgsConstructor
public class MongoDbService implements DbOperation {

    private final MongoDbRepository repository;

    @Timed
    @Override
    public void save(final List<User> users) {
        final List<MongoUser> mongoUsers = users.stream()
                .map(MongoUser::fromUser)
                .collect(Collectors.toList());
        repository.saveAll(mongoUsers);

    }

    @Timed
    @Override
    public List<User> readAll() {
        final List<MongoUser> mongoUsers = repository.findAll();

        return mongoUsers.stream()
                .map(User::fromMongoUser)
                .collect(Collectors.toList());
    }

    @Timed
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
