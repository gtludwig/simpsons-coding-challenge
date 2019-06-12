package ie.gtludwig.citi.simpsons.service.impl;

import ie.gtludwig.citi.simpsons.persistence.dao.CharacterJpaRepository;
import ie.gtludwig.citi.simpsons.persistence.dao.PhraseJpaRepository;
import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service(value = "characterService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private PhraseJpaRepository phraseJpaRepository;

    private static Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    @Override
    public void create(Character character) {
        try {
            characterJpaRepository.save(character);
            logger.info("successfully created character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem creating the character with firstName: " + character.getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public Character retrieve(String id) {
        return characterJpaRepository.getOne(id);
    }

    @Override
    public void update(Character character) {
        try {
            characterJpaRepository.save(character);
            logger.info("successfully updated character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem updating the character with firstName: " + character.getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(Character character) {
        try {
            characterJpaRepository.delete(character);
            logger.info("successfully deleted character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem deleting the character with firstName: " + character.getFirstName());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }


    @Override
    public void createCharacter(String firstName, String lastName, URL picture, List<Phrase> phraseList, int age) {

        Character character = new Character();
        character.setFirstName(firstName);
        character.setLastName(lastName);
        character.setPicture(picture);
        character.setPhraseList(phraseList);
        character.setAge(age);

        create(character);
    }

    @Override
    public Character retrieveCharacter(String characterId) {
        return retrieve(characterId);
    }

    @Override
    public void updateCharacter(String id, String firstName, String lastName, URL picture, List<Phrase> phraseList, int age) {
        Character character = retrieve(id);
        character.setFirstName(firstName.isEmpty() || firstName == null ? character.getFirstName() : firstName);
        character.setLastName(lastName.isEmpty() || lastName == null ? character.getLastName() : lastName);
        character.setPicture(picture == null ? character.getPicture() : picture);
        character.setPhraseList(phraseList.isEmpty() || phraseList == null ? character.getPhraseList() : phraseList);
        character.setAge(String.valueOf(age).isEmpty() || String.valueOf(age) == null ? character.getAge() : age);

        update(character);
    }

    @Override
    public void deleteCharacter(String id) {
        delete(retrieve(id));
    }

    @Override
    public List<Character> findAllCharacters() {
        return characterJpaRepository.findAll();
    }

    @Override
    public List<Character> findAllCharactersByLastName(String lastName) {
        return characterJpaRepository.findByLastName(lastName);
    }
}
