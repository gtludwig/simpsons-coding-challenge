package ie.gtludwig.citi.simpsons.service.impl;

import ie.gtludwig.citi.simpsons.persistence.dao.PhraseJpaRepository;
import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.dao.CharacterJpaRepository;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.SimpsonsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "simpsonsService")
public class SimpsonsServiceImpl implements SimpsonsService {

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private PhraseJpaRepository phraseJpaRepository;

    private static Logger logger = LoggerFactory.getLogger(SimpsonsServiceImpl.class);

    @Override
    public void create(Character pojo) {
        Character character = new Character();

        character.setFirstName(pojo.getFirstName());
        character.setLastName(pojo.getLastName());
        character.setPicture(pojo.getPicture());
        character.setPhraseSet(pojo.getPhraseSet());
        character.setAge(pojo.getAge());

        try {
            characterJpaRepository.save(character);
            logger.info("successfuly created character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem creating the character with firstName: " + character.getFirstName());
        }
    }

    @Override
    public Character retrieve(String id) {
        return characterJpaRepository.getOne(id);
    }

    @Override
    public void update(String id, Character pojo) {
        Character character = retrieve(id);

        character.setFirstName(pojo.getFirstName());
        character.setLastName(pojo.getLastName());
        character.setPhraseSet(pojo.getPhraseSet());
        character.setPicture(pojo.getPicture());
        character.setAge(pojo.getAge());

        try {
            characterJpaRepository.save(character);
            logger.info("successfully updated character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem updating the character with firstName: " + character.getFirstName());
        }
    }

    @Override
    public void delete(String id) {
        Character character = retrieve(id);
        try {
            characterJpaRepository.delete(character);
            logger.info("successfully deleted character with firstName: " + character.getFirstName());
        } catch (Exception e) {
            logger.error("there was a problem deleting the character with firstName: " + character.getFirstName());
        }

    }

    @Override
    public List<Character> findAll() {
        return characterJpaRepository.findAll();
    }

    @Override
    public List<Character> findAllByFirstName(String firstName) {
        return characterJpaRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<Character> findAllByLastName(String lastName) {
        return characterJpaRepository.findByLastName(lastName);
    }

    @Override
    public List<Phrase> findAllByCharacter(Character character) {
        return phraseJpaRepository.findAllByCharacter(character);
    }
}
