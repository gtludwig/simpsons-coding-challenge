package ie.gtludwig.citi.simpsons.persistence.model.dao;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhraseJpaRepository extends JpaRepository<Phrase, String> {

    List<Phrase> findAllByCharacter(Character character);


}
