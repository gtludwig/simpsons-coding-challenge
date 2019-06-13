package ie.gtludwig.citi.simpsons.controller.app;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.persistence.model.Phrase;
import ie.gtludwig.citi.simpsons.service.CharacterService;
import ie.gtludwig.citi.simpsons.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SimpsonsController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private PhraseService phraseService;

    @RequestMapping(value = {"/", "/characters"}, method = RequestMethod.GET)
    public String listCharacters(ModelMap modelMap, @RequestParam(value = "lastName", required = false) String lastName, RedirectAttributes redirectAttributes) {
        modelMap.addAttribute("pojoList", lastName == null ? characterService.findAllCharacters() : characterService.findAllCharactersByLastName(lastName));
        return "characters";
    }

    @RequestMapping(value = "/listPhrases", method = RequestMethod.GET)
    public String listCharactersByLastName(ModelMap modelMap, @RequestParam(value = "id") String id) {
        Character character = characterService.retrieve(id);
        modelMap.addAttribute("character", character);
        modelMap.addAttribute("pojoList", phraseService.findAllPhrasesByCharacter(character));
        return "phrases";
    }

}
