package pl.springacademy.dbcomparer.service.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.springacademy.dbcomparer.model.Gender;
import pl.springacademy.dbcomparer.model.User;

@Document("users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MongoUser {

    @Id
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public Gender gender;

    public static MongoUser fromUser(final User user) {
        return MongoUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }

}
