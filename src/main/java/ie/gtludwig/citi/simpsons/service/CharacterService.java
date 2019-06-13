package ie.gtludwig.citi.simpsons.service;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.generic.CrudService;

import java.net.URL;
import java.util.List;

public interface CharacterService extends CrudService<Character> {

    // API
    void createCharacter(String firstName, String lastName, URL picture, List<Phrase> phraseList, int age);

    Character retrieveCharacter(String characterId);

    void updateCharacter(String id, String firstName, String lastName, URL picture, List<Phrase> phraseList, int age);

    void deleteCharacter(String id);

    List<Character> findAllCharactersByCriteria(String criteria);

    // APP
    List<Character> findAllCharacters();

    List<Character> findAllCharactersByLastName(String lastName);
}
