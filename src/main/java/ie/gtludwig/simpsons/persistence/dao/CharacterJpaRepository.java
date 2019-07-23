package ie.gtludwig.simpsons.persistence.dao;

import ie.gtludwig.simpsons.persistence.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterJpaRepository extends JpaRepository<Character, String> {

    List<Character> findByLastName(String lastName);

    List<Character> findByFirstName(String firstName);

    List<Character> findByAge(int age);
}

