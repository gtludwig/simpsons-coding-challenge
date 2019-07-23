package ie.gtludwig.simpsons.persistence.dao;

import ie.gtludwig.simpsons.persistence.model.Character;
import ie.gtludwig.simpsons.persistence.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhraseJpaRepository extends JpaRepository<Phrase, String> {

    List<Phrase> findAllByCharacter(Character character);


}
