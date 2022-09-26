package pl.springacademy.dbcomparer.model;

import java.util.Arrays;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    POLYGENDER("Polygender"),
    BIGENDER("Bigender"),
    NON_BINARY("Non-binary"),
    GENDERQUEER("Genderqueer"),
    AGENDER("Agender"),
    GENDERFLUID("Genderfluid");

    public final String name;

    public static Gender fromValue(final String value) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.name.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Gender enum mapping not fount for value " + value));
    }
}
