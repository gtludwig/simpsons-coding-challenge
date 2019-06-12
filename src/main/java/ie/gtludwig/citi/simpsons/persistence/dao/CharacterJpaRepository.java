package ie.gtludwig.citi.simpsons.persistence.dao;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterJpaRepository extends JpaRepository<Character, String> {

    List<Character> findAllByFirstName(String firstName);

    List<Character> findAllByLastName(String lastName);


}

