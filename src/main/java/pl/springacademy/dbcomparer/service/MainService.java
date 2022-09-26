package pl.springacademy.dbcomparer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.springacademy.dbcomparer.model.User;

@Slf4j
@Component
public class MainService {

    @Autowired
    @Qualifier("mongo_db")
    private DbOperation mongoDbOperation;

    @Autowired
    @Qualifier("postgres_db")
    private DbOperation postgresDbOperation;

    @EventListener(ApplicationReadyEvent.class)
    public void compareDb() {
        log.info("\n START PROCESSING \n");

        final List<User> usersFromCsv = DataProvider.getUsersFromCsv();

        mongoDbOperation.save(usersFromCsv);
        final List<User> mongoUsers = mongoDbOperation.readAll();
        mongoDbOperation.deleteAll();

        postgresDbOperation.save(usersFromCsv);
        final List<User> postgresUsers = postgresDbOperation.readAll();
        postgresDbOperation.deleteAll();
    }
}
