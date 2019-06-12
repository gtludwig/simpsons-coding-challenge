package ie.gtludwig.citi.simpsons.persistence.model.dao;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterJpaRepository extends JpaRepository<Character, String> {



}

