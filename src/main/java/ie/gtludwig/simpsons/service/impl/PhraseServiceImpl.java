package ie.gtludwig.simpsons.service.impl;

import ie.gtludwig.simpsons.persistence.dao.PhraseJpaRepository;
import ie.gtludwig.simpsons.persistence.model.Character;
import ie.gtludwig.simpsons.persistence.model.Phrase;
import ie.gtludwig.simpsons.service.CharacterService;
import ie.gtludwig.simpsons.service.PhraseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "phraseService")
public class PhraseServiceImpl implements PhraseService {

    private static final Logger logger = LoggerFactory.getLogger(PhraseServiceImpl.class);

    @Autowired
    private PhraseJpaRepository phraseJpaRepository;

    @Autowired
    private CharacterService characterService;

    @Override
    public void createPhrase(String characterId, String quote) {
        Phrase phrase = new Phrase();
        phrase.setCharacter(characterService.retrieveCharacter(characterId));
        phrase.setPhrase(quote);

        create(phrase);
    }

    @Override
    public Phrase retrievePhrase(String phraseId) {
        return phraseJpaRepository.getOne(phraseId);
    }

    @Override
    public void updatePhrase(String id, String quote) {
        Phrase phrase = retrievePhrase(id);
        phrase.setPhrase(quote.isEmpty() || quote == null ? phrase.getPhrase() : quote);

        update(phrase);
    }

    @Override
    public void deletePhrase(String id) {
        delete(retrieve(id));
    }

    @Override
    public List<Phrase> findAllPhrasesByCharacter(Character character) {
        return phraseJpaRepository.findAllByCharacter(character);
    }

    @Override
    public void create(Phrase phrase) {
        try {
            phraseJpaRepository.save(phrase);
            logger.info("successfully created new phrase for character: " + phrase.getCharacter().getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem creating new phrase for character: " + phrase.getCharacter().getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public Phrase retrieve(String id) {
        return phraseJpaRepository.getOne(id);
    }

    @Override
    public void update(Phrase phrase) {
        try {
            phraseJpaRepository.save(phrase);
            logger.info("successfully updated phrase for character: " + phrase.getCharacter().getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem updating phrase for character: " + phrase.getCharacter().getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(Phrase phrase) {
        try {
            phraseJpaRepository.delete(phrase);
            logger.info("successfully deleted phrase for character: " + phrase.getCharacter().getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem deleting phrase for character: " + phrase.getCharacter().getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
