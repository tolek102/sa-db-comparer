package pl.springacademy.dbcomparer.model;

import lombok.Builder;
import lombok.Value;
import pl.springacademy.dbcomparer.service.model.MongoUser;
import pl.springacademy.dbcomparer.service.model.PostgresUser;

@Value
@Builder
public class User {

    Integer id;
    String firstName;
    String lastName;
    String email;
    Gender gender;

    public static User fromMongoUser(final MongoUser mongoUser) {
        return User.builder()
                .id(mongoUser.getId())
                .firstName(mongoUser.getFirstName())
                .lastName(mongoUser.getLastName())
                .email(mongoUser.getEmail())
                .gender(mongoUser.getGender())
                .build();
    }

    public static User fromPostgresUser(final PostgresUser postgresUser) {
        return User.builder()
                .id(postgresUser.getId())
                .firstName(postgresUser.getFirstName())
                .lastName(postgresUser.getLastName())
                .email(postgresUser.getEmail())
                .gender(postgresUser.getGender())
                .build();
    }
}
