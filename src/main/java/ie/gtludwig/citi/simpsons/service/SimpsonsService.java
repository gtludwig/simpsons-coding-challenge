package ie.gtludwig.citi.simpsons.service;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.generic.CrudService;

import java.util.List;

public interface SimpsonsService extends CrudService<Character> {

    List<Character> findAll();

    List<Character> findAllByFirstName(String firstName);

    List<Character> findAllByLastName(String lastName);

    List<Phrase> findAllByCharacter(Character character);


}
