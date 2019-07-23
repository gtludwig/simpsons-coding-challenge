package ie.gtludwig.simpsons.controller.api;

import ie.gtludwig.simpsons.persistence.model.Character;
import ie.gtludwig.simpsons.persistence.model.Phrase;
import ie.gtludwig.simpsons.service.CharacterService;
import ie.gtludwig.simpsons.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SimpsonsRestController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private PhraseService phraseService;

    // CREATE ONE CHARACTER
    @PostMapping(value = "/characters", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public void createCharacter(@RequestBody Character character) {
        characterService.createCharacter(character.getFirstName(), character.getLastName(), character.getPicture(), character.getPhraseList(), character.getAge());
    }

    // RETRIEVE ALL CHARACTERS
    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Character> getAllCharacters() {
        return characterService.findAllCharacters();
    }

    // RETRIEVE ALL CHARACTERS
    @GetMapping(value = "/characters/{criteria}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Character> getAllCharacters(@PathVariable(value = "criteria") String criteria) {
        return characterService.findAllCharactersByCriteria(criteria);
    }

    // RETRIEVE ONE CHARACTER
    @GetMapping(value = "/characters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Character findCharacterById(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return characterService.retrieveCharacter(id);
    }

    // UPDATE CHARACTER
    @PutMapping(value = "/characters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody public void updateCharacter(@PathVariable(value = "id") String id, @RequestBody Character character) {
        characterService.updateCharacter(id, character.getFirstName(), character.getLastName(), character.getPicture(), character.getPhraseList(), character.getAge());
    }

    // DELETE CHARACTER
    @DeleteMapping(value = "/characters/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCharacter(@PathVariable(value = "id") String id) {
        characterService.deleteCharacter(id);
    }

    // CREATE ONE PHRASE
    @PostMapping(value = "/phrases/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public void createPhrase(@PathVariable(value = "id") String id, @RequestBody String phrase) {
        phraseService.createPhrase(id, phrase);
    }

    // RETRIEVE ONE PHRASE
    @GetMapping(value = "/phrases/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Phrase findPhraseById(@PathVariable(value = "id") String id) {
        return phraseService.retrievePhrase(id);
    }

    // RETRIVE ALL PHRASES BY CHARACTER
    @GetMapping(value = "/phrases/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Phrase> findPhrasesByCharacter(@PathVariable(value = "id") String id) {
        return phraseService.findAllPhrasesByCharacter(characterService.retrieve(id));
    }

    // UPDATE PHRASE
    @PutMapping(value = "/phrases/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePhrase(@PathVariable(value = "id") String id, @RequestBody String phrase) {
        phraseService.updatePhrase(id, phrase);
    }

    // DELETE PHRASE
    @DeleteMapping(value = "/phrases/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deletePhrase(@PathVariable(value = "id") String id) {
        phraseService.deletePhrase(id);
    }
}
