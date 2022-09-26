package pl.springacademy.dbcomparer.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;
import pl.springacademy.dbcomparer.model.Gender;
import pl.springacademy.dbcomparer.model.User;

@Slf4j
public class DataProvider {

    private static final String FILE = "TEST_DATA.csv";

    public static List<User> getUsersFromCsv() {
        log.info("\n Getting Data From File \n");
        final InputStream input;
        try {
            input = new ClassPathResource(FILE).getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try (final BufferedReader fileReader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        try (final InputStreamReader inputStreamReader = new InputStreamReader(input, StandardCharsets.UTF_8);
             final CSVParser csvParser = new CSVParser(inputStreamReader,
                CSVFormat.Builder.create()
                        .setSkipHeaderRecord(true)
                        .setIgnoreHeaderCase(true)
                        .setHeader("id", "first_name", "last_name", "email", "gender")
                        .setTrim(true)
                        .build()))
        {
            return csvParser.getRecords().stream()
                    .map(csvRecord -> User.builder()
                            .id(Integer.parseInt(csvRecord.get("id")))
                            .firstName(csvRecord.get("first_name"))
                            .lastName(csvRecord.get("last_name"))
                            .email(csvRecord.get("email"))
                            .gender(Gender.fromValue(csvRecord.get("gender")))
                            .build())
                    .collect(Collectors.toList());

        } catch (final IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
