package pl.springacademy.dbcomparer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.springacademy.dbcomparer.aspect.Timed;
import pl.springacademy.dbcomparer.model.User;
import pl.springacademy.dbcomparer.repository.PostgresRepository;
import pl.springacademy.dbcomparer.service.model.PostgresUser;

@Slf4j
@Service
@Qualifier("postgres_db")
@RequiredArgsConstructor
public class PostgresService implements DbOperation{

    private final PostgresRepository repository;

    @Timed
    @Override
    public void save(final List<User> users) {
        final List<PostgresUser> postgresUsers = users.stream()
                .map(PostgresUser::fromUser)
                .collect(Collectors.toList());
        repository.saveAll(postgresUsers);
    }
    @Timed
    @Override
    public List<User> readAll() {
        final List<PostgresUser> postgresUsers = repository.findAll();
        return postgresUsers.stream()
                .map(User::fromPostgresUser)
                .collect(Collectors.toList());
    }

    @Timed
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
