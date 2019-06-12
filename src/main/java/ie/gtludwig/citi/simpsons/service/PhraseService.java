package ie.gtludwig.citi.simpsons.service;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.generic.CrudService;

import java.util.List;

public interface PhraseService extends CrudService<Phrase> {

    void createPhrase(String characterId, String phrase);

    Phrase retrievePhrase(String phraseId);

    void updatePhrase(String id, String phrase);

    void deletePhrase(String id);

    List<Phrase> findAllPhrasesByCharacter(Character character);
}
