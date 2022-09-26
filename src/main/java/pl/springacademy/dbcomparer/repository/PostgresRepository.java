package pl.springacademy.dbcomparer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.springacademy.dbcomparer.service.model.PostgresUser;

@Repository
public interface PostgresRepository extends JpaRepository<PostgresUser, Integer> {

}
